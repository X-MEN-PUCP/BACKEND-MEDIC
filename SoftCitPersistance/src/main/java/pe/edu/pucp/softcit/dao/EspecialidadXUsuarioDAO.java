/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;

/**
 *
 * @author salva
 */
public interface EspecialidadXUsuarioDAO {
    
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorUsuario(Integer id);
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorEspecialidad(Integer idEspecialidad);
    public Integer insertar(UsuarioPorEspecialidadDTO usuarioXespecialidad);
    
}
