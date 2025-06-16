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
    
    private InterconsultaDAO dao;
    
    public InterconsultaBO(){
        this.dao = new InterconsultaDAOImpl();
    }
    
    public Integer insertar(InterconsultaDTO turno){
        return this.dao.insertar(turno);
    }
    public InterconsultaDTO obtenerPorId(Integer idEspecialidad, Integer idCita){
        return this.dao.obtenerPorId(idEspecialidad, idCita);
    }
    public ArrayList<InterconsultaDTO> listarTodos(){
        return this.dao.listarTodos();
    }
    
}
