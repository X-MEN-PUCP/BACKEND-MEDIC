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
import pe.edu.pucp.softcit.dao.ExamenPorCitaDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.db.DBManager;
import pe.edu.pucp.softcit.model.CitaDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.ExamenDTO;
import pe.edu.pucp.softcit.model.ExamenPorCita;

/**
 *
 * @author Cesar
 */
public class ExamenPorCitaDAOImpl extends DAOImplBase implements ExamenPorCitaDAO {

    private ExamenPorCita examenPorCita;
    private final CargaTablas cargaTablas;

    public ExamenPorCitaDAOImpl() {
        super("examen_por_cita");
        this.retornarLlavePrimaria = true;
        this.examenPorCita = null;
        this.cargaTablas = new CargaTablas();
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_examen", true, false));
        this.listaColumnas.add(new Columna("id_cita", true, false));
        this.listaColumnas.add(new Columna("observacion", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, new ExamenDTO(this.examenPorCita.getExamen()).getIdExamen());
        this.statement.setInt(2, new CitaDTO(this.examenPorCita.getCita()).getIdCita());
        this.statement.setString(3, this.examenPorCita.getObservaciones());
        this.statement.setInt(4, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(5, this.examenPorCita.getUsuarioCreacion());
        this.statement.setDate(6, Date.valueOf(this.examenPorCita.getFechaCreacion()));
        this.statement.setNull(7, Types.INTEGER);
        this.statement.setNull(8, Types.DATE);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.examenPorCita = this.cargaTablas.cargarExamenPorCita(resultSet);
        this.examenPorCita.setExamen(this.cargaTablas.cargarExamen(resultSet));
        this.examenPorCita.setCita(this.cargaTablas.cargarCita(resultSet));
        this.examenPorCita.getCita().setMedico(this.cargaTablas.cargarUsuario(resultSet));
        this.examenPorCita.getCita().setTurno(this.cargaTablas.cargarTurno(resultSet));
        this.examenPorCita.getCita().setConsultorio(this.cargaTablas.cargarConsultorio(resultSet));
        this.examenPorCita.getCita().setEspecialidad(this.cargaTablas.cargarEspecialidad(resultSet));
        
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.examenPorCita = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.examenPorCita);
    }

    @Override
    public Integer insertar(ExamenPorCita examenPorCita) {
        this.examenPorCita = examenPorCita;
        return super.insertar();
    }

    @Override
    public ArrayList<ExamenPorCita> listarTodos() {
        return (ArrayList<ExamenPorCita>) this.listarExamenesPorCitaCompleto(null, null);
    }

    @Override
    public ArrayList<ExamenPorCita> listarPorIdCita(Integer idCita) {
        return this.listarExamenesPorCitaCompleto(null, idCita);
    }

    private ArrayList<ExamenPorCita> listarExamenesPorCitaCompleto(Integer idExamen, Integer idCita) {
        ArrayList<ExamenPorCita> lista = new ArrayList<>();

        try {
            String sql = "{CALL universidad.sp_listar_examenes_por_cita_completo(?, ?)}";

            this.abrirConexion();
            this.colocarSQLenStatement(sql);

            setParametrosFiltroExamenPorCita(idExamen, idCita);

            this.ejecutarConsultaEnBD();

            while (this.resultSet.next()) {
                this.agregarObjetoALaLista(lista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamenPorCitaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    private void setParametrosFiltroExamenPorCita(Integer idExamen, Integer idCita) throws SQLException {
        if (idExamen != null) {
            this.statement.setInt(1, idExamen);
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
