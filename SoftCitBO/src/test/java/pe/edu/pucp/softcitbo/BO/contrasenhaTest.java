/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author salva
 */
public class contrasenhaTest {
    
    @Test
    @Disabled
    public void modificarUsuario() {
        UsuarioDTO usuario = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAOImpl();
        UsuarioBO bo = new UsuarioBO();
        usuario = dao.obtenerPorId(1);
        String contrasenhaNueva = "Pass1";
        bo.CambiarContrasenha(usuario, contrasenhaNueva);
    }
    
}
