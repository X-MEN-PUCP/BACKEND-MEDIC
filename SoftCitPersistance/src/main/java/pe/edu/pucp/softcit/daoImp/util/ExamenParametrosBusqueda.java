/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class ExamenParametrosBusqueda {
    private Integer idExamen;
    private Integer idTipoDeExamen;
    
    public ExamenParametrosBusqueda(){
        this.idExamen = null;
        this.idTipoDeExamen = null;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Integer getIdTipoDeExamen() {
        return idTipoDeExamen;
    }

    public void setIdTipoDeExamen(Integer idTipoDeExamen) {
        this.idTipoDeExamen = idTipoDeExamen;
    }
    
}
