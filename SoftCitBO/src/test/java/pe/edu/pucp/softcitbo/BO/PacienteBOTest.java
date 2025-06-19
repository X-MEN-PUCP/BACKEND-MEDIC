/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author Mcerv
 */
public class PacienteBOTest {
    
    public PacienteBOTest() {
    }

    /**
     * Test of listarCitas method, of class PacienteBO.
     */
    @Test
    public void testListarCitas() {
        System.out.println("listarCitas");
        Integer idEspecialidad = null;
        String fecha = null;
        Integer idMedico = 3;
        PacienteBO instance = new PacienteBO();
        ArrayList<CitaDTO> expResult = null;
        ArrayList<CitaDTO> result = instance.listarCitas(idEspecialidad, fecha, idMedico);
        System.out.println("Citas: " + result.size());
    }

//    /**
//     * Test of reservarCita method, of class PacienteBO.
//     */
//    @Test
//    public void testReservarCita() {
//        System.out.println("reservarCita");
//        CitaDTO cita = null;
//        UsuarioDTO paciente = null;
//        PacienteBO instance = new PacienteBO();
//        int expResult = 0;
//        int result = instance.reservarCita(cita, paciente);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of cancelarCita method, of class PacienteBO.
//     */
//    @Test
//    public void testCancelarCita() {
//        System.out.println("cancelarCita");
//        CitaDTO cita = null;
//        HistoriaClinicaPorCitaDTO historia_por_cita = null;
//        PacienteBO instance = new PacienteBO();
//        int expResult = 0;
//        int result = instance.cancelarCita(cita, historia_por_cita);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of reprogramar method, of class PacienteBO.
//     */
//    @Test
//    public void testReprogramar() {
//        System.out.println("reprogramar");
//        CitaDTO citaAntigua = null;
//        CitaDTO citaNueva = null;
//        HistoriaClinicaPorCitaDTO historia_por_cita = null;
//        PacienteBO instance = new PacienteBO();
//        int expResult = 0;
//        int result = instance.reprogramar(citaAntigua, citaNueva, historia_por_cita);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarCitasPorPersona method, of class PacienteBO.
//     */
//    @Test
//    public void testListarCitasPorPersona() {
//        System.out.println("listarCitasPorPersona");
//        HistoriaClinicaDTO historia = null;
//        PacienteBO instance = new PacienteBO();
//        ArrayList<HistoriaClinicaPorCitaDTO> expResult = null;
//        ArrayList<HistoriaClinicaPorCitaDTO> result = instance.listarCitasPorPersona(historia);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
