/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.ExamenDAO;
import pe.edu.pucp.softcit.dao.TipoExamenDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.ExamenDTO;
import pe.edu.pucp.softcit.model.TipoExamenDTO;

/**
 *
 * @author Mcerv
 */
public class ExamenDAOImpl extends DAOImplBase implements ExamenDAO{
    private ExamenDTO examen;
    
    public ExamenDAOImpl(){
        super("examen");
        this.retornarLlavePrimaria = true;
        this.examen = null;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_examen", true, true));
        this.listaColumnas.add(new Columna("nombre_examen", false, false));
        this.listaColumnas.add(new Columna("id_tipo_de_examen", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.examen.getNombreExamen());
        this.statement.setInt(2, this.examen.getTipoExamen().getIdTipoExamen());
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.examen.getIdExamen());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.examen = new ExamenDTO();
        this.examen.setIdExamen(this.resultSet.getInt("id_examen"));
        this.examen.setNombreExamen(this.resultSet.getString("nombre_diagnostico"));
        //cargar Tipo de examen
        Integer idTipoExamen = this.resultSet.getInt("id_tipo_de_examen");
        TipoExamenDAO tipoExamenDAO = new TipoExamenDAOImpl();
        TipoExamenDTO tipoExamen = tipoExamenDAO.obtenerPorId(idTipoExamen);
        this.examen.setTipoExamen(tipoExamen);
        
        this.examen.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13
        
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.examen = null;
    }
    
    @Override
    public Integer insertar(ExamenDTO examen) {
        this.examen = examen;
        return super.insertar();
    }
    
    @Override
    public ExamenDTO obtenerPorId(Integer examenId) {
        this.examen = new ExamenDTO();
        this.examen.setIdExamen(examenId);
        super.obtenerPorId();
        return this.examen;
    }
    
    @Override
    public ArrayList<ExamenDTO> listarTodos() {
        return (ArrayList<ExamenDTO>) super.listarTodos();
    }
}
