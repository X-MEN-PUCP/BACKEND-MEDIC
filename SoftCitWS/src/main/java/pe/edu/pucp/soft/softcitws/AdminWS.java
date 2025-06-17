/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcitbo.BO.AdminBO;
/**
 *
 * @author Cesar
 */
@WebService(serviceName = "AdminWS")
public class AdminWS {
    
    private AdminBO adminBO;
    
    public AdminWS(){
        this.adminBO = new AdminBO();
    }
    
    @WebMethod(operationName = "asignarNuevoRol")
    public Integer asignarNuevoRol(@WebParam(name = "usuario")UsuarioDTO usuario
            ,@WebParam(name = "idRol")Integer idRol){
        return this.adminBO.asignarNuevoRol(usuario, idRol);
    }
    
    
}
