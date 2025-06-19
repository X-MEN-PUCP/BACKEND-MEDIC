/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.CitaDTO;

/**
 *
 * @author Mcerv
 */
public interface CitaDAO {
    public Integer modificar(CitaDTO cita);
    public ArrayList<CitaDTO> listarTodos();
    public ArrayList<CitaDTO> listarCitasProgramadas(Integer codMedico);
    public ArrayList<CitaDTO> buscarCitasDisponibles(Integer idEspecialidad, Integer codMedico, String fecha); 
    public CitaDTO obtenerPorId(Integer id);
    public ArrayList<CitaDTO> buscarCitasDisponiblesSoloCalenario(Integer idEspecialidad, Integer idMedico, String fecha);
}
