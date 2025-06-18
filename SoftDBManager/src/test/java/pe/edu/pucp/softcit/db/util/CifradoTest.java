/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softcit.db.util;

import pe.edu.pucp.softcit.db.util.Cifrado;
import java.util.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author salva
 */
public class CifradoTest {
    //Properties properties = new Properties();
    public CifradoTest() {
    }
    
    Cifrado cifrado = new Cifrado();
    
    @Test
    public void testCifrarMD5() {
        String clave = "admin1";
        String claveCifrada;
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        String claveDecifrada;
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "admin2";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "med1";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "med2";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "med3";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "pac1";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "pac2";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "pac3";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        clave = "pac4";
        claveCifrada = cifrado.cifrarMD5(clave);
        System.out.println("Clave Cifrada>"+claveCifrada+"<");
        claveDecifrada = cifrado.descifrarMD5(claveCifrada);
        System.out.println("Clave decifrada>"+claveDecifrada+"<");
        
        
        
    }


    
}
