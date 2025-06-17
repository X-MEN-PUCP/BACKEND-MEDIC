/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.HistoriaClinicaPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.HistoriaClinicaPorCitaDAOImpl;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;

/**
 *
 * @author salva
 */
public class HistoriaClinicaPorCitaBO {
    
    private HistoriaClinicaPorCitaDAO dao;
    
    public HistoriaClinicaPorCitaBO(){
        this.dao = new HistoriaClinicaPorCitaDAOImpl();
    }
    
    
    
     public Integer insertar(HistoriaClinicaPorCitaDTO historiaPorCita){
         return this.dao.insertar(historiaPorCita);
     }
    public Integer modificar(HistoriaClinicaPorCitaDTO historiaPorCita){
        return this.dao.modificar(historiaPorCita);
    }
    public ArrayList<HistoriaClinicaPorCitaDTO> listarTodos(){
        return this.dao.listarTodos();
        
    }
    public ArrayList<HistoriaClinicaPorCitaDTO> listarPorIdHistoria(Integer idHistoria){
        return this.dao.listarPorIdHistoria(idHistoria);
    }
    public HistoriaClinicaPorCitaDTO ObtenerPorIdCita(Integer idCita){
        return this.dao.ObtenerPorIdCita(idCita);
    }
    
}
