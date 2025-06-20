/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import pe.edu.pucp.softcit.dao.RolesXUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.RolesXUsuarioDAOImpl;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.RolDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author salva
 */
public class AdminBO {
    
    private final RolesPorUsuarioBO rolesPorUsuarioBo;
    private final EspecialidadBO especialidadBo;
    private final UsuarioBO usuarioBo;
    private final UsuarioPorEspecialidadBO usuarioPorEspecialidadBo;
    
    public AdminBO(){
        this.rolesPorUsuarioBo = new RolesPorUsuarioBO();
        this.especialidadBo = new EspecialidadBO();
        this.usuarioBo = new UsuarioBO();
        this.usuarioPorEspecialidadBo = new UsuarioPorEspecialidadBO();
    }
    
    public Integer asignarNuevoRol(UsuarioPorRolDTO usuarioPorRol){   
        return this.rolesPorUsuarioBo.insertar(usuarioPorRol);
    }
    
    public Integer eliminarRol(UsuarioPorRolDTO usuarioPorRol){
        return this.rolesPorUsuarioBo.eliminar(usuarioPorRol);
    }
    
    public Integer insertarNuevaEspecialidad(EspecialidadDTO especialidad){
        return this.especialidadBo.insertar(especialidad);
    }
    
    public Integer insertarNuevoMedico(UsuarioDTO medico, EspecialidadDTO especialidad){
        Integer insertUsuario = this.usuarioBo.insertar(medico);
        Integer idUsuarioCreacion = medico.getUsuarioCreacion();
        String fechaCreacion = LocalDate.now().toString();
        RolDTO rol = new RolDTO();
        rol.setIdRol(2); //se debería obtener por nombre de rol "Médico"
        UsuarioPorEspecialidadDTO usuarioPorEspecialidad = new UsuarioPorEspecialidadDTO();
        usuarioPorEspecialidad.setEspecialidad(especialidad);
        usuarioPorEspecialidad.setUsuario(medico);
        usuarioPorEspecialidad.setUsuarioCreacion(idUsuarioCreacion);
        usuarioPorEspecialidad.setFechaCreacion(fechaCreacion);
        
        UsuarioPorRolDTO usuarioPorRol = new UsuarioPorRolDTO();
        usuarioPorRol.setUsuarioDTO(medico);
        usuarioPorRol.setRol(rol);
        usuarioPorRol.setUsuarioCreacion(idUsuarioCreacion);
        usuarioPorRol.setFechaCreacion(fechaCreacion);
        this.usuarioPorEspecialidadBo.insertar(usuarioPorEspecialidad);
        this.rolesPorUsuarioBo.insertar(usuarioPorRol);
        return insertUsuario;
    }
    
}
