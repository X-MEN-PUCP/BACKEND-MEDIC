/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class HistoriaClinicaParametrosBusquedaBuilder {
    private Integer idHistoria;
    private Integer idPaciente;
    
    public HistoriaClinicaParametrosBusquedaBuilder(){
        this.idHistoria = null;
        this.idPaciente = null;
    }
    
    public HistoriaClinicaParametrosBusquedaBuilder conIdHistoria(Integer idHistoria){
        this.idHistoria = idHistoria;
        return this;
    }
    
    public HistoriaClinicaParametrosBusquedaBuilder conIdPaciente(Integer idPaciente){
        this.idPaciente = idPaciente;
        return this;
    }
    
    public HistoriaClinicaParametrosBusqueda BuildHistoriaClinicaParametrosBusqueda(){
        HistoriaClinicaParametrosBusqueda parametros = new HistoriaClinicaParametrosBusqueda();
        parametros.setIdHistoria(this.getIdHistoria());
        parametros.setIdPaciente(this.getIdPaciente());
        return parametros;
    }
    
    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    
}
