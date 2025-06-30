/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.softcit.daoImp.RolesPorUsuarioDAOImpl;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.RolDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcit.dao.RolesPorUsuarioDAO;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.dao.EspecialidadPorUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.EspecialidadDAOImpl;
import pe.edu.pucp.softcit.daoImp.EspecialidadPorUsuarioDAOImpl;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcitbo.BO.util.Cifrado;

/**
 *
 * @author salva
 */
public class AdminBO {
    
    private final RolesPorUsuarioDAO rolesPorUsuarioDao;
    private final EspecialidadDAO especialidadDao;
    private final UsuarioDAO usuarioDao;
    private final EspecialidadPorUsuarioDAO usuarioPorEspecialidadDao;
    private final RegistroBO resgitoBo;
    private final Cifrado cifrado;
    
    public AdminBO(){
        this.rolesPorUsuarioDao = new RolesPorUsuarioDAOImpl();
        this.especialidadDao = new EspecialidadDAOImpl();
        this.usuarioDao = new UsuarioDAOImpl();
        this.usuarioPorEspecialidadDao = new EspecialidadPorUsuarioDAOImpl();
        this.resgitoBo = new RegistroBO();
        this.cifrado = new Cifrado();
    }
    
    public Integer asignarNuevoRol(UsuarioPorRolDTO usuarioPorRol){   
        return this.rolesPorUsuarioDao.insertar(usuarioPorRol);
    }
    
    public Integer agregarEspecialidadAMedico(UsuarioPorEspecialidadDTO usuarioPorEspecialidad){//////////////
        usuarioPorEspecialidad.setFechaCreacion(LocalDate.now().toString());
        return this.usuarioPorEspecialidadDao.insertar(usuarioPorEspecialidad);
    }
    
    public Integer eliminarEspecialidadMedico(UsuarioPorEspecialidadDTO usuarioPorEspecialidad){////////////
        return this.usuarioPorEspecialidadDao.eliminar(usuarioPorEspecialidad);
    }
    
    public Integer eliminarRol(UsuarioPorRolDTO usuarioPorRol){
        return this.rolesPorUsuarioDao.eliminar(usuarioPorRol);
    }
    
    public Integer insertarNuevaEspecialidad(EspecialidadDTO especialidad){
        return this.especialidadDao.insertar(especialidad);
    }
    
    public Integer insertarNuevoMedico(UsuarioDTO medico, ArrayList<EspecialidadDTO> especialidades){
        String contrasehnaAutomatica = this.generarContrasenha(medico);
        medico.setContrasenha(contrasehnaAutomatica);
        Integer id = this.resgitoBo.registrarse(medico);
        if(id!=0){ 
            Integer idUsuarioCreacion = medico.getUsuarioCreacion();
            String fechaCreacion = LocalDate.now().toString();
            RolDTO rol = new RolDTO();
            rol.setIdRol(2); //se debería obtener por nombre de rol "Médico"
            medico.setIdUsuario(id);
            UsuarioPorEspecialidadDTO usuarioPorEspecialidad = new UsuarioPorEspecialidadDTO();
            usuarioPorEspecialidad.setUsuario(medico);
            usuarioPorEspecialidad.setUsuarioCreacion(idUsuarioCreacion);
            usuarioPorEspecialidad.setFechaCreacion(fechaCreacion);
            for(EspecialidadDTO especialidad : especialidades){
                usuarioPorEspecialidad.setEspecialidad(especialidad);
                this.usuarioPorEspecialidadDao.insertar(usuarioPorEspecialidad);
            }

            UsuarioPorRolDTO usuarioPorRol = new UsuarioPorRolDTO();
            usuarioPorRol.setUsuarioDTO(medico);
            usuarioPorRol.setRol(rol);
            usuarioPorRol.setUsuarioCreacion(idUsuarioCreacion);
            usuarioPorRol.setFechaCreacion(fechaCreacion);
            this.rolesPorUsuarioDao.insertar(usuarioPorRol);
        }
        return id;
    }
    
