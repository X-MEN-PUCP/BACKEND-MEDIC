
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.daoImp.CitaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;

public class CitaDAOTest {

    @Test
    public void testBuscarCitasDisponibles() {
        try {
            // Instancia del DAO (con conexión gestionada internamente)
            CitaDAO citaDAO = new CitaDAOImpl();

            // Parámetros de prueba
            Integer idEspecialidad = null;
            Integer idMedico = null;
            String fecha = null;
            String horaInicio = null;
            EstadoCita estado = null;

            // Ejecutar
            ArrayList<CitaDTO> citas = citaDAO.buscarCitasDisponibles(idEspecialidad, idMedico, fecha, horaInicio, estado);

            // Verificar que el array no es nulo
            assertNotNull(citas, "La lista de citas no debe ser nula");

            // Imprimir tamaño y un atributo si hay resultados
            System.out.println("🔍 Total de citas encontradas: " + citas.size());

            if (!citas.isEmpty()) {
                CitaDTO cita = citas.get(0);

                System.out.println("📄 Detalle de la primera cita:");
                System.out.println("🩺 Médico: " + cita.getMedico().getNombres() + " "
                        + cita.getMedico().getApellidoPaterno() + " "
                        + cita.getMedico().getApellidoMaterno());
                System.out.println("📧 Correo: " + cita.getMedico().getCorreoElectronico());
                System.out.println("📱 Celular: " + cita.getMedico().getNumCelular());

                System.out.println("🏥 Consultorio: Nº " + cita.getConsultorio().getNumConsultorio()
                        + ", Piso: " + cita.getConsultorio().getNumPiso());

                System.out.println("📚 Especialidad: " + cita.getEspecialidad().getNombreEspecialidad()
                        + " (S/. " + cita.getEspecialidad().getPrecioConsulta() + ")");

                System.out.println("📅 Fecha: " + cita.getFechaCita());
                System.out.println("🕒 Hora: " + cita.getHoraInicio() + " - " + cita.getHoraFin());
                System.out.println("🎯 Estado: " + cita.getEstado());

                // Asegurar que los campos clave no son nulos
                assertNotNull(cita.getMedico().getNombres(), "El nombre del médico no debe ser nulo");
                assertNotNull(cita.getEspecialidad().getNombreEspecialidad(), "El nombre de la especialidad no debe ser nulo");
                assertNotNull(cita.getConsultorio().getNumConsultorio(), "El número de consultorio no debe ser nulo");
            }

        } catch (Exception e) {
            fail("Error al ejecutar testBuscarCitasDisponibles: " + e.getMessage());
        }
    }
}
