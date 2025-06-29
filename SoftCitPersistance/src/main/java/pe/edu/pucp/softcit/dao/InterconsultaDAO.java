/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.InterconsultaDTO;

/**
 *
 * @author Cesar
 */
public interface InterconsultaDAO {
    public Integer insertar(InterconsultaDTO turno);
    public Integer modificar(InterconsultaDTO interconsulta);
    public Integer eliminar(InterconsultaDTO interconsulta);
    public InterconsultaDTO obtenerPorId(Integer idEspecialidad, Integer idCita);
    public ArrayList<InterconsultaDTO> listarTodos();
}
