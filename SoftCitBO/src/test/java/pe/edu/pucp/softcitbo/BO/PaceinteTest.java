/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pe.edu.pucp.softcit.model.EstadoCita;

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
    
}
