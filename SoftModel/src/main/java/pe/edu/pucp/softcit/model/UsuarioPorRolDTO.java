/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class UsuarioPorRolDTO {
    private UsuarioDTO usuarioDTO;
    private RolDTO rol;

    public UsuarioPorRolDTO() {
        this.rol = null;
        this.usuarioDTO = null;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }
    
}
