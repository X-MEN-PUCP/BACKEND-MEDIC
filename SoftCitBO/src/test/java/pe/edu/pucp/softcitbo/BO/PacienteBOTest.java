/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
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
        System.out.println("listarCitas ======================");
        Integer idEspecialidad = null;
        String fecha = null;
        Integer idMedico = 3;
        EstadoCita estado = EstadoCita.DISPONIBLE;
        String hora_inicio = null;
        PacienteBO instance = new PacienteBO();
        ArrayList<CitaDTO> result = instance.listarCitas(idEspecialidad, fecha, idMedico, hora_inicio, estado);
        System.out.println("Citas: " + result.size());
        System.out.println("listarCitasCalendario ======================");
        result = instance.buscarCitasParaCalendario(idEspecialidad, fecha, idMedico, hora_inicio, estado);
        System.out.println("Citas: " + result.size());
    }
//
    /**
     * Test of reservarCita method, of class PacienteBO.
     */
    @Test
    
    public void testFlujoCita() {
//        System.out.println("reservarCita");
        CitaDTO cita;
        CitaBO citaBO = new CitaBO();
        cita = citaBO.obtenerPorId(5);
        UsuarioDTO paciente = new UsuarioDTO();
        paciente.setIdUsuario(5);
        PacienteBO instance = new PacienteBO();
        int result = instance.reservarCita(cita, paciente);
        System.out.println("Cita reservada: "+ result);
        System.out.println("listarCitasPorPersona");
        ArrayList<HistoriaClinicaPorCitaDTO> lista = instance.listarCitasPorPersona(paciente);
        System.out.println("Tamaño de lista: "+lista.size());
        System.out.println("cancelarCita");
        HistoriaClinicaPorCitaDTO historia_por_cita = lista.get(0);
        int cancelada = instance.cancelarCita(historia_por_cita);
        System.out.println("Cita cancelada: "+ cancelada);
        
    }
    
    /**
     * Test of cancelarCita method, of class PacienteBO.
     */
//    @Test
//    public void testCancelarCita() {
//        System.out.println("cancelarCita");
//        CitaDTO cita = null;
//        HistoriaClinicaPorCitaDTO historia_por_cita = null;
//        PacienteBO instance = new PacienteBO();
//        int expResult = 0;
//        int result = instance.cancelarCita(historia_por_cita);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of reprogramar method, of class PacienteBO.
     */
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

    /**
     * Test of listarCitasPorPersona method, of class PacienteBO.
     */
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
