/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.soft.reports;

import java.util.HashMap;

/**
 *
 * @author luisa
 */
public class ReporteUtil {
    
    
    public static byte[] invocarReporte(String nombreReporte, HashMap parametros){
        byte[] reporte = null;
        return reporte;
    }
    
    public static byte[] reporteCitas(Integer idCita, String fechaDesde, String fechaHasta, Integer idEspecialidad, Integer codMedico){
        HashMap map = new HashMap();
        map.put("idCita", idCita);
        map.put("fechaDesde", fechaDesde);
        map.put("fechaHasta", fechaHasta);
        map.put("idEspecialidad", idEspecialidad);
        map.put("codMedico",codMedico);
        return invocarReporte("Reporte_Citas", map);
    }
}
