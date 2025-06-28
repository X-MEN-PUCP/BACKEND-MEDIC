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
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.HistoriaDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.daoImp.util.HistoriaClinicaParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.HistoriaClinicaParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;

/**
 *
 * @author salva
 */
public class HistoriaDAOImpl extends DAOImplBase implements HistoriaDAO {

    private HistoriaClinicaDTO historia;
    private final CargaTablas cargaTablas;

    public HistoriaDAOImpl() {
        super("historia_clinica");
        this.historia = null;
        this.cargaTablas = new CargaTablas();
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_historia", true, true));
        this.listaColumnas.add(new Columna("id_paciente", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {

        this.statement.setInt(1, this.historia.getPaciente().getIdUsuario());
        this.statement.setInt(2, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(3, this.historia.getUsuarioCreacion());
        this.statement.setDate(4, Date.valueOf(this.historia.getFechaCreacion()));
        this.statement.setNull(5, Types.INTEGER);
        this.statement.setNull(6, Types.DATE);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.historia = this.cargaTablas.cargarHistoriaClinica(this.resultSet);
        this.historia.setPaciente(this.cargaTablas.cargarUsuario(this.resultSet));
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.historia.getIdHistoriaClinica());

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.historia = null;

    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.historia);
    }

    @Override
    public ArrayList<HistoriaClinicaDTO> listar() {
        return (ArrayList<HistoriaClinicaDTO>) this.listarHistoriasClinicasConFiltro(null, null);

    }

    @Override
    public Integer insertar(HistoriaClinicaDTO historia) {
        this.historia = historia;
        return super.insertar();
    }

    @Override
    public HistoriaClinicaDTO obtenerPorIdPaciente(Integer idPaciente) {
        ArrayList<HistoriaClinicaDTO> lista;
        Integer idHistoria = null;
        lista = listarHistoriasClinicasConFiltro(idHistoria, idPaciente);
        if (!lista.isEmpty()) {
            this.historia = lista.getFirst();
        }
        return this.historia;
        
    }

    @Override
    public HistoriaClinicaDTO obtenerPorId(Integer idHistoria) {
        ArrayList<HistoriaClinicaDTO> lista;
        Integer idPaciente = null;
        lista = listarHistoriasClinicasConFiltro(idHistoria, idPaciente);
        if (!lista.isEmpty()) {
            this.historia = lista.getFirst();
        }
        return this.historia;
    }

    private ArrayList<HistoriaClinicaDTO> listarHistoriasClinicasConFiltro(Integer idHistoria, Integer idPaciente) {
        String sql = "{CALL universidad.sp_listar_historia_clinica(?, ?)}";
        Object parametros = new HistoriaClinicaParametrosBusquedaBuilder()
                                .conIdHistoria(idHistoria)
                                .conIdPaciente(idPaciente)
                                .BuildHistoriaClinicaParametrosBusqueda();
        return (ArrayList<HistoriaClinicaDTO>) super.listarTodos(sql, this::inluirValorDeParametrosParaBusquedaDeHistoriaClinica, parametros);
    }

    private void inluirValorDeParametrosParaBusquedaDeHistoriaClinica(Object parametros){
        HistoriaClinicaParametrosBusqueda historiaParametros = (HistoriaClinicaParametrosBusqueda) parametros;
        try{
            // Parámetro 1: id_historia
            if (historiaParametros.getIdHistoria() != null) {
                this.statement.setInt(1, historiaParametros.getIdHistoria());
            } else {
                this.statement.setNull(1, Types.INTEGER);
            }

            // Parámetro 2: id_paciente
            if (historiaParametros.getIdPaciente() != null) {
                this.statement.setInt(2, historiaParametros.getIdPaciente());
            } else {
                this.statement.setNull(2, Types.INTEGER);
            }
        }catch(SQLException ex){
            Logger.getLogger(HistoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
