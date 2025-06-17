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
    
    private ExamenPorCitaDAO dao;
    
    public ExamenPorCitaBO(){
        this.dao = new ExamenPorCitaDAOImpl();
    }
    
    public Integer insertar(ExamenPorCita examenPorCita){
        return this.dao.insertar(examenPorCita);
    }
    public ArrayList<ExamenPorCita> listarTodos(){
        return this.dao.listarTodos();
    }
    public ArrayList<ExamenPorCita> listarPorIdCita(Integer idCita){
        return this.dao.listarPorIdCita(idCita);
    }
    
    
}