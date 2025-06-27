/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

import java.sql.SQLException;
import pe.edu.pucp.softcit.dao.ConsultorioDAO;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.dao.TurnoDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.ConsultorioDAOImpl;
import pe.edu.pucp.softcit.daoImp.DAOImplBase;
import pe.edu.pucp.softcit.daoImp.EspecialidadDAOImpl;
import pe.edu.pucp.softcit.daoImp.TurnoDAOImpl;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.ConsultorioDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoCita;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.EstadoLogico;
import pe.edu.pucp.softcit.model.Genero;
import pe.edu.pucp.softcit.model.TipoDocumento;
import pe.edu.pucp.softcit.model.TurnoDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/**
 *
 * @author salva
 */
public class NuevoBuscarCitasBorrador extends DAOImplBase{
    
    private CitaDTO cita;
    private UsuarioDTO usuario;
    private EspecialidadDTO especialidad;
    private ConsultorioDTO consultorio;
    private TurnoDTO turno;

    public NuevoBuscarCitasBorrador(String nombre_tabla) {
        super("");
    }
    
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cita = new CitaDTO();
        this.cita.setIdCita(this.resultSet.getInt("id_cita"));

        //cargar Medico        
        this.usuario = new UsuarioDTO();
        this.usuario.setIdUsuario(this.resultSet.getInt("id_medico"));//1
        this.usuario.setTipoDocumento(TipoDocumento.valueOf(this.resultSet.getString("tipo_documento")));//2
        this.usuario.setNumDocumento(this.resultSet.getString("nro_documento"));//3
        this.usuario.setContrasenha(this.resultSet.getString("contrasenha"));//4
        this.usuario.setNombres(this.resultSet.getString("nombre"));//5
        this.usuario.setApellidoPaterno(this.resultSet.getString("apellido_paterno"));//6
        this.usuario.setApellidoMaterno(this.resultSet.getString("apellido_materno"));//7

        java.sql.Date fechaSQL = this.resultSet.getDate("fecha_nacimiento");//8
        this.usuario.setFechaNacimiento(fechaSQL.toString());

        this.usuario.setCorreoElectronico(this.resultSet.getString("correo_electronico")); //9
        this.usuario.setNumCelular(this.resultSet.getString("num_celular"));//10
        this.usuario.setCodMedico(this.resultSet.getString("cod_medico")); //11

        this.usuario.setGenero(Genero.valueOf(this.resultSet.getString("genero"))); //12

        this.usuario.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado_general"))); //13
        this.usuario.setEstadoLogico(EstadoLogico.valueOfCodigo(this.resultSet.getInt("estado_logico"))); //14
        this.usuario.setUsuarioCreacion(this.resultSet.getInt("usuario_creacion"));
        this.usuario.setFechaCreacion(this.resultSet.getDate("fecha_creacion").toString());
        this.usuario.setUsuarioModificacion(this.resultSet.getInt("usuario_modificacion"));
        if(this.resultSet.getDate("fecha_modificacion") != null) 
            this.usuario.setFechaModificacion(this.resultSet.getDate("fecha_modificacion").toString());
        
        this.cita.setMedico(usuario);

        //cargar Especialidad
        
        
        this.especialidad = new EspecialidadDTO();
        
        this.especialidad.setIdEspecialidad(this.resultSet.getInt("id_especialidad"));
        this.especialidad.setNombreEspecialidad(this.resultSet.getString("nombre_especialidad"));
        this.especialidad.setPrecioConsulta(this.resultSet.getDouble("precio_consulta"));
        this.especialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13
        this.especialidad.setUsuarioCreacion(this.resultSet.getInt("usuario_creación"));
        this.especialidad.setFechaCreacion(this.resultSet.getDate("fecha_creacion").toString());
        this.especialidad.setUsuarioModificacion(this.resultSet.getInt("usuario_modificación"));
        if(this.resultSet.getDate("fecha_modificacion") != null) 
            this.especialidad.setFechaModificacion(this.resultSet.getDate("fecha_modificacion").toString());
        this.cita.setEspecialidad(especialidad);

        //cargar turno
        this.turno=new TurnoDTO();
        this.turno.setIdTurno(this.resultSet.getInt("id_turno"));
        this.turno.setNombreTurno(this.resultSet.getString("nombre_turno"));
        
        java.sql.Time horain = this.resultSet.getTime("hora_inicio");
        this.turno.setHoraInicio(horain.toString());

        java.sql.Time horafi = this.resultSet.getTime("hora_fin");
        this.turno.setHoraFin(horafi.toString());
        
        
        this.turno.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado_general")));
        this.turno.setUsuarioCreacion(this.resultSet.getInt("usuario_creación"));
        this.turno.setFechaCreacion(this.resultSet.getDate("fecha_creacion").toString());
        this.turno.setUsuarioModificacion(this.resultSet.getInt("usuario_modificación"));
        if(this.resultSet.getDate("fecha_modificacion") != null) 
            this.turno.setFechaModificacion(this.resultSet.getDate("fecha_modificacion").toString());
        this.cita.setTurno(turno);

        //cargar Consultorio
        this.consultorio = new ConsultorioDTO();
        this.consultorio.setIdConsultorio(this.resultSet.getInt("id_consultorio"));
        this.consultorio.setNumConsultorio(this.resultSet.getInt("numero_consultorio"));
        this.consultorio.setNumPiso(this.resultSet.getInt("piso"));
        this.consultorio.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13
        this.consultorio.setUsuarioCreacion(this.resultSet.getInt("usuario_creación"));
        this.consultorio.setFechaCreacion(this.resultSet.getDate("fecha_creacion").toString());
        this.consultorio.setUsuarioModificacion(this.resultSet.getInt("usuario_modificación"));
        if(this.resultSet.getDate("fecha_modificacion") != null) 
            this.consultorio.setFechaModificacion(this.resultSet.getDate("fecha_modificacion").toString());

        //Cita
        java.sql.Time horaini = this.resultSet.getTime("hora_inicio");
        this.cita.setHoraInicio(horaini.toString());

        java.sql.Time horafin = this.resultSet.getTime("hora_fin");
        this.cita.setHoraFin(horafin.toString());

        java.sql.Date fechaSql = resultSet.getDate("fecha_cita");
        this.cita.setFechaCita(fechaSql.toString());

        Integer idEstado = this.resultSet.getInt("estado_cita");
        EstadoCita estado = EstadoCita.valueOfCodigo(idEstado);
        this.cita.setEstado(estado);
        this.cita.setUsuarioCreacion(this.resultSet.getInt("usuario_creación"));
        this.cita.setFechaCreacion(this.resultSet.getDate("fecha_creacion").toString());
        this.cita.setUsuarioModificacion(this.resultSet.getInt("usuario_modificación"));
        if(this.resultSet.getDate("fecha_modificacion") != null) 
            this.cita.setFechaModificacion(this.resultSet.getDate("fecha_modificacion").toString());
    }

    @Override
    protected void configurarListaDeColumnas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
