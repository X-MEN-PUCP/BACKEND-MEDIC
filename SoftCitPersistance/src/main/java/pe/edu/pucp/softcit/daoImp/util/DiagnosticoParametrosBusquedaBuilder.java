/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class DiagnosticoParametrosBusquedaBuilder {
    private Integer idCita;
    private Integer idDiagnostico;

    public DiagnosticoParametrosBusquedaBuilder() {
        this.idCita = null;
        this.idDiagnostico = null;
    }
    
    public DiagnosticoParametrosBusquedaBuilder conIdCita(Integer idCita){
        this.idCita = idCita;
        return this;
    }
    
    public DiagnosticoParametrosBusquedaBuilder conIdDiagnostico(Integer idDiagnostico){
        this.idDiagnostico = idDiagnostico;
        return this;
    }
    
    public DiagnosticoParametrosBusqueda BuildDiagnosticoParametrosBusqueda(){
        DiagnosticoParametrosBusqueda parametros = new DiagnosticoParametrosBusqueda();
        parametros.setIdCita(this.getIdCita());
        parametros.setIdDiagnostico(this.getIdDiagnostico());
        return parametros;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
    
}
