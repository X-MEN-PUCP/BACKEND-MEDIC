/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.DiagnositcoPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.daoImp.util.DiagnosticoParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.DiagnosticoParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.db.DBManager;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;

/**
 *
 * @author Cesar
 */
public class DiagnosticoPorCitaDAOImpl extends DAOImplBase implements DiagnositcoPorCitaDAO {

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
        this.statement.setInt(1, this.diagnosticoPorCita.getCita().getIdCita());
        this.statement.setInt(2, this.diagnosticoPorCita.getDiagnostico().getIdDiagnostico());
        this.statement.setString(3, this.diagnosticoPorCita.getObservacion());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.diagnosticoPorCita = new DiagnosticoPorCita();
        this.diagnosticoPorCita.setDiagnostico(this.cargaTabla.cargarDiagnostico(this.resultSet));
        this.diagnosticoPorCita.setCita(this.cargaTabla.cargarCita(resultSet));
        this.diagnosticoPorCita.setObservacion(this.resultSet.getString("observacion_diagnostico_por_cita"));
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.diagnosticoPorCita = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.diagnosticoPorCita);
    }
    
    @Override
    public Integer insertar(DiagnosticoPorCita diagnositcoPorCita) {
        this.diagnosticoPorCita = diagnositcoPorCita;
        return super.insertar();
    }

    @Override
    public ArrayList<DiagnosticoPorCita> listarPorIdCita(Integer idCita) {
        Integer idDiagnostico = null;
        return this.listarDiagnositicoPorFiltros(idCita, idDiagnostico);
    }

    @Override
    public ArrayList<DiagnosticoPorCita> listarTodos() {
        Integer idCita = null;
        Integer idDiagnostico = null;
        return this.listarDiagnositicoPorFiltros(idCita, idDiagnostico);
    }

    
    private ArrayList<DiagnosticoPorCita> listarDiagnositicoPorFiltros(Integer idCita, Integer idDiagnostico) {
        String sql = "{CALL universidad.sp_listar_diagnostico_por_cita(?, ?)}";
        Object parametros = new DiagnosticoParametrosBusquedaBuilder()
                                .conIdCita(idCita)
                                .conIdDiagnostico(idDiagnostico)
                                .BuildDiagnosticoParametrosBusqueda();

        return (ArrayList<DiagnosticoPorCita>) super.listarTodos(sql, this::incluirValorDeParametrosParaBuscarDiagnostico, parametros);
    }

    private void incluirValorDeParametrosParaBuscarDiagnostico(Object parametros){
        try {
            DiagnosticoParametrosBusqueda diagnosticoParametros = (DiagnosticoParametrosBusqueda) parametros;
            if (diagnosticoParametros.getIdCita() != null) {
                this.statement.setInt(1, diagnosticoParametros.getIdCita());
            } else {
                this.statement.setNull(1, Types.INTEGER);
            }
            
            if (diagnosticoParametros.getIdDiagnostico() != null) {
                this.statement.setInt(2, diagnosticoParametros.getIdDiagnostico());
            } else {
                this.statement.setNull(2, Types.INTEGER);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiagnosticoPorCitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
