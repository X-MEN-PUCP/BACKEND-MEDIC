/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.DiagnositcoPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.db.DBManager;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;

/**
 *
 * @author Cesar
 */
public class DiagnosticoPorCitaDAOImpl extends DAOImplBase implements DiagnositcoPorCitaDAO {

    DiagnosticoPorCita diagnosticoPorCita;
    private final CargaTablas cargaTablas;

    public DiagnosticoPorCitaDAOImpl() {
        super("diagnositco_por_cita");
        this.retornarLlavePrimaria = true;
        this.diagnosticoPorCita = null;
        this.cargaTablas = new CargaTablas();
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_cita", true, false));
        this.listaColumnas.add(new Columna("id_diagnostico", true, false));
        this.listaColumnas.add(new Columna("observacion", true, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.diagnosticoPorCita.getCita().getIdCita());
        this.statement.setInt(2, this.diagnosticoPorCita.getDiagnostico().getIdDiagnostico());
        this.statement.setString(3, this.diagnosticoPorCita.getObservacion());
    }

    @Override
    public Integer insertar(DiagnosticoPorCita diagnositcoPorCita) {
        this.diagnosticoPorCita = diagnositcoPorCita;
        return super.insertar();
    }

    @Override
    public ArrayList<DiagnosticoPorCita> listarPorIdCita(Integer idCita) {
        return this.buscarDiagnosticosPorCita(idCita, null);
    }

    @Override
    public ArrayList<DiagnosticoPorCita> listarTodos() {
        return (ArrayList<DiagnosticoPorCita>) this.buscarDiagnosticosPorCita(null,null);
    }

    
    private ArrayList<DiagnosticoPorCita> buscarDiagnosticosPorCita(Integer idCita, Integer idDiagnostico) {
        ArrayList<DiagnosticoPorCita> lista = new ArrayList<>();

        try {
            String sql = "{CALL universidad.sp_listar_diagnostico_por_cita(?, ?)}";

            this.abrirConexion();
            this.colocarSQLenStatement(sql);

            setParametrosFiltroDiagnostico(idCita, idDiagnostico);

            this.ejecutarConsultaEnBD();

            while (this.resultSet.next()) {
                this.agregarObjetoDiagnosticoALaLista(lista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DiagnosticoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    private void agregarObjetoDiagnosticoALaLista(ArrayList<DiagnosticoPorCita> lista) throws SQLException {
        DiagnosticoPorCita dpc = new DiagnosticoPorCita();

        dpc.setObservacion(this.resultSet.getString("observacion_diagnostico_por_cita"));

        dpc.setDiagnostico(this.cargaTablas.cargarDiagnostico(this.resultSet));
        
        
        CitaDTO cita = this.cargaTablas.cargarCita(resultSet);
        cita.setMedico(this.cargaTablas.cargarUsuario(resultSet));
        cita.setEspecialidad(this.cargaTablas.cargarEspecialidad(resultSet));
        cita.setTurno(this.cargaTablas.cargarTurno(resultSet));
        cita.setConsultorio(this.cargaTablas.cargarConsultorio(resultSet));
        dpc.setCita(cita);
        
        lista.add(dpc);
    }

    private void setParametrosFiltroDiagnostico(Integer idCita, Integer idDiagnostico) throws SQLException {
        if (idCita != null) {
            this.statement.setInt(1, idCita);
        } else {
            this.statement.setNull(1, Types.INTEGER);
        }

        if (idDiagnostico != null) {
            this.statement.setInt(2, idDiagnostico);
        } else {
            this.statement.setNull(2, Types.INTEGER);
        }
    }

}
