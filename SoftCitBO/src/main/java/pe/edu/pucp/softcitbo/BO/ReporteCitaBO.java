/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

/**
 *
 * @author salva
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.ReporteCitasDAO;
import pe.edu.pucp.softcit.daoImp.ReporteCitasDAOImpl;
import pe.edu.pucp.softcit.model.ReporteCitaDTO;

public class ReporteCitaBO {

    private ReporteCitasDAO reporteCitaDAO;

    // Constructor que recibe la conexión y crea el DAO
    public ReporteCitaBO() {
        this.reporteCitaDAO = new ReporteCitasDAOImpl();
    }

    
    public ArrayList<ReporteCitaDTO> obtenerReporteCitas(
            String fechaDesde,
            String fechaHasta,
            Integer idEspecialidad,
            Integer idDoctor){

        return reporteCitaDAO.obtenerReporteCitas(fechaDesde, fechaHasta, idEspecialidad, idDoctor);
    }
}
