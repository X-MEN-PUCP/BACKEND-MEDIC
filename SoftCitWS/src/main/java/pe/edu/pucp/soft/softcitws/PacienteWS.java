/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcitbo.BO.PacienteBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "PacienteWS")
public class PacienteWS {

    private final PacienteBO pacienteBO;

    public PacienteWS() {
        this.pacienteBO = new PacienteBO();
    }

    @WebMethod(operationName = "buscarCitasPaciente")
    public ArrayList<CitaDTO> buscarCitasPaciente(
            @WebParam(name = "idEspecialidad") Integer idEspecialidad,
            @WebParam(name = "fecha") String fecha,
            @WebParam(name = "idMedico") Integer idMedico,
            @WebParam(name= "hora_inicio") String hora_inicio, 
            @WebParam(name= "estadoCita") EstadoCita estado){
        return this.pacienteBO.listarCitas(idEspecialidad, fecha, idMedico, hora_inicio, estado);
    }
    
    @WebMethod(operationName = "reservarCitaPaciente")
    public int reservarCitaPaciente(
            @WebParam(name = "cita")CitaDTO cita,
            @WebParam(name = "paciente")UsuarioDTO paciente) {//es id de cuenta o id persona? cemanu: no sabria decirte
        return this.pacienteBO.reservarCita(cita, paciente);
    }

    @WebMethod(operationName = "cancelarCitaPaciente")
    public int cancelarCitaPaciente(@WebParam(name = "historia_por_cita")
                    HistoriaClinicaPorCitaDTO historia_por_cita) {
        return this.pacienteBO.cancelarCita(historia_por_cita);
    }

    @WebMethod(operationName = "reprogramarCitaPaciente")
    public int reprogramarCitaPaciente(
            @WebParam(name = "citaNueva")CitaDTO citaNueva,
            @WebParam(name = "historia_por_cita")HistoriaClinicaPorCitaDTO historia_por_cita) {
        return this.pacienteBO.reprogramar(citaNueva, historia_por_cita);
    }

    @WebMethod(operationName = "listarCitasPorPaciente")
    public ArrayList<HistoriaClinicaPorCitaDTO> listarCitasPorPaciente(
            @WebParam(name = "paciente")UsuarioDTO persona) {
        return this.pacienteBO.listarCitasPorPersona(persona);
    }
    
    @WebMethod(operationName = "ActualizarEStadoDeCita")
    public void ActualizarEStadoDeCita(
            @WebParam(name = "idCita")Integer idCita,
            @WebParam(name = "Estado")Integer Estado,@WebParam(name = "IdModificacion")Integer idModi){
        this.pacienteBO.cambiarEstadoCita(idCita, Estado,idModi);
    }
    
    @WebMethod(operationName = "listarMedicosPorEspecialidadPaciente")
    public ArrayList<UsuarioPorEspecialidadDTO> listarMedicosPorEspecialidadPaciente(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad){
        return this.pacienteBO.listarPorEspecialidad(idEspecialidad);
    }
    
    
    
    @WebMethod(operationName = "listarTodosPerfilesMedicosParaPaciente")
    public ArrayList<UsuarioPorEspecialidadDTO> listarTodosPerfilesMedicosParaPaciente(){
        return this.pacienteBO.listarPorEspecialidad(null);
    }
    
     @WebMethod(operationName = "listarTodasLasEspecialidadesParaElPaceinte")
    public ArrayList<EspecialidadDTO> listarTodasLasEspecialidadesParaElPaceinte(){
        return this.pacienteBO.listarEspecialidades();
    }
    
    @WebMethod(operationName = "buscarCitasParaPaciente")
    public ArrayList<CitaDTO> buscarCitasParaPaciente(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad,
            @WebParam(name = "codMedico")Integer codMedico,
            @WebParam(name = "fecha")String fecha, 
            @WebParam(name= "hora_inicio") String hora_inicio, 
            @WebParam(name= "estadoCita") EstadoCita estado){
        return this.pacienteBO.buscarCitas(idEspecialidad, codMedico, fecha, hora_inicio, estado);
    }
    
    @WebMethod(operationName = "obtenerPorIdCitaParaPaciente")
    public CitaDTO obtenerPorIdCitaParaPaciente(@WebParam(name = "id")Integer id){
        return this.pacienteBO.obtenerCitaPorId(id);
    }
    
    @WebMethod(operationName = "modificarCitaParaPaciente")
    public Integer modificarCitaParaPaciente(@WebParam(name = "idCita")CitaDTO cita) {
        return pacienteBO.modificarCita(cita);
    }
    
    @WebMethod(operationName = "listarRolesPorUsuarioVistaPaciente")
    public ArrayList<UsuarioPorRolDTO> listarRolesPorUsuarioVistaPaciente(
            @WebParam(name = "id")Integer id){
        return this.pacienteBO.listarRolesDelUsuario(id);
    }
    
}
