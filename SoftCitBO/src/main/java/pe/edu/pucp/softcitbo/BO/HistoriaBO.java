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
    
    private HistoriaDAO dao;
    
    public HistoriaBO(){
        this.dao = new HistoriaDAOImpl();
    }
    
    
    public ArrayList<HistoriaClinicaDTO> listar(){
        return this.dao.listar();
    }
    public Integer insertar(HistoriaClinicaDTO historia){
        return this.dao.insertar(historia);
    }   
    public HistoriaClinicaDTO obtenerPorIdPaciente(Integer id){
        return this.dao.obtenerPorIdPaciente(id);
    }
    public HistoriaClinicaDTO obtenerPorId(Integer id){
        return this.dao.obtenerPorId(id);
    }
    
}
