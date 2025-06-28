

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;

/**
 *
 * @author Cesar
 */
public interface DiagnositcoPorCitaDAO {
    public Integer insertar(DiagnosticoPorCita diagnositcoPorCita);
    public Integer modificar(DiagnosticoPorCita diagnosticoPorCita);
    public Integer eliminar(DiagnosticoPorCita diagnosticoPorCita);
    public ArrayList<DiagnosticoPorCita> listarPorIdCita(Integer idCita);
    public ArrayList<DiagnosticoPorCita> listarTodos();
}
