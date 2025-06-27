/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.EstadoLogico;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcitbo.BO.util.Cifrado;

/**
 *
 * @author salva
 */
public class UsuarioBO {
    
    private final UsuarioDAO usuarioDao;
    
    
    public UsuarioBO(){
        usuarioDao = new UsuarioDAOImpl();
    } 
    
    public UsuarioDTO obtenerPorId(Integer id){
        return this.usuarioDao.obtenerPorId(id);
    }
    
    public UsuarioDTO buscarCuenta(String nroDocumento,String tipoDoc,String contrasenha){
        return this.usuarioDao.buscarCuenta(nroDocumento, tipoDoc, contrasenha);
    }
    
    public Integer insertar(UsuarioDTO usuario){
        
        return this.usuarioDao.insertar(usuario);
    }
    
    public Integer modificar(UsuarioDTO usuario){
        return this.usuarioDao.modificar(usuario);
    }
    
    public Integer cambiarEstadoGeneral(UsuarioDTO usuario,Integer estadoGeneral){
        usuario.setEstadoGeneral(EstadoGeneral.valueOfCodigo(estadoGeneral));
        return this.usuarioDao.cambiarEstadoGeneral(usuario);
    }
    
    public Integer cambiarEstadoLogico(UsuarioDTO usuario,Integer estadoLogico){
        usuario.setEstadoLogico(EstadoLogico.valueOfCodigo(estadoLogico));
        return this.usuarioDao.cambiarEstadoLogico(usuario);
    }
    
    public UsuarioDTO completarRoles(UsuarioDTO usuario){
        return this.usuarioDao.completarRoles(usuario);
    }
    
    public ArrayList<UsuarioDTO> listarMedicos(){
        return this.usuarioDao.listarMedicos();
    }
    
    public ArrayList<UsuarioDTO> listarTodos(){
        return this.usuarioDao.listarTodos();
    }
    
    public Integer CambiarContrasenha(UsuarioDTO usuario, String contrasenhaNueva){
        String contra = Cifrado.cifrarMD5(contrasenhaNueva);
        usuario.setContrasenha(contra);
        return this.usuarioDao.modificar(usuario);
    }
    
}
