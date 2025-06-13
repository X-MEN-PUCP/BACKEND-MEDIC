/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Mcerv
 */
public class CitaDTO {
    private Integer idCita;
    private UsuarioDTO medico;
    private EspecialidadDTO especialidad;
    private TurnoDTO turno;
    private ConsultorioDTO consultorio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaCita;

    public CitaDTO() {
        this.idCita = null;
        this.medico = null;
        this.especialidad = null;
        this.turno = null;
        this.consultorio = null;
        this.horaInicio = null;
        this.horaFin = null;
        this.fechaCita = null;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public UsuarioDTO getMedico() {
        return medico;
    }

    public void setMedico(UsuarioDTO medico) {
        this.medico = medico;
    }

    public EspecialidadDTO getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

    public ConsultorioDTO getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(ConsultorioDTO consultorio) {
        this.consultorio = consultorio;
    }
    
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }
    
}
