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
import pe.edu.pucp.softcit.dao.ExamenPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.daoImp.util.ExamenParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.ExamenPorCitaParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.ExamenPorCitaParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
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
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, new ExamenDTO(this.examenPorCita.getExamen()).getIdExamen());
        this.statement.setInt(2, new CitaDTO(this.examenPorCita.getCita()).getIdCita());
        this.statement.setString(3, this.examenPorCita.getObservaciones());
        this.statement.setInt(4, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(5, this.examenPorCita.getUsuarioCreacion());
        this.statement.setDate(6, Date.valueOf(this.examenPorCita.getFechaCreacion()));
        this.statement.setNull(7, Types.INTEGER);
        this.statement.setNull(8, Types.DATE);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.examenPorCita.setExamen(this.cargaTabla.cargarExamen(resultSet));
        this.examenPorCita.setCita(this.cargaTabla.cargarCita(resultSet));
        
        this.examenPorCita.setObservaciones(this.resultSet.getString("observacion_examen_por_cita"));
        this.examenPorCita.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado_examen_por_cita")));
        this.examenPorCita.setUsuarioCreacion(this.resultSet.getInt("usuario_creacion_examen_por_cita"));
        this.examenPorCita.setFechaCreacion(this.resultSet.getDate("fecha_creacion_examen_por_cita").toString());
        this.examenPorCita.setUsuarioModificacion(this.resultSet.getInt("usuario_modificacion_examen_por_cita"));

        if (this.resultSet.getDate("fecha_modificacion_examen_por_cita") != null) {
            this.examenPorCita.setFechaModificacion(this.resultSet.getDate("fecha_modificacion_examen_por_cita").toString());
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.examenPorCita = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.examenPorCita);
    }

    @Override
    public Integer insertar(ExamenPorCita examenPorCita) {
        this.examenPorCita = examenPorCita;
        return super.insertar();
    }

    @Override
    public ArrayList<ExamenPorCita> listarTodos() {
        Integer idExamen = null;
        Integer idCita = null;
        return this.listarExamenesPorCitaConFiltros(idExamen, idCita);
    }

    @Override
    public ArrayList<ExamenPorCita> listarPorIdCita(Integer idCita) {
        Integer idExamen = null;
        return this.listarExamenesPorCitaConFiltros(idExamen, idCita);
    }

    private ArrayList<ExamenPorCita> listarExamenesPorCitaConFiltros(Integer idExamen, Integer idCita) {
        String sql = "{CALL universidad.sp_listar_examenes_por_cita_completo(?, ?)}";
        Object parametros = new ExamenPorCitaParametrosBusquedaBuilder()
                                .conIdCita(idCita)
                                .conIdExamen(idExamen)
                                .BuildExamenPorCitaParametrosBusqueda();
        return (ArrayList<ExamenPorCita>) super.listarTodos(sql, this::incluirParametrosParaBusquedaExamenPorCita, parametros);
    }

    private void incluirParametrosParaBusquedaExamenPorCita(Object parametros){
        ExamenPorCitaParametrosBusqueda examenPorCitaParametros = (ExamenPorCitaParametrosBusqueda) parametros;
        try{
            if (examenPorCitaParametros.getIdExamen() != null) {
                this.statement.setInt(1, examenPorCitaParametros.getIdExamen());
            } else {
                this.statement.setNull(1, Types.INTEGER);
            }

            if (examenPorCitaParametros.getIdCita() != null) {
                this.statement.setInt(2, examenPorCitaParametros.getIdCita());
            } else {
                this.statement.setNull(2, Types.INTEGER);
            }
        }catch(SQLException ex){
            Logger.getLogger(ExamenPorCitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
