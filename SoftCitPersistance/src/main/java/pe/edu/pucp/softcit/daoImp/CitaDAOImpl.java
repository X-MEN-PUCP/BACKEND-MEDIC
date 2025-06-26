/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.ConsultorioDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.TurnoDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.dao.ConsultorioDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.dao.TurnoDAO;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.EstadoLogico;
import pe.edu.pucp.softcit.model.Genero;
import pe.edu.pucp.softcit.model.TipoDocumento;

/**
 *
 * @author Mcerv
 */
public class CitaDAOImpl extends DAOImplBase implements CitaDAO {

    private CitaDTO cita;

    public CitaDAOImpl() {
        super("cita");
        this.retornarLlavePrimaria = true;
        this.cita = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_cita", true, true));
        this.listaColumnas.add(new Columna("id_medico", false, false));
        this.listaColumnas.add(new Columna("id_especialidad", false, false));
        this.listaColumnas.add(new Columna("id_turno", false, false));
        this.listaColumnas.add(new Columna("id_consultorio", false, false));
        this.listaColumnas.add(new Columna("hora_inicio", false, false));
        this.listaColumnas.add(new Columna("hora_fin", false, false));
        this.listaColumnas.add(new Columna("fecha_cita", false, false));
        this.listaColumnas.add(new Columna("estado_cita", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.cita.getMedico().getIdUsuario());
        this.statement.setInt(2, this.cita.getEspecialidad().getIdEspecialidad());
        this.statement.setInt(3, this.cita.getTurno().getIdTurno());
        this.statement.setInt(4, this.cita.getConsultorio().getIdConsultorio());
        this.statement.setTime(5, Time.valueOf(this.cita.getHoraInicio()));
        this.statement.setTime(6, Time.valueOf(this.cita.getHoraFin()));
        this.statement.setDate(7, Date.valueOf(this.cita.getFechaCita()));
        this.statement.setInt(8, this.cita.getEstado().getCodigo());
        this.statement.setInt(9, this.cita.getUsuarioCreacion());
        this.statement.setDate(10, Date.valueOf(this.cita.getFechaCreacion()));
        this.statement.setInt(11, this.cita.getUsuarioModificacion());
        this.statement.setDate(12, Date.valueOf(this.cita.getFechaModificacion()));
        this.statement.setInt(13, this.cita.getIdCita());
    }

    
    

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cita = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSetEficaz();
        lista.add(this.cita);
    }

    @Override
    public Integer modificar(CitaDTO cita) {
        this.cita = cita;
        return super.modificar();
    }

    @Override
    public ArrayList<CitaDTO> listarTodos() {
        return (ArrayList<CitaDTO>) this.BuscaCitasMaestro(null, null,null, null, null, null);
    }

