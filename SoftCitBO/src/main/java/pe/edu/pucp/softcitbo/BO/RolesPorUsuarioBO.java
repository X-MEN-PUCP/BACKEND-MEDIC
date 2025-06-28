/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.daoImp.RolesPorUsuarioDAOImpl;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcit.dao.RolesPorUsuarioDAO;

/**
 *
 * @author salva
 */
public class RolesPorUsuarioBO {
    
    private final RolesPorUsuarioDAO rolesPorUsuarioDao;
    
    public RolesPorUsuarioBO(){
        this.rolesPorUsuarioDao = new RolesPorUsuarioDAOImpl();
    } 
    
    public ArrayList<UsuarioPorRolDTO> listarPorUsuario(Integer id){
        return this.rolesPorUsuarioDao.listarPorUsuario(id);
    }
    
    public Integer insertar(UsuarioPorRolDTO usarioPorRol){
        return this.rolesPorUsuarioDao.insertar(usarioPorRol);
    }
    
    public Integer eliminar(UsuarioPorRolDTO usuarioPorRol){
        return this.rolesPorUsuarioDao.eliminar(usuarioPorRol);
    }
    
}
