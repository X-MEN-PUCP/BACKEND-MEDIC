/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.dao;

import java.util.ArrayList;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author salva
 */
public interface UsuarioDAO {
    
    public UsuarioDTO obtenerPorId(Integer id);
    public UsuarioDTO buscarCuenta(String nroDocumento,String tipoDoc,String contrasenha);
    public Integer insertar(UsuarioDTO usuario);
    public Integer modificar(UsuarioDTO usuario);
    public Integer cambiarEstadoGeneral(UsuarioDTO usuario);
    public Integer cambiarEstadoLogico(UsuarioDTO usuario);
    public UsuarioDTO completarRoles(UsuarioDTO usuario);
    public ArrayList<UsuarioDTO> listarMedicos();
    public ArrayList<UsuarioDTO> listarTodos();
}
