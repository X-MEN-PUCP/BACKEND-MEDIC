/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author salva
 */
public interface RolesXUsuarioDAO {
    public ArrayList<UsuarioPorRolDTO> listarPorUsuario(Integer id);
    public Integer insertar(UsuarioPorRolDTO usarioPorRol) ;
    
}
