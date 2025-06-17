/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.DiagnositcoPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.DiagnosticoPorCitaDAOImpl;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;

/**
 *
 * @author salva
 */
public class DiagnosticoPorCitaBO {
    
    private DiagnositcoPorCitaDAO dao;
    
    public DiagnosticoPorCitaBO(){
        this.dao = new DiagnosticoPorCitaDAOImpl();
    }
    
    
    public Integer insertar(DiagnosticoPorCita diagnositcoPorCita){
        return this.dao.insertar(diagnositcoPorCita);
    }
    public ArrayList<DiagnosticoPorCita> listarPorIdCita(Integer idCita){
        return this.dao.listarPorIdCita(idCita);
    }
    public ArrayList<DiagnosticoPorCita> listarTodos(){
        return this.dao.listarTodos();
    }
    
    
}
