/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softcit.model.DiagnosticoDTO;
/**
 *
 * @author Mcerv
 */
public class DiagnosticoBOTest {
    
    public DiagnosticoBOTest() {
    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public v    }

    /**
     * Test of insertar method, of class DiagnosticoBO.
     */
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        DiagnosticoDTO diagnostico = null;
//        DiagnosticoBO instance = new DiagnosticoBO();
//        Integer expResult = null;
//        Integer result = instance.insertar(diagnostico);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerPorId method, of class DiagnosticoBO.
//     */
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        Integer diagnosticoId = null;
//        DiagnosticoBO instance = new DiagnosticoBO();
//        DiagnosticoDTO expResult = null;
//        DiagnosticoDTO result = instance.obtenerPorId(diagnosticoId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listarTodos method, of class DiagnosticoBO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        DiagnosticoBO instance = new DiagnosticoBO();
        ArrayList<DiagnosticoDTO> result = instance.listarTodos();
        System.out.println("Size: "+result.size());
    }
    
}
