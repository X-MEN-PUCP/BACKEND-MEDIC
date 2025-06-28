/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.daoImp.util.CitaParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.daoImp.util.CitaParametrosBusqueda;

/**
 *
 * @author Mcerv
 */
public class CitaDAOImpl extends DAOImplBase implements CitaDAO {

    private CitaDTO cita;
    private final CargaTablas cargaTablas;

    public CitaDAOImpl() {
        super("cita");
        this.retornarLlavePrimaria = true;
        this.cita = null;
        this.cargaTablas = new CargaTablas();

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
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cita = this.cargaTablas.cargarCita(resultSet);
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
        Integer idCita = null;
        Integer idEspecialidad = null;
        String fecha = null;
        String hora_inicio = null;
        Integer idMedico = null;
        EstadoCita estado = null;
        return this.listarCitasConFiltros(idCita, idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }

    @Override
    public ArrayList<CitaDTO> listarCitasMedico(Integer idMedico, EstadoCita estado) {
        Integer idEspecialidad = null;
        String fecha = null;
        String hora_inicio = null;
        Integer idCita = null;
        return this.listarCitasConFiltros(idCita, idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }

    @Override 
    public ArrayList<CitaDTO> buscarCitas(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado) {
        Integer idCita = null;
        return this.listarCitasConFiltros(idCita, idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }

    @Override //ver como podemos hacer esto
    public CitaDTO obtenerPorId(Integer id) {
        ArrayList<CitaDTO> lista;
        Integer idEspecialidad = null;
        String fecha = null;
        String hora_inicio = null;
        Integer idMedico = null;
        EstadoCita estado = null;
        lista = this.listarCitasConFiltros(id, idEspecialidad, idMedico, fecha, hora_inicio, estado);
        if (!lista.isEmpty()) {
            this.cita = lista.getFirst();
        }
        return this.cita;
    }

    private ArrayList<CitaDTO> listarCitasConFiltros(Integer idCita, Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado){
        String sql = "{CALL universidad.sp_listar_citas_completas(?, ?, ?, ?, ?, ?)}";
        Object parametros = new CitaParametrosBusquedaBuilder()
                .conEstado(estado)
                .conFecha(fecha)
                .conHoraInicio(hora_inicio)
                .conIdCita(idCita)
                .conIdEspecialidad(idEspecialidad)
                .conIdMedico(idMedico)
                .BuildCitaParametrosBusqueda();
        return (ArrayList<CitaDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaBuscarCitas, parametros);
    }

    private void incluirValorDeParametrosParaBuscarCitas(Object parametros) {
        CitaParametrosBusqueda paramatrosCita = (CitaParametrosBusqueda) parametros;
        // Parámetro 1: idCita
        try {
            if (paramatrosCita.getIdCita() != null) {
                this.statement.setInt(1, paramatrosCita.getIdCita());
            } else {
                this.statement.setNull(1, Types.INTEGER);
            }

            // Parámetro 2: idEspecialidad
            if (paramatrosCita.getIdEspecialidad() != null) {
                this.statement.setInt(2, paramatrosCita.getIdEspecialidad());
            } else {
                this.statement.setNull(2, Types.INTEGER);
            }

            // Parámetro 3: idMedico
            if (paramatrosCita.getIdMedico() != null) {
                this.statement.setInt(3, paramatrosCita.getIdMedico());
            } else {
                this.statement.setNull(3, Types.INTEGER);
            }

            // Parámetro 4: fecha (DATE)
            if (paramatrosCita.getFecha() != null) {
                java.sql.Date sqlFecha = java.sql.Date.valueOf(paramatrosCita.getFecha()); // formato esperado: yyyy-MM-dd
                this.statement.setDate(4, sqlFecha);
            } else {
                this.statement.setNull(4, Types.DATE);
            }

            // Parámetro 5: hora_inicio (TIME)
            if (paramatrosCita.getHora_inicio() != null) {
                java.sql.Time sqlHora = java.sql.Time.valueOf(paramatrosCita.getHora_inicio()); // formato esperado: HH:mm:ss
                this.statement.setTime(5, sqlHora);
            } else {
                this.statement.setNull(5, Types.TIME);
            }

            // Parámetro 6: estado_cita (TINYINT)
            if (paramatrosCita.getEstado() != null) {
                this.statement.setInt(6, paramatrosCita.getEstado().getCodigo()); // Asegúrate de que EstadoCita tenga getCodigo()
            } else {
                this.statement.setNull(6, Types.TINYINT);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
