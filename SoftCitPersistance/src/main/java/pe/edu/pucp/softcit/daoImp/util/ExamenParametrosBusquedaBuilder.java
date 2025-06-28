/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class ExamenParametrosBusquedaBuilder {
    private Integer idExamen;
    private Integer idTipoDeExamen;
    
    public ExamenParametrosBusquedaBuilder(){
        this.idExamen = null;
        this.idTipoDeExamen = null;
    }
    
    public ExamenParametrosBusquedaBuilder conIdExamen(Integer idExamen){
        this.idExamen = idExamen;
        return this;
    }
    
    public ExamenParametrosBusquedaBuilder conIdTipoDeExamen(Integer idTipoDeExamen){
        this.idTipoDeExamen = idTipoDeExamen;
        return this;
    }
    
    public ExamenParametrosBusqueda BuildExamenParametrosBusqueda(){
        ExamenParametrosBusqueda parametros = new ExamenParametrosBusqueda();
        parametros.setIdExamen(this.getIdExamen());
        parametros.setIdTipoDeExamen(this.getIdTipoDeExamen());
        return parametros;
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
