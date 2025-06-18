/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softcit.dao.TipoExamenDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.TipoExamenDTO;

/**
 *
 * @author Mcerv
 */
public class TipoExamenDAOImpl extends DAOImplBase implements TipoExamenDAO{
    private TipoExamenDTO tipoExamen;
    
    public TipoExamenDAOImpl(){
        super("tipo_de_examen");
        this.retornarLlavePrimaria = true;
        this.tipoExamen = null;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_tipo_de_examen", true, true));
        this.listaColumnas.add(new Columna("nombre_examen", false, false));
        this.listaColumnas.add(new Columna("indicacion", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.tipoExamen.getNombreTipoExamen());
        this.statement.setString(2, this.tipoExamen.getIndicacion());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.tipoExamen.getNombreTipoExamen());
        this.statement.setString(2, this.tipoExamen.getIndicacion());
        this.statement.setInt(3, this.tipoExamen.getIdTipoExamen());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.tipoExamen.getIdTipoExamen());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.tipoExamen = new TipoExamenDTO();
        this.tipoExamen.setIdTipoExamen(this.resultSet.getInt("id_tipo_de_examen"));
        this.tipoExamen.setNombreTipoExamen(this.resultSet.getString("nombre_examen"));
        this.tipoExamen.setIndicacion(this.resultSet.getString("indicacion"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.tipoExamen = null;
    }
    
    @Override
    public Integer insertar(TipoExamenDTO tipoExamen) {
        this.tipoExamen = tipoExamen;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(TipoExamenDTO tipoExamen) {
        this.tipoExamen = tipoExamen;
        return super.modificar();
    }
    
    @Override
    public TipoExamenDTO obtenerPorId(Integer tipoExamenId) {
        this.tipoExamen = new TipoExamenDTO();
        this.tipoExamen.setIdTipoExamen(tipoExamenId);
        super.obtenerPorId();
        return this.tipoExamen;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.tipoExamen);
    }
    
    
    @Override
    public ArrayList<TipoExamenDTO> listarTodos() {
        return (ArrayList<TipoExamenDTO>) super.listarTodos();
    }
}
