/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.dao.HistoriaDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.HistoriaClinicaDTO;
import pe.edu.pucp.softcit.model.UsuarioDTO;
import pe.edu.pucp.softcit.model.UsuarioPorEspecialidadDTO;

/**
 *
 * @author salva
 */
public class HistoriaDAOImpl extends DAOImplBase implements HistoriaDAO {
    
    private HistoriaClinicaDTO historia;

    public HistoriaDAOImpl(){
        super("historia_clinica");
        this.historia = null;
        
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_historia", true, false));
        this.listaColumnas.add(new Columna("id_paciente", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));

    }
    

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.historia.getIdHistoriaClinica());
        this.statement.setInt(2, this.historia.getPaciente().getIdUsuario());
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());

    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.historia = new HistoriaClinicaDTO();
        
        this.historia.setIdHistoriaClinica(this.resultSet.getInt("id_historia"));

        Integer id_usuario = this.resultSet.getInt("id_paciente");
        UsuarioDAO usuarioDao = new UsuarioDAOImpl();
        UsuarioDTO usuario = usuarioDao.obtenerPorId(id_usuario);
         
        
        this.historia.setPaciente(usuario);
        
        this.historia.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13

    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.historia.getIdHistoriaClinica());
        
    }
    

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.historia = null;

    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.historia);
    }


    @Override
    public ArrayList<HistoriaClinicaDTO> listar() {
        return (ArrayList<HistoriaClinicaDTO>) super.listarTodos();
        
    }

    @Override
    public Integer insertar(HistoriaClinicaDTO historia) {
        this.historia = historia;
        return super.insertar();
    }

    @Override
    public HistoriaClinicaDTO obtenerPorIdPaciente(Integer id) {
        limpiarObjetoDelResultSet();
    try {
        this.abrirConexion();

        String sql = "SELECT * FROM historia_clinica WHERE id_paciente = ?";
        this.colocarSQLenStatement(sql);
        this.statement.setInt(1, id);

        this.ejecutarConsultaEnBD();
        if (this.resultSet.next()) {
            this.instanciarObjetoDelResultSet();
        }
    } catch (SQLException ex) {
        System.err.println("Error al obtener historia clínica por id_paciente - " + ex);
    } finally {
        try {
            this.cerrarConexion();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar la conexión - " + ex);
        }
    }
    return historia;
    }

    @Override
    public HistoriaClinicaDTO obtenerPorId(Integer id) {
        this.historia = new HistoriaClinicaDTO();
        this.historia.setIdHistoriaClinica(id);
        super.obtenerPorId();
        return this.historia;
    }
    
}
