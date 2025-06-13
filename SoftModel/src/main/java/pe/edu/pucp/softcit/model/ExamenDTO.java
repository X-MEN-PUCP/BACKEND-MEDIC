/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class ExamenDTO {
    private Integer idExamen;
    private TipoExamenDTO tipoExamen;
    private String nombreExamen;

    public ExamenDTO() {
        this.idExamen = null;
        this.tipoExamen = null;
        this.nombreExamen = null;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public TipoExamenDTO getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(TipoExamenDTO tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }
    
}
