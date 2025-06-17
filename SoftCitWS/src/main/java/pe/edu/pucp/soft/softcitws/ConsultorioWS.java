/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.ConsultorioDTO;
import pe.edu.pucp.softcitbo.BO.ConsultorioBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "ConsultorioWS")
public class ConsultorioWS {

    private ConsultorioBO consultorioBO;
    
    public ConsultorioWS(){
        consultorioBO = new ConsultorioBO();
    }
    
    @WebMethod(operationName = "insertarConsultorio")
    public Integer insertarConsultorio(@WebParam(name = "consultorio")ConsultorioDTO consultorio){
        return this.consultorioBO.insertar(consultorio);
    }
    
    @WebMethod(operationName = "modificarConsultorio")
    public Integer modificarConsultorio(@WebParam(name = "consultorio")ConsultorioDTO consultorio){
        return this.consultorioBO.modificar(consultorio);
    }
    
    @WebMethod(operationName = "obtenerPorIdConsultorio")
    public ConsultorioDTO obtenerPorIdConsultorio(@WebParam(name = "consultorioId")Integer consultorioId){
        return this.consultorioBO.obtenerPorId(consultorioId);
    }
    
    @WebMethod(operationName = "listarTodosConsultorio")
    public ArrayList<ConsultorioDTO> listarTodosConsultorio(){
        return this.consultorioBO.listarTodos();
    }
}