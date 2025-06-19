/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.InterconsultaDAO;
import pe.edu.pucp.softcit.daoImp.InterconsultaDAOImpl;
import pe.edu.pucp.softcit.model.InterconsultaDTO;

/**
 *
 * @author salva
 */
public class InterconsultaBO {
    
    private final InterconsultaDAO interconsultaDao;
    
    public InterconsultaBO(){
        this.interconsultaDao = new InterconsultaDAOImpl();
    }
    
    public Integer insertar(InterconsultaDTO turno){
        return this.interconsultaDao.insertar(turno);
    }
    
    public InterconsultaDTO obtenerPorId(Integer idEspecialidad, Integer idCita){
        return this.interconsultaDao.obtenerPorId(idEspecialidad, idCita);
    }
    
    public ArrayList<InterconsultaDTO> listarTodos(){
        return this.interconsultaDao.listarTodos();
    }
    
}
