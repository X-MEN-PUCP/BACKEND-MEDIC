/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
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
//        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
//        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
//        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
//        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
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
        this.statement.setInt(9, this.cita.getIdCita());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cita = new CitaDTO();
        this.cita.setIdCita(this.resultSet.getInt("id_cita"));

        //cargar Medico
        Integer idMedico = this.resultSet.getInt("id_medico");
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        /////
        UsuarioDTO medico = usuarioDAO.obtenerPorId(idMedico);
        this.cita.setMedico(medico);

        //cargar Especialidad
        Integer idEspecialidad = this.resultSet.getInt("id_especialidad");
        EspecialidadDAO especialidadDAO = new EspecialidadDAOImpl();
        EspecialidadDTO especialidad = especialidadDAO.obtenerPorId(idEspecialidad);
        this.cita.setEspecialidad(especialidad);

        //cargar turno
        Integer idTurno = this.resultSet.getInt("id_turno");
        TurnoDAO turnoDAO = new TurnoDAOImpl();
        TurnoDTO turno = turnoDAO.obtenerPorId(idTurno);
        this.cita.setTurno(turno);

        //cargar Consultorio
        Integer idConsultorio = this.resultSet.getInt("id_consultorio");
        ConsultorioDAO consultorioDAO = new ConsultorioDAOImpl();
        ConsultorioDTO consultorio = consultorioDAO.obtenerPorId(idConsultorio);
        this.cita.setConsultorio(consultorio);

        java.sql.Time horain = this.resultSet.getTime("hora_inicio");
        this.cita.setHoraInicio(horain.toString());

        java.sql.Time horafi = this.resultSet.getTime("hora_fin");
        this.cita.setHoraFin(horafi.toString());

        java.sql.Date fechaSql = resultSet.getDate("fecha_cita");
        this.cita.setFechaCita(fechaSql.toString());

        Integer idEstado = this.resultSet.getInt("estado_cita");
        EstadoCita estado = EstadoCita.valueOfCodigo(idEstado);
        this.cita.setEstado(estado);
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.cita.getIdCita());
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cita = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.cita);
    }

    @Override
    public Integer modificar(CitaDTO cita) {
        this.cita = cita;
        return super.modificar();
    }

    @Override
    public ArrayList<CitaDTO> listarTodos() {
        return (ArrayList<CitaDTO>) super.listarTodos();
    }

    @Override //
    public ArrayList<CitaDTO> listarCitasMedico(Integer idMedico, EstadoCita estado) {
        Integer idEspecialidad = null;
        String fecha = null;
        String hora_inicio = null;
        return this.buscarCitas(idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }

    @Override //
    public ArrayList<CitaDTO> buscarCitas(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado) {
        Boolean conEspecialidad = (idEspecialidad != null);
        Boolean conIdMedico = (idMedico != null);
        Boolean conFecha = (fecha != null);
        Boolean conHora = (hora_inicio != null);
        Boolean conEstado = (estado != null);

        String sql = this.generarSQLParaBuscarCitas(conEspecialidad, conIdMedico, conFecha, conHora, conEstado);
        Date fechaD = (fecha != null ? Date.valueOf(fecha) : null);
        List<Object> params = new ArrayList<>();
        
        if(estado != null){
            params.add(estado.getCodigo());
        }
        if (idMedico != null) {
            params.add(idMedico);
        }
        if (idEspecialidad != null) {
            params.add(idEspecialidad);
        }
        if (hora_inicio != null) {
            params.add(hora_inicio);
        }
        if (fecha != null) {
            params.add(fechaD);
        }

        return (ArrayList<CitaDTO>) super.listarTodos(sql, this::incluirValorDeParametros, params);
    }

    private String generarSQLParaBuscarCitas(Boolean conEspecialidad, Boolean conIdMedico, Boolean conFecha, Boolean conHora, Boolean conEstado) {
        /*
        "SELECT * "
                + "FROM cita"
                + "WHERE estado=? "
        
         */
        String sql = "SELECT ";
        String sql_columnas = "";
        String sql_predicado = "";
        for (Columna columna : this.listaColumnas) {
            if (!sql_columnas.isBlank()) {
                sql_columnas = sql_columnas.concat(", ");
            }
//            sql_columnas = sql_columnas.concat(" ");
            sql_columnas = sql_columnas.concat(columna.getNombre());
        }
        sql = sql.concat(sql_columnas);
        sql = sql.concat(" FROM ");
        sql = sql.concat(this.nombre_tabla);
//        sql = sql.concat(" c JOIN usuario u ON c.id_medico = u.id_usuario");
//        sql = sql.concat(" JOIN especialidad e ON c.id_especialidad = e.id_especialidad");
        sql = sql.concat(" WHERE ");
        
        if (conEstado)
            sql_predicado = sql_predicado.concat("estado_cita = ? AND ");

        if (conIdMedico) 
            sql_predicado = sql_predicado.concat("id_medico = ? ");
        
        if (conEspecialidad) 
            sql_predicado = sql_predicado.concat("AND id_especialidad = ? ");
        
        if (conHora)
            sql_predicado = sql_predicado.concat("AND TIME(hora_inicio) = ? ");
        
        if (conFecha) 
            sql_predicado = sql_predicado.concat("AND DATE(fecha_cita) = ? ");
        
        sql = sql.concat(sql_predicado);
        System.out.println(sql);
        return sql;
    }

    private void incluirValorDeParametros(Object objetoParametros) {
        List<Object> params = (List<Object>) objetoParametros;
        try {
            for (int i = 0; i < params.size(); i++) {
                this.statement.setObject(i + 1, params.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<CitaDTO> buscarCitasDisponiblesSoloCalenario(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado) {
        ArrayList<CitaDTO> lista = new ArrayList<>();
        this.limpiarObjetoDelResultSet();

        try {

            Boolean conEspecialidad = (idEspecialidad != null);
            Boolean conIdMedico = (idMedico != null);
            Boolean conFecha = (fecha != null);
            Boolean conHora = (hora_inicio != null);
            Boolean conEstado = (estado != null);
            
            String sql = this.generarSQLParaBuscarCitas(conEspecialidad, conIdMedico, conFecha, conHora, conEstado);
            Date fechaD = (fecha != null ? Date.valueOf(fecha) : null);
            List<Object> params = new ArrayList<>();

            if(estado != null){
                params.add(estado.getCodigo());
            }
            if (idMedico != null) {
                params.add(idMedico);
            }
            if (idEspecialidad != null) {
                params.add(idEspecialidad);
            }
            if (hora_inicio != null) {
                params.add(hora_inicio);
            }
            if (fecha != null) {
                params.add(fechaD);
            }
            
            this.abrirConexion();
            
            this.colocarSQLenStatement(sql);

            this.incluirValorDeParametros(params);

            this.ejecutarConsultaEnBD();
            while (this.resultSet.next()) {
                this.cita = new CitaDTO();
                java.sql.Time horain = this.resultSet.getTime("hora_inicio");
                this.cita.setHoraInicio(horain.toString());

                java.sql.Time horafi = this.resultSet.getTime("hora_fin");
                this.cita.setHoraFin(horafi.toString());

                java.sql.Date fechaSql = resultSet.getDate("fecha_cita");
                this.cita.setFechaCita(fechaSql.toString());

                lista.add(this.cita);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public CitaDTO obtenerPorId(Integer id) {
        this.cita = new CitaDTO();
        cita.setIdCita(id);
        super.obtenerPorId();
        return this.cita;
    }
}
