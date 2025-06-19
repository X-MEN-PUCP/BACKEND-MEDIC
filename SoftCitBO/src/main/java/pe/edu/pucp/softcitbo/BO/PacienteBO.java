/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.daoImp.HistoriaClinicaPorCitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.HistoriaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author salva
 */
public class PacienteBO {
    
    private final CitaBO citaBO;
    
    public PacienteBO(){
        this.citaBO = new CitaBO();
    }
    
    public ArrayList<CitaDTO> listarCitas(Integer idEspecialidad, String fecha, Integer idMedico){
        ArrayList<CitaDTO> citas = new ArrayList<>();
        if (idMedico != null || idEspecialidad != null) {
           citas = this.citaBO.buscarCitasDisponibles(idEspecialidad, idMedico, fecha);
        } else {
            System.out.println("Debe seleccionar una especialidad o un médico. Error listar Citas");
            
        }
        return citas;
    }
    
    
     public int reservarCita(CitaDTO cita, UsuarioDTO paciente) {//es id de cuenta o id persona?
        //actualizar cita (Estado: reservado)
        System.out.println("Modificando estado de cita");
        cita.setEstado(EstadoCita.RESERVADO);
        //Integer id = super.getIdCuenta();
        
        Integer idPaciente = paciente.getIdUsuario();
        HistoriaClinicaDTO historia;
        historia = new HistoriaDAOImpl().obtenerPorIdPaciente(idPaciente);
        HistoriaClinicaPorCitaDTO historia_por_cita = new HistoriaClinicaPorCitaDTO();
        historia_por_cita.setCita(cita);
        historia_por_cita.setHistoriaClinica(historia);
        Integer insert = new HistoriaClinicaPorCitaDAOImpl().insertar(historia_por_cita);
        return insert;
    }
     
     public int cancelarCita(CitaDTO cita,HistoriaClinicaPorCitaDTO historia_por_cita) {
        //actualizar cita (Estado: disponible)
        cita.setEstado(EstadoCita.DISPONIBLE);
        
        this.citaBO.modificar(cita);
        historia_por_cita.setEstadoGeneral(EstadoGeneral.INACTIVO);
        Integer modificar = new HistoriaClinicaPorCitaDAOImpl().modificar(historia_por_cita);
        
        
        return modificar;
    }
     
     public int reprogramar(CitaDTO citaAntigua,CitaDTO citaNueva,HistoriaClinicaPorCitaDTO historia_por_cita) {
        //actualizar cita (Estado: disponible)
        citaAntigua.setEstado(EstadoCita.DISPONIBLE);
        
        this.citaBO.modificar(citaAntigua);
        
        citaNueva.setEstado(EstadoCita.RESERVADO);
        historia_por_cita.setCita(citaNueva);
        
        Integer modificar = new HistoriaClinicaPorCitaDAOImpl().modificar(historia_por_cita);
        
        
        return modificar;
    }
     
    

     public ArrayList<HistoriaClinicaPorCitaDTO> listarCitasPorPersona(HistoriaClinicaDTO historia){
        ArrayList<HistoriaClinicaPorCitaDTO> citas = null;
        Integer idHistoria = historia.getIdHistoriaClinica();
       
        citas = new HistoriaClinicaPorCitaDAOImpl().listarPorIdHistoria(idHistoria);
        
        return citas;
    }
    
}
