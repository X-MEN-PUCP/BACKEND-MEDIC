/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcitbo.BO.RolesPorUsuarioBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "RolesPorUsuarioWS")
public class RolesPorUsuarioWS {

    private final RolesPorUsuarioBO rolesPorUsuarioBO;
    
    public RolesPorUsuarioWS(){
        this.rolesPorUsuarioBO=new RolesPorUsuarioBO();
    }
    
    @WebMethod(operationName = "listarPorUsuarioRolesPorUsuario")
    public ArrayList<UsuarioPorRolDTO> listarPorUsuarioRolesPorUsuario(
            @WebParam(name = "id")Integer id){
        return this.rolesPorUsuarioBO.listarPorUsuario(id);
    }
    
    @WebMethod(operationName = "insertarRolesPorUsuario")
    public Integer insertarRolesPorUsuario(
            @WebParam(name = "usarioPorRol")UsuarioPorRolDTO usarioPorRol){
        return this.rolesPorUsuarioBO.insertar(usarioPorRol);
    }
    
    @WebMethod(operationName = "eliminarRolPorUsuario")
    public Integer eliminarRolPorUsuario(
            @WebParam(name="usarioPorRol")UsuarioPorRolDTO usuarioPorRol){
        return this.rolesPorUsuarioBO.eliminar(usuarioPorRol);
    }
}
