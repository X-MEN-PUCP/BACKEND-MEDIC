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
import pe.edu.pucp.softcit.dao.InterconsultaDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.daoImp.util.InterconsultaParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.InterconsultaParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.InterconsultaDTO;

/**
 *
 * @author Cesar
 */
public class InterconsultaDAOImpl extends DAOImplBase implements InterconsultaDAO {

    private InterconsultaDTO interconsulta;

    public InterconsultaDAOImpl() {
        super("interconsulta");
        this.retornarLlavePrimaria = true;
        this.interconsulta = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_interconsulta", true, false));
        this.listaColumnas.add(new Columna("id_cita", true, false));
        this.listaColumnas.add(new Columna("razon_interconsulta", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, new EspecialidadDTO(this.interconsulta.getEspecialidadInterconsulta()).getIdEspecialidad());
        this.statement.setInt(2, new CitaDTO(this.interconsulta.getCita()).getIdCita());
        this.statement.setString(3, this.interconsulta.getRazonInterconsulta());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.interconsulta.getRazonInterconsulta());
        this.statement.setInt(2, this.interconsulta.getEspecialidadInterconsulta().getIdEspecialidad());
        this.statement.setInt(3, this.interconsulta.getCita().getIdCita());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.interconsulta.getEspecialidadInterconsulta().getIdEspecialidad());
        this.statement.setInt(2, this.interconsulta.getCita().getIdCita());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, new EspecialidadDTO(this.interconsulta.getEspecialidadInterconsulta()).getIdEspecialidad());
        this.statement.setInt(2, new CitaDTO(this.interconsulta.getCita()).getIdCita());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.interconsulta = new InterconsultaDTO();
        this.interconsulta.setEspecialidadInterconsulta(this.cargaTabla.cargarEspecialidad(this.resultSet));
        this.interconsulta.setCita(this.cargaTabla.cargarCita(this.resultSet));
        this.interconsulta.setRazonInterconsulta(this.resultSet.getString("razon_interconsulta_interconsulta"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.interconsulta = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.interconsulta);
    }

    @Override
    public Integer insertar(InterconsultaDTO interconsulta) {
        this.interconsulta = interconsulta;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(InterconsultaDTO interconsulta) {
        this.interconsulta = interconsulta;
        return super.modificar();
    }
    
    @Override
    public Integer eliminar(InterconsultaDTO interconsulta) {
        this.interconsulta = interconsulta;
        return super.eliminar();
    }

    @Override
    public InterconsultaDTO obtenerPorId(Integer idEspecialidad, Integer idCita) {
        ArrayList<InterconsultaDTO> lista;
        lista = listarInterconsultasPorFiltros(idEspecialidad, idCita);
        if (!lista.isEmpty()) {
            this.interconsulta = lista.getFirst();
        }
        return this.interconsulta;
    }

    @Override
    public ArrayList<InterconsultaDTO> listarTodos() {
        Integer idEspecialidadInterconsulta = null;
        Integer idCita = null;
        return this.listarInterconsultasPorFiltros(idEspecialidadInterconsulta, idCita);
    }

    @Override
    public ArrayList<InterconsultaDTO> buscarInterconsultasPorCita(Integer idCita) {
        Integer idEspecialidadInterconsulta = null;
        return this.listarInterconsultasPorFiltros(idEspecialidadInterconsulta, idCita);
    }
    
    private ArrayList<InterconsultaDTO> listarInterconsultasPorFiltros(Integer idEspecialidadInterconsulta, Integer idCita){
        String sql = "{CALL universidad.sp_listar_interconsultas_completo(?, ?)}";
        Object parametros = new InterconsultaParametrosBusquedaBuilder()
                                .conIdCita(idCita)
                                .conIdEspecialidadInterconsulta(idEspecialidadInterconsulta)
                                .BuildInterconsultaParametrosBusqueda();
        return (ArrayList<InterconsultaDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaBuscarInterconsulta, parametros);
    }

    private void incluirValorDeParametrosParaBuscarInterconsulta(Object parametros){
        InterconsultaParametrosBusqueda interconsultaParametros = (InterconsultaParametrosBusqueda) parametros;
        try{
            if (interconsultaParametros.getIdEspecialidadInterconsulta() != null) {
                this.statement.setInt(1, interconsultaParametros.getIdEspecialidadInterconsulta());
            } else {
                this.statement.setNull(1, Types.INTEGER);
            }

            if (interconsultaParametros.getIdCita() != null) {
                this.statement.setInt(2, interconsultaParametros.getIdCita());
            } else {
                this.statement.setNull(2, Types.INTEGER);
            }
        }catch(SQLException ex){
            Logger.getLogger(InterconsultaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
