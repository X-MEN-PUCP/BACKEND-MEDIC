
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softcit.model.UsuarioDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author salva
 */
public class TestUsuario {

    @Test
    @Disabled
    public void modificarUsuario() {
        UsuarioDTO usuario = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAOImpl();
        usuario = dao.obtenerPorId(1);
        System.out.println("tipo_documento: " + usuario.getTipoDocumento());
        System.out.println("nro_documento: " + usuario.getNumDocumento());
        System.out.println("contrasenha: " + usuario.getContrasenha());
        System.out.println("nombres: " + usuario.getNombres());
        System.out.println("apellido_paterno: " + usuario.getApellidoPaterno());
        System.out.println("apellido_materno: " + usuario.getApellidoMaterno());
        System.out.println("fecha_nacimiento: " + usuario.getFechaNacimiento());
        System.out.println("correo_electronico: " + usuario.getCorreoElectronico());
        System.out.println("num_celular: " + usuario.getNumCelular());
        System.out.println("cod_medico: " + usuario.getCodMedico());
        System.out.println("genero: " + usuario.getGenero());
        System.out.println("estado_general: " + usuario.getEstadoGeneral());
        System.out.println("estado_logico: " + usuario.getEstadoLogico());
        System.out.println("usuario_creacion: " + usuario.getUsuarioCreacion());
        System.out.println("fecha_creacion: " + usuario.getFechaCreacion());
        System.out.println("usuario_modificacion: " + usuario.getUsuarioModificacion());
        System.out.println("fecha_modificacion: " + usuario.getFechaModificacion());
        System.out.println("codigo_verificacion: " + usuario.getCodigoVerificacion());
        System.out.println("fecha_expiracion_codigo: " + usuario.getFechaExpiracionCodigo());
        System.out.println("id_usuario: " + usuario.getIdUsuario());
        usuario.setNombres("Altair");
        dao.modificar(usuario);
    }

}
