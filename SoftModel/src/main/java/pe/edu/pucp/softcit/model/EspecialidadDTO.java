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
    

    public EspecialidadDTO() {
        this.idEspecialidad = null;
        this.nombreEspecialidad = null;
        this.precioConsulta = null;
    }
    
    public EspecialidadDTO(EspecialidadDTO especialidad) {
        this.idEspecialidad=especialidad.idEspecialidad;
        this.nombreEspecialidad=especialidad.nombreEspecialidad;
        this.nombreEspecialidad=especialidad.nombreEspecialidad;
        this.estadoGeneral=especialidad.estadoGeneral;
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
    
    
}
