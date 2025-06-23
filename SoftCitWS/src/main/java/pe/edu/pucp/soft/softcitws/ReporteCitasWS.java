
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.ReporteCitaDTO;
import pe.edu.pucp.softcitbo.BO.ReporteCitaBO;

/**
 *
 * @author salva
 */
@WebService(serviceName = "ReporteWS")
public class ReporteCitasWS {
    
    ReporteCitaBO reporteCitaBO;
    
    public ReporteCitasWS(){
        this.reporteCitaBO = new ReporteCitaBO();
    }
    
    @WebMethod(operationName = "ReporteDeCitasGeneral")
    public ArrayList<ReporteCitaDTO> ReporteDeCitasGeneral(
            @WebParam(name = "idEspecialidad")Integer idEspecialidad,
            @WebParam(name = "codMedico")Integer codMedico,
            @WebParam(name = "fecha_inicio")String fecha_inicio, 
            @WebParam(name= "fecha_fini") String fecha_fin){
        if(idEspecialidad==0)idEspecialidad=null;
        if(codMedico==0)codMedico=null;

        return this.reporteCitaBO.obtenerReporteCitas(fecha_inicio, fecha_fin, idEspecialidad, codMedico);
    }
    
}
