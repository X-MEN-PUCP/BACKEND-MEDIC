/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcitbo.BO.HistoriaClinicaPorCitaBO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;

@WebService(serviceName = "HistoriaClinicaPorCitaWS")
public class HistoriaClinicaPorCitaWS {

    private HistoriaClinicaPorCitaBO historiaBO;

    public HistoriaClinicaPorCitaWS() {
        this.historiaBO = new HistoriaClinicaPorCitaBO();
    }

    @WebMethod(operationName = "InsertarHistoriaClinicaPorCita")
    public Integer insertarHistoriaClinicaPorCita(
        @WebParam(name = "historiaPorCita") HistoriaClinicaPorCitaDTO historiaPorCita) {
        return this.historiaBO.insertar(historiaPorCita);
    }

    @WebMethod(operationName = "ModificarHistoriaClinicaPorCita")
    public Integer modificarHistoriaClinicaPorCita(
        @WebParam(name = "historiaPorCita") HistoriaClinicaPorCitaDTO historiaPorCita) {
        return this.historiaBO.modificar(historiaPorCita);
    }

    @WebMethod(operationName = "ListarTodasLasHistoriasClinicasPorCita")
    public ArrayList<HistoriaClinicaPorCitaDTO> listarTodasLasHistoriasClinicasPorCita() {
        return this.historiaBO.listarTodos();
    }

    @WebMethod(operationName = "ListarHistoriasClinicasPorIdHistoria")
    public ArrayList<HistoriaClinicaPorCitaDTO> listarHistoriasClinicasPorIdHistoria(
        @WebParam(name = "idHistoria") Integer idHistoria) {
        return this.historiaBO.listarPorIdHistoria(idHistoria);
    }

    @WebMethod(operationName = "ObtenerHistoriaClinicaPorIdCita")
    public HistoriaClinicaPorCitaDTO obtenerHistoriaClinicaPorIdCita(
        @WebParam(name = "idCita") Integer idCita) {
        return this.historiaBO.ObtenerPorIdCita(idCita);
    }
}
