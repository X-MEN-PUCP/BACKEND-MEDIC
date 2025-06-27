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
import org.junit.jupiter.api.Disabled;
import pe.edu.pucp.softcit.model.InterconsultaDTO;

/**
 *
 * @author Mcerv
 */
public class InterconsultaBOTest {
    
    public InterconsultaBOTest() {
    }
    
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
//    public void tearDown() {
//    }

    /**
     * Test of insertar method, of class InterconsultaBO.
     */
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        InterconsultaDTO turno = null;
//        InterconsultaBO instance = new InterconsultaBO();
//        Integer expResult = null;
//        Integer result = instance.insertar(turno);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of obtenerPorId method, of class InterconsultaBO.
     */
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        Integer idEspecialidad = null;
//        Integer idCita = null;
//        InterconsultaBO instance = new InterconsultaBO();
//        InterconsultaDTO expResult = null;
//        InterconsultaDTO result = instance.obtenerPorId(idEspecialidad, idCita);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of listarTodos method, of class InterconsultaBO.
     */
    @Test
    @Disabled
    public void testListarTodos() {
        System.out.println("listarTodos");
        InterconsultaBO instance = new InterconsultaBO();
//        ArrayList<InterconsultaDTO> expResult = null;
        ArrayList<InterconsultaDTO> result = instance.listarTodos();
        System.out.println("Size: "+result.size());
    }
    
}
