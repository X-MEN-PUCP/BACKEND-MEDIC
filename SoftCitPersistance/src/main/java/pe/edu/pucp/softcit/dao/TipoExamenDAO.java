/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.TipoExamenDTO;

/**
 *
 * @author Mcerv
 */
public interface TipoExamenDAO {
    public Integer insertar(TipoExamenDTO tipoExamen);
    public Integer modificar(TipoExamenDTO tipoExamen);
    public TipoExamenDTO obtenerPorId(Integer tipoExamenId);
    public ArrayList<TipoExamenDTO> listarTodos();
}
