/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class ExamenPorCitaParametrosBusquedaBuilder {
    private Integer idExamen;
    private Integer idCita;
    
    public ExamenPorCitaParametrosBusquedaBuilder(){
        this.idCita = null;
        this.idExamen = null;
    }
    
    public ExamenPorCitaParametrosBusquedaBuilder conIdExamen(Integer idExamen){
        this.idExamen = idExamen;
        return this;
    }
    public ExamenPorCitaParametrosBusquedaBuilder conIdCita(Integer idCita){
        this.idCita = idCita;
        return this;
    }
    
    public ExamenPorCitaParametrosBusqueda BuildExamenPorCitaParametrosBusqueda(){
        ExamenPorCitaParametrosBusqueda parametros = new ExamenPorCitaParametrosBusqueda();
        parametros.setIdCita(this.getIdCita());
        parametros.setIdExamen(this.getIdExamen());
        return parametros;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    
}
