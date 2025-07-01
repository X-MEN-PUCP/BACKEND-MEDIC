/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.dao.EspecialidadPorUsuarioDAO;
import pe.edu.pucp.softcit.dao.HistoriaClinicaPorCitaDAO;
import pe.edu.pucp.softcit.dao.HistoriaDAO;
import pe.edu.pucp.softcit.dao.RolesPorUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.CitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.EspecialidadDAOImpl;
import pe.edu.pucp.softcit.daoImp.EspecialidadPorUsuarioDAOImpl;
import pe.edu.pucp.softcit.daoImp.HistoriaClinicaPorCitaDAOImpl;
import pe.edu.pucp.softcit.daoImp.HistoriaDAOImpl;
import pe.edu.pucp.softcit.daoImp.RolesPorUsuarioDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.HistoriaClinicaPorCitaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author salva
 */
public class PacienteBO {
    
    private final CitaDAO citaDAO;
    private final HistoriaClinicaPorCitaDAO historiaClinicaPorCitaDAO;
    private final HistoriaDAO historiaDAO;
    private final EspecialidadDAO especialidadDAO;
    private final EspecialidadPorUsuarioDAO usuarioPorEspecialidadDao;
    private final CitaDAO citaDao;
    private final RolesPorUsuarioDAO rolesPorUsuarioDao;
    
    
    public PacienteBO(){
        this.citaDAO = new CitaDAOImpl();
        this.historiaClinicaPorCitaDAO = new HistoriaClinicaPorCitaDAOImpl();
        this.historiaDAO = new HistoriaDAOImpl();
        this.especialidadDAO = new EspecialidadDAOImpl();
        this.usuarioPorEspecialidadDao = new EspecialidadPorUsuarioDAOImpl();
        this.citaDao = new CitaDAOImpl();
        this.rolesPorUsuarioDao = new RolesPorUsuarioDAOImpl();
        
    }
    
    
    public ArrayList<CitaDTO> listarCitas(Integer idEspecialidad, String fecha, Integer idMedico, String hora_inicio, EstadoCita estado){
        ArrayList<CitaDTO> citas = new ArrayList<>();
        if (idMedico != null || idEspecialidad != null) {
           citas = this.citaDAO.buscarCitas(idEspecialidad, idMedico, fecha, hora_inicio, estado);
        } else {
            System.out.println("Debe seleccionar una especialidad o un médico. Error listar Citas");
        }
        return citas;
    }
    
    public ArrayList<CitaDTO> buscarCitasParaCalendario(Integer idEspecialidad, String fecha, Integer idMedico, String hora_inicio, EstadoCita estado){
        ArrayList<CitaDTO> citas = new ArrayList<>();
        if (idMedico != null || idEspecialidad != null) {
           citas = this.citaDAO.buscarCitas(idEspecialidad, idMedico, fecha, hora_inicio, estado);
        } else {
            System.out.println("Debe seleccionar una especialidad o un médico. Error listar Citas");
        }
        return citas;
    }
    
    
    public int reservarCita(CitaDTO cita, UsuarioDTO paciente){
        Integer idPaciente = paciente.getIdUsuario();
        //actualizar cita (Estado: reservado)
        System.out.println("Modificando estado de cita");
        cita.setEstado(EstadoCita.RESERVADO);
        cita.setUsuarioModificacion(idPaciente);
        String fechaHoy = LocalDate.now().toString();
        cita.setFechaModificacion(fechaHoy);
        this.citaDAO.modificar(cita);
        
        
        HistoriaClinicaDTO historia;
        historia = this.historiaDAO.obtenerPorIdPaciente(idPaciente);
        
        HistoriaClinicaPorCitaDTO historia_por_cita = new HistoriaClinicaPorCitaDTO();
        historia_por_cita.setCita(cita);
        historia_por_cita.setHistoriaClinica(historia);
        historia_por_cita.setUsuarioCreacion(idPaciente);
        historia_por_cita.setFechaCreacion(fechaHoy);
        return this.historiaClinicaPorCitaDAO.insertar(historia_por_cita);
    }
     
