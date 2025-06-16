/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;

/**
 *
 * @author Cesar
 */
public interface HistoriaClinicaPorCitaDAO {
    public Integer insertar(HistoriaClinicaPorCitaDTO historiaPorCita);
    public Integer modificar(HistoriaClinicaPorCitaDTO historiaPorCita);
    public ArrayList<HistoriaClinicaPorCitaDTO> listarTodos();
    public ArrayList<HistoriaClinicaPorCitaDTO> 
        listarPorIdHistoria(Integer idHistoria);
    public ArrayList<HistoriaClinicaPorCitaDTO> listarPorIdCita(Integer idCita);
}
