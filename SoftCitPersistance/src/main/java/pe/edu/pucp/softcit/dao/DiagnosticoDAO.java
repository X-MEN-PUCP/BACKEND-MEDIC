/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;

/**
 *
 * @author Mcerv
 */
public interface DiagnosticoDAO {
    public Integer insertar(DiagnosticoDTO diagnostico);
    public DiagnosticoDTO obtenerPorId(Integer diagnosticoId);
    public ArrayList<DiagnosticoDTO> listarTodos();
}
