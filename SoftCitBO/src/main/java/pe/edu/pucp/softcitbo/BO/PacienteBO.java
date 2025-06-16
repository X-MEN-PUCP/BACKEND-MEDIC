/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.CitaDTO;

/**
 *
 * @author salva
 */
public class PacienteBO {
    
    private CitaBO citaBO;
    
    
    public PacienteBO(){
        citaBO = new CitaBO();
    }
    
    public ArrayList<CitaDTO> listarCitas(Integer idEspecialidad, LocalDate fecha, Integer idMedico){
        ArrayList<CitaDTO> citas = new ArrayList<>();
        if (idMedico != null || idEspecialidad != null) {
           citas = this.citaBO.buscarCitasDisponibles(idEspecialidad, idMedico, fecha);
        } else {
            System.out.println("Debe seleccionar una especialidad o un médico. Error listar Citas");
            
        }
        return citas;
    }
    
}
