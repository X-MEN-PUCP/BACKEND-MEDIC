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
public class RegistroBO {
    
    private final UsuarioDAO usuarioDao;
    private final RolesXUsuarioDAO rolesPorUsuarioDao;
    
    
    public RegistroBO(){
        this.usuarioDao = new UsuarioDAOImpl();
        this.rolesPorUsuarioDao = new RolesXUsuarioDAOImpl();
    } 
    
    public boolean registrarse(UsuarioDTO usuario){
        Integer insert = this.usuarioDao.insertar(usuario);
        if(insert!=0){
            UsuarioPorRolDTO usarioPorRol = new UsuarioPorRolDTO();
            usarioPorRol.setUsuarioDTO(usuario);
            RolDTO rol = new RolDTO();
            rol.setIdRol(1);
            usarioPorRol.setRol(rol);
            this.rolesPorUsuarioDao.insertar(usarioPorRol);
            return true;
        }
        return false;
    }
    
    
}
