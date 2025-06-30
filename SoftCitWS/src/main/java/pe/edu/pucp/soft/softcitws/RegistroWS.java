/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.RolDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcitbo.BO.RegistroBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "RegistroWS")
public class RegistroWS {

    private RegistroBO registroBO;
    
    public RegistroWS(){
        this.registroBO = new RegistroBO();
    }
    
    @WebMethod(operationName = "registrarse")
    public boolean registrarse(@WebParam(name = "usuario")UsuarioDTO usuario){
        return this.registroBO.registrarse(usuario);
    }
    
    @WebMethod(operationName = "verificarCodigo")
    public UsuarioDTO verificarCodigo(@WebParam(name="correo")String correo, @WebParam(name="codigo")String codigo){
        return this.registroBO.verificarCodigo(correo, codigo);
    }
    
    @WebMethod(operationName = "reenviarCodigo")
    public boolean reenviarCodigo(@WebParam(name="correo")String correo){
        return registroBO.reenviarCodigo(correo);
    }
}
