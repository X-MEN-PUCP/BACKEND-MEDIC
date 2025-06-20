/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.daoImp.HistoriaClinicaPorCitaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcitbo.BO.MedicoBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "MedicoWS")
public class MedicoWS {

    private MedicoBO medicoBo;
    
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
}
