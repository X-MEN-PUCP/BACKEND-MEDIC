/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.dao.DiagnositcoPorCitaDAO;
import pe.edu.pucp.softcit.dao.DiagnosticoDAO;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.dao.ExamenDAO;
import pe.edu.pucp.softcit.dao.ExamenPorCitaDAO;
import pe.edu.pucp.softcit.dao.HistoriaClinicaPorCitaDAO;
import pe.edu.pucp.softcit.dao.InterconsultaDAO;
import pe.edu.pucp.softcit.dao.TipoExamenDAO;
import pe.edu.pucp.softcit.daoImp.CitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.DiagnosticoDAOImpl;
import pe.edu.pucp.softcit.daoImp.DiagnosticoPorCitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.EspecialidadDAOImpl;
import pe.edu.pucp.softcit.daoImp.ExamenDAOImpl;
import pe.edu.pucp.softcit.daoImp.ExamenPorCitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.HistoriaClinicaPorCitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.InterconsultaDAOImpl;
import pe.edu.pucp.softcit.daoImp.TipoExamenDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;
import pe.edu.pucp.softcit.model.DiagnosticoPorCita;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.ExamenDTO;
import pe.edu.pucp.softcit.model.ExamenPorCitaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.InterconsultaDTO;
import pe.edu.pucp.softcit.model.TipoExamenDTO;

/**
 *
 * @author salva
 */
public class MedicoBO {

    private final CitaDAO citaDao;
    private final HistoriaClinicaPorCitaDAO historiaClinicaPorCitaDao;
    private final EspecialidadDAO especialidadDAO;
    private final InterconsultaDAO interconsultaDAO;
    private final TipoExamenDAO tipoExamenDAO;
    private final ExamenDAO examenDAO;
    private final ExamenPorCitaDAO examenPorCitaDAO;
    private final DiagnosticoDAO diagnosticoDAO;
    private final DiagnositcoPorCitaDAO diagnosticoPorCitaDAO;

    public MedicoBO() {
        this.citaDao = new CitaDAOImpl();
        this.historiaClinicaPorCitaDao = new HistoriaClinicaPorCitaDAOImpl();
        this.especialidadDAO = new EspecialidadDAOImpl();
        this.interconsultaDAO = new InterconsultaDAOImpl();
        this.tipoExamenDAO = new TipoExamenDAOImpl();
        this.examenDAO = new ExamenDAOImpl();
        this.examenPorCitaDAO = new ExamenPorCitaDAOImpl();
        this.diagnosticoDAO=new DiagnosticoDAOImpl();
        this.diagnosticoPorCitaDAO=new DiagnosticoPorCitaDAOImpl();
    }
    
    //Cita

    public ArrayList<CitaDTO> listarCitasMedico(Integer idMedico, EstadoCita estado) {
        return this.citaDao.listarCitasMedico(idMedico, estado);
    }
    
    public Integer modificarCita(CitaDTO cita){
        return this.citaDao.modificar(cita);
    }
    
    public CitaDTO obtenerCitaPorId(Integer id){
        return this.citaDao.obtenerPorId(id);
    }
    
    //Historia Clinica Por Cita
    
    public Integer llenarEpicrisis(HistoriaClinicaPorCitaDTO epiciris){
        String fechaHoy = LocalDate.now().toString();
        epiciris.setFechaModificacion(fechaHoy);
        return this.historiaClinicaPorCitaDao.modificar(epiciris);
    }
    
    public HistoriaClinicaPorCitaDTO obtenerHistoriaClinicaPorCita(Integer idCita){
        return this.historiaClinicaPorCitaDao.ObtenerPorIdCita(idCita);
    }
    
    //Especialidades
    
    public ArrayList<EspecialidadDTO> listarEspecialidadesParaInterconsulta(){
        return this.especialidadDAO.listar();
    }
    
    public EspecialidadDTO obtenerEspecialidadPorId(Integer id){
        return this.especialidadDAO.obtenerPorId(id);
    }
    
    //Intercosnulta
    
    public Integer insertarInterconsultasDeCita(InterconsultaDTO interconsulta){
        //falta el usuario de creacion y fecha
        return this.interconsultaDAO.insertar(interconsulta);
    }
    
    public Integer modificarInteronsultaDeCita(InterconsultaDTO interconsulta){
        return this.interconsultaDAO.modificar(interconsulta);
    }
    
    public Integer eliminarInterconsultaDeCita(InterconsultaDTO interconsulta){
        return this.interconsultaDAO.eliminar(interconsulta);
    }
    
    public ArrayList<InterconsultaDTO> ListarInterconsultasPorIdCita(Integer idCita){
        return this.interconsultaDAO.buscarInterconsultasPorCita(idCita);
    }
    
    public ArrayList<InterconsultaDTO> listarTodasLasInterconsultas(){
        return this.interconsultaDAO.listarTodos();
    }
    
    //Tipos de examenes
    
    public ArrayList<TipoExamenDTO> listarTiposDeExamen(){
        return this.tipoExamenDAO.listarTodos();
    }
    
    //Examen
    
    public ArrayList<ExamenDTO> listarExamenesPorTipo(Integer idTipoExamen){
        return this.examenDAO.listarPorIdTipoExamen(idTipoExamen);
    }
    
    public ArrayList<ExamenDTO> listarTodosLosExamanes(){
        return this.examenDAO.listarTodos();
    }
    
    public ExamenDTO obtenerExamenPorId(Integer examenId){
        return this.examenDAO.obtenerPorId(examenId);
    }
    
    // Examen por cita
    public Integer agregarExamenPorCita(ExamenPorCitaDTO examenPorCita){
        examenPorCita.setEstadoGeneral(EstadoGeneral.ACTIVO);
        examenPorCita.setFechaCreacion(LocalDate.now().toString());
        return this.examenPorCitaDAO.insertar(examenPorCita);
    }
    
    public ArrayList<ExamenPorCitaDTO> listarExamenesPorIdCita(Integer idCita){
        return this.examenPorCitaDAO.listarPorIdCita(idCita);
    }
    
    public Integer modificarExamenPorCita(ExamenPorCitaDTO examenPorCita){
        return this.examenPorCitaDAO.modificar(examenPorCita);
    }
    
    public Integer eliminarExamenPorCita(ExamenPorCitaDTO examenPorCita){
        return this.examenPorCitaDAO.eliminar(examenPorCita);
    }
    
    //Diagnostico
    
    public ArrayList<DiagnosticoDTO> listarDiagnosticos(){
        return this.diagnosticoDAO.listarTodos();
    }
    
    public DiagnosticoDTO obtenerDiagnoticoPorId(Integer diagnosticoId){
       return this.diagnosticoDAO.obtenerPorId(diagnosticoId);
    }
    
    //Diagnostico por cita
    public Integer agregarDiagnosticoPorCita(DiagnosticoPorCita diagnosticoPorCita){
        return this.diagnosticoPorCitaDAO.insertar(diagnosticoPorCita);
    }
    
    public Integer modificarDiagnosticoPorCita(DiagnosticoPorCita diagnosticoPorCita){
        return this.diagnosticoPorCitaDAO.modificar(diagnosticoPorCita);
    }
    
    public Integer eliminarDiagnosticoPorCita(DiagnosticoPorCita diagnosticoPorCita){
        return this.diagnosticoPorCitaDAO.eliminar(diagnosticoPorCita);
    }
    
    public ArrayList<DiagnosticoPorCita> listarDiagnosticoPorIdCita(Integer idCita){
        return this.diagnosticoPorCitaDAO.listarPorIdCita(idCita);
    }
}
