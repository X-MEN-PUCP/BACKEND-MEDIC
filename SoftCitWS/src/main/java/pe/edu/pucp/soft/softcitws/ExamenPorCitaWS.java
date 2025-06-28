/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcitbo.BO.ExamenPorCitaBO;
import pe.edu.pucp.softcit.model.ExamenPorCitaDTO;

@WebService(serviceName = "ExamenPorCitaWS")
public class ExamenPorCitaWS {
    
    private ExamenPorCitaBO examenBO;

    public ExamenPorCitaWS() {
        this.examenBO = new ExamenPorCitaBO();
    }

    @WebMethod(operationName = "InsertarExamenPorCita")
    public Integer insertarExamenPorCita(
        @WebParam(name = "examenPorCita") ExamenPorCitaDTO examenPorCita) {
        return this.examenBO.insertar(examenPorCita);
    }

    @WebMethod(operationName = "ListarExamenesPorIdCita")
    public ArrayList<ExamenPorCitaDTO> listarExamenesPorIdCita(
        @WebParam(name = "idCita") Integer idCita) {
        return this.examenBO.listarPorIdCita(idCita);
    }

    @WebMethod(operationName = "ListarTodosLosExamenesPorCita")
    public ArrayList<ExamenPorCitaDTO> listarTodosLosExamenesPorCita() {
        return this.examenBO.listarTodos();
    }
}
