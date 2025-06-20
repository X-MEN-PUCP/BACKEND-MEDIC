/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;

/**
 *
 * @author Mcerv
 */
public interface CitaDAO {
    public Integer modificar(CitaDTO cita);
    public ArrayList<CitaDTO> listarTodos();
    public ArrayList<CitaDTO> listarCitasMedico(Integer idMedico, EstadoCita estado);
    public ArrayList<CitaDTO> buscarCitas(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado);
    public CitaDTO obtenerPorId(Integer id);
    public ArrayList<CitaDTO> buscarCitasDisponiblesSoloCalenario(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado);
}
