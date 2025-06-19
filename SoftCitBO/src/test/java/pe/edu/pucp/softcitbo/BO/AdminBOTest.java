/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softcit.model.RolDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author Mcerv
 */
public class AdminBOTest {
    
    public AdminBOTest() {
    }
    
    
    @Test
    /**
     * Test of asignarNuevoRol method, of class AdminBO.
     */
    public void testAsignarNuevoRolEliminarRol() {
        System.out.println("asignarNuevoRol");
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdUsuario(6);
        Integer idRol = 2;
        AdminBO instance = new AdminBO();
        Integer result = instance.asignarNuevoRol(usuario, idRol);
        System.out.println("Rol: "+2+" asignado: "+result);
        
        /**
        * Test of eliminarRol method, of class AdminBO.
        */
        System.out.println("eliminarRol");
        UsuarioPorRolDTO usuarioPorRol = new UsuarioPorRolDTO();
        RolDTO rol = new RolDTO();
        rol.setIdRol(2);
        usuarioPorRol.setRol(rol);
        usuarioPorRol.setUsuarioDTO(usuario);
        result = instance.eliminarRol(usuarioPorRol);
        System.out.println("Rol eliminado: "+result);
    }
    
}
