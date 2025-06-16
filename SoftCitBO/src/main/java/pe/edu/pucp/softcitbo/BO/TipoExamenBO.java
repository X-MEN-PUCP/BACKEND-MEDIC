/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.TipoExamenDAO;
import pe.edu.pucp.softcit.daoImp.TipoExamenDAOImpl;
import pe.edu.pucp.softcit.model.TipoExamenDTO;
import pe.edu.pucp.softcit.model.TurnoDTO;

/**
 *
 * @author salva
 */
public class TipoExamenBO {
    
    private TipoExamenDAO dao;
    
    public TipoExamenBO(){
        this.dao = new TipoExamenDAOImpl();
    }
    
    public Integer insertar(TipoExamenDTO tipoExamen){
        return this.dao.insertar(tipoExamen);
    }
    public Integer modificar(TipoExamenDTO tipoExamen){
        return this.dao.modificar(tipoExamen);
    }
    public TipoExamenDTO obtenerPorId(Integer tipoExamenId){
        return this.dao.obtenerPorId(tipoExamenId);
    }
    public ArrayList<TipoExamenDTO> listarTodos(){
        return this.dao.listarTodos();
    }
    
}
