/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;
import pe.edu.pucp.softcitbo.BO.UsuarioPorEspecialidadBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "UsuarioPorEspecialidadWS")
public class UsuarioPorEspecialidadWS {

    private UsuarioPorEspecialidadBO usuarioPorEspecialidadBO;
    
    public UsuarioPorEspecialidadWS(){
        this.usuarioPorEspecialidadBO = new UsuarioPorEspecialidadBO();
    }
    
    @WebMethod(operationName = "listarPorUsuario")
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorUsuario(
            @WebParam(name = "id")Integer id){
        return this.usuarioPorEspecialidadBO.listarPorUsuario(id);
    }
    
    @WebMethod(operationName = "listarPorEspecialidad")
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorEspecialidad(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad){
        return this.usuarioPorEspecialidadBO.listarPorEspecialidad(idEspecialidad);
    }
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "usuarioXespecialidad")
                    UsuarioPorEspecialidadDTO usuarioXespecialidad){
        return this.usuarioPorEspecialidadBO.insertar(usuarioXespecialidad);
    }
}
