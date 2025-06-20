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
import pe.edu.pucp.softcit.dao.ExamenPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.db.DBManager;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.ExamenDTO;
import pe.edu.pucp.softcit.model.ExamenPorCita;

/**
 *
 * @author Cesar
 */
public class ExamenPorCitaDAOImpl extends DAOImplBase implements ExamenPorCitaDAO {

    private ExamenPorCita examenPorCita;

    public ExamenPorCitaDAOImpl() {
        super("examen_por_cita");
        this.retornarLlavePrimaria = true;
        this.examenPorCita = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_examen", true, false));
        this.listaColumnas.add(new Columna("id_cita", true, false));
        this.listaColumnas.add(new Columna("observacion", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, new ExamenDTO(this.examenPorCita.getExamen()).getIdExamen());
        this.statement.setInt(2, new CitaDTO(this.examenPorCita.getCita()).getIdCita());
        this.statement.setString(3, this.examenPorCita.getObservaciones());
        this.statement.setInt(4, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(5, this.examenPorCita.getUsuarioCreacion());
        this.statement.setDate(6, Date.valueOf(this.examenPorCita.getFechaCreacion()));
        this.statement.setNull(7, Types.INTEGER);
        this.statement.setNull(8, Types.DATE);        
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.examenPorCita = new ExamenPorCita();
        this.examenPorCita.setExamen(new ExamenDAOImpl().obtenerPorId(this.resultSet.getInt("id_examen")));
        this.examenPorCita.setCita(new CitaDAOImpl().obtenerPorId(this.resultSet.getInt("id_cita")));
        this.examenPorCita.setObservaciones(this.resultSet.getString("observacion"));
        this.examenPorCita.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13
        this.examenPorCita.setUsuarioCreacion(this.resultSet.getInt("usuario_creación"));
        this.examenPorCita.setFechaCreacion(this.resultSet.getDate("fecha_creacion").toString());
        this.examenPorCita.setUsuarioModificacion(this.resultSet.getInt("usuario_modificación"));
        if(this.resultSet.getDate("fecha_modificacion") != null) 
            this.examenPorCita.setFechaModificacion(this.resultSet.getDate("fecha_modificacion").toString());
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.examenPorCita = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.examenPorCita);
    }
    
    @Override
    public Integer insertar(ExamenPorCita examenPorCita) {
        this.examenPorCita = examenPorCita;
        return super.insertar();
    }

    @Override
    public ArrayList<ExamenPorCita> listarTodos() {
        return (ArrayList<ExamenPorCita>) super.listarTodos();
    }

    @Override
    public ArrayList<ExamenPorCita> listarPorIdCita(Integer idCita) {
        try {
            ArrayList<ExamenPorCita> lista;
            lista = new ArrayList<>();
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM examen_por_cita WHERE id_cita = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, idCita);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                ExamenPorCita examen_por_Cita = new ExamenPorCita();
                examen_por_Cita.setExamen(new ExamenDAOImpl().obtenerPorId(this.resultSet.getInt("id_examen")));
                examen_por_Cita.setCita(new CitaDAOImpl().obtenerPorId(this.resultSet.getInt("id_cita")));
                examen_por_Cita.setObservaciones(this.resultSet.getString("observacion"));
                lista.add(examen_por_Cita);
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println("Error al listar por cita");
        }
        return null;
    }
}
