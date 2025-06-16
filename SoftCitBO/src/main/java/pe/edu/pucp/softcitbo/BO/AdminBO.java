/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import pe.edu.pucp.softcit.dao.RolesXUsuarioDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.RolesXUsuarioDAOImpl;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.RolDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author salva
 */
public class AdminBO {
    
    private UsuarioDAO usuarioDao;
    private RolesXUsuarioDAO rolesPorUsuarioDao;
    
    
    public AdminBO(){
        usuarioDao = new UsuarioDAOImpl();
        rolesPorUsuarioDao = new RolesXUsuarioDAOImpl();
    } 
    
    public Integer asignarNuevoRol(UsuarioDTO usuario,Integer idRol){
        
        UsuarioPorRolDTO usuarioPorRol = new UsuarioPorRolDTO();
        usuarioPorRol.setUsuarioDTO(usuario);
        
        RolDTO rol = new RolDTO();
        rol.setIdRol(idRol);
        
        usuarioPorRol.setRol(rol);
        
        return this.rolesPorUsuarioDao.insertar(usuarioPorRol);
    }
    
}
