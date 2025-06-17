/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.RolesXUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.RolesXUsuarioDAOImpl;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author salva
 */
public class RolesPorUsuarioBO {
    
 
    private RolesXUsuarioDAO rolesPorUsuarioDao;
    
    
    public RolesPorUsuarioBO(){
        rolesPorUsuarioDao = new RolesXUsuarioDAOImpl();
    } 
    
    public ArrayList<UsuarioPorRolDTO> listarPorUsuario(Integer id){
        return this.rolesPorUsuarioDao.listarPorUsuario(id);
    }
    public Integer insertar(UsuarioPorRolDTO usarioPorRol){
        return this.rolesPorUsuarioDao.insertar(usarioPorRol);
    }
    
}
