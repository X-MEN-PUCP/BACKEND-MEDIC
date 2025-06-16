/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.daoImp.CitaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;

/**
 *
 * @author salva
 */
public class CitaBO {
    
    private CitaDAO citaDao;
    
    public CitaBO(){
        this.citaDao = new CitaDAOImpl();
    }
    
    public Integer modificar(CitaDTO cita){
        return this.citaDao.modificar(cita);
    }
    public ArrayList<CitaDTO> listarTodos(){
        return this.citaDao.listarTodos();
    }
    public ArrayList<CitaDTO> listarCitasProgramadas(Integer codMedico){
        return this.citaDao.listarCitasProgramadas(codMedico);
    }
    public ArrayList<CitaDTO> buscarCitasDisponibles(Integer idEspecialidad, Integer codMedico, LocalDate fecha){
        return this.citaDao.buscarCitasDisponibles(idEspecialidad, codMedico, fecha);
    }
    public CitaDTO obtenerPorId(Integer id){
        return this.citaDao.obtenerPorId(id);
    }
    
    
    
}
