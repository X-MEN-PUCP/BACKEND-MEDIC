/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
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
import pe.edu.pucp.softcitbo.BO.util.ServicioCorreo;

/**
 *
 * @author salva
 */
public class RegistroBO {
    
    private final UsuarioDAO usuarioDao;
    private final RolesPorUsuarioDAO rolesPorUsuarioDao;
    private final HistoriaDAO historiaDAO;
    private ServicioCorreo servicioCorreo;
    
    public RegistroBO(){
        this.usuarioDao = new UsuarioDAOImpl();
        this.rolesPorUsuarioDao = new RolesPorUsuarioDAOImpl();
        this.historiaDAO = new HistoriaDAOImpl();
        this.servicioCorreo = new ServicioCorreo();
    } 
    
    public boolean registrarse(UsuarioDTO usuario){
        if(usuarioDao.buscarPorCorreo(usuario.getCorreoElectronico())!=null){
            System.err.println("Error de registro: El correo ya existe");
            return false;
        }
        if (usuarioDao.buscarCuenta(usuario.getNumDocumento(), usuario.getTipoDocumento().toString(), null) != null) {
            System.err.println("Error de registro: El documento ya existe.");
            return false;
        }
        String codigoVerificacion = generarCodigoAleatorio(6);
        String fechaExpiracionStr = LocalDateTime.now().plusMinutes(10).toString();
        Boolean creacionAdmin = false;
        if(usuario.getUsuarioCreacion()!=null)
            creacionAdmin = true;
        if(!creacionAdmin)
            usuario.setUsuarioCreacion(1);
        String fechaCreacion = LocalDate.now().toString();
        usuario.setFechaCreacion(fechaCreacion);
        usuario.setEstadoGeneral(EstadoGeneral.PENDIENTE_VERIFICACION);
        usuario.setCodigoVerificacion(codigoVerificacion);
        usuario.setFechaExpiracionCodigo(fechaExpiracionStr);
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
            boolean correoEnviado = servicioCorreo.enviarCorreoVerificacion(usuario.getCorreoElectronico(), codigoVerificacion);
            return true;
        }
        return false;
    }

    public UsuarioDTO verificarCodigo(String correo, String codigoIngresado){
        UsuarioDTO usuario = usuarioDao.buscarPorCorreo(correo);
        if(usuario == null || usuario.getEstadoGeneral() != EstadoGeneral.PENDIENTE_VERIFICACION){
            return null;
        }
        LocalDateTime fechaExp = LocalDateTime.parse(usuario.getFechaExpiracionCodigo());
        if(fechaExp.isBefore(LocalDateTime.now())){
            return null;//expiro el codigo
        }
        if(usuario.getCodigoVerificacion().equals(codigoIngresado)){
            int resultadoModificacion = usuarioDao.actualizarEstado(usuario.getIdUsuario(), EstadoGeneral.ACTIVO);
            if(resultadoModificacion == 0) return null;
            
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
            return usuarioDao.obtenerPorId(usuario.getIdUsuario());
        }
        return null;
    }
    
    public boolean reenviarCodigo(String correo){
        UsuarioDTO usuario = usuarioDao.buscarPorCorreo(correo);
        if(usuario == null || usuario.getEstadoGeneral() != EstadoGeneral.PENDIENTE_VERIFICACION){
            return false;
        }
        String nuevoCodigo = generarCodigoAleatorio(6);
        String nuevaFechaExpiracionStr = LocalDateTime.now().plusMinutes(10).toString();
        
        int resultadoUpdate = usuarioDao.actualizarCodigoVerificacion(usuario.getIdUsuario(), nuevoCodigo, nuevaFechaExpiracionStr);

        if (resultadoUpdate > 0) {
            return servicioCorreo.enviarCorreoVerificacion(correo, nuevoCodigo);
        }
        return false;
    }
    
    private String generarCodigoAleatorio(int longitud) {
        return new Random().ints(longitud, 0, 10).mapToObj(String::valueOf).collect(Collectors.joining());
    }
}
