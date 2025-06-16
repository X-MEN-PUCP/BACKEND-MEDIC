/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;

/**
 *
 * @author salva
 */
public interface HistoriaDAO {
    
    public ArrayList<HistoriaClinicaDTO> listar();
    public Integer insertar(HistoriaClinicaDTO historia);    
    public HistoriaClinicaDTO obtenerPorIdPaciente(Integer id);
    public HistoriaClinicaDTO obtenerPorId(Integer id);
    
    
}
