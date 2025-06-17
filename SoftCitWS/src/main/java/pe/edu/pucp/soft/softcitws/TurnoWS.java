/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.TurnoDTO;
import pe.edu.pucp.softcitbo.BO.TurnoBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "TurnoWS")
public class TurnoWS {

    private TurnoBO turnoBO;
    
    public TurnoWS(){
        this.turnoBO = new TurnoBO();
    }
    
    @WebMethod(operationName = "modificar")
    public Integer modificar(@WebParam(name = "turno")TurnoDTO turno){
        return this.turnoBO.modificar(turno);
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public TurnoDTO obtenerPorId(@WebParam(name = "idTurno")Integer idTurno){
        return this.turnoBO.obtenerPorId(idTurno);
    }
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<TurnoDTO> listarTodos(){
        return this.turnoBO.listarTodos();
    }
}
