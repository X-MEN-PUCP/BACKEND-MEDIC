/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class ExamenPorCita {
    private ExamenDTO examen;
    private CitaDTO cita;
    private String observaciones;

    public ExamenPorCita() {
        this.examen =  null;
        this.cita = null;
        this.observaciones = null;
    }

    public ExamenDTO getExamen() {
        return examen;
    }

    public void setExamen(ExamenDTO examen) {
        this.examen = examen;
    }

    public CitaDTO getCita() {
        return cita;
    }

    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
