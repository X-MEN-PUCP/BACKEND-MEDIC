/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcitbo.BO.HistoriaBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "HistoriaWS")
public class HistoriaWS {

    private HistoriaBO historiaBO;
    
    public HistoriaWS(){
        historiaBO = new HistoriaBO();
    }
    
    @WebMethod(operationName = "listar")
    public ArrayList<HistoriaClinicaDTO> listar(){
        return this.historiaBO.listar();
    }
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(@WebParam(name = "historia")HistoriaClinicaDTO historia){
        return this.historiaBO.insertar(historia);
    }
    
    @WebMethod(operationName = "obtenerPorIdPaciente")
    public HistoriaClinicaDTO obtenerPorIdPaciente(@WebParam(name = "id")Integer id){
        return this.historiaBO.obtenerPorIdPaciente(id);
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public HistoriaClinicaDTO obtenerPorId(@WebParam(name = "id")Integer id){
        return this.historiaBO.obtenerPorId(id);
    }
}
