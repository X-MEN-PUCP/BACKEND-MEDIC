/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;
import pe.edu.pucp.softcit.model.ReporteCitaDTO;

/**
 *
 * @author salva
 */
public class DiagnosticPorCitaTest {
    
    @Test
    @Disabled
    public void testListarCitas() {
        CitaDTO cita = new CitaDTO();
        cita.setIdCita(3);
        DiagnosticoDTO diag = new DiagnosticoDTO();
        diag.setIdDiagnostico(1);
        DiagnosticoPorCita diagxcita = new DiagnosticoPorCita();
        diagxcita.setCita(cita);
        diagxcita.setDiagnostico(diag);
        diagxcita.setObservacion("Hola");
        
        DiagnosticoPorCitaBO bo = new DiagnosticoPorCitaBO();
        bo.insertar(diagxcita);
    }
    
    
}
