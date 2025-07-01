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
import pe.edu.pucp.softcit.model.ReporteCitaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;
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
    
    //////////////////////////////////////////////////
    @WebMethod(operationName = "insertarNuevoMedico")
    public Integer insertarNuevoMedico(@WebParam(name="medico") UsuarioDTO medico, @WebParam(name="especialidades") ArrayList<EspecialidadDTO> especialidades){
        return this.adminBO.insertarNuevoMedico(medico, especialidades);
    }
    
    @WebMethod(operationName = "listarMedicos")
    public ArrayList<UsuarioDTO> listarMedicos(){
        return this.adminBO.listarMedicos();
    }
    
    @WebMethod(operationName = "listarTodosUsuarios")
    public ArrayList<UsuarioDTO> listarTodosUsuarios(){
        return this.adminBO.listarTodosUsuarios();
    }
    
    @WebMethod(operationName = "listarEspecialidades")
    public ArrayList<EspecialidadDTO> listarEspecialidades(){
        return this.adminBO.listarEspecialidades();
    }
    
    @WebMethod(operationName = "obtenerEspecialidadPorId")
    public EspecialidadDTO obtenerEspecialidadPorId(
            @WebParam(name="idEspecialidad")Integer idEspecialidad){
        return this.adminBO.obtenerEspecialidadPorId(idEspecialidad);
    }
    
    @WebMethod(operationName = "modificarEspecialidads")
    public Integer modificarEspecialidad(
            @WebParam(name="especialidad") EspecialidadDTO especialidad){
        return this.adminBO.modificarEspecialidad(especialidad);
    }
    
    @WebMethod(operationName = "listarUsuariosPorEspecialidad")
    public ArrayList<UsuarioPorEspecialidadDTO> listarUsuariosPorEspecialidad(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad){
        return this.adminBO.listarUsuariosPorEspecialidad(idEspecialidad);
    }
    
    @WebMethod(operationName = "listarRolesDeUsuario")
    public ArrayList<UsuarioPorRolDTO> listarRolesDeUsuario(
            @WebParam(name = "idUsuario")Integer idUsuario){
        return this.adminBO.listarRolesDeUsuario(idUsuario);
    }
    
    @WebMethod(operationName = "obtenerUsuarioPorId")
    public UsuarioDTO obtenerUsuarioPorId(
            @WebParam(name="idUsuario")Integer idUsuario){
        return this.adminBO.obtenerUsuarioPorId(idUsuario);
    }
    
    @WebMethod(operationName = "modificarUsuarios")
    public Integer modificarUsuario(
            @WebParam(name="usuario")UsuarioDTO usuario){
        return this.adminBO.modificarUsuario(usuario);
    }
    
    @WebMethod(operationName = "agregarEspecialidadAMedico")
    public Integer agregarEspecialidadAMedico(
            @WebParam(name="usuarioPorEspecialidad")UsuarioPorEspecialidadDTO usuarioPorEspecialidad){
        return this.adminBO.agregarEspecialidadAMedico(usuarioPorEspecialidad);
    }
    
    @WebMethod(operationName = "eliminarEspecialidadMedico")
    public Integer eliminarEspecialidadMedico(UsuarioPorEspecialidadDTO usuarioPorEspecialidad){////////////
        return this.adminBO.eliminarEspecialidadMedico(usuarioPorEspecialidad);
    }
    
    @WebMethod(operationName = "insertarNuevoAdministrador")
    public Integer insertarNuevoAdministrador(UsuarioDTO administrador){
        return this.adminBO.insertarNuevoAdministrador(administrador);
    }
            
    @WebMethod(operationName = "insertarNuevoPaciente")         
    public Integer insertarNuevoPaciente(UsuarioDTO paciente){
        return this.adminBO.insertarNuevoPaciente(paciente);
    }
    
    @WebMethod(operationName = "ReporteDeCitasGeneralAdministrador")
    public ArrayList<ReporteCitaDTO> ReporteDeCitasGeneralAdministrador(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad,
            @WebParam(name = "codMedico")Integer codMedico,
            @WebParam(name = "fecha_inicio")String fecha_inicio, 
            @WebParam(name= "fecha_fini") String fecha_fin){
        

        return this.adminBO.obtenerReporteCitas(fecha_inicio, fecha_fin, idEspecialidad, codMedico);
    }
}
