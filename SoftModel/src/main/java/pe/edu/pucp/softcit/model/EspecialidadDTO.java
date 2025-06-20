/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class EspecialidadDTO {
    private Integer idEspecialidad;
    private String nombreEspecialidad;
    private Double precioConsulta;
    private EstadoGeneral estadoGeneral;
    private Integer usuarioCreacion;
    private String fechaCreacion;
    private Integer usuarioModificacion;
    private String fechaModificacion;

    public EspecialidadDTO() {
        this.idEspecialidad = null;
        this.nombreEspecialidad = null;
        this.precioConsulta = null;
        this.usuarioCreacion = null;
        this.fechaCreacion = null;
        this.usuarioModificacion = null;
        this.fechaModificacion = null;
    }
    
    public EspecialidadDTO(EspecialidadDTO especialidad) {
        this.idEspecialidad=especialidad.idEspecialidad;
        this.nombreEspecialidad=especialidad.nombreEspecialidad;
        this.nombreEspecialidad=especialidad.nombreEspecialidad;
        this.estadoGeneral=especialidad.estadoGeneral;
        this.usuarioCreacion = especialidad.usuarioCreacion;
        this.fechaCreacion = especialidad.fechaCreacion;
        this.usuarioModificacion = especialidad.usuarioModificacion;
        this.fechaModificacion = especialidad.fechaModificacion;
    }
    
    public EstadoGeneral getEstadoGeneral() {
        return estadoGeneral;
    }

    public void setEstadoGeneral(EstadoGeneral estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public Double getPrecioConsulta() {
        return precioConsulta;
    }

    public void setPrecioConsulta(Double precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    
}
