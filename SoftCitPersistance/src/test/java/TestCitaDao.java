
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.daoImp.CitaDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoCita;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author salva
 */
public class TestCitaDao {

    private CitaDAO dao;

    @Test
    public void ListarCitas() {
        this.dao = new CitaDAOImpl();
        Integer idCita = null;
        Integer idEspecialidad = null;
        String fecha = null;
        String hora_inicio = null;
        Integer idMedico = null;
        EstadoCita estado = null;
        
        ArrayList<CitaDTO> lista;
        
        lista = dao.listarTodos();
        System.err.println("Hay en la lista: " + lista.size());
        
        lista = dao.buscarCitas(idEspecialidad, idMedico, fecha, hora_inicio, estado);
        System.err.println("Hay en la lista: " + lista.size());
    }

}
