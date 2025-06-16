/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.ExamenPorCita;

/**
 *
 * @author Cesar
 */
public interface ExamenPorCitaDAO {
    public Integer insertar(ExamenPorCita examenPorCita);
    public ArrayList<ExamenPorCita> listarTodos();
    public ArrayList<ExamenPorCita> listarPorIdCita(Integer idCita);
}
