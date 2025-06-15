/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.ConsultorioDTO;

/**
 *
 * @author Mcerv
 */
public interface ConsultorioDAO {
    public Integer insertar(ConsultorioDTO consultorio);
    public Integer modificar(ConsultorioDTO consultorio);
    public ConsultorioDTO obtenerPorId(Integer consultorioId);
    public ArrayList<ConsultorioDTO> listarTodos();
}
