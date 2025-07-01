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
import org.junit.jupiter.api.Disabled;
import pe.edu.pucp.softcit.model.Genero;
import pe.edu.pucp.softcit.model.TipoDocumento;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author salva
 */
public class RegistroBOTest {
    
    public RegistroBOTest() {
    }
    
    
    @Test
    @Disabled
    public void testRegistrarse() {
        System.out.println("registrarse");
        UsuarioDTO usuario = new UsuarioDTO();
        RegistroBO instance = new RegistroBO();
        usuario.setNombres("Juan");
        usuario.setApellidoPaterno("Perez");
        usuario.setApellidoMaterno("Cuellar");
        usuario.setCorreoElectronico("juan@example.com");
        usuario.setContrasenha("pass99");
        usuario.setFechaNacimiento("2025-10-01");
        usuario.setGenero(Genero.MASCULINO);
        usuario.setTipoDocumento(TipoDocumento.DNI);
        usuario.setNumDocumento("99999999");

        // Simula que la base devuelve ID=10 al insertar usuario
        

        // Act
        Integer resultado = instance.registrarse(usuario);

        // Assert
        //assertTrue(resultado);
    }
    
}
