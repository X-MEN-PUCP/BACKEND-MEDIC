/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcitbo.BO.AdminBO;
/**
 *
 * @author Cesar
 */
@WebService(serviceName = "AdminWS")
public class AdminWS {
    
    private final AdminBO adminBO;
    
    public AdminWS(){
        this.adminBO = new AdminBO();
    }
    
    @WebMethod(operationName = "asignarNuevoRolParaUsuario")
    public Integer asignarNuevoRolUsuario(
            @WebParam(name = "rolPorUsuario")UsuarioPorRolDTO usuarioPorRol){
        return this.adminBO.asignarNuevoRol(usuarioPorRol);
    }
    
    @WebMethod(operationName = "eliminarRolDeUsuario")
    public Integer eliminarRolDeUsuario(@WebParam(name="rolPorUsuario") UsuarioPorRolDTO usuarioPorRol){
        return this.adminBO.eliminarRol(usuarioPorRol);
    }
    
    @WebMethod(operationName = "insertarNuevaEspecialidad")
    public Integer insertarNuevaEspecialidad(@WebParam(name="especialidad") EspecialidadDTO especialidad){
        return this.adminBO.insertarNuevaEspecialidad(especialidad);
    }
    
    @WebMethod(operationName = "insertarNuevoMedico")
    public Integer insertarNuevoMedico(@WebParam(name="medico") UsuarioDTO medico, @WebParam(name="especialidad") EspecialidadDTO especialidad){
        return this.adminBO.insertarNuevoMedico(medico, especialidad);
    }
    
    @WebMethod(operationName = "listarMedicos")
    public ArrayList<UsuarioDTO> listarMedicos(){
        return this.adminBO.listarMedicos();
    }
}
