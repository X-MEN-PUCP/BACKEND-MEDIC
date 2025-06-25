/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.db.util.Cifrado;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.EstadoLogico;
import pe.edu.pucp.softcit.model.Genero;
import pe.edu.pucp.softcit.model.TipoDocumento;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorRolDTO;

/**
 *
 * @author salva
 */
public class UsuarioDAOImpl extends DAOImplBase implements UsuarioDAO {

    private UsuarioDTO usuario;

    public UsuarioDAOImpl() {
        super("usuario");
        this.retornarLlavePrimaria = true;
        this.usuario = null;
    }

    @Override
    protected void configurarListaDeColumnas() {

        this.listaColumnas.add(new Columna("id_usuario", true, true));
        this.listaColumnas.add(new Columna("tipo_documento", false, false));
        this.listaColumnas.add(new Columna("nro_documento", false, false));
        this.listaColumnas.add(new Columna("contrasenha", false, false));
        this.listaColumnas.add(new Columna("nombre", false, false));
        this.listaColumnas.add(new Columna("apellido_paterno", false, false));
        this.listaColumnas.add(new Columna("apellido_materno", false, false));
        this.listaColumnas.add(new Columna("fecha_nacimiento", false, false));
        this.listaColumnas.add(new Columna("correo_electronico", false, false));
        this.listaColumnas.add(new Columna("num_celular", false, false));
        this.listaColumnas.add(new Columna("cod_medico", false, false));
        this.listaColumnas.add(new Columna("genero", false, false));
        this.listaColumnas.add(new Columna("estado_general", false, false));
        this.listaColumnas.add(new Columna("estado_logico", false, false));
        this.listaColumnas.add(new Columna("usuario_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificacion", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));

    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.usuario.getTipoDocumento().toString());
        this.statement.setString(2, this.usuario.getNumDocumento());
        this.statement.setString(3, this.usuario.getContrasenha());
        this.statement.setString(4, this.usuario.getNombres());
        this.statement.setString(5, this.usuario.getApellidoPaterno());
        this.statement.setString(6, this.usuario.getApellidoMaterno());
        this.statement.setDate(7, Date.valueOf(this.usuario.getFechaNacimiento()));

        if (usuario.getCorreoElectronico() != null) {
            statement.setString(8, usuario.getCorreoElectronico());
        } else {
            statement.setNull(8, java.sql.Types.VARCHAR);
        }

        if (usuario.getNumCelular() != null) {
            statement.setString(9, usuario.getNumCelular());
        } else {
            statement.setNull(9, java.sql.Types.VARCHAR);
        }

        if (usuario.getCodMedico() != null) {
            statement.setString(10, usuario.getCodMedico());
        } else {
            statement.setNull(10, java.sql.Types.VARCHAR);
        }

        this.statement.setString(11, this.usuario.getGenero().toString());
        this.statement.setInt(12, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(13, EstadoLogico.DISPONIBLE.getCodigo());
        this.statement.setInt(14, this.usuario.getUsuarioCreacion());
        this.statement.setDate(15, Date.valueOf(this.usuario.getFechaCreacion()));
        this.statement.setNull(16, Types.INTEGER);
        this.statement.setNull(17, Types.DATE);
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.usuario.getTipoDocumento().toString());
        this.statement.setString(2, this.usuario.getNumDocumento());
        this.statement.setString(3, this.usuario.getContrasenha());
        this.statement.setString(4, this.usuario.getNombres());
        this.statement.setString(5, this.usuario.getApellidoPaterno());
        this.statement.setString(6, this.usuario.getApellidoMaterno());
        this.statement.setDate(7, Date.valueOf(this.usuario.getFechaNacimiento()));

        if (usuario.getCorreoElectronico() != null) {
            statement.setString(8, usuario.getCorreoElectronico());
        } else {
            statement.setNull(8, java.sql.Types.VARCHAR);
        }

        if (usuario.getNumCelular() != null) {
            statement.setString(9, usuario.getNumCelular());
        } else {
            statement.setNull(9, java.sql.Types.VARCHAR);
        }

        if (usuario.getCodMedico() != null) {
            statement.setString(10, usuario.getCodMedico());
        } else {
            statement.setNull(10, java.sql.Types.VARCHAR);
        }

        this.statement.setString(11, this.usuario.getGenero().toString());

        this.statement.setInt(12, this.usuario.getEstadoGeneral().getCodigo());
        this.statement.setInt(13, this.usuario.getEstadoLogico().getCodigo());
        this.statement.setInt(14, this.usuario.getUsuarioCreacion());
        this.statement.setDate(15, Date.valueOf(this.usuario.getFechaCreacion()));
        this.statement.setInt(16, this.usuario.getUsuarioModificacion());
        this.statement.setDate(17, Date.valueOf(this.usuario.getFechaModificacion()));
        this.statement.setInt(18, this.usuario.getIdUsuario());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.usuario.getIdUsuario());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.usuario.getIdUsuario());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.usuario = new UsuarioDTO();
        this.usuario.setIdUsuario(this.resultSet.getInt("id_usuario"));//1
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

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.usuario = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.usuario);
    }

    @Override
    public UsuarioDTO obtenerPorId(Integer id) {
        this.usuario = new UsuarioDTO();
        this.usuario.setIdUsuario(id);
        super.obtenerPorId();
        return this.usuario;
    }

    @Override
    public UsuarioDTO buscarCuenta(String nroDocumento, String tipoDoc, String contrasenha) {

        this.usuario = null; // Asegúrate de reiniciar el objeto

        try {
            this.abrirConexion();

            String sql = "SELECT * FROM usuario "
                    + "WHERE nro_documento = ? AND tipo_documento = ? AND contrasenha = ?";

            this.colocarSQLenStatement(sql);

            this.statement.setString(1, nroDocumento);
            this.statement.setString(2, tipoDoc);
            this.statement.setString(3, contrasenha);

            this.ejecutarConsultaEnBD();

            if (this.resultSet.next()) {
                this.instanciarObjetoDelResultSet();
            } else {
                this.limpiarObjetoDelResultSet();
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", ex);
            }
        }

        return this.usuario;
    }

    @Override
    public Integer cambiarEstadoGeneral(UsuarioDTO usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    public Integer cambiarEstadoLogico(UsuarioDTO usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    public Integer insertar(UsuarioDTO usuario) {
        this.usuario = usuario;
        String contra = usuario.getContrasenha();
        contra = Cifrado.cifrarMD5(contra);
        usuario.setContrasenha(contra);
        return super.insertar();
    }

    @Override
    public Integer modificar(UsuarioDTO usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    public UsuarioDTO completarRoles(UsuarioDTO usuario) {
        ArrayList<UsuarioPorRolDTO> lista = new RolesXUsuarioDAOImpl().listarPorUsuario(usuario.getIdUsuario());

        ArrayList<Integer> listaIds = new ArrayList<>();
        for (UsuarioPorRolDTO upr : lista) {
            listaIds.add(upr.getRol().getIdRol()); // Asegúrate de tener getIdRol() en UsuarioPorRolDTO
        }

        usuario.setRoles(listaIds);
        return usuario;
    }
    
    @Override
    public ArrayList<UsuarioDTO> listarTodos() {
        return (ArrayList<UsuarioDTO>) super.listarTodos();
    }
    
    @Override
    public ArrayList<UsuarioDTO> listarMedicos(){
        String sql = "{call SP_CIT_LISTAR_MEDICOS()}";
        Object parametros = null;
        Consumer incluirValorDeParametros = null;
        return (ArrayList<UsuarioDTO>) super.listarTodos(sql, incluirValorDeParametros, parametros);
    }
    
}
