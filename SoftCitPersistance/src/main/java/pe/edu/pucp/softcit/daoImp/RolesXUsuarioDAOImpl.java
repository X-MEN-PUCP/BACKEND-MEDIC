/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softcit.dao.RolesXUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
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
        
        this.listaColumnas.add(new Columna("id_usuario", true, false));
        this.listaColumnas.add(new Columna("id_rol", true, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        
    }
    
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.usarioPorRol = new UsuarioPorRolDTO();
        
        Integer id = this.resultSet.getInt("id_usuario");
        this.obtenerUsuario(id);
        this.usarioPorRol.setUsuarioDTO(this.usuario);
        
        Integer rol_id = this.resultSet.getInt("id_rol");
        RolDTO rol = new RolDTO();
        rol.setIdRol(rol_id);
        this.usarioPorRol.setRol(rol);
        
        this.usarioPorRol.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13

    }
    
    protected void obtenerUsuario(Integer id){
        if(this.usuario == null || !id.equals(this.usuario.getIdUsuario())){            
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
    public ArrayList<UsuarioPorRolDTO> listarPorUsuario(Integer id) {
        ArrayList<UsuarioPorRolDTO> lista = new ArrayList<>();
        this.usuario = null;
        try {
            this.abrirConexion();

            String sql = "SELECT * FROM usuario_por_rol WHERE id_usuario = ?";
            this.colocarSQLenStatement(sql); 

            this.statement.setInt(1, id);

            //Inlcuir parametros
            this.ejecutarConsultaEnBD();
            while (this.resultSet.next()) {
                agregarObjetoALaLista(lista);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return lista;
    }

}
