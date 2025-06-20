/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.ConsultorioDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.ConsultorioDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;

/**
 *
 * @author Mcerv
 */
public class ConsultorioDAOImpl extends DAOImplBase implements ConsultorioDAO{
    private ConsultorioDTO consultorio;
    
    public ConsultorioDAOImpl(){
        super("consultorio");
        this.retornarLlavePrimaria = true;
        this.consultorio = null;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_consultorio", true, true));
        this.listaColumnas.add(new Columna("numero_consultorio", false, false));
        this.listaColumnas.add(new Columna("piso", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.consultorio.getNumConsultorio());
        this.statement.setInt(2, this.consultorio.getNumPiso());
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());
        this.statement.setInt(4, this.consultorio.getUsuarioCreacion());
        this.statement.setDate(5, Date.valueOf(this.consultorio.getFechaCreacion()));
        this.statement.setNull(6, Types.INTEGER);
        this.statement.setNull(7, Types.DATE);
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.consultorio.getNumConsultorio());
        this.statement.setInt(2, this.consultorio.getNumPiso());
        this.statement.setInt(3, this.consultorio.getEstadoGeneral().getCodigo());
        this.statement.setInt(4, this.consultorio.getUsuarioCreacion());
        this.statement.setDate(5, Date.valueOf(this.consultorio.getFechaCreacion()));
        this.statement.setInt(6, this.consultorio.getUsuarioModificacion());
        this.statement.setDate(7, Date.valueOf(this.consultorio.getFechaModificacion()));
        this.statement.setInt(8, this.consultorio.getIdConsultorio());
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.consultorio.getIdConsultorio());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
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
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.consultorio = null;
    }
    
    @Override
    public Integer insertar(ConsultorioDTO consultorio) {
        this.consultorio = consultorio;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(ConsultorioDTO consultorio) {
        this.consultorio = consultorio;
        return super.modificar();
    }
    
    @Override
    public ConsultorioDTO obtenerPorId(Integer consultorioId) {
        this.consultorio = new ConsultorioDTO();
        this.consultorio.setIdConsultorio(consultorioId);
        super.obtenerPorId();
        return this.consultorio;
    }
    
    @Override
    public ArrayList<ConsultorioDTO> listarTodos() {
        return (ArrayList<ConsultorioDTO>) super.listarTodos();
    }
}
