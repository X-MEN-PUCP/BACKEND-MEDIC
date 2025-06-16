/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class DiagnosticoPorCita {
    private DiagnosticoDTO diagnostico;
    private CitaDTO cita;
    private String observacion;

    /**
     * @return the diagnostico
     */
    public DiagnosticoDTO getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(DiagnosticoDTO diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the cita
     */
    public CitaDTO getCita() {
        return cita;
    }

    /**
     * @param cita the cita to set
     */
    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
