/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softcit.dao.DiagnosticoDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;

/**
 *
 * @author Mcerv
 */
public class DiagnosticoDAOImpl extends DAOImplBase implements DiagnosticoDAO{
    private DiagnosticoDTO diagnostico;
    
    public DiagnosticoDAOImpl(){
        super("diagnostico");
        this.retornarLlavePrimaria = true;
        this.diagnostico = null;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_diagnostico", true, true));
        this.listaColumnas.add(new Columna("nombre_diagnostico", false, false));
        this.listaColumnas.add(new Columna("descripcion", false, false));
        this.listaColumnas.add(new Columna("capitulo", false, false));
        this.listaColumnas.add(new Columna("grupo", false, false));
        this.listaColumnas.add(new Columna("nivel", false, false));
//        this.listaColumnas.add(new Columna("activo", false, false)); //esto para que es?
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.diagnostico.getNombreDiagnostico());
        this.statement.setString(2, this.diagnostico.getDescripcion());
        this.statement.setString(3, this.diagnostico.getCapitulo());
        this.statement.setString(4, this.diagnostico.getGrupo());
        this.statement.setInt(5, this.diagnostico.getNivel());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.diagnostico.getIdDiagnostico());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.diagnostico = new DiagnosticoDTO();
        this.diagnostico.setIdDiagnostico(this.resultSet.getInt("id_diagnostico"));
        this.diagnostico.setNombreDiagnostico(this.resultSet.getString("nombre_diagnostico"));
        this.diagnostico.setDescripcion(this.resultSet.getString("descripcion"));
        this.diagnostico.setCapitulo(this.resultSet.getString("capitulo"));
        this.diagnostico.setGrupo(this.resultSet.getString("grupo"));
        this.diagnostico.setNivel(this.resultSet.getInt("nivel"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.diagnostico = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.diagnostico);
    }
    
    @Override
    public Integer insertar(DiagnosticoDTO diagnostico) {
        this.diagnostico = diagnostico;
        return super.insertar();
    }
    
    @Override
    public DiagnosticoDTO obtenerPorId(Integer diagnosticoId) {
        this.diagnostico = new DiagnosticoDTO();
        this.diagnostico.setIdDiagnostico(diagnosticoId);
        super.obtenerPorId();
        return this.diagnostico;
    }
    
    @Override
    public ArrayList<DiagnosticoDTO> listarTodos() {
        return (ArrayList<DiagnosticoDTO>) super.listarTodos();
    }
}
