/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.ReporteCitasDAO;
import pe.edu.pucp.softcit.model.ReporteCitaDTO;

public class ReporteCitasDAOImpl extends DAOImplBase implements ReporteCitasDAO {

    public ReporteCitasDAOImpl() {
        super("");
    }

    @Override
    protected void configurarListaDeColumnas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ReporteCitaDTO> obtenerReporteCitas(
            String fechaDesdeStr,
            String fechaHastaStr,
            Integer idEspecialidad,
            Integer idDoctor) {

        ArrayList<ReporteCitaDTO> lista = new ArrayList<>();

        // Formato esperado de las fechas
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaDesde = null;
        java.sql.Date fechaHasta = null;

        // Conversión de String a java.sql.Date, si aplica
        if (fechaDesdeStr != null && !fechaDesdeStr.trim().isEmpty()) {
            try {
                java.util.Date utilDesde = sdf.parse(fechaDesdeStr);
                fechaDesde = new java.sql.Date(utilDesde.getTime());

                if (fechaHastaStr != null && !fechaHastaStr.trim().isEmpty()) {
                    java.util.Date utilHasta = sdf.parse(fechaHastaStr);
                    fechaHasta = new java.sql.Date(utilHasta.getTime());
                }
                this.abrirConexion();
                String sql = "{CALL sp_reporte_citas_atendidas(?, ?, ?, ?)}";
                this.colocarSQLenStatement(sql);

                // Parámetro 1: fechaDesde
                if (fechaDesde != null) {
                    this.statement.setDate(1, fechaDesde);
                } else {
                    this.statement.setNull(1, Types.DATE);
                }

                // Parámetro 2: fechaHasta
                if (fechaHasta != null) {
                    this.statement.setDate(2, fechaHasta);
                } else {
                    this.statement.setNull(2, Types.DATE);
                }

                // Parámetro 3: idEspecialidad
                if (idEspecialidad != null) {
                    this.statement.setInt(3, idEspecialidad);
                } else {
                    this.statement.setNull(3, Types.INTEGER);
                }

                // Parámetro 4: idDoctor
                if (idDoctor != null) {
                    this.statement.setInt(4, idDoctor);
                } else {
                    this.statement.setNull(4, Types.INTEGER);
                }
                
                this.ejecutarConsultaEnBD();

                while (this.resultSet.next()) {
                    ReporteCitaDTO dto = new ReporteCitaDTO();
                    dto.setIdCita(this.resultSet.getString("id_cita"));
                    dto.setPaciente(this.resultSet.getString("paciente"));
                    dto.setEspecialidad(this.resultSet.getString("especialidad"));
                    dto.setCodMedico(this.resultSet.getString("cod_medico"));
                    dto.setDoctor(this.resultSet.getString("doctor"));
                    dto.setFechaCita(this.resultSet.getString("fecha_cita"));
                    dto.setHora(this.resultSet.getString("hora"));
                    lista.add(dto);
                }

            } catch (ParseException ex) {
                Logger.getLogger(ReporteCitasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ReporteCitasDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

}
