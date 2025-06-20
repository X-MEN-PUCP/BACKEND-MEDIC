/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.daoImp.HistoriaClinicaPorCitaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;

/**
 *
 * @author salva
 */
public class MedicoBO {

    private final CitaBO citaBO;
    

    public MedicoBO() {
        this.citaBO = new CitaBO();
    }

    public ArrayList<CitaDTO> listarCitasMedico(Integer idMedico, EstadoCita estado) {
        ArrayList<CitaDTO> citas;
        citas = this.citaBO.listarCitasMedico(idMedico, estado);

        return citas;
    }
    
    public Integer llenarEpicrisis(HistoriaClinicaPorCitaDTO epiciris){
        Integer modificar = new HistoriaClinicaPorCitaDAOImpl().modificar(epiciris);
        return modificar;
    }

}
