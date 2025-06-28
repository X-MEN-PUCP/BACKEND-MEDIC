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
import pe.edu.pucp.softcit.dao.EspecialidadXUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.daoImp.util.UsuarioPorEspecialidadParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.UsuarioPorEspecialidadParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;

/**
 *
 * @author salva
 */
public class EspecialidadXUsuarioDAOImpl extends DAOImplBase implements EspecialidadXUsuarioDAO {

    private UsuarioPorEspecialidadDTO usuarioPorEspecialidad;

    public EspecialidadXUsuarioDAOImpl() {
        super("usuario_por_especialidad");
        this.usuarioPorEspecialidad = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_especialidad", true, false));
        this.listaColumnas.add(new Columna("id_usuario", true, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));

    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.usuarioPorEspecialidad.getEspecialidad().getIdEspecialidad());
        this.statement.setInt(2, this.usuarioPorEspecialidad.getUsuario().getIdUsuario());
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(4, this.usuarioPorEspecialidad.getUsuarioCreacion());
        this.statement.setDate(5, Date.valueOf(this.usuarioPorEspecialidad.getFechaCreacion()));
        this.statement.setNull(6, Types.INTEGER);
        this.statement.setNull(7, Types.DATE);

    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.usuarioPorEspecialidad = new UsuarioPorEspecialidadDTO();

        this.usuarioPorEspecialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado_usuario_por_especialidad")));
        this.usuarioPorEspecialidad.setUsuarioCreacion(this.resultSet.getInt("usuario_creacion_usuario_por_especialidad"));
        this.usuarioPorEspecialidad.setFechaCreacion(this.resultSet.getDate("fecha_creacion_usuario_por_especialidad").toString());
        this.usuarioPorEspecialidad.setUsuarioModificacion(this.resultSet.getInt("usuario_modificacion_usuario_por_especialidad"));
        if (this.resultSet.getDate("fecha_modificacion_usuario_por_especialidad") != null) {
            usuarioPorEspecialidad.setFechaModificacion(this.resultSet.getDate("fecha_modificacion_usuario_por_especialidad").toString());
        }

        this.usuarioPorEspecialidad.setUsuario(this.cargaTabla.cargarUsuario(this.resultSet));
        this.usuarioPorEspecialidad.setEspecialidad(this.cargaTabla.cargarEspecialidad(this.resultSet));

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.usuarioPorEspecialidad = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.usuarioPorEspecialidad);
    }
    
    @Override
    public Integer insertar(UsuarioPorEspecialidadDTO usuarioXespecialidad) {
        this.usuarioPorEspecialidad = usuarioXespecialidad;
        return super.insertar();
    }

    @Override
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorUsuario(Integer id) {
        Integer idEspecialidad = null;
        return listarUsuariosPorEspecialidadConFiltro(id, idEspecialidad);
    }

    @Override
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorEspecialidad(Integer idEspecialidad) {
        Integer idUsuario = null;
        return listarUsuariosPorEspecialidadConFiltro(idEspecialidad, idUsuario);
    }

    public ArrayList<UsuarioPorEspecialidadDTO> listarUsuariosPorEspecialidadConFiltro(Integer idUsuario, Integer idEspecialidad) {
        String sql = "{CALL universidad.sp_listar_usuarios_por_especialidad_completo(?, ?)}";

        Object parametros = new UsuarioPorEspecialidadParametrosBusquedaBuilder()
                .conIdUsuario(idUsuario)
                .conIdEspecialidad(idEspecialidad)
                .build();

        return (ArrayList<UsuarioPorEspecialidadDTO>) super.listarTodos(sql, this::incluirValorDeParametrosUsuarioPorEspecialidad, parametros);
    }

    private void incluirValorDeParametrosUsuarioPorEspecialidad(Object parametros) {
        UsuarioPorEspecialidadParametrosBusqueda filtro = (UsuarioPorEspecialidadParametrosBusqueda) parametros;

        try {
            if (filtro.getIdUsuario() != null) {
                this.statement.setInt(1, filtro.getIdUsuario());
            } else {
                this.statement.setNull(1, Types.INTEGER);
            }

            if (filtro.getIdEspecialidad() != null) {
                this.statement.setInt(2, filtro.getIdEspecialidad());
            } else {
                this.statement.setNull(2, Types.INTEGER);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadXUsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
