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
import pe.edu.pucp.softcit.dao.HistoriaClinicaPorCitaDAO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;

/**
 *
 * @author Mcerv
 */
public class HistoriaClinicaPorCitaBOTest {
    
    public HistoriaClinicaPorCitaBOTest() {
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

//    /**
//     * Test of insertar method, of class HistoriaClinicaPorCitaBO.
//     */
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        HistoriaClinicaPorCitaDTO historiaPorCita = null;
//        HistoriaClinicaPorCitaBO instance = new HistoriaClinicaPorCitaBO();
//        Integer expResult = null;
//        Integer result = instance.insertar(historiaPorCita);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of modificar method, of class HistoriaClinicaPorCitaBO.
     */
    @Test
    
    public void testModificar() {
        System.out.println("modificar");
        HistoriaClinicaPorCitaBO instance = new HistoriaClinicaPorCitaBO();
        HistoriaClinicaPorCitaDTO historiaPorCita = instance.ObtenerPorIdCita(1);
        historiaPorCita.setPeso(100.0);
        historiaPorCita.setUsuarioModificacion(45);
        historiaPorCita.setFechaModificacion("2025-05-12");
        Integer result = instance.modificar(historiaPorCita);
        System.out.println("Modificado: "+result);
    }

//    /**
//     * Test of listarTodos method, of class HistoriaClinicaPorCitaBO.
//     */
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        HistoriaClinicaPorCitaBO instance = new HistoriaClinicaPorCitaBO();
//        ArrayList<HistoriaClinicaPorCitaDTO> expResult = null;
//        ArrayList<HistoriaClinicaPorCitaDTO> result = instance.listarTodos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarPorIdHistoria method, of class HistoriaClinicaPorCitaBO.
//     */
//    @Test
//    public void testListarPorIdHistoria() {
//        System.out.println("listarPorIdHistoria");
//        Integer idHistoria = null;
//        HistoriaClinicaPorCitaBO instance = new HistoriaClinicaPorCitaBO();
//        ArrayList<HistoriaClinicaPorCitaDTO> expResult = null;
//        ArrayList<HistoriaClinicaPorCitaDTO> result = instance.listarPorIdHistoria(idHistoria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ObtenerPorIdCita method, of class HistoriaClinicaPorCitaBO.
//     */
//    @Test
//    public void testObtenerPorIdCita() {
//        System.out.println("ObtenerPorIdCita");
//        Integer idCita = null;
//        HistoriaClinicaPorCitaBO instance = new HistoriaClinicaPorCitaBO();
//        HistoriaClinicaPorCitaDTO expResult = null;
//        HistoriaClinicaPorCitaDTO result = instance.ObtenerPorIdCita(idCita);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminar method, of class HistoriaClinicaPorCitaBO.
//     */
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        HistoriaClinicaPorCitaDTO historiaPorCita = null;
//        HistoriaClinicaPorCitaBO instance = new HistoriaClinicaPorCitaBO();
//        Integer expResult = null;
//        Integer result = instance.eliminar(historiaPorCita);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
