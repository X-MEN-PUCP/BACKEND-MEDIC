/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;
import pe.edu.pucp.softcitbo.BO.DiagnosticoPorCitaBO;

@WebService(serviceName = "DiagnosticoPorCitaWS")
public class DiagnosticoPorCitaWS {

    private DiagnosticoPorCitaBO diagnosticoBO;

    public DiagnosticoPorCitaWS() {
        this.diagnosticoBO = new DiagnosticoPorCitaBO();
    }

    @WebMethod(operationName = "InsertarDiagnosticoPorCita")
    public Integer InsertarDiagnosticoPorCita(@WebParam(name = "diagnostico") DiagnosticoPorCita diagnostico) {
        return this.diagnosticoBO.insertar(diagnostico);
    }

    @WebMethod(operationName = "ListarDiagnosticoPorIdCita")
    public ArrayList<DiagnosticoPorCita> ListarDiagnosticoPorIdCita(@WebParam(name = "idCita") Integer idCita) {
        return this.diagnosticoBO.listarPorIdCita(idCita);
    }

    @WebMethod(operationName = "ListarTodosLosDiagnosticos")
    public ArrayList<DiagnosticoPorCita> ListarTodosLosDiagnosticos() {
        return this.diagnosticoBO.listarTodos();
    }
}
