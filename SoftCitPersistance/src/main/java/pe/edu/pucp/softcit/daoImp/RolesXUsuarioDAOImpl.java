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
import pe.edu.pucp.softcit.dao.RolesXUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.util.UsuarioRolParametrosBusqueda;
import pe.edu.pucp.softcit.daoImp.util.UsuarioRolParametrosBusquedaBuilder;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.RolDTO;

/**
 *
 * @author salva
 */
public class RolesXUsuarioDAOImpl extends DAOImplBase implements RolesXUsuarioDAO {

    private UsuarioPorRolDTO usarioPorRol;
    private UsuarioDTO usuario;

    public RolesXUsuarioDAOImpl() {
        super("usuario_por_rol");
        this.usarioPorRol = null;
        this.usuario = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_rol", true, false));
        this.listaColumnas.add(new Columna("id_usuario", true, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.usarioPorRol.getRol().getIdRol());
        this.statement.setInt(2, this.usarioPorRol.getUsuarioDTO().getIdUsuario());
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(4, this.usarioPorRol.getUsuarioCreacion());
        this.statement.setDate(5, Date.valueOf(this.usarioPorRol.getFechaCreacion()));
        this.statement.setNull(6, Types.INTEGER);
        this.statement.setNull(7, Types.DATE);
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.usarioPorRol.getRol().getIdRol());
        this.statement.setInt(2, this.usarioPorRol.getUsuarioDTO().getIdUsuario());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.usarioPorRol = new UsuarioPorRolDTO();

        this.usarioPorRol.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado_usuario_por_rol")));
        this.usarioPorRol.setUsuarioCreacion(this.resultSet.getInt("usuario_creacion_usuario_por_rol"));
        this.usarioPorRol.setFechaCreacion(this.resultSet.getDate("fecha_creacion_usuario_por_rol").toString());
        this.usarioPorRol.setUsuarioModificacion(this.resultSet.getInt("usuario_modificacion_usuario_por_rol"));
        if (this.resultSet.getDate("fecha_modificacion_usuario_por_rol") != null) {
            this.usarioPorRol.setFechaModificacion(this.resultSet.getDate("fecha_modificacion_usuario_por_rol").toString());
        }
        this.usarioPorRol.setUsuarioDTO(this.cargaTabla.cargarUsuario(this.resultSet));
        this.usarioPorRol.setRol(this.cargaTabla.cargarRol(this.resultSet));

    }

    protected void obtenerUsuario(Integer id) {
        if (this.usuario == null || !id.equals(this.usuario.getIdUsuario())) {
            UsuarioDAO usuarioDao = new UsuarioDAOImpl();
            this.usuario = usuarioDao.obtenerPorId(id);
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.usarioPorRol = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.usarioPorRol);

    }

    @Override
    public Integer insertar(UsuarioPorRolDTO usarioPorRol) {
        this.usarioPorRol = usarioPorRol;
        return super.insertar();
    }

    @Override
    public Integer eliminar(UsuarioPorRolDTO usuarioPorRol) {
        this.usarioPorRol = usuarioPorRol;
        return super.eliminar();
    }

    @Override
    public ArrayList<UsuarioPorRolDTO> listarPorUsuario(Integer id) {
        Integer idRol = null;
        return listarUsuariosPorRol(id, idRol);
    }

    public ArrayList<UsuarioPorRolDTO> listarUsuariosPorRol(Integer idUsuario, Integer idRol) {
        String sql = "{CALL universidad.sp_listar_usuarios_por_rol_completo(?, ?)}";

        Object parametros = new UsuarioRolParametrosBusquedaBuilder()
                .conIdUsuario(idUsuario)
                .conIdRol(idRol)
                .buildUsuarioRolParametrosBusqueda();

        return (ArrayList<UsuarioPorRolDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaBuscarUsuarioRol, parametros);
    }

    private void incluirValorDeParametrosParaBuscarUsuarioRol(Object parametros) {
        UsuarioRolParametrosBusqueda p = (UsuarioRolParametrosBusqueda) parametros;

        try {
            // Parámetro 1: id_usuario
            if (p.getIdUsuario() != null) {
                this.statement.setInt(1, p.getIdUsuario());
            } else {
                this.statement.setNull(1, Types.INTEGER);
            }

            // Parámetro 2: id_rol
            if (p.getIdRol() != null) {
                this.statement.setInt(2, p.getIdRol());
            } else {
                this.statement.setNull(2, Types.INTEGER);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesXUsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
