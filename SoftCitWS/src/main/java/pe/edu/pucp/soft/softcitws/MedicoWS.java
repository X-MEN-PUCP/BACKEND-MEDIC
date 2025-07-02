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
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.ExamenDTO;
import pe.edu.pucp.softcit.model.ExamenPorCitaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.InterconsultaDTO;
import pe.edu.pucp.softcit.model.TipoExamenDTO;
import pe.edu.pucp.softcitbo.BO.MedicoBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "MedicoWS")
public class MedicoWS {

    private final MedicoBO medicoBo;
    
    public MedicoWS(){
        this.medicoBo = new MedicoBO();
    }
    
    @WebMethod(operationName = "listarCitasMedico")
    public ArrayList<CitaDTO> listarCitasMedico(
            @WebParam(name = "idMedico")Integer idMedico, 
            @WebParam(name= "estadoCita") EstadoCita estado){
        return this.medicoBo.listarCitasMedico(idMedico, estado);
    }
    
    @WebMethod(operationName = "llenarEpicrisisMedico")
    public Integer llenarEpicrisisMedico(
            @WebParam(name = "epiciris")HistoriaClinicaPorCitaDTO epiciris){
        return this.medicoBo.llenarEpicrisis(epiciris);
    }
    
    @WebMethod(operationName = "obtenerHistoriaClinicaPorCita")/////////////////
    public HistoriaClinicaPorCitaDTO obtenerHistoriaClinicaPorCita(
            @WebParam(name = "idCita")Integer idCita){
        return this.medicoBo.obtenerHistoriaClinicaPorCita(idCita);
    }
    
    @WebMethod(operationName = "listarEspecialidadesParaInterconsulta")///////
    public ArrayList<EspecialidadDTO> listarEspecialidadesParaInterconsulta(){
        return this.medicoBo.listarEspecialidadesParaInterconsulta();
    }
    
    @WebMethod(operationName = "insertarInterconsultasDeCita")////////
    public Integer insertarInterconsultasDeCita(
            @WebParam(name = "interconsulta") InterconsultaDTO interconsulta){
        return this.medicoBo.insertarInterconsultasDeCita(interconsulta);
    }
    
    @WebMethod(operationName = "modificarInteronsultaDeCita")////////
    public Integer modificarInteronsultaDeCita(
            @WebParam (name = "interconsulta")InterconsultaDTO interconsulta){
        return this.medicoBo.modificarInteronsultaDeCita(interconsulta);
    }
    
    @WebMethod(operationName = "eliminarInterconsultaDeCita")////////
    public Integer eliminarInterconsultaDeCita(
            @WebParam (name = "interconsulta")InterconsultaDTO interconsulta){
        return this.medicoBo.eliminarInterconsultaDeCita(interconsulta);
    }
    
    @WebMethod(operationName = "listarTiposDeExamen")////////
    public ArrayList<TipoExamenDTO> listarTiposDeExamen(){
        return this.medicoBo.listarTiposDeExamen();
    }
    
    @WebMethod(operationName = "listarExamenesPorTipo")////////
    public ArrayList<ExamenDTO> listarExamenesPorTipo(
            @WebParam (name = "idTipoExamen")Integer idTipoExamen){
        return this.medicoBo.listarExamenesPorTipo(idTipoExamen);
    }
    
    @WebMethod(operationName = "agregarExamenPorCita")////////
    public Integer agregarExamenPorCita(
            @WebParam (name = "examenPorCita")ExamenPorCitaDTO examenPorCita){
        return this.medicoBo.agregarExamenPorCita(examenPorCita);
    }
    
    
    @WebMethod(operationName = "obtenerCitaPorIdCitaParaMedico")
    public CitaDTO obtenerCitaPorIdCitaParaMedico(@WebParam(name = "id")Integer id){
        return this.medicoBo.obtenerCitaPorId(id);
    }
    
    @WebMethod(operationName = "modificarCitaParaMedico")
    public Integer modificarCitaParaPaciente(@WebParam(name = "idCita")CitaDTO cita) {
        return medicoBo.modificarCita(cita);
    }
    
    @WebMethod(operationName = "listarInterconsultasPorIdCitaParMedico")
    public ArrayList<InterconsultaDTO> listarInterconsultasPorIdCitaParMedico(@WebParam(name = "idCita") Integer idCita) {
        return medicoBo.ListarInterconsultasPorIdCita(idCita);
    }

    @WebMethod(operationName = "listarTodasLasInterconsultasParaMedico")
    public ArrayList<InterconsultaDTO> listarTodasLasInterconsultasParaMedico() {
        return medicoBo.listarTodasLasInterconsultas();
    }
    
    @WebMethod(operationName = "listarTodosLosExamenesParaMedico")
    public ArrayList<ExamenDTO> listarTodosLosExamenes() {
        return medicoBo.listarTodosLosExamanes();
    }

    @WebMethod(operationName = "obtenerExamenPorIdParaMedico")
    public ExamenDTO obtenerExamenPorId(@WebParam(name = "examenId") Integer examenId) {
        return medicoBo.obtenerExamenPorId(examenId);
    }
    
    @WebMethod(operationName = "listarExamenesPorIdCitaParaMedico")
    public ArrayList<ExamenPorCitaDTO> listarExamenesPorIdCitaParaMedico(@WebParam(name = "idCita") Integer idCita) {
        return medicoBo.listarExamenesPorIdCita(idCita);
    }

    @WebMethod(operationName = "obtenerDiagnosticoPorIdParaMedico")
    public DiagnosticoDTO obtenerDiagnosticoPorIdParaMedico(@WebParam(name = "diagnosticoId") Integer diagnosticoId) {
        return medicoBo.obtenerDiagnoticoPorId(diagnosticoId);
    }
    
    @WebMethod(operationName = "listarTodosLosDiaganosticosParaMedico")
    public ArrayList<DiagnosticoDTO> listarTodosLosDiaganosticosParaMedico() {
        return medicoBo.listarDiagnosticos();
    }
    
}
