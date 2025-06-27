/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softcit.dao.ExamenDAO;
import pe.edu.pucp.softcit.dao.TipoExamenDAO;
import pe.edu.pucp.softcit.daoImp.util.CargaTablas;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.ExamenDTO;
import pe.edu.pucp.softcit.model.TipoExamenDTO;

/**
 *
 * @author Mcerv
 */
public class ExamenDAOImpl extends DAOImplBase implements ExamenDAO{
    private ExamenDTO examen;
    private final CargaTablas cargaTablas;
    public ExamenDAOImpl(){
        super("examen");
        this.retornarLlavePrimaria = true;
        this.examen = null;
        this.cargaTablas = new CargaTablas();
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_examen", true, true));
        this.listaColumnas.add(new Columna("nombre_examen", false, false));
        this.listaColumnas.add(new Columna("id_tipo_de_examen", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.examen.getNombreExamen());
        this.statement.setInt(2, this.examen.getTipoExamen().getIdTipoExamen());
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(4, this.examen.getUsuarioCreacion());
        this.statement.setDate(5, Date.valueOf(this.examen.getFechaCreacion()));
        this.statement.setNull(6, Types.INTEGER);
        this.statement.setNull(7, Types.DATE);
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.examen.getIdExamen());
    }
    
    

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.examen = null;
    }
    

    
    
    @Override
    public Integer insertar(ExamenDTO examen) {
        this.examen = examen;
        return super.insertar();
    }
    
    @Override
    public ExamenDTO obtenerPorId(Integer examenId) {
        ArrayList<ExamenDTO> lista = new ArrayList<>();

        lista = this.buscarExamenes(examenId, null);
        if (lista.size() > 0) {
            this.examen = new ExamenDTO();
            this.examen = lista.getFirst();
            return this.examen;
        }
        return null;
    }
    
    @Override
    public ArrayList<ExamenDTO> listarTodos() {
        return (ArrayList<ExamenDTO>) this.buscarExamenes(null, null);
    }
    
    private ArrayList<ExamenDTO> buscarExamenes(Integer idExamen, Integer idTipoDeExamen) {
        ArrayList<ExamenDTO> lista = new ArrayList<>();

        try {
            String sql = "{CALL universidad.sp_listar_examenes_completo(?, ?)}";
            this.abrirConexion();
            this.colocarSQLenStatement(sql);
            setParametrosFiltroExamen(idExamen, idTipoDeExamen);
            this.ejecutarConsultaEnBD();

            while (this.resultSet.next()) {
                this.agregarObjetoALaLista(lista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    protected void instanciarObjetoDelResultSetEficaz() throws SQLException {
        this.examen = this.cargaTablas.cargarExamen(this.resultSet);
        
    }

    private void agregarObjetoALaLista(ArrayList<ExamenDTO> lista) throws SQLException {
        instanciarObjetoDelResultSetEficaz();
        lista.add(this.examen);
    }

    private void setParametrosFiltroExamen(Integer idExamen, Integer idTipoDeExamen) throws SQLException {
        // Parámetro 1: idExamen
        if (idExamen != null) {
            this.statement.setInt(1, idExamen);
        } else {
            this.statement.setNull(1, Types.INTEGER);
        }

        // Parámetro 2: idTipoDeExamen
        if (idTipoDeExamen != null) {
            this.statement.setInt(2, idTipoDeExamen);
        } else {
            this.statement.setNull(2, Types.INTEGER);
        }
    }
    
}
