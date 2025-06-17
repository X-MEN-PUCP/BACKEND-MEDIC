/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.InterconsultaDTO;
import pe.edu.pucp.softcitbo.BO.InterconsultaBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "InterconsultaWS")
public class InterconsultaWS {

    private InterconsultaBO interconsultaBO;

    public InterconsultaWS() {
        this.interconsultaBO = new InterconsultaBO();
    }

    @WebMethod(operationName = "insertarInterconuslta")
    public Integer insertarInterconuslta(@WebParam(name = "turno") InterconsultaDTO turno) {
        return this.interconsultaBO.insertar(turno);
    }

    @WebMethod(operationName = "obtenerPorIdInterconuslta")
    public InterconsultaDTO obtenerPorIdInterconuslta(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad,
            @WebParam(name = "idCita")Integer idCita) {
        return this.interconsultaBO.obtenerPorId(idEspecialidad, idCita);
    }
    
    @WebMethod(operationName = "listarTodosInterconuslta")
    public ArrayList<InterconsultaDTO> listarTodosInterconuslta() {
        return this.interconsultaBO.listarTodos();
    }
}
