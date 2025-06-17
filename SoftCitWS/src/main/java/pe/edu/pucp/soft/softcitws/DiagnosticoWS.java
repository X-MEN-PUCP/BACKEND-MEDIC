/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;
import pe.edu.pucp.softcitbo.BO.DiagnosticoBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "DiagnosticoWS")
public class DiagnosticoWS {

    private DiagnosticoBO diagnosticoBO;

    public DiagnosticoWS() {
        diagnosticoBO = new DiagnosticoBO();
    }

    @WebMethod(operationName = "insertarDiagnostico")
    public Integer insertarDiagnostico(@WebParam(name = "diagnostico")DiagnosticoDTO diagnostico) {
        return this.diagnosticoBO.insertar(diagnostico);
    }

    @WebMethod(operationName = "obtenerPorIdDiagnostico")
    public DiagnosticoDTO obtenerPorIdDiagnostico(@WebParam(name = "diagnosticoId")Integer diagnosticoId) {
        return this.diagnosticoBO.obtenerPorId(diagnosticoId);
    }

    @WebMethod(operationName = "listarTodosDiagnostico")
    public ArrayList<DiagnosticoDTO> listarTodosDiagnostico() {
        return this.diagnosticoBO.listarTodos();
    }
}
