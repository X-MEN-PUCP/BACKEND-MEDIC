/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Mcerv
 */
public class UsuarioDTO {
    private Integer idUsuario;
    private TipoDocumento tipoDocumento;
    private String numDocumento;
    private String contrasenha;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String correoElectronico;
    private String numCelular;
    private String codMedico;
    private Genero genero;
    
    private ArrayList<Integer> roles;

    private EstadoGeneral estadoGeneral;
    private EstadoLogico estadoLogico;
    private Integer usuarioCreacion;
    private String fechaCreacion;
    private Integer usuarioModificacion;
    private String fechaModificacion;
    private String codigoVerificacion;
    private String fechaExpiracionCodigo;

    public UsuarioDTO() {
        this.idUsuario = null;
        this.numDocumento = null;
        this.tipoDocumento = null;
        this.contrasenha = null;
        this.nombres = null;
        this.apellidoPaterno = null;
        this.apellidoMaterno = null;
        this.fechaNacimiento = null;
        this.correoElectronico = null;
        this.numCelular = null;
        this.codMedico = null;
        this.genero = null;
        this.roles=null;
        this.usuarioCreacion = null;
        this.fechaCreacion = null;
        this.usuarioModificacion = null;
        this.fechaModificacion = null;
        this.codigoVerificacion = null;
        this.fechaExpiracionCodigo = null;
    }

    public ArrayList<Integer> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Integer> roles) {
        this.roles = roles;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(String codMedico) {
        this.codMedico = codMedico;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public EstadoGeneral getEstadoGeneral() {
        return estadoGeneral;
    }

    public void setEstadoGeneral(EstadoGeneral estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    public EstadoLogico getEstadoLogico() {
        return estadoLogico;
    }

    public void setEstadoLogico(EstadoLogico estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }
    
    public String getFechaExpiracionCodigo() {
        return fechaExpiracionCodigo;
    }

    public void setFechaExpiracionCodigo(String fechaExpiracionCodigo) {
        this.fechaExpiracionCodigo = fechaExpiracionCodigo;
    }
}
