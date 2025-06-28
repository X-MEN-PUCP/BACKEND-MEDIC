/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

/**
 *
 * @author Mcerv
 */
public class InterconsultaParametrosBusqueda {
    private Integer idEspecialidadInterconsulta;
    private Integer idCita;

    public InterconsultaParametrosBusqueda() {
        this.idCita = null;
        this.idEspecialidadInterconsulta = null;
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
