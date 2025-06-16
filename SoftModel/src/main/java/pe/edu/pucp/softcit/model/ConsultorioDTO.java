/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class ConsultorioDTO {
    private Integer idConsultorio;
    private Integer numConsultorio;
    private Integer numPiso;

    public ConsultorioDTO() {
        this.idConsultorio = null;
        this.numConsultorio = null;
        this.numPiso = null; 
    }

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Integer getNumConsultorio() {
        return numConsultorio;
    }

    public void setNumConsultorio(Integer numConsultorio) {
        this.numConsultorio = numConsultorio;
    }

    public Integer getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(Integer numPiso) {
        this.numPiso = numPiso;
    }
    
}
