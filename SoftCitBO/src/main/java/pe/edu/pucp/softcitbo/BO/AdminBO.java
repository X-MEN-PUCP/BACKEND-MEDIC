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
    
    public AdminBO(){
        this.rolesPorUsuarioDao = new RolesPorUsuarioDAOImpl();
        this.especialidadDao = new EspecialidadDAOImpl();
        this.usuarioDao = new UsuarioDAOImpl();
        this.usuarioPorEspecialidadDao = new EspecialidadPorUsuarioDAOImpl();
        this.resgitoBo = new RegistroBO();
    }
    
    public Integer asignarNuevoRol(UsuarioPorRolDTO usuarioPorRol){   
        return this.rolesPorUsuarioDao.insertar(usuarioPorRol);
    }
    
    public Integer eliminarRol(UsuarioPorRolDTO usuarioPorRol){
        return this.rolesPorUsuarioDao.eliminar(usuarioPorRol);
    }
    
    public Integer insertarNuevaEspecialidad(EspecialidadDTO especialidad){
        return this.especialidadDao.insertar(especialidad);
    }
    
    public Boolean insertarNuevoMedico(UsuarioDTO medico, ArrayList<EspecialidadDTO> especialidades){
        if(this.resgitoBo.registrarse(medico)){
            Integer idUsuarioCreacion = medico.getUsuarioCreacion();
            String fechaCreacion = LocalDate.now().toString();
            RolDTO rol = new RolDTO();
            rol.setIdRol(2); //se debería obtener por nombre de rol "Médico"

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
            return true;
        }
        return false;
    }
    
    public ArrayList<UsuarioDTO> listarMedicos(){
        return this.usuarioDao.listarMedicos();
    }
    
    public ArrayList<UsuarioDTO> listarTodosUsuarios(){
        return this.usuarioDao.listarTodos();
    }
    
}
