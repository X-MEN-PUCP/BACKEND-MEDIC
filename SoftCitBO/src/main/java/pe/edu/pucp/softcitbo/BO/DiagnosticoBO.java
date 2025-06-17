/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.DiagnosticoDAO;
import pe.edu.pucp.softcit.daoImp.DiagnosticoDAOImpl;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;

/**
 *
 * @author salva
 */
public class DiagnosticoBO {
    
    private DiagnosticoDAO dao;
    
    public DiagnosticoBO(){
        this.dao = new DiagnosticoDAOImpl();
    }
    
    
   public Integer insertar(DiagnosticoDTO diagnostico){
       return this.dao.insertar(diagnostico);
               
   }
   public DiagnosticoDTO obtenerPorId(Integer diagnosticoId){
       return this.dao.obtenerPorId(diagnosticoId);
   }
   public ArrayList<DiagnosticoDTO> listarTodos(){
       return this.dao.listarTodos();
   }
    
}
