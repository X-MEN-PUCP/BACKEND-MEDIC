/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.ConsultorioDAO;
import pe.edu.pucp.softcit.daoImp.ConsultorioDAOImpl;
import pe.edu.pucp.softcit.model.ConsultorioDTO;

/**
 *
 * @author salva
 */
public class ConsultorioBO {
    
    private final ConsultorioDAO consultorioDao;
    
    public ConsultorioBO(){
        this.consultorioDao = new ConsultorioDAOImpl();
    }
    
    public Integer insertar(ConsultorioDTO consultorio){
        return this.consultorioDao.insertar(consultorio);
    }
    
    public Integer modificar(ConsultorioDTO consultorio){
        return this.consultorioDao.modificar(consultorio);
    }
    
    public ConsultorioDTO obtenerPorId(Integer consultorioId){
        return this.consultorioDao.obtenerPorId(consultorioId);
    }
    
    public ArrayList<ConsultorioDTO> listarTodos(){
        return this.consultorioDao.listarTodos();
    }
    
}
