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
    
    private final DiagnosticoDAO DiagnosticoDao;
    
    public DiagnosticoBO(){
        this.DiagnosticoDao = new DiagnosticoDAOImpl();
    }
    
    public Integer insertar(DiagnosticoDTO diagnostico){
       return this.DiagnosticoDao.insertar(diagnostico);
    }
    
    public DiagnosticoDTO obtenerPorId(Integer diagnosticoId){
       return this.DiagnosticoDao.obtenerPorId(diagnosticoId);
    }
    
    public ArrayList<DiagnosticoDTO> listarTodos(){
       return this.DiagnosticoDao.listarTodos();
    }
    
}
