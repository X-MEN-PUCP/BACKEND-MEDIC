/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcitbo.BO.LoginBO;
import pe.edu.pucp.softcitbo.BO.util.Cifrado;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "LoginWS")
public class LoginWS {

    private LoginBO loginBO;
    
    public LoginWS(){
        this.loginBO = new LoginBO();
    }
    
    @WebMethod(operationName = "iniciarSesion")
    public UsuarioDTO iniciarSesion(
            @WebParam(name = "numeroDoc")String numeroDoc,
            @WebParam(name = "tipoDoc")String tipoDoc,
            @WebParam(name = "contrasenha")String contrasenha){
        return this.loginBO.iniciarSesion(numeroDoc, tipoDoc, contrasenha);
    }
    
    @WebMethod(operationName = "cerrarSesion")
    public boolean cerrarSesion(
            @WebParam(name = "usuarioDTO")UsuarioDTO usuarioDTO){
        usuarioDTO = null;
        return true;
    }
}
