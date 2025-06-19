/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.EspecialidadXUsuarioDAO;
import pe.edu.pucp.softcit.daoImp.EspecialidadXUsuarioDAOImpl;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;

/**
 *
 * @author salva
 */
public class UsuarioPorEspecialidadBO {
    
    private final EspecialidadXUsuarioDAO usuarioPorEspecialidadDao;
    
    public UsuarioPorEspecialidadBO(){
        this.usuarioPorEspecialidadDao = new EspecialidadXUsuarioDAOImpl();
    }
    
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorUsuario(Integer id){
        return this.usuarioPorEspecialidadDao.listarPorUsuario(id);
    }
    
    public ArrayList<UsuarioPorEspecialidadDTO> listarPorEspecialidad(Integer idEspecialidad){
        return this.usuarioPorEspecialidadDao.listarPorEspecialidad(idEspecialidad);
    }
    
    public Integer insertar(UsuarioPorEspecialidadDTO usuarioXespecialidad){
        return this.usuarioPorEspecialidadDao.insertar(usuarioXespecialidad);
    }
    
}
