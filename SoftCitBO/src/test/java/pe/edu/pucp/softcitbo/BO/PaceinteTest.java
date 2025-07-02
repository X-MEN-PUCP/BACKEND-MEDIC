/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSInput;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author salva
 */
public class PaceinteTest {
    
    @Test
    @Disabled
    public void cambiarEstadoCita(){
        PacienteBO bo = new PacienteBO();
        Integer idcita = 1;
        Integer Estado = EstadoCita.ATENDIDO.getCodigo();
        Integer idModi = 1;
        bo.cambiarEstadoCita(idcita, Estado,idModi);
    }
    
    @Test
    @Disabled
    public void ListarCitasPacienteTest(){
        PacienteBO bo = new PacienteBO();
        UsuarioDTO pac= new UsuarioDTO();
        ArrayList<HistoriaClinicaPorCitaDTO> lista = new ArrayList<>();
        pac.setIdUsuario(9);
        lista = bo.listarCitasPorPersona(pac);
        System.out.println("LAs lista tiene: " + lista.size());
        for(int i =0 ; i<lista.size();i++){
            System.out.println("Id cita: " + lista.get(i).getCita().getIdCita());
        }
    }
    
}
