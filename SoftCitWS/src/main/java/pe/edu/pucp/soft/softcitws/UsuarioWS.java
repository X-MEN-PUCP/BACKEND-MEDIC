/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.EstadoLogico;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcitbo.BO.UsuarioBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "UsuarioWS")
public class UsuarioWS {

    private UsuarioBO usuarioBO;
    
    public UsuarioWS(){
        this.usuarioBO = new UsuarioBO();
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public UsuarioDTO obtenerPorId(@WebParam(name = "id")Integer id){
        return this.usuarioBO.obtenerPorId(id);
    }
    
    @WebMethod(operationName = "buscarCuenta")
    public UsuarioDTO buscarCuenta(@WebParam(name = "nroDocumento")String nroDocumento,
            @WebParam(name = "tipoDoc")String tipoDoc,
            @WebParam(name = "contrasenha")String contrasenha){
        return this.usuarioBO.buscarCuenta(nroDocumento, tipoDoc, contrasenha);
    }
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(@WebParam(name = "usuario")UsuarioDTO usuario){
        return this.usuarioBO.insertar(usuario);
    }
    
    @WebMethod(operationName = "modificar")
    public Integer modificar(@WebParam(name = "usuario")UsuarioDTO usuario){
        return this.usuarioBO.modificar(usuario);
    }
    
    @WebMethod(operationName = "cambiarEstadoGeneral")
    public Integer cambiarEstadoGeneral(@WebParam(name = "usuario")UsuarioDTO usuario,
            @WebParam(name = "estadoGeneral")Integer estadoGeneral){
        return this.usuarioBO.cambiarEstadoGeneral(usuario,estadoGeneral);
    }
    
    @WebMethod(operationName = "cambiarEstadoLogico")
    public Integer cambiarEstadoLogico(@WebParam(name = "usuario")UsuarioDTO usuario,
            @WebParam(name = "estadoLogico")Integer estadoLogico){
        return this.usuarioBO.cambiarEstadoLogico(usuario,estadoLogico);
    }
    
    @WebMethod(operationName = "completarRoles")
    public UsuarioDTO completarRoles(@WebParam(name = "usuario")UsuarioDTO usuario){
        return this.usuarioBO.completarRoles(usuario);
    }
}
