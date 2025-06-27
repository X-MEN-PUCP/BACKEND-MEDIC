/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.HistoriaClinicaPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.ConsultorioDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.TurnoDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author Cesar
 */
public class HistoriaClinicaPorCitaDAOImpl extends DAOImplBase implements HistoriaClinicaPorCitaDAO {

    private HistoriaClinicaPorCitaDTO historiaPorCita;
    private final CargaTablas cargaTablas;

    public HistoriaClinicaPorCitaDAOImpl() {
        super("historia_clinica_por_cita");
        this.retornarLlavePrimaria = true;
        this.historiaPorCita = null;
        this.cargaTablas = new CargaTablas();
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_historia", true, false));
        this.listaColumnas.add(new Columna("id_cita", true, false));
        this.listaColumnas.add(new Columna("peso", false, false));
        this.listaColumnas.add(new Columna("talla", false, false));
        this.listaColumnas.add(new Columna("presion_arterial", false, false));
        this.listaColumnas.add(new Columna("temperatura", false, false));
        this.listaColumnas.add(new Columna("frecuencia_cardiaca", false, false));
        this.listaColumnas.add(new Columna("motivo_consulta", false, false));
        this.listaColumnas.add(new Columna("tratamiento", false, false));
        this.listaColumnas.add(new Columna("evolucion", false, false));
        this.listaColumnas.add(new Columna("recomendacion", false, false));
        this.listaColumnas.add(new Columna("receta", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.historiaPorCita.getHistoriaClinica().getIdHistoriaClinica());
        this.statement.setInt(2, this.historiaPorCita.getCita().getIdCita());
        if (this.historiaPorCita.getPeso() != null) {
            this.statement.setDouble(3, this.historiaPorCita.getPeso());
        } else {
            this.statement.setNull(3, java.sql.Types.DOUBLE);
        }

        if (this.historiaPorCita.getTalla() != null) {
            this.statement.setDouble(4, this.historiaPorCita.getTalla());
        } else {
            this.statement.setNull(4, java.sql.Types.DOUBLE);
        }

        if (this.historiaPorCita.getPresionArterial() != null) {
            this.statement.setString(5, this.historiaPorCita.getPresionArterial());
        } else {
            this.statement.setNull(5, java.sql.Types.VARCHAR);
        }

        if (this.historiaPorCita.getTemperatura() != null) {
            this.statement.setDouble(6, this.historiaPorCita.getTemperatura());
        } else {
            this.statement.setNull(6, java.sql.Types.DOUBLE);
        }

        if (this.historiaPorCita.getFrecuenciaCardiaca() != null) {
            this.statement.setInt(7, this.historiaPorCita.getFrecuenciaCardiaca());
        } else {
            this.statement.setNull(7, java.sql.Types.INTEGER);
        }

        if (this.historiaPorCita.getMotivoConsulta() != null) {
            this.statement.setString(8, this.historiaPorCita.getMotivoConsulta());
        } else {
            this.statement.setNull(8, java.sql.Types.VARCHAR);
        }

        if (this.historiaPorCita.getTratamiento() != null) {
            this.statement.setString(9, this.historiaPorCita.getTratamiento());
        } else {
            this.statement.setNull(9, java.sql.Types.VARCHAR);
        }

        if (this.historiaPorCita.getEvolucion() != null) {
            this.statement.setString(10, this.historiaPorCita.getEvolucion());
        } else {
            this.statement.setNull(10, java.sql.Types.VARCHAR);
        }

        if (this.historiaPorCita.getRecomendacion() != null) {
            this.statement.setString(11, this.historiaPorCita.getRecomendacion());
        } else {
            this.statement.setNull(11, java.sql.Types.VARCHAR);
        }

        if (this.historiaPorCita.getReceta() != null) {
            this.statement.setString(12, this.historiaPorCita.getReceta());
        } else {
            this.statement.setNull(12, java.sql.Types.VARCHAR);
        }

        this.statement.setInt(13, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(14, this.historiaPorCita.getUsuarioCreacion());
        this.statement.setDate(15, Date.valueOf(this.historiaPorCita.getFechaCreacion()));
        this.statement.setNull(16, Types.INTEGER);
        this.statement.setNull(17, Types.DATE);
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setDouble(1, this.historiaPorCita.getPeso());
        this.statement.setDouble(2, this.historiaPorCita.getTalla());
        this.statement.setString(3, this.historiaPorCita.getPresionArterial());
        this.statement.setDouble(4, this.historiaPorCita.getTemperatura());
        this.statement.setInt(5, this.historiaPorCita.getFrecuenciaCardiaca());
        this.statement.setString(6, this.historiaPorCita.getMotivoConsulta());
        this.statement.setString(7, this.historiaPorCita.getTratamiento());
        this.statement.setString(8, this.historiaPorCita.getEvolucion());
        this.statement.setString(9, this.historiaPorCita.getRecomendacion());
        this.statement.setString(10, this.historiaPorCita.getReceta());
        this.statement.setInt(11, this.historiaPorCita.getEstadoGeneral().getCodigo());
        this.statement.setInt(12, this.historiaPorCita.getUsuarioCreacion());
        this.statement.setDate(13, Date.valueOf(this.historiaPorCita.getFechaCreacion()));
        this.statement.setInt(14, this.historiaPorCita.getUsuarioModificacion());
        this.statement.setDate(15, Date.valueOf(this.historiaPorCita.getFechaModificacion()));
        this.statement.setInt(16, this.historiaPorCita.getHistoriaClinica().getIdHistoriaClinica());
        this.statement.setInt(17, this.historiaPorCita.getCita().getIdCita());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.historiaPorCita.getHistoriaClinica().getIdHistoriaClinica());
        this.statement.setInt(2, this.historiaPorCita.getCita().getIdCita());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {

        this.historiaPorCita = this.cargaTablas.cargarHistoriaClinicaPorCita(resultSet);

        // Cargar objetos anidados
        HistoriaClinicaDTO historiaClinica = this.cargaTablas.cargarHistoriaClinica(resultSet);
        CitaDTO cita = this.cargaTablas.cargarCita(resultSet);
        UsuarioDTO medico = this.cargaTablas.cargarUsuario(resultSet);
        TurnoDTO turno = this.cargaTablas.cargarTurno(resultSet);
        ConsultorioDTO consultorio = this.cargaTablas.cargarConsultorio(resultSet);
        EspecialidadDTO especialidad = this.cargaTablas.cargarEspecialidad(resultSet);

        // Asignar objetos a la estructura
        cita.setMedico(medico);
        cita.setTurno(turno);
        cita.setConsultorio(consultorio);
        cita.setEspecialidad(especialidad);

        this.historiaPorCita.setHistoriaClinica(historiaClinica);
        this.historiaPorCita.setCita(cita);

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.historiaPorCita = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.historiaPorCita);
    }

    @Override
    public Integer insertar(HistoriaClinicaPorCitaDTO historiaPorCita) {
        this.historiaPorCita = historiaPorCita;
        return super.insertar();
    }

    @Override
    public Integer modificar(HistoriaClinicaPorCitaDTO historiaPorCita) {
        this.historiaPorCita = historiaPorCita;
        return super.modificar();
    }

    @Override
    public Integer eliminar(HistoriaClinicaPorCitaDTO historiaPorCita) {
        this.historiaPorCita = historiaPorCita;
        return super.eliminar();
    }

    @Override
    public ArrayList<HistoriaClinicaPorCitaDTO> listarTodos() {
        return (ArrayList<HistoriaClinicaPorCitaDTO>) this.buscarHistoriaClinicaPorCita(null, null);
    }

    //refactorizar
    @Override
    public ArrayList<HistoriaClinicaPorCitaDTO> listarPorIdHistoria(Integer idHistoria) {

        return this.buscarHistoriaClinicaPorCita(idHistoria, null);
    }

    @Override
    public HistoriaClinicaPorCitaDTO ObtenerPorIdCita(Integer idCita) {
        ArrayList<HistoriaClinicaPorCitaDTO> lista = new ArrayList<>();

        lista = this.buscarHistoriaClinicaPorCita(null, idCita);
        if (lista.size() > 0) {
            this.historiaPorCita = new HistoriaClinicaPorCitaDTO();
            this.historiaPorCita = lista.getFirst();
            return this.historiaPorCita;
        }
        return null;
    }

    private ArrayList<HistoriaClinicaPorCitaDTO> buscarHistoriaClinicaPorCita(Integer idHistoria, Integer idCita) {
        ArrayList<HistoriaClinicaPorCitaDTO> lista = new ArrayList<>();

        try {
            String sql = "{CALL universidad.sp_listar_historia_clinica_por_cita(?, ?)}";

            this.abrirConexion();
            this.colocarSQLenStatement(sql);

            setParametrosFiltroHistoriaClinicaPorCita(idHistoria, idCita);

            this.ejecutarConsultaEnBD();

            while (this.resultSet.next()) {
                this.agregarObjetoALaLista(lista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HistoriaClinicaPorCitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    private void setParametrosFiltroHistoriaClinicaPorCita(Integer idHistoria, Integer idCita) throws SQLException {
        if (idHistoria != null) {
            this.statement.setInt(1, idHistoria);
        } else {
            this.statement.setNull(1, Types.INTEGER);
        }

        if (idCita != null) {
            this.statement.setInt(2, idCita);
        } else {
            this.statement.setNull(2, Types.INTEGER);
        }
    }

}
