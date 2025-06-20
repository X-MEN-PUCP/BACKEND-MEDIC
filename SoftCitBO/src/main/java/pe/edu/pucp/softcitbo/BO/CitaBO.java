/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;


import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.daoImp.CitaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;

/**
 *
 * @author salva
 */
public class CitaBO {
    
    private final CitaDAO citaDao;
    
    public CitaBO(){
        this.citaDao = new CitaDAOImpl();
    }
    
    public Integer modificar(CitaDTO cita){
        return this.citaDao.modificar(cita);
    }
    
    public ArrayList<CitaDTO> listarTodos(){
        return this.citaDao.listarTodos();
    }
    
    public ArrayList<CitaDTO> listarCitasMedico(Integer idMedico, EstadoCita estado){
        return this.citaDao.listarCitasMedico(idMedico, estado);
    }
    
    public ArrayList<CitaDTO> buscarCitas(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado){
        return this.citaDao.buscarCitas(idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }
    
    public ArrayList<CitaDTO> buscarCitasParaCalendario(Integer idEspecialidad, Integer codMedico, String fecha, String hora_inicio, EstadoCita estado){
        return this.citaDao.buscarCitasDisponiblesSoloCalenario(idEspecialidad, codMedico, fecha, hora_inicio, estado);
    }
    
    public CitaDTO obtenerPorId(Integer id){
        return this.citaDao.obtenerPorId(id);
    }
    
}
