/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.ExamenPorCitaDTO;

/**
 *
 * @author Cesar
 */
public interface ExamenPorCitaDAO {
    public Integer insertar(ExamenPorCitaDTO examenPorCita);
    public Integer modificar(ExamenPorCitaDTO examenPorCita);
    public Integer eliminar(ExamenPorCitaDTO examenPorCita);
    public ArrayList<ExamenPorCitaDTO> listarTodos();
    public ArrayList<ExamenPorCitaDTO> listarPorIdCita(Integer idCita);
}