    public int cancelarCita(HistoriaClinicaPorCitaDTO historia_por_cita) {
        //actualizar cita (Estado: disponible)
        CitaDTO cita = historia_por_cita.getCita();
        //cita.setEstado(EstadoCita.DISPONIBLE);
        cita.setUsuarioModificacion(historia_por_cita.getHistoriaClinica().getPaciente().getIdUsuario());
        //cita.setFechaModificacion(LocalDate.now().toString());
        this.citaDAO.actualizarEstadoCita(cita.getIdCita(), EstadoCita.DISPONIBLE.getCodigo(), cita.getUsuarioModificacion());
        return this.historiaClinicaPorCitaDAO.eliminar(historia_por_cita);
    }
     
    public int reprogramar(CitaDTO citaNueva, HistoriaClinicaPorCitaDTO historia_por_cita) {
        Integer idUsuarioModifcacion = citaNueva.getUsuarioModificacion();
        String fechaHoy = LocalDate.now().toString();
        //actualizar cita (Estado: disponible)
        CitaDTO citaAntigua = historia_por_cita.getCita();
        citaAntigua.setEstado(EstadoCita.DISPONIBLE);
        citaAntigua.setUsuarioModificacion(idUsuarioModifcacion);
        citaAntigua.setFechaModificacion(fechaHoy);
        this.citaDAO.modificar(citaAntigua);
        this.historiaClinicaPorCitaDAO.eliminar(historia_por_cita);
        
        citaNueva.setEstado(EstadoCita.RESERVADO);
        citaNueva.setFechaModificacion(fechaHoy);
        this.citaDAO.modificar(citaNueva);
        historia_por_cita.setCita(citaNueva);
        historia_por_cita.setUsuarioCreacion(idUsuarioModifcacion);
        historia_por_cita.setFechaCreacion(fechaHoy);
        return this.historiaClinicaPorCitaDAO.insertar(historia_por_cita);
    }
    
    public ArrayList<HistoriaClinicaPorCitaDTO> listarCitasPorPersona(UsuarioDTO paciente){
        Integer idPaciente = paciente.getIdUsuario();
        HistoriaClinicaDTO historia = this.historiaDAO.obtenerPorIdPaciente(idPaciente);
        Integer idHistoria = historia.getIdHistoriaClinica();
        return this.historiaClinicaPorCitaDAO.listarPorIdHistoria(idHistoria);
    }
    
    public HistoriaClinicaDTO obtenerHistoriaDelPaciente(UsuarioDTO paciente){
        Integer idPaciente = paciente.getIdUsuario();
        return this.historiaDAO.obtenerPorIdPaciente(idPaciente);
    }
    
    public void cambiarEstadoCita(Integer idCita,Integer Estado,Integer idModi){
        citaDAO.actualizarEstadoCita(idCita, Estado,idModi);
    }
    
    public ArrayList<EspecialidadDTO> listarEspecialidades(){
        return this.especialidadDAO.listar();
    }
    
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorEspecialidad(Integer idEspecialidad){
        return this.usuarioPorEspecialidadDao.listarPorEspecialidad(idEspecialidad);
    }
    
    public ArrayList<CitaDTO> buscarCitas(Integer idEspecialidad, Integer idMedico, String fecha, String hora_inicio, EstadoCita estado){
        if(idMedico == 0)idMedico = null;
        return this.citaDao.buscarCitas(idEspecialidad, idMedico, fecha, hora_inicio, estado);
    }
    
    public CitaDTO obtenerCitaPorId(Integer id){
        return this.citaDao.obtenerPorId(id);
    }
    
    public Integer modificarCita(CitaDTO cita){
        return this.citaDao.modificar(cita);
    }
    
    public ArrayList<UsuarioPorRolDTO> listarRolesDelUsuario(Integer id){
        return this.rolesPorUsuarioDao.listarPorUsuario(id);
    }
    
}

