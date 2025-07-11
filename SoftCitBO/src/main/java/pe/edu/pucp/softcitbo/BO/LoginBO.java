/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcitbo.BO;

import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcitbo.BO.util.Cifrado;

/**
 *
 * @author salva
 */
public class LoginBO {
    
    private final UsuarioDAO usuarioDao;
    
    
    public LoginBO(){
        this.usuarioDao = new UsuarioDAOImpl();
    } 
    
    public UsuarioDTO iniciarSesion(String numeroDoc,String tipoDoc , String contrasenha){
        UsuarioDTO cuenta;
        cuenta= this.usuarioDao.buscarCuenta(numeroDoc, tipoDoc, Cifrado.cifrarMD5(contrasenha));
        System.out.println(">"+ Cifrado.cifrarMD5(contrasenha)+"<");
        if(cuenta!=null){
            //cuenta = this.usuarioDao.completarRoles(cuenta);
            return cuenta;
        }
        System.out.println("No existe el usuario");
        return null;
    }
    
    public boolean cerrarSesion(UsuarioDTO usuarioDTO){
        usuarioDTO = null;
        return true;
    }
    
}
