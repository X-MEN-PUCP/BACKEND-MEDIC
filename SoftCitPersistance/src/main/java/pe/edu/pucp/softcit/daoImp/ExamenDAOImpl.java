/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.ExamenDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.daoImp.util.ExamenParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.ExamenParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.ExamenDTO;

/**
 *
 * @author Mcerv
 */
public class ExamenDAOImpl extends DAOImplBase implements ExamenDAO{
    private ExamenDTO examen;
    private final CargaTablas cargaTablas;
    public ExamenDAOImpl(){
        super("examen");
        this.retornarLlavePrimaria = true;
        this.examen = null;
        this.cargaTablas = new CargaTablas();
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_examen", true, true));
        this.listaColumnas.add(new Columna("nombre_examen", false, false));
        this.listaColumnas.add(new Columna("id_tipo_de_examen", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.examen.getNombreExamen());
        this.statement.setInt(2, this.examen.getTipoExamen().getIdTipoExamen());
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(4, this.examen.getUsuarioCreacion());
        this.statement.setDate(5, Date.valueOf(this.examen.getFechaCreacion()));
        this.statement.setNull(6, Types.INTEGER);
        this.statement.setNull(7, Types.DATE);
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.examen.getIdExamen());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.examen = this.cargaTablas.cargarExamen(this.resultSet);
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.examen = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.examen);
    }
    
    @Override
    public Integer insertar(ExamenDTO examen) {
        this.examen = examen;
        return super.insertar();
    }
    
    @Override
    public ExamenDTO obtenerPorId(Integer examenId) {
        ArrayList<ExamenDTO> lista;
        Integer idTipoDeExamen = null;
        lista = this.listarExamenesPorFiltro(examenId, idTipoDeExamen);
        if (!lista.isEmpty()) {
            this.examen = lista.getFirst();
        }
        return this.examen;
    }
    
    @Override
    public ArrayList<ExamenDTO> listarTodos() {
        Integer idExamen = null;
        Integer idTipoDeExamen = null;
        return this.listarExamenesPorFiltro(idExamen, idTipoDeExamen);
    }
    
    private ArrayList<ExamenDTO> listarExamenesPorFiltro(Integer idExamen, Integer idTipoDeExamen) {
        String sql = "{CALL universidad.sp_listar_examenes_completo(?, ?)}";
        Object parametros = new ExamenParametrosBusquedaBuilder()
                                .conIdExamen(idExamen)
                                .conIdTipoDeExamen(idTipoDeExamen)
                                .BuildExamenParametrosBusqueda();
        
        return (ArrayList<ExamenDTO>) super.listarTodos(sql,this::incluirValorDeParametrosParaBuscarExamen, parametros);
    }

    private void incluirValorDeParametrosParaBuscarExamen(Object parametros){
        ExamenParametrosBusqueda examenParametro = (ExamenParametrosBusqueda) parametros;
        try{
        // Parámetro 1: idExamen
        if (examenParametro.getIdExamen() != null) {
            this.statement.setInt(1, examenParametro.getIdExamen());
        } else {
            this.statement.setNull(1, Types.INTEGER);
        }

        // Parámetro 2: idTipoDeExamen
        if (examenParametro.getIdTipoDeExamen() != null) {
            this.statement.setInt(2, examenParametro.getIdTipoDeExamen());
        } else {
            this.statement.setNull(2, Types.INTEGER);
        }
        }catch(SQLException ex){
            Logger.getLogger(ExamenPorCitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
