/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pe.edu.pucp.softcit.model.ReporteCitaDTO;

/**
 *
 * @author salva
 */
public class ReporteBOTest {
    
    
    
    @Test
    public void testListarCitas() {
        System.out.println("ReportelistarCitas ======================");
        ReporteCitaBO instance = new ReporteCitaBO();
        Integer id_espcialidad = 0;
        Integer id_medico = 0;
        String Fecha_Inico = null;
        String Fecha_Fin = null;
        
        ArrayList<ReporteCitaDTO> list = new ArrayList<>();
        list = instance.obtenerReporteCitas(Fecha_Inico, Fecha_Fin, id_espcialidad, id_medico);
        Integer tamano = list.size();
        System.out.println("Tamaño del array: "+ tamano);
    }
    
}