    @Override //
    public ArrayList<CitaDTO> listarCitasMedico(Integer idMedico, EstadoCita estado) {
        Integer idEspecialidad = null;
        String fecha = null;
        String hora_inicio = null;
        return this.BuscaCitasMaestro(null,idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }

    @Override //
    public ArrayList<CitaDTO> buscarCitas(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado) {
        return (ArrayList<CitaDTO>) this.BuscaCitasMaestro(null, idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }

    

    @Override
    public ArrayList<CitaDTO> buscarCitasDisponiblesSoloCalenario(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado) {
        ArrayList<CitaDTO> lista = new ArrayList<>();
        this.limpiarObjetoDelResultSet();
        return this.BuscaCitasMaestro(null, idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }

    @Override
    public CitaDTO obtenerPorId(Integer id) {
        ArrayList<CitaDTO> lista = new ArrayList<>();

        lista = BuscaCitasMaestro(id, null, null, null, null, null);
        if (lista.size() > 0) {
            this.cita = new CitaDTO();
            this.cita = lista.getFirst();
            return this.cita;
        }
        return null;
    }

    @Override
    public ArrayList<CitaDTO> BuscaCitasMaestro(Integer idCita, Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado) {
        ArrayList<CitaDTO> lista = new ArrayList<>();

        try {

            boolean conTransaccion = true;

            String sql = "{CALL universidad.sp_listar_citas_completas(?, ?, ?, ?, ?, ?)}";

            this.abrirConexion();

            this.colocarSQLenStatement(sql);

            setParametrosFiltroCita(idCita, idEspecialidad, idMedico, fecha, hora_inicio, estado);

            this.ejecutarConsultaEnBD();// asegúrate que esto realmente hace un SELECT

            while (this.resultSet.next()) {
                this.agregarObjetoALaLista(lista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReporteCitasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    protected void instanciarObjetoDelResultSetEficaz() throws SQLException {
        this.cita = cargarCita(resultSet);
        this.cita.setMedico(cargarUsuario(resultSet));
        this.cita.setEspecialidad(cargarEspecialidad(resultSet));
        this.cita.setTurno(cargarTurno(resultSet));
        this.cita.setConsultorio(cargarConsultorio(resultSet));
    }

    private UsuarioDTO cargarUsuario(ResultSet rs) throws SQLException {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdUsuario(rs.getInt("id_usuario_usuario"));
        usuario.setTipoDocumento(TipoDocumento.valueOf(rs.getString("tipo_documento_usuario")));
        usuario.setNumDocumento(rs.getString("nro_documento_usuario"));
        usuario.setContrasenha(rs.getString("contrasenha_usuario"));
        usuario.setNombres(rs.getString("nombre_usuario"));
        usuario.setApellidoPaterno(rs.getString("apellido_paterno_usuario"));
        usuario.setApellidoMaterno(rs.getString("apellido_materno_usuario"));
        usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento_usuario").toString());
        usuario.setCorreoElectronico(rs.getString("correo_electronico_usuario"));
        usuario.setNumCelular(rs.getString("num_celular_usuario"));
        usuario.setCodMedico(rs.getString("cod_medico_usuario"));
        usuario.setGenero(Genero.valueOf(rs.getString("genero_usuario")));
        usuario.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_general_usuario")));
        usuario.setEstadoLogico(EstadoLogico.valueOfCodigo(rs.getInt("estado_logico_usuario")));
        usuario.setUsuarioCreacion(rs.getInt("usuario_creacion_usuario"));
        usuario.setFechaCreacion(rs.getDate("fecha_creacion_usuario").toString());
        usuario.setUsuarioModificacion(rs.getInt("usuario_modificacion_usuario"));
        if (rs.getDate("fecha_modificacion_usuario") != null) {
            usuario.setFechaModificacion(rs.getDate("fecha_modificacion_usuario").toString());
        }

        return usuario;
    }

    private CitaDTO cargarCita(ResultSet rs) throws SQLException {
        CitaDTO cita = new CitaDTO();
        cita.setIdCita(rs.getInt("id_cita_cita"));
        cita.setHoraInicio(rs.getTime("hora_inicio_cita").toString());
        cita.setHoraFin(rs.getTime("hora_fin_cita").toString());
        cita.setFechaCita(rs.getDate("fecha_cita_cita").toString());
        cita.setEstado(EstadoCita.valueOfCodigo(rs.getInt("estado_cita_cita")));
        cita.setUsuarioCreacion(rs.getInt("usuario_creacion_cita"));
        cita.setFechaCreacion(rs.getDate("fecha_creacion_cita").toString());
        cita.setUsuarioModificacion(rs.getInt("usuario_modificacion_cita"));
        if (rs.getDate("fecha_modificacion_cita") != null) {
            cita.setFechaModificacion(rs.getDate("fecha_modificacion_cita").toString());
        }

        return cita;
    }

    private EspecialidadDTO cargarEspecialidad(ResultSet rs) throws SQLException {
        EspecialidadDTO especialidad = new EspecialidadDTO();
        especialidad.setIdEspecialidad(rs.getInt("id_especialidad_especialidad"));
        especialidad.setNombreEspecialidad(rs.getString("nombre_especialidad_especialidad"));
        especialidad.setPrecioConsulta(rs.getDouble("precio_consulta_especialidad"));
        especialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_especialidad")));
        especialidad.setUsuarioCreacion(rs.getInt("usuario_creacion_especialidad"));
        especialidad.setFechaCreacion(rs.getDate("fecha_creacion_especialidad").toString());
        especialidad.setUsuarioModificacion(rs.getInt("usuario_modificacion_especialidad"));
        if (rs.getDate("fecha_modificacion_especialidad") != null) {
            especialidad.setFechaModificacion(rs.getDate("fecha_modificacion_especialidad").toString());
        }

        return especialidad;
    }

    private TurnoDTO cargarTurno(ResultSet rs) throws SQLException {
        TurnoDTO turno = new TurnoDTO();
        turno.setIdTurno(rs.getInt("id_turno_turno"));
        turno.setNombreTurno(rs.getString("nombre_turno_turno"));
        turno.setHoraInicio(rs.getTime("hora_inicio_turno").toString());
        turno.setHoraFin(rs.getTime("hora_fin_turno").toString());
        turno.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_general_turno")));
        turno.setUsuarioCreacion(rs.getInt("usuario_creacion_turno"));
        turno.setFechaCreacion(rs.getDate("fecha_creacion_turno").toString());
        turno.setUsuarioModificacion(rs.getInt("usuario_modificacion_turno"));
        if (rs.getDate("fecha_modificacion_turno") != null) {
            turno.setFechaModificacion(rs.getDate("fecha_modificacion_turno").toString());
        }

        return turno;
    }

    private ConsultorioDTO cargarConsultorio(ResultSet rs) throws SQLException {
        ConsultorioDTO consultorio = new ConsultorioDTO();
        consultorio.setIdConsultorio(rs.getInt("id_consultorio_consultorio"));
        consultorio.setNumConsultorio(rs.getInt("numero_consultorio_consultorio"));
        consultorio.setNumPiso(rs.getInt("piso_consultorio"));
        consultorio.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_consultorio")));
        consultorio.setUsuarioCreacion(rs.getInt("usuario_creacion_consultorio"));
        consultorio.setFechaCreacion(rs.getDate("fecha_creacion_consultorio").toString());
        consultorio.setUsuarioModificacion(rs.getInt("usuario_modificacion_consultorio"));
        if (rs.getDate("fecha_modificacion_consultorio") != null) {
            consultorio.setFechaModificacion(rs.getDate("fecha_modificacion_consultorio").toString());
        }

        return consultorio;
    }

    private void setParametrosFiltroCita(Integer idCita, Integer idEspecialidad, Integer idMedico,
            String fecha, String horaInicio, EstadoCita estado) throws SQLException {
        // Parámetro 1: idCita
        if (idCita != null) {
            this.statement.setInt(1, idCita);
        } else {
            this.statement.setNull(1, Types.INTEGER);
        }

        // Parámetro 2: idEspecialidad
        if (idEspecialidad != null) {
            this.statement.setInt(2, idEspecialidad);
        } else {
            this.statement.setNull(2, Types.INTEGER);
        }

        // Parámetro 3: idMedico
        if (idMedico != null) {
            this.statement.setInt(3, idMedico);
        } else {
            this.statement.setNull(3, Types.INTEGER);
        }

        // Parámetro 4: fecha (DATE)
        if (fecha != null && !fecha.isEmpty()) {
            java.sql.Date sqlFecha = java.sql.Date.valueOf(fecha); // formato esperado: yyyy-MM-dd
            this.statement.setDate(4, sqlFecha);
        } else {
            this.statement.setNull(4, Types.DATE);
        }

        // Parámetro 5: hora_inicio (TIME)
        if (horaInicio != null && !horaInicio.isEmpty()) {
            java.sql.Time sqlHora = java.sql.Time.valueOf(horaInicio); // formato esperado: HH:mm:ss
            this.statement.setTime(5, sqlHora);
        } else {
            this.statement.setNull(5, Types.TIME);
        }

        // Parámetro 6: estado_cita (TINYINT)
        if (estado != null) {
            this.statement.setInt(6, estado.getCodigo()); // Asegúrate de que EstadoCita tenga getCodigo()
        } else {
            this.statement.setNull(6, Types.TINYINT);
        }
    }

}
