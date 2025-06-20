/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.TipoExamenDAO;
import pe.edu.pucp.softcit.daoImp.TipoExamenDAOImpl;
import pe.edu.pucp.softcit.model.TipoExamenDTO;

/**
 *
 * @author salva
 */
public class TipoExamenBO {
    
    private final TipoExamenDAO tipoExamenDao;
    
    public TipoExamenBO(){
        this.tipoExamenDao = new TipoExamenDAOImpl();
    }
    
    public Integer insertar(TipoExamenDTO tipoExamen){
        return this.tipoExamenDao.insertar(tipoExamen);
    }
    public Integer modificar(TipoExamenDTO tipoExamen){
        return this.tipoExamenDao.modificar(tipoExamen);
    }
    public TipoExamenDTO obtenerPorId(Integer tipoExamenId){
        return this.tipoExamenDao.obtenerPorId(tipoExamenId);
    }
    public ArrayList<TipoExamenDTO> listarTodos(){
        return this.tipoExamenDao.listarTodos();
    }
    
}
