/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.ExamenDTO;

/**
 *
 * @author Mcerv
 */
public interface ExamenDAO {
    public Integer insertar(ExamenDTO examen);
    public ExamenDTO obtenerPorId(Integer examenId);
    public ArrayList<ExamenDTO> listarTodos();
    public ArrayList<ExamenDTO> listarPorIdTipoExamen(Integer idTipoExamen);
}
