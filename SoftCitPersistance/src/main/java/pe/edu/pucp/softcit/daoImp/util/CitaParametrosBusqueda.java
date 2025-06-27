/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

import pe.edu.pucp.softcit.model.EstadoCita;

/**
 *
 * @author Mcerv
 */
public class CitaParametrosBusqueda {
    private Integer idCita;
    private Integer idEspecialidad;
    private Integer idMedico;
    private String fecha; 
    private String horaInicio; 
    private EstadoCita estado;

    public CitaParametrosBusqueda() {
        this.idCita = null;
        this.idEspecialidad = null;
        this.idMedico = null;
        this.fecha = null;
        this.horaInicio = null;
        this.estado = null;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return horaInicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.horaInicio = hora_inicio;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
    
}
