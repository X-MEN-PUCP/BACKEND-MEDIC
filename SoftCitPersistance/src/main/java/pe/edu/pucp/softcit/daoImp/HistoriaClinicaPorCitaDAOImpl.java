/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softcit.dao.HistoriaClinicaPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.db.DBManager;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;

/**
 *
 * @author Cesar
 */
public class HistoriaClinicaPorCitaDAOImpl extends DAOImplBase implements HistoriaClinicaPorCitaDAO {

    HistoriaClinicaPorCitaDTO historiaPorCita;

    public HistoriaClinicaPorCitaDAOImpl() {
        super("historia_clinica_por_cita");
        this.retornarLlavePrimaria = true;
        this.historiaPorCita = null;
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
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.historiaPorCita.getHistoriaClinica().getIdHistoriaClinica());
        this.statement.setInt(2, this.historiaPorCita.getCita().getIdCita());
        this.statement.setDouble(3, this.historiaPorCita.getPeso());
        this.statement.setDouble(4, this.historiaPorCita.getTalla());
        this.statement.setString(5, this.historiaPorCita.getPresionArterial());
        this.statement.setDouble(6, this.historiaPorCita.getTemperatura());
        this.statement.setInt(7, this.historiaPorCita.getFrecuenciaCardiaca());
        this.statement.setString(8, this.historiaPorCita.getMotivoConsulta());
        this.statement.setString(9, this.historiaPorCita.getTratamiento());
        this.statement.setString(10, this.historiaPorCita.getEvolucion());
        this.statement.setString(11, this.historiaPorCita.getRecomendacion());
        this.statement.setString(12, this.historiaPorCita.getReceta());
        this.statement.setInt(13, EstadoGeneral.ACTIVO.getCodigo());
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
        this.statement.setInt(12, this.historiaPorCita.getHistoriaClinica().getIdHistoriaClinica());
        this.statement.setInt(13, this.historiaPorCita.getCita().getIdCita());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {

        HistoriaClinicaPorCitaDTO historia_por_cita = new HistoriaClinicaPorCitaDTO();
        historia_por_cita.setHistoriaClinica(new HistoriaDAOImpl().obtenerPorId(this.resultSet.getInt("id_historia")));
        historia_por_cita.setCita(new CitaDAOImpl().obtenerPorId(this.resultSet.getInt("id_cita")));
        historia_por_cita.setPeso(this.resultSet.getDouble("peso"));
        historia_por_cita.setTalla(this.resultSet.getDouble("talla"));
        historia_por_cita.setPresionArterial(this.resultSet.getString("presion_arterial"));
        historia_por_cita.setTemperatura(this.resultSet.getDouble("temperatura"));
        historia_por_cita.setFrecuenciaCardiaca(this.resultSet.getInt("frecuencia_cardiaca"));
        historia_por_cita.setMotivoConsulta(this.resultSet.getString("motivo_consulta"));
        historia_por_cita.setTratamiento(this.resultSet.getString("tratamiento"));
        historia_por_cita.setEvolucion(this.resultSet.getString("evolucion"));
        historia_por_cita.setRecomendacion(this.resultSet.getString("recomendacion"));
        historia_por_cita.setReceta(this.resultSet.getString("receta"));
        historia_por_cita.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13

        this.historiaPorCita = historia_por_cita;

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
    public ArrayList<HistoriaClinicaPorCitaDTO> listarTodos() {
        return (ArrayList<HistoriaClinicaPorCitaDTO>) super.listarTodos();
    }

    @Override
    public ArrayList<HistoriaClinicaPorCitaDTO> listarPorIdHistoria(Integer idHistoria) {
        try {
            ArrayList<HistoriaClinicaPorCitaDTO> lista;
            lista = new ArrayList<>();
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM historia_clinica_por_cita WHERE id_cita = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, idHistoria);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                HistoriaClinicaPorCitaDTO historia_por_cita = new HistoriaClinicaPorCitaDTO();
                historia_por_cita.setHistoriaClinica(new HistoriaDAOImpl().obtenerPorId(this.resultSet.getInt("id_historia")));
                historia_por_cita.setCita(new CitaDAOImpl().obtenerPorId(this.resultSet.getInt("id_cita")));
                historia_por_cita.setPeso(this.resultSet.getDouble("peso"));
                historia_por_cita.setTalla(this.resultSet.getDouble("talla"));
                historia_por_cita.setPresionArterial(this.resultSet.getString("presion_arterial"));
                historia_por_cita.setTemperatura(this.resultSet.getDouble("temperatura"));
                historia_por_cita.setFrecuenciaCardiaca(this.resultSet.getInt("frecuencia_cardiaca"));
                historia_por_cita.setMotivoConsulta(this.resultSet.getString("motivo_consulta"));
                historia_por_cita.setTratamiento(this.resultSet.getString("tratamiento"));
                historia_por_cita.setEvolucion(this.resultSet.getString("evolucion"));
                historia_por_cita.setRecomendacion(this.resultSet.getString("recomendacion"));
                historia_por_cita.setReceta(this.resultSet.getString("receta"));
                lista.add(historia_por_cita);
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println("Error al listar por cita");
        }
        return null;
    }

    @Override
    public ArrayList<HistoriaClinicaPorCitaDTO> listarPorIdCita(Integer idCita) {
        try {
            ArrayList<HistoriaClinicaPorCitaDTO> lista;
            lista = new ArrayList<>();
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM historia_clinica_por_cita WHERE id_cita = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, idCita);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                HistoriaClinicaPorCitaDTO historia_por_cita = new HistoriaClinicaPorCitaDTO();
                historia_por_cita.setHistoriaClinica(new HistoriaDAOImpl().obtenerPorId(this.resultSet.getInt("id_historia")));
                historia_por_cita.setCita(new CitaDAOImpl().obtenerPorId(this.resultSet.getInt("id_cita")));
                historia_por_cita.setPeso(this.resultSet.getDouble("peso"));
                historia_por_cita.setTalla(this.resultSet.getDouble("talla"));
                historia_por_cita.setPresionArterial(this.resultSet.getString("presion_arterial"));
                historia_por_cita.setTemperatura(this.resultSet.getDouble("temperatura"));
                historia_por_cita.setFrecuenciaCardiaca(this.resultSet.getInt("frecuencia_cardiaca"));
                historia_por_cita.setMotivoConsulta(this.resultSet.getString("motivo_consulta"));
                historia_por_cita.setTratamiento(this.resultSet.getString("tratamiento"));
                historia_por_cita.setEvolucion(this.resultSet.getString("evolucion"));
                historia_por_cita.setRecomendacion(this.resultSet.getString("recomendacion"));
                historia_por_cita.setReceta(this.resultSet.getString("receta"));
                lista.add(historia_por_cita);
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println("Error al listar por cita");
        }
        return null;
    }

}
