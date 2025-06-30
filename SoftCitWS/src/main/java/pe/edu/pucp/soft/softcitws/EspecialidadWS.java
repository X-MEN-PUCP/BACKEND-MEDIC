/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.soft.softcitws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcitbo.BO.EspecialidadBO;

/**
 *
 * @author Cesar
 */
@WebService(serviceName = "EspecialidadWS")
public class EspecialidadWS {

    private EspecialidadBO especialidadBO;
    
    public EspecialidadWS(){
        especialidadBO = new EspecialidadBO();
    }
    
    @WebMethod(operationName = "listarEspecialidad")
    public ArrayList<EspecialidadDTO> listarEspecialidad(){
        return this.especialidadBO.listar();
    }

    @WebMethod(operationName = "insertarEspecialidad")
    public Integer insertarEspecialidad(@WebParam(name = "especialidad")EspecialidadDTO especialidad){
        return this.especialidadBO.insertar(especialidad);
    }

//    @WebMethod(operationName = "modificarEspecialidad")
//    public Integer modificarEspecialidad(@WebParam(name = "especialidad")EspecialidadDTO especialidad){
//        return this.especialidadBO.modificar(especialidad);
//    }

    @WebMethod(operationName = "cambiarEstadoEspecialidad")
    public Integer cambiarEstadoEspecialidad(
            @WebParam(name = "especialidad")EspecialidadDTO especialidad,
            @WebParam(name = "estado")Integer estado){
        especialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(estado));
        return this.especialidadBO.modificar(especialidad);
    }
    
    @WebMethod(operationName = "obtenerPorIdTablaEspecialidad")
    public EspecialidadDTO obtenerPorIdTablaEspecialidad(@WebParam(name = "id")Integer id){
        return this.especialidadBO.obtenerPorId(id);
    }
}
