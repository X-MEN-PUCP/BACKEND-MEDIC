/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import pe.edu.pucp.softcit.dao.HistoriaDAO;
import pe.edu.pucp.softcit.dao.RolesXUsuarioDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.HistoriaDAOImpl;
import pe.edu.pucp.softcit.daoImp.RolesXUsuarioDAOImpl;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.RolDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author salva
 */
public class RegistroBO {
    
    private final UsuarioDAO usuarioDao;
    private final RolesXUsuarioDAO rolesPorUsuarioDao;
    private final HistoriaDAO historiaDAO;
    
    
    public RegistroBO(){
        this.usuarioDao = new UsuarioDAOImpl();
        this.rolesPorUsuarioDao = new RolesXUsuarioDAOImpl();
        this.historiaDAO = new HistoriaDAOImpl();
    } 
    
    public boolean registrarse(UsuarioDTO usuario){
        usuario.setUsuarioCreacion(1);
        String fechaCreacion = LocalDate.now().toString();
        usuario.setFechaCreacion(fechaCreacion);
        Integer insert = this.usuarioDao.insertar(usuario);
        if(insert!=0){
            usuario.setUsuarioCreacion(insert);
            usuario.setUsuarioModificacion(insert);
            usuario.setFechaModificacion(usuario.getFechaCreacion());
            this.usuarioDao.modificar(usuario);
            
            UsuarioPorRolDTO usarioPorRol = new UsuarioPorRolDTO();
            usarioPorRol.setUsuarioDTO(usuario);
            RolDTO rol = new RolDTO();
            rol.setIdRol(1);
            usarioPorRol.setRol(rol);
            usarioPorRol.setUsuarioCreacion(insert);
            usarioPorRol.setFechaCreacion(usuario.getFechaCreacion());
            this.rolesPorUsuarioDao.insertar(usarioPorRol);
            
            HistoriaClinicaDTO historia = new HistoriaClinicaDTO();
            historia.setPaciente(usuario);
            historia.setEstadoGeneral(EstadoGeneral.ACTIVO);
            historia.setUsuarioCreacion(insert);
            historia.setFechaCreacion(usuario.getFechaCreacion());
            this.historiaDAO.insertar(historia);
            
            return true;
        }
        return false;
    }
    
    
}
