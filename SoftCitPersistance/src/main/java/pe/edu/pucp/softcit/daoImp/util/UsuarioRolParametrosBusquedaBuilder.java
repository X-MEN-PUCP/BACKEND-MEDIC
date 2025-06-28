package pe.edu.pucp.softcit.daoImp.util;

public class UsuarioRolParametrosBusquedaBuilder {
    private Integer idUsuario;
    private Integer idRol;

    public UsuarioRolParametrosBusquedaBuilder() {
        this.idUsuario = null;
        this.idRol = null;
    }

    public UsuarioRolParametrosBusquedaBuilder conIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioRolParametrosBusquedaBuilder conIdRol(Integer idRol) {
        this.idRol = idRol;
        return this;
    }

    public UsuarioRolParametrosBusqueda buildUsuarioRolParametrosBusqueda() {
        UsuarioRolParametrosBusqueda params = new UsuarioRolParametrosBusqueda();
        params.setIdUsuario(this.idUsuario);
        params.setIdRol(this.idRol);
        return params;
    }
}
