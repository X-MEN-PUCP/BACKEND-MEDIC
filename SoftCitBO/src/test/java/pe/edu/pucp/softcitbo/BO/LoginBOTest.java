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
import pe.edu.pucp.softcit.model.TipoDocumento;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author Mcerv
 */
public class LoginBOTest {
    
    public LoginBOTest() {
    }

    /**
     * Test of iniciarSesion method, of class LoginBO.
     */
    @Test
    public void testIniciarSesion() {
        System.out.println("iniciarSesion");
        String numeroDoc = "X1234567";
        TipoDocumento tipoDoc = TipoDocumento.CE;
        String contrasenha = "pac4";
        LoginBO instance = new LoginBO();
        UsuarioDTO result = instance.iniciarSesion(numeroDoc, tipoDoc.toString(), contrasenha);
        if(result!=null){
            System.out.println("Sesión Iniciada: "+result.getNombres() +" "+ result.getApellidoPaterno());
            boolean result2 = instance.cerrarSesion(result);
            System.err.println("Sesión cerrada: "+ result2);
            
        }else
            System.out.println("No se encontró al usuario");
    }


    
}
