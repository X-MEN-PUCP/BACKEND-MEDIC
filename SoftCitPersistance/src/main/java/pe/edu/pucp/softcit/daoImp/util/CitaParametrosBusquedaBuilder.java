/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

import pe.edu.pucp.softcit.model.EstadoCita;

/**
 *
 * @author Mcerv
 */
public class CitaParametrosBusquedaBuilder {
    private Integer idCita;
    private Integer idEspecialidad;
    private Integer idMedico;
    private String fecha; 
    private String horaInicio; 
    private EstadoCita estado;
    
    public CitaParametrosBusquedaBuilder(){
        this.idCita = null;
        this.idEspecialidad = null;
        this.idMedico = null;
        this.fecha = null;
        this.horaInicio = null;
        this.estado = null;
    }
    
    public CitaParametrosBusquedaBuilder conIdCita(Integer idCita){
        this.idCita = idCita;
        return this;
    }
    
    public CitaParametrosBusquedaBuilder conIdEspecialidad(Integer idEspecialidad){
        this.idEspecialidad = idEspecialidad;
        return this;
    }
    
    public CitaParametrosBusquedaBuilder conIdMedico(Integer idMedico){
        this.idMedico = idMedico;
        return this;
    }
    
    public CitaParametrosBusquedaBuilder conFecha(String fecha){
        this.fecha = fecha;
        return this;
    }
    
    public CitaParametrosBusquedaBuilder conHoraInicio(String horaInicio){
        this.horaInicio = horaInicio;
        return this;
    }
    
    public CitaParametrosBusquedaBuilder conEstado(EstadoCita estado){
        this.estado = estado;
        return this;
    }
    
    public CitaParametrosBusqueda BuildCitaParametrosBusqueda(){
        CitaParametrosBusqueda parametros = new CitaParametrosBusqueda();
        parametros.setEstado(this.getEstado());
        parametros.setFecha(this.getFecha());
        parametros.setHora_inicio(this.getHoraInicio());
        parametros.setIdCita(this.getIdCita());
        parametros.setIdEspecialidad(this.getIdEspecialidad());
        parametros.setIdMedico(this.getIdMedico());
        return parametros;
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
    
    
}
