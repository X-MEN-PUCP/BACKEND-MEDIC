
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.ReporteCitaDTO;

/**
 *
 * @author salva
 */
public interface ReporteCitasDAO {
    public ArrayList<ReporteCitaDTO> obtenerReporteCitas(
        String fechaDesdeStr,
        String fechaHastaStr,
        Integer idEspecialidad,
        Integer idDoctor) ;
}
