/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.ExamenDAO;
import pe.edu.pucp.softcit.daoImp.ExamenDAOImpl;
import pe.edu.pucp.softcit.model.ExamenDTO;

/**
 *
 * @author salva
 */
public class ExamenBO {
    
    private final ExamenDAO examenDao;
    
    public ExamenBO(){
        this.examenDao = new ExamenDAOImpl();
        
    }
    
    public Integer insertar(ExamenDTO examen){
        return this.examenDao.insertar(examen);
    }
    
    public ExamenDTO obtenerPorId(Integer examenId){
        return this.examenDao.obtenerPorId(examenId);
    }
    
    public ArrayList<ExamenDTO> listarTodos(){
        return this.examenDao.listarTodos();
    }
    
}
