/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import pe.edu.pucp.softcit.dao.HistoriaDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.HistoriaDAOImpl;
import pe.edu.pucp.softcit.daoImp.RolesPorUsuarioDAOImpl;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.EstadoLogico;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.RolDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;
import pe.edu.pucp.softcit.dao.RolesPorUsuarioDAO;

/**
 *
 * @author salva
 */
public class RegistroBO {
    
    private final UsuarioDAO usuarioDao;
    private final RolesPorUsuarioDAO rolesPorUsuarioDao;
    private final HistoriaDAO historiaDAO;
    
    
    public RegistroBO(){
        this.usuarioDao = new UsuarioDAOImpl();
        this.rolesPorUsuarioDao = new RolesPorUsuarioDAOImpl();
        this.historiaDAO = new HistoriaDAOImpl();
    } 
    
    public boolean registrarse(UsuarioDTO usuario){
        Boolean creacionAdmin = false;
        if(usuario.getUsuarioCreacion()!=null)
            creacionAdmin = true;
        if(!creacionAdmin)
            usuario.setUsuarioCreacion(1);
        String fechaCreacion = LocalDate.now().toString();
        usuario.setFechaCreacion(fechaCreacion);
        usuario.setEstadoGeneral(EstadoGeneral.ACTIVO);
        usuario.setEstadoLogico(EstadoLogico.DISPONIBLE);
        Integer idUsuario = this.usuarioDao.insertar(usuario);
        
        if(idUsuario!=0){
            usuario.setIdUsuario(idUsuario);
            if(!creacionAdmin){
                usuario.setUsuarioCreacion(idUsuario);
                usuario.setUsuarioModificacion(idUsuario);
                usuario.setFechaModificacion(usuario.getFechaCreacion());
                this.usuarioDao.modificar(usuario);
            }
            Integer idUserCreacion = usuario.getUsuarioCreacion();
            UsuarioPorRolDTO usarioPorRol = new UsuarioPorRolDTO();
            usarioPorRol.setUsuarioDTO(usuario);
            RolDTO rol = new RolDTO();
            rol.setIdRol(3);//obtener rol paciente
            usarioPorRol.setRol(rol);
            usarioPorRol.setUsuarioCreacion(idUserCreacion);
            usarioPorRol.setFechaCreacion(usuario.getFechaCreacion());
            this.rolesPorUsuarioDao.insertar(usarioPorRol);
            
            HistoriaClinicaDTO historia = new HistoriaClinicaDTO();
            historia.setPaciente(usuario);
            historia.setEstadoGeneral(EstadoGeneral.ACTIVO);
            historia.setUsuarioCreacion(idUserCreacion);
            historia.setFechaCreacion(usuario.getFechaCreacion());
            this.historiaDAO.insertar(historia);
            return true;
        }
        return false;
    }
    
    
}
