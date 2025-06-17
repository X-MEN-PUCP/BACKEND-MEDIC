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
    
    @WebMethod(operationName = "modificar")
    public Integer modificar(@WebParam(name = "idCita")CitaDTO cita) {
        return citaBO.modificar(cita);
    }
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<CitaDTO> listarTodos(){
        return this.citaBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarCitasProgramadas")
    public ArrayList<CitaDTO> listarCitasProgramadas(
            @WebParam(name = "codMedico")Integer codMedico){
        return this.citaBO.listarCitasProgramadas(codMedico);
    }
    
    @WebMethod(operationName = "buscarCitasDisponibles")
    public ArrayList<CitaDTO> buscarCitasDisponibles(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad,
            @WebParam(name = "codMedico")Integer codMedico,
            @WebParam(name = "fecha")LocalDate fecha){
        return this.citaBO.buscarCitasDisponibles(idEspecialidad, codMedico, fecha);
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public CitaDTO obtenerPorId(@WebParam(name = "id")Integer id){
        return this.citaBO.obtenerPorId(id);
    }
}
