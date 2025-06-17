/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.TipoExamenDTO;
import pe.edu.pucp.softcitbo.BO.TipoExamenBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "TipoExamenWS")
public class TipoExamenWS {

    private TipoExamenBO tipoExamenBO;
    
    public TipoExamenWS(){
        this.tipoExamenBO = new TipoExamenBO();
    }
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(@WebParam(name = "tipoExamen")TipoExamenDTO tipoExamen){
        return this.tipoExamenBO.insertar(tipoExamen);
    }
    
    @WebMethod(operationName = "modificar")
    public Integer modificar(@WebParam(name = "tipoExamen")TipoExamenDTO tipoExamen){
        return this.tipoExamenBO.modificar(tipoExamen);
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public TipoExamenDTO obtenerPorId(@WebParam(name = "tipoExamenId")Integer tipoExamenId){
        return this.tipoExamenBO.obtenerPorId(tipoExamenId);
    }
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<TipoExamenDTO> listarTodos(){
        return this.tipoExamenBO.listarTodos();
    }
}
