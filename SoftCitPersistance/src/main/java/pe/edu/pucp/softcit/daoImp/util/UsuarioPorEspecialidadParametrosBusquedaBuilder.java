package pe.edu.pucp.softcit.daoImp.util;

public class UsuarioPorEspecialidadParametrosBusquedaBuilder {

    private Integer idUsuario;
    private Integer idEspecialidad;

    public UsuarioPorEspecialidadParametrosBusquedaBuilder() {
        this.idUsuario = null;
        this.idEspecialidad = null;
    }

    public UsuarioPorEspecialidadParametrosBusquedaBuilder conIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioPorEspecialidadParametrosBusquedaBuilder conIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        return this;
    }

    public UsuarioPorEspecialidadParametrosBusqueda build() {
        UsuarioPorEspecialidadParametrosBusqueda parametros = new UsuarioPorEspecialidadParametrosBusqueda();
        parametros.setIdUsuario(this.idUsuario);
        parametros.setIdEspecialidad(this.idEspecialidad);
        return parametros;
    }
}
