/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.HistoriaDAO;
import pe.edu.pucp.softcit.daoImp.HistoriaDAOImpl;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;

/**
 *
 * @author salva
 */
public class HistoriaBO {
    
    private final HistoriaDAO historiaDao;
    
    public HistoriaBO(){
        this.historiaDao = new HistoriaDAOImpl();
    }
    
    public ArrayList<HistoriaClinicaDTO> listar(){
        return this.historiaDao.listar();
    }
    
    public Integer insertar(HistoriaClinicaDTO historia){
        return this.historiaDao.insertar(historia);
    }  
    
    public HistoriaClinicaDTO obtenerPorIdPaciente(Integer id){
        return this.historiaDao.obtenerPorIdPaciente(id);
    }
    
    public HistoriaClinicaDTO obtenerPorId(Integer id){
        return this.historiaDao.obtenerPorId(id);
    }
    
}
