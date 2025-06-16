/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.ExamenPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.db.DBManager;
import pe.edu.pucp.softcit.model.CitaDTO;
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
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, new ExamenDTO(this.examenPorCita.getExamen()).getIdExamen());
        this.statement.setInt(2, new CitaDTO(this.examenPorCita.getCita()).getIdCita());
        this.statement.setString(3, this.examenPorCita.getObservaciones());
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
