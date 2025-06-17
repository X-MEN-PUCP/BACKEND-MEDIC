/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.ExamenDTO;
import pe.edu.pucp.softcitbo.BO.ExamenBO;
/**
 *
 * @author Cesar
 */
@WebService(serviceName = "ExamenWS")
public class ExamenWS {

    private ExamenBO examenBO;
    
    public ExamenWS(){
        examenBO = new ExamenBO();
    }
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(@WebParam(name = "examen")ExamenDTO examen){
        return this.examenBO.insertar(examen);
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public ExamenDTO obtenerPorId(@WebParam(name = "examenId")Integer examenId){
        return this.examenBO.obtenerPorId(examenId);
    }
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<ExamenDTO> listarTodos(){
        return this.examenBO.listarTodos();
    }
}
