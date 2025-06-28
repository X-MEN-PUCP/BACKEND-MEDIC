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
    
    @WebMethod(operationName = "listarPorUsuarioUsuarioPorEspecialidad")
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorUsuarioUsuarioPorEspecialidad(
            @WebParam(name = "id")Integer id){
        return this.usuarioPorEspecialidadBO.listarPorUsuario(id);
    }
    
    @WebMethod(operationName = "listarPorEspecialidadUsuarioPorEspecialidad")
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorEspecialidadUsuarioPorEspecialidad(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad){
        return this.usuarioPorEspecialidadBO.listarPorEspecialidad(idEspecialidad);
    }
    
    @WebMethod(operationName = "insertarUsuarioPorEspecialidad")
    public Integer insertarUsuarioPorEspecialidad(
            @WebParam(name = "usuarioXespecialidad")
                    UsuarioPorEspecialidadDTO usuarioXespecialidad){
        return this.usuarioPorEspecialidadBO.insertar(usuarioXespecialidad);
    }
    
    @WebMethod(operationName = "listarTodosPerfilesMedicos")
    public ArrayList<UsuarioPorEspecialidadDTO> listarTodosPerfilesMedicos(){
        return this.usuarioPorEspecialidadBO.listarPorEspecialidad(null);
    }
}
