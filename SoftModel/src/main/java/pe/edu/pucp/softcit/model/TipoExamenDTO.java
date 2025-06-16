/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class TipoExamenDTO {
    private Integer idTipoExamen;
    private String nombreTipoExamen;
    private String indicacion;

    public TipoExamenDTO() {
        this.idTipoExamen = null;
        this.nombreTipoExamen = null;
        this.indicacion = null;
    }

    public Integer getIdTipoExamen() {
        return idTipoExamen;
    }

    public void setIdTipoExamen(Integer idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    public String getNombreTipoExamen() {
        return nombreTipoExamen;
    }

    public void setNombreTipoExamen(String nombreTipoExamen) {
        this.nombreTipoExamen = nombreTipoExamen;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }
    
}
