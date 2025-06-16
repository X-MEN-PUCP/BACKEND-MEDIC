/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.DiagnositcoPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.db.DBManager;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;

/**
 *
 * @author Cesar 
 */
public class DiagnosticoPorCitaDAOImpl extends DAOImplBase implements DiagnositcoPorCitaDAO{
    DiagnosticoPorCita diagnosticoPorCita;
    
    public DiagnosticoPorCitaDAOImpl() {
        super("diagnositco_por_cita");
        this.retornarLlavePrimaria = true;
        this.diagnosticoPorCita = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_cita", true, false));
        this.listaColumnas.add(new Columna("id_diagnostico", true, false));
        this.listaColumnas.add(new Columna("observacion", true, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1,this.diagnosticoPorCita.getCita().getIdCita());
        this.statement.setInt(2,this.diagnosticoPorCita.getDiagnostico().getIdDiagnostico());
        this.statement.setString(3,this.diagnosticoPorCita.getObservacion());
    }

    @Override
    public Integer insertar(DiagnosticoPorCita diagnositcoPorCita) {
        this.diagnosticoPorCita=diagnositcoPorCita;
        return super.insertar();
    }
    
    @Override
    public ArrayList<DiagnosticoPorCita> listarPorIdCita(Integer idCita) {
        try {
            ArrayList<DiagnosticoPorCita> lista;
            lista = new ArrayList<>();
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM examen_por_cita WHERE id_cita = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, idCita);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                DiagnosticoPorCita diagnositico_por_cita = new DiagnosticoPorCita();
                diagnositico_por_cita.setDiagnostico(new DiagnosticoDAOImpl().obtenerPorId(this.resultSet.getInt("id_examen")));
                diagnositico_por_cita.setCita(new CitaDAOImpl().obtenerPorId(this.resultSet.getInt("id_cita")));
                diagnositico_por_cita.setObservacion(this.resultSet.getString("observacion"));
                lista.add(diagnositico_por_cita);
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println("Error al listar por cita");
        }
        return null;
    }

    @Override
    public ArrayList<DiagnosticoPorCita> listarTodos() {
        return (ArrayList<DiagnosticoPorCita>) super.listarTodos();
    }
}
