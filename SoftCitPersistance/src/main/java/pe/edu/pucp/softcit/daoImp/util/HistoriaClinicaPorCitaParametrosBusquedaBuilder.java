/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class HistoriaClinicaPorCitaParametrosBusquedaBuilder {
    private Integer idHistoria;
    private Integer idCita;

    public HistoriaClinicaPorCitaParametrosBusquedaBuilder() {
        this.idHistoria = null;
        this.idCita = null;
    }
    
    public HistoriaClinicaPorCitaParametrosBusquedaBuilder conIdCita(Integer idCita){
        this.idCita = idCita;
        return this;
    }
    
    public HistoriaClinicaPorCitaParametrosBusquedaBuilder conIdHistoria(Integer idHistoria){
        this.idHistoria = idHistoria;
        return this;
    }
    
    public HistoriaClinicaPorCitaParametrosBusqueda BuildHistoriaClinicaParametrosBusqueda(){
        HistoriaClinicaPorCitaParametrosBusqueda parametros = new HistoriaClinicaPorCitaParametrosBusqueda();
        parametros.setIdCita(this.getIdCita());
        parametros.setIdHistoria(this.getIdHistoria());
        return parametros;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    
}
