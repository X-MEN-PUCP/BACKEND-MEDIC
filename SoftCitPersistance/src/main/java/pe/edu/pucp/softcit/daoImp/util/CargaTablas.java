/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.ConsultorioDTO;
import pe.edu.pucp.softcit.model.DiagnosticoDTO;
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
public class CargaTablas {

    public UsuarioDTO cargarUsuario(ResultSet rs) throws SQLException {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdUsuario(rs.getInt("id_usuario_usuario"));
        usuario.setTipoDocumento(TipoDocumento.valueOf(rs.getString("tipo_documento_usuario")));
        usuario.setNumDocumento(rs.getString("nro_documento_usuario"));
        usuario.setContrasenha(rs.getString("contrasenha_usuario"));
        usuario.setNombres(rs.getString("nombre_usuario"));
        usuario.setApellidoPaterno(rs.getString("apellido_paterno_usuario"));
        usuario.setApellidoMaterno(rs.getString("apellido_materno_usuario"));
        usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento_usuario").toString());
        usuario.setCorreoElectronico(rs.getString("correo_electronico_usuario"));
        usuario.setNumCelular(rs.getString("num_celular_usuario"));
        usuario.setCodMedico(rs.getString("cod_medico_usuario"));
        usuario.setGenero(Genero.valueOf(rs.getString("genero_usuario")));
        usuario.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_general_usuario")));
        usuario.setEstadoLogico(EstadoLogico.valueOfCodigo(rs.getInt("estado_logico_usuario")));
        usuario.setUsuarioCreacion(rs.getInt("usuario_creacion_usuario"));
        usuario.setFechaCreacion(rs.getDate("fecha_creacion_usuario").toString());
        usuario.setUsuarioModificacion(rs.getInt("usuario_modificacion_usuario"));
        if (rs.getDate("fecha_modificacion_usuario") != null) {
            usuario.setFechaModificacion(rs.getDate("fecha_modificacion_usuario").toString());
        }

        return usuario;
    }

    public CitaDTO cargarCita(ResultSet rs) throws SQLException {
        CitaDTO cita = new CitaDTO();
        cita.setIdCita(rs.getInt("id_cita_cita"));
        cita.setHoraInicio(rs.getTime("hora_inicio_cita").toString());
        cita.setHoraFin(rs.getTime("hora_fin_cita").toString());
        cita.setFechaCita(rs.getDate("fecha_cita_cita").toString());
        cita.setEstado(EstadoCita.valueOfCodigo(rs.getInt("estado_cita_cita")));
        cita.setUsuarioCreacion(rs.getInt("usuario_creacion_cita"));
        cita.setFechaCreacion(rs.getDate("fecha_creacion_cita").toString());
        cita.setUsuarioModificacion(rs.getInt("usuario_modificacion_cita"));
        if (rs.getDate("fecha_modificacion_cita") != null) {
            cita.setFechaModificacion(rs.getDate("fecha_modificacion_cita").toString());
        }

        return cita;
    }

    public EspecialidadDTO cargarEspecialidad(ResultSet rs) throws SQLException {
        EspecialidadDTO especialidad = new EspecialidadDTO();
        especialidad.setIdEspecialidad(rs.getInt("id_especialidad_especialidad"));
        especialidad.setNombreEspecialidad(rs.getString("nombre_especialidad_especialidad"));
        especialidad.setPrecioConsulta(rs.getDouble("precio_consulta_especialidad"));
        especialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_especialidad")));
        especialidad.setUsuarioCreacion(rs.getInt("usuario_creacion_especialidad"));
        especialidad.setFechaCreacion(rs.getDate("fecha_creacion_especialidad").toString());
        especialidad.setUsuarioModificacion(rs.getInt("usuario_modificacion_especialidad"));
        if (rs.getDate("fecha_modificacion_especialidad") != null) {
            especialidad.setFechaModificacion(rs.getDate("fecha_modificacion_especialidad").toString());
        }

        return especialidad;
    }

    public TurnoDTO cargarTurno(ResultSet rs) throws SQLException {
        TurnoDTO turno = new TurnoDTO();
        turno.setIdTurno(rs.getInt("id_turno_turno"));
        turno.setNombreTurno(rs.getString("nombre_turno_turno"));
        turno.setHoraInicio(rs.getTime("hora_inicio_turno").toString());
        turno.setHoraFin(rs.getTime("hora_fin_turno").toString());
        turno.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_general_turno")));
        turno.setUsuarioCreacion(rs.getInt("usuario_creacion_turno"));
        turno.setFechaCreacion(rs.getDate("fecha_creacion_turno").toString());
        turno.setUsuarioModificacion(rs.getInt("usuario_modificacion_turno"));
        if (rs.getDate("fecha_modificacion_turno") != null) {
            turno.setFechaModificacion(rs.getDate("fecha_modificacion_turno").toString());
        }

        return turno;
    }

    public ConsultorioDTO cargarConsultorio(ResultSet rs) throws SQLException {
        ConsultorioDTO consultorio = new ConsultorioDTO();
        consultorio.setIdConsultorio(rs.getInt("id_consultorio_consultorio"));
        consultorio.setNumConsultorio(rs.getInt("numero_consultorio_consultorio"));
        consultorio.setNumPiso(rs.getInt("piso_consultorio"));
        consultorio.setEstadoGeneral(EstadoGeneral.valueOfCodigo(rs.getInt("estado_consultorio")));
        consultorio.setUsuarioCreacion(rs.getInt("usuario_creacion_consultorio"));
        consultorio.setFechaCreacion(rs.getDate("fecha_creacion_consultorio").toString());
        consultorio.setUsuarioModificacion(rs.getInt("usuario_modificacion_consultorio"));
        if (rs.getDate("fecha_modificacion_consultorio") != null) {
            consultorio.setFechaModificacion(rs.getDate("fecha_modificacion_consultorio").toString());
        }

        return consultorio;
    }

    public DiagnosticoDTO cargarDiagnostico(ResultSet rs) throws SQLException {
        DiagnosticoDTO diagnostico = new DiagnosticoDTO();
        diagnostico.setIdDiagnostico(rs.getInt("id_diagnostico_diagnostico"));
        diagnostico.setNombreDiagnostico(rs.getString("nombre_diagnostico_diagnostico"));
        diagnostico.setDescripcion(rs.getString("descripcion_diagnostico"));
        diagnostico.setCapitulo(rs.getString("capitulo_diagnostico"));
        diagnostico.setGrupo(rs.getString("grupo_diagnostico"));
        diagnostico.setNivel(rs.getInt("nivel_diagnostico"));
        
        return diagnostico;
    }
    
    

}
