/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.daoImp.HistoriaClinicaPorCitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.HistoriaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcitbo.BO.PacienteBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "PacienteWS")
public class PacienteWS {

    private PacienteBO pacienteBO;

    public PacienteWS() {
        this.pacienteBO = new PacienteBO();
    }

    @WebMethod(operationName = "listarCitas")
    public ArrayList<CitaDTO> listarCitas(
            @WebParam(name = "idEspecialidad") Integer idEspecialidad,
            @WebParam(name = "fecha") LocalDate fecha,
            @WebParam(name = "idMedico") Integer idMedico) {
        return this.pacienteBO.listarCitas(idEspecialidad, fecha, idMedico);
    }
    
    @WebMethod(operationName = "reservarCita")
    public int reservarCita(
            @WebParam(name = "cita")CitaDTO cita,
            @WebParam(name = "paciente")UsuarioDTO paciente) {//es id de cuenta o id persona? cemanu: no sabria decirte
        return this.pacienteBO.reservarCita(cita, paciente);
    }

    @WebMethod(operationName = "cancelarCita")
    public int cancelarCita(
            @WebParam(name = "cita")CitaDTO cita,
            @WebParam(name = "historia_por_cita")
                    HistoriaClinicaPorCitaDTO historia_por_cita) {
        return this.pacienteBO.cancelarCita(cita, historia_por_cita);
    }

    @WebMethod(operationName = "reprogramar")
    public int reprogramar(
            @WebParam(name = "citaAntigua")CitaDTO citaAntigua,
            @WebParam(name = "citaNueva")CitaDTO citaNueva,
            @WebParam(name = "historia_por_cita")HistoriaClinicaPorCitaDTO historia_por_cita) {
        return this.pacienteBO.reprogramar(citaAntigua, citaNueva, historia_por_cita);
    }

    @WebMethod(operationName = "listarCitasPorPersona")
    public ArrayList<HistoriaClinicaPorCitaDTO> listarCitasPorPersona(
            @WebParam(name = "historia")HistoriaClinicaDTO historia) {
        return this.pacienteBO.listarCitasPorPersona(historia);
    }
}
