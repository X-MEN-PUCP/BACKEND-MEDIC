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

    private EspecialidadDAO dao;

    public EspecialidadBO() {
        this.dao = new EspecialidadDAOImpl();
    }

    public ArrayList<EspecialidadDTO> listar(){
        return this.dao.listar();
    }

    public Integer insertar(EspecialidadDTO especialidad){
        return this.dao.insertar(especialidad);
    }

    public Integer modificar(EspecialidadDTO especialidad){
        return this.dao.modificar(especialidad);
    }

    public Integer cambiarEstadoEspecialidad(EspecialidadDTO especialidad,Integer estado){
        especialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(estado));
        return this.dao.modificar(especialidad);
    }
    

    public EspecialidadDTO obtenerPorId(Integer id){
        return this.dao.obtenerPorId(id);
    }
}
