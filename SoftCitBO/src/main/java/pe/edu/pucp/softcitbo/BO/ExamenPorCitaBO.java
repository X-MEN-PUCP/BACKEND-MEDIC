/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.ExamenPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.ExamenPorCitaDAOImpl;
import pe.edu.pucp.softcit.model.ExamenPorCita;

/**
 *
 * @author salva
 */
public class ExamenPorCitaBO {
    
    private final ExamenPorCitaDAO examenPorCitaDao;
    
    public ExamenPorCitaBO(){
        this.examenPorCitaDao = new ExamenPorCitaDAOImpl();
    }
    
    public Integer insertar(ExamenPorCita examenPorCita){
        return this.examenPorCitaDao.insertar(examenPorCita);
    }
    
    public ArrayList<ExamenPorCita> listarTodos(){
        return this.examenPorCitaDao.listarTodos();
    }
    
    public ArrayList<ExamenPorCita> listarPorIdCita(Integer idCita){
        return this.examenPorCitaDao.listarPorIdCita(idCita);
    }
    
}