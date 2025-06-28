/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class InterconsultaParametrosBusquedaBuilder {
    private Integer idEspecialidadInterconsulta;
    private Integer idCita;
    
    public InterconsultaParametrosBusquedaBuilder(){
        this.idCita = null;
        this.idEspecialidadInterconsulta = null;
    }
    
    public InterconsultaParametrosBusquedaBuilder conIdCita(Integer idCita){
        this.idCita = idCita;
        return this;
    }
    
    public InterconsultaParametrosBusquedaBuilder conIdEspecialidadInterconsulta(Integer idEspecialidadInterconsulta){
        this.idEspecialidadInterconsulta = idEspecialidadInterconsulta;
        return this;
    }
    
    public InterconsultaParametrosBusqueda BuildInterconsultaParametrosBusqueda(){
        InterconsultaParametrosBusqueda parametros = new InterconsultaParametrosBusqueda();
        parametros.setIdCita(this.getIdCita());
        parametros.setIdEspecialidadInterconsulta(this.getIdEspecialidadInterconsulta());
        return parametros;
    }

    public Integer getIdEspecialidadInterconsulta() {
        return idEspecialidadInterconsulta;
    }

    public void setIdEspecialidadInterconsulta(Integer idEspecialidadInterconsulta) {
        this.idEspecialidadInterconsulta = idEspecialidadInterconsulta;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    
}
