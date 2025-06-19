/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.daoImp.EspecialidadDAOImpl;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;

/**
 *
 * @author salva
 */
public class EspecialidadBO {

    private final EspecialidadDAO especialidadDao;

    public EspecialidadBO() {
        this.especialidadDao = new EspecialidadDAOImpl();
    }

    public ArrayList<EspecialidadDTO> listar(){
        return this.especialidadDao.listar();
    }

    public Integer insertar(EspecialidadDTO especialidad){
        return this.especialidadDao.insertar(especialidad);
    }

    public Integer modificar(EspecialidadDTO especialidad){
        return this.especialidadDao.modificar(especialidad);
    }

    public Integer cambiarEstadoEspecialidad(EspecialidadDTO especialidad,Integer estado){
        especialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(estado));
        return this.especialidadDao.modificar(especialidad);
    }
    
    public EspecialidadDTO obtenerPorId(Integer id){
        return this.especialidadDao.obtenerPorId(id);
    }
}