    public Integer insertarNuevoAdministrador(UsuarioDTO administrador){////////////////
        String contrasehnaAutomatica = this.generarContrasenha(administrador);
        administrador.setContrasenha(contrasehnaAutomatica);
        Integer id = this.resgitoBo.registrarse(administrador);
        if(id!=0){
            Integer idUsuarioCreacion = administrador.getUsuarioCreacion();
            String fechaCreacion = LocalDate.now().toString();
            RolDTO rol = new RolDTO();
            rol.setIdRol(1);//rol admin
            administrador.setIdUsuario(id);
            UsuarioPorRolDTO usuarioPorRol = new UsuarioPorRolDTO();
            usuarioPorRol.setUsuarioDTO(administrador);
            usuarioPorRol.setRol(rol);
            usuarioPorRol.setUsuarioCreacion(idUsuarioCreacion);
            usuarioPorRol.setFechaCreacion(fechaCreacion);
            this.rolesPorUsuarioDao.insertar(usuarioPorRol);
        }
        return id;
    }
    
    public Integer insertarNuevoPaciente(UsuarioDTO paciente){/////////////////////
        //75843948CV
        String contrasehnaAutomatica = this.generarContrasenha(paciente);
        paciente.setContrasenha(contrasehnaAutomatica);
        Integer id = this.resgitoBo.registrarse(paciente);
        if(id!=0){
            Integer idUsuarioCreacion = paciente.getUsuarioCreacion();
            String fechaCreacion = LocalDate.now().toString();
            RolDTO rol = new RolDTO();
            rol.setIdRol(3);//rol paciente
            paciente.setIdUsuario(id);
            UsuarioPorRolDTO usuarioPorRol = new UsuarioPorRolDTO();
            usuarioPorRol.setUsuarioDTO(paciente);
            usuarioPorRol.setRol(rol);
            usuarioPorRol.setUsuarioCreacion(idUsuarioCreacion);
            usuarioPorRol.setFechaCreacion(fechaCreacion);
            this.rolesPorUsuarioDao.insertar(usuarioPorRol);
        }
        return this.resgitoBo.registrarse(paciente);
    }
    
    private String generarContrasenha(UsuarioDTO usuario){
        String contrasehnaAutomatica = usuario.getNumDocumento();
        String primerLetraApellidoPaterno = String.valueOf(usuario.getApellidoPaterno().charAt(0));
        String primerLetraApellidoMaterno = String.valueOf(usuario.getApellidoPaterno().charAt(0));
        contrasehnaAutomatica = contrasehnaAutomatica.concat(primerLetraApellidoPaterno.toUpperCase());
        contrasehnaAutomatica = contrasehnaAutomatica.concat(primerLetraApellidoMaterno.toUpperCase());
        return contrasehnaAutomatica;
    }
    
    public ArrayList<UsuarioDTO> listarMedicos(){
        return this.usuarioDao.listarMedicos();
    }
    
    public ArrayList<UsuarioDTO> listarTodosUsuarios(){
        return this.usuarioDao.listarTodos();
    }
    
    public ArrayList<EspecialidadDTO> listarEspecialidades(){
        return this.especialidadDao.listar();
    }
    
    public EspecialidadDTO obtenerEspecialidadPorId(Integer idEspecialidad){
        return this.especialidadDao.obtenerPorId(idEspecialidad);
    }
    
    public Integer modificarEspecialidad(EspecialidadDTO especialidad){
        especialidad.setFechaModificacion(LocalDate.now().toString());
        return this.especialidadDao.modificar(especialidad);
    }
    
    public ArrayList<UsuarioPorEspecialidadDTO> listarUsuariosPorEspecialidad(Integer idEspecialidad){
        return this.usuarioPorEspecialidadDao.listarPorEspecialidad(idEspecialidad);
    }
    
    public ArrayList<UsuarioPorRolDTO> listarRolesDeUsuario(Integer idUsuario){
        return this.rolesPorUsuarioDao.listarPorUsuario(idUsuario);
    }
    
    public UsuarioDTO obtenerUsuarioPorId(Integer idUsuario){
        UsuarioDTO usuario = this.usuarioDao.obtenerPorId(idUsuario);
        String contra = usuario.getContrasenha();
        contra = this.cifrado.descifrarMD5(contra);
        usuario.setContrasenha(contra);
        return usuario;
    }
    
    public Integer modificarUsuario(UsuarioDTO usuario){
        usuario.setFechaModificacion(LocalDate.now().toString());
        return this.usuarioDao.modificar(usuario);
    }
}
