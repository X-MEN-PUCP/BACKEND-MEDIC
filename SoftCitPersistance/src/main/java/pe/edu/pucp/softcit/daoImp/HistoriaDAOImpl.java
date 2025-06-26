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
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.dao.HistoriaDAO;
import pe.edu.pucp.softcit.dao.UsuarioDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
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
    private final CargaTablas cargaTablas;

    public HistoriaDAOImpl() {
        super("historia_clinica");
        this.historia = null;
        this.cargaTablas = new CargaTablas();
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_historia", true, true));
        this.listaColumnas.add(new Columna("id_paciente", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {

        this.statement.setInt(1, this.historia.getPaciente().getIdUsuario());
        this.statement.setInt(2, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(3, this.historia.getUsuarioCreacion());
        this.statement.setDate(4, Date.valueOf(this.historia.getFechaCreacion()));
        this.statement.setNull(5, Types.INTEGER);
        this.statement.setNull(6, Types.DATE);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.historia = this.cargaTablas.cargarHistoriaClinica(this.resultSet);
        this.historia.setPaciente(this.cargaTablas.cargarUsuario(this.resultSet));
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
        return (ArrayList<HistoriaClinicaDTO>) this.listarHistoriasClinicas(null, null);

    }

    @Override
    public Integer insertar(HistoriaClinicaDTO historia) {
        this.historia = historia;
        return super.insertar();
    }

    @Override
    public HistoriaClinicaDTO obtenerPorIdPaciente(Integer id) {
        ArrayList<HistoriaClinicaDTO> lista = new ArrayList<>();

        lista = listarHistoriasClinicas(null, id);
        if (lista.size() > 0) {
            this.historia = new HistoriaClinicaDTO();
            this.historia = lista.getFirst();
            return this.historia;
        }
        return null;
        
    }

    @Override
    public HistoriaClinicaDTO obtenerPorId(Integer id) {
        ArrayList<HistoriaClinicaDTO> lista = new ArrayList<>();

        lista = listarHistoriasClinicas(id, null);
        if (lista.size() > 0) {
            this.historia = new HistoriaClinicaDTO();
            this.historia = lista.getFirst();
            return this.historia;
        }
        return null;
    }

    private ArrayList<HistoriaClinicaDTO> listarHistoriasClinicas(Integer idHistoria, Integer idPaciente) {
        ArrayList<HistoriaClinicaDTO> lista = new ArrayList<>();
        try {
            String sql = "{CALL universidad.sp_listar_historia_clinica(?, ?)}";
            this.abrirConexion();
            this.colocarSQLenStatement(sql);
            this.setParametrosFiltroHistoriaClinica(idHistoria, idPaciente);
            this.ejecutarConsultaEnBD();
            while (this.resultSet.next()) {
                this.agregarObjetoALaLista(lista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HistoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private void setParametrosFiltroHistoriaClinica(Integer idHistoria, Integer idPaciente) throws SQLException {
        // Parámetro 1: id_historia
        if (idHistoria != null) {
            this.statement.setInt(1, idHistoria);
        } else {
            this.statement.setNull(1, Types.INTEGER);
        }

        // Parámetro 2: id_paciente
        if (idPaciente != null) {
            this.statement.setInt(2, idPaciente);
        } else {
            this.statement.setNull(2, Types.INTEGER);
        }
    }

}
