/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.TurnoDTO;

/**
 *
 * @author Cesar
 */
public interface TurnoDAO {
    public Integer modificar(TurnoDTO turno);
    public TurnoDTO obtenerPorId(Integer idTurno);
    public ArrayList<TurnoDTO> listarTodos();
}
