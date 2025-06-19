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
    
    private final HistoriaClinicaPorCitaDAO historiaClinicaPorCitaDao;
    
    public HistoriaClinicaPorCitaBO(){
        this.historiaClinicaPorCitaDao = new HistoriaClinicaPorCitaDAOImpl();
    }
    
    public Integer insertar(HistoriaClinicaPorCitaDTO historiaPorCita){
        return this.historiaClinicaPorCitaDao.insertar(historiaPorCita);
    }
    
    public Integer modificar(HistoriaClinicaPorCitaDTO historiaPorCita){
        return this.historiaClinicaPorCitaDao.modificar(historiaPorCita);
    }
    
    public ArrayList<HistoriaClinicaPorCitaDTO> listarTodos(){
        return this.historiaClinicaPorCitaDao.listarTodos();    
    }
    
    public ArrayList<HistoriaClinicaPorCitaDTO> listarPorIdHistoria(Integer idHistoria){
        return this.historiaClinicaPorCitaDao.listarPorIdHistoria(idHistoria);
    }
    
    public HistoriaClinicaPorCitaDTO ObtenerPorIdCita(Integer idCita){
        return this.historiaClinicaPorCitaDao.ObtenerPorIdCita(idCita);
    }
    
}
