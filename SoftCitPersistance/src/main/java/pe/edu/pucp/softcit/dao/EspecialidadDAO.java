/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.EspecialidadDTO;

/**
 *
 * @author salva
 */
public interface EspecialidadDAO {
    
    public ArrayList<EspecialidadDTO> listar();
    public Integer insertar(EspecialidadDTO especialidad);
    public Integer modificar(EspecialidadDTO especialidad);
    public Integer cambiarEstadoEspecialidad(EspecialidadDTO especialidad);
    public EspecialidadDTO obtenerPorId(Integer id);
    
}
