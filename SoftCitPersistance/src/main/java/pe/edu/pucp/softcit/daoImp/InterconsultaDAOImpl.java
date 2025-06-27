/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.CitaDAO;
import pe.edu.pucp.softcit.dao.InterconsultaDAO;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.InterconsultaDTO;

/**
 *
 * @author Cesar
 */
public class InterconsultaDAOImpl extends DAOImplBase implements InterconsultaDAO {

    private InterconsultaDTO interconsulta;

    public InterconsultaDAOImpl() {
        super("interconsulta");
        this.retornarLlavePrimaria = true;
        this.interconsulta = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_interconsulta", true, false));
        this.listaColumnas.add(new Columna("id_cita", true, false));
        this.listaColumnas.add(new Columna("razon_interconsulta", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, new EspecialidadDTO(this.interconsulta.getEspecialidadInterconsulta()).getIdEspecialidad());
        this.statement.setInt(2, new CitaDTO(this.interconsulta.getCita()).getIdCita());
        this.statement.setString(3, this.interconsulta.getRazonInterconsulta());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, new EspecialidadDTO(this.interconsulta.getEspecialidadInterconsulta()).getIdEspecialidad());
        this.statement.setInt(2, new CitaDTO(this.interconsulta.getCita()).getIdCita());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.interconsulta = new InterconsultaDTO();
        this.interconsulta.setEspecialidadInterconsulta(this.cargaTabla.cargarEspecialidadInterconsulta(resultSet));
        this.interconsulta.setCita(this.cargaTabla.cargarCita(resultSet));
        this.interconsulta.getCita().setMedico(this.cargaTabla.cargarUsuario(resultSet));
        this.interconsulta.getCita().setTurno(this.cargaTabla.cargarTurno(resultSet));
        this.interconsulta.getCita().setConsultorio(this.cargaTabla.cargarConsultorio(resultSet));
        this.interconsulta.getCita().setEspecialidad(this.cargaTabla.cargarEspecialidad(resultSet));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.interconsulta = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.interconsulta);
    }

    @Override
    public Integer insertar(InterconsultaDTO interconsulta) {
        this.interconsulta = interconsulta;
        return super.insertar();
    }

    @Override
    public InterconsultaDTO obtenerPorId(Integer idEspecialidad, Integer idCita) {
        ArrayList<InterconsultaDTO> lista = new ArrayList<>();

        lista = buscarInterconsultas(idEspecialidad, idCita);
        if (lista.size() > 0) {
            this.interconsulta = new InterconsultaDTO();
            this.interconsulta = lista.getFirst();
            return this.interconsulta;
        }
        return null;
    }

    @Override
    public ArrayList<InterconsultaDTO> listarTodos() {
        return (ArrayList<InterconsultaDTO>) this.buscarInterconsultas(null,null);
    }

    public ArrayList<InterconsultaDTO> buscarInterconsultas(Integer idEspecialidadInterconsulta, Integer idCita) {
        ArrayList<InterconsultaDTO> lista = new ArrayList<>();

        try {
            String sql = "{CALL universidad.sp_listar_interconsultas_completo(?, ?)}";

            this.abrirConexion();
            this.colocarSQLenStatement(sql);

            setParametrosFiltroInterconsulta(idEspecialidadInterconsulta, idCita);

            this.ejecutarConsultaEnBD();

            while (this.resultSet.next()) {
                this.agregarObjetoALaLista(lista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterconsultaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    private void setParametrosFiltroInterconsulta(Integer idEspecialidadInterconsulta, Integer idCita) throws SQLException {
        if (idEspecialidadInterconsulta != null) {
            this.statement.setInt(1, idEspecialidadInterconsulta);
        } else {
            this.statement.setNull(1, Types.INTEGER);
        }

        if (idCita != null) {
            this.statement.setInt(2, idCita);
        } else {
            this.statement.setNull(2, Types.INTEGER);
        }
    }

}
