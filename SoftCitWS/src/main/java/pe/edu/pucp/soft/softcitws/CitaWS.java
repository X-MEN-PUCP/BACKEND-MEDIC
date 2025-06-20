/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcitbo.BO.CitaBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "CitaWS")
public class CitaWS {

    private CitaBO citaBO;
    
    public CitaWS(){
        citaBO = new CitaBO();
    }
    
    @WebMethod(operationName = "modificarCita")
    public Integer modificarCita(@WebParam(name = "idCita")CitaDTO cita) {
        return citaBO.modificar(cita);
    }
    
    @WebMethod(operationName = "listarTodosCita")
    public ArrayList<CitaDTO> listarTodosCita(){
        return this.citaBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarCitasMedicoWS")
    public ArrayList<CitaDTO> listarCitasMedicoWS(
            @WebParam(name = "idMedico")Integer idMedico, @WebParam(name= "estadoCita") EstadoCita estado){
        return this.citaBO.listarCitasMedico(idMedico, estado);
    }
    
    @WebMethod(operationName = "buscarCitasWSCitas")
    public ArrayList<CitaDTO> buscarCitasWSCitas(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad,
            @WebParam(name = "codMedico")Integer codMedico,
            @WebParam(name = "fecha")String fecha, 
            @WebParam(name= "hora_inicio") String hora_inicio, 
            @WebParam(name= "estadoCita") EstadoCita estado){
        return this.citaBO.buscarCitas(idEspecialidad, codMedico, fecha, hora_inicio, estado);
    }
    
    @WebMethod(operationName = "buscarCitasoloCalendario")
    public ArrayList<CitaDTO> buscarCitasoloCalendario(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad,
            @WebParam(name = "codMedico")Integer codMedico,
            @WebParam(name = "fecha")String fecha,
            @WebParam(name= "hora_inicio") String hora_inicio, 
            @WebParam(name= "estadoCita") EstadoCita estado){
        return this.citaBO.buscarCitasParaCalendario(idEspecialidad, codMedico, fecha, hora_inicio, estado);
    }
    
    @WebMethod(operationName = "obtenerPorIdCitaCita")
    public CitaDTO obtenerPorIdCita(@WebParam(name = "id")Integer id){
        return this.citaBO.obtenerPorId(id);
    }
}
