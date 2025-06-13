/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author Mcerv
 */
public class DiagnosticoDTO {
    private Integer idDiagnostico;
    private String nombreDiagnostico;
    private String descripcion;
    private String capitulo;
    private String grupo;
    private Integer nivel;

    public DiagnosticoDTO() {
        this.idDiagnostico = null;
        this.nombreDiagnostico = null;
        this.descripcion = null;
        this.capitulo = null;
        this.grupo = null;
        this.nivel = null;
    }

    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
}
