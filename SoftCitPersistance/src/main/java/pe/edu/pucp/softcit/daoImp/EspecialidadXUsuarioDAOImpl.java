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
import pe.edu.pucp.softcit.dao.EspecialidadXUsuarioDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;

/**
 *
 * @author salva
 */
public class EspecialidadXUsuarioDAOImpl extends DAOImplBase implements EspecialidadXUsuarioDAO {

    private UsuarioPorEspecialidadDTO usuarioPorEspecialidad;
    private UsuarioDTO usuario;
    private EspecialidadDTO especialidad;

    public EspecialidadXUsuarioDAOImpl() {
        super("usuario_por_especialidad");
        this.usuarioPorEspecialidad = null;
        this.usuario = null;
        this.especialidad = null;
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

        Integer id_usuario = this.resultSet.getInt("id_usuario");
        UsuarioDTO usuario = obtenerUsuario(id_usuario);
        this.usuarioPorEspecialidad.setUsuario(usuario);

        Integer id_especialidad = this.resultSet.getInt("id_especialidad");
        EspecialidadDTO especialidad = obtenerEspecialidad(id_especialidad);
        this.usuarioPorEspecialidad.setEspecialidad(especialidad);
        
        this.usuarioPorEspecialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13
        this.usuarioPorEspecialidad.setUsuarioCreacion(this.resultSet.getInt("usuario_creación"));
        this.usuarioPorEspecialidad.setFechaCreacion(this.resultSet.getDate("fecha_creacion").toString());
        this.usuarioPorEspecialidad.setUsuarioModificacion(this.resultSet.getInt("usuario_modificación"));
        if(this.resultSet.getDate("fecha_modificacion") != null) 
            this.usuarioPorEspecialidad.setFechaModificacion(this.resultSet.getDate("fecha_modificacion").toString());
    }

    protected UsuarioDTO obtenerUsuario(Integer id) {
        if (this.usuario == null || !id.equals(this.usuario.getIdUsuario())) {
            UsuarioDAO usuarioDao = new UsuarioDAOImpl();
            this.usuario = usuarioDao.obtenerPorId(id);
        }
        return this.usuario;
    }

    protected EspecialidadDTO obtenerEspecialidad(Integer id) {
        if (this.especialidad == null || !id.equals(this.especialidad.getIdEspecialidad())) {
            EspecialidadDAO especialidadDAO = new EspecialidadDAOImpl();
            this.especialidad = especialidadDAO.obtenerPorId(id);
        }
        return this.especialidad;
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.usuarioPorEspecialidad = null;
        this.usuario = null;
        this.especialidad = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.usuarioPorEspecialidad);
    }

    @Override
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorUsuario(Integer id) {
        return listarPorCampo("id_usuario", id);
    }

    @Override
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorEspecialidad(Integer idEspecialidad) {
        return listarPorCampo("id_especialidad", idEspecialidad);
    }

    private ArrayList<UsuarioPorEspecialidadDTO> listarPorCampo(String nombreCampo, Integer valor) {
        ArrayList<UsuarioPorEspecialidadDTO> lista = new ArrayList<>();
        this.limpiarObjetoDelResultSet();
        try {
            this.abrirConexion();

            String sql = "SELECT * FROM usuario_por_especialidad WHERE " + nombreCampo + " = ?";
            this.colocarSQLenStatement(sql);

            this.statement.setInt(1, valor);

            this.ejecutarConsultaEnBD();
            while (this.resultSet.next()) {
                agregarObjetoALaLista(lista);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listar por campo '" + nombreCampo + "' - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return lista;
    }

    @Override
    public Integer insertar(UsuarioPorEspecialidadDTO usuarioXespecialidad) {
        this.usuarioPorEspecialidad = usuarioXespecialidad;
        return super.insertar();
    }

}
