/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.TurnoDAO;
import pe.edu.pucp.softcit.daoImp.TurnoDAOImpl;
import pe.edu.pucp.softcit.model.TurnoDTO;

/**
 *
 * @author salva
 */
public class TurnoBO {
    
    private final TurnoDAO turnoDao;
    
    public TurnoBO(){
        this.turnoDao = new TurnoDAOImpl();
    }
    
    public Integer modificar(TurnoDTO turno){
        return this.turnoDao.modificar(turno);
    }
    public TurnoDTO obtenerPorId(Integer idTurno){
        return this.turnoDao.obtenerPorId(idTurno);
    }
    public ArrayList<TurnoDTO> listarTodos(){
        return this.turnoDao.listarTodos();
    }
            
    
}
