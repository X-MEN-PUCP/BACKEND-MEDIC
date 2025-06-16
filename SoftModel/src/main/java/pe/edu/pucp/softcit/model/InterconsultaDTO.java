/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class InterconsultaDTO {
    private EspecialidadDTO especialidadInterconsulta;
    private CitaDTO cita;
    private String razonInterconsulta;

    public InterconsultaDTO() {
        this.especialidadInterconsulta = null;
        this.cita = null;
        this.razonInterconsulta = null;
    }

    public EspecialidadDTO getEspecialidadInterconsulta() {
        return especialidadInterconsulta;
    }

    public void setEspecialidadInterconsulta(EspecialidadDTO especialidadInterconsulta) {
        this.especialidadInterconsulta = especialidadInterconsulta;
    }

    public CitaDTO getCita() {
        return cita;
    }

    public void setCita(CitaDTO cita) {
        this.cita = cita;
    }

    public String getRazonInterconsulta() {
        return razonInterconsulta;
    }

    public void setRazonInterconsulta(String razonInterconsulta) {
        this.razonInterconsulta = razonInterconsulta;
    }
    
}
