/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import pe.edu.pucp.softcit.dao.TurnoDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.EstadoGeneral;
import pe.edu.pucp.softcit.model.TurnoDTO;

/**
 *
 * @author Cesar
 */
public class TurnoDAOImpl extends DAOImplBase implements TurnoDAO{

    private TurnoDTO turno;
    
    public TurnoDAOImpl(){
        super("turno");
        this.retornarLlavePrimaria = true;
        this.turno = null;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_turno",true,true));
        this.listaColumnas.add(new Columna("nombre_turno",false,false));
        this.listaColumnas.add(new Columna("hora_inicio",false,false));
        this.listaColumnas.add(new Columna("hora_fin",false,false));
        this.listaColumnas.add(new Columna("estado_general", false, false));
        this.listaColumnas.add(new Columna("usuario_creación", false, false));//not null
        this.listaColumnas.add(new Columna("fecha_creacion", false, false));//not null
        this.listaColumnas.add(new Columna("usuario_modificación", false, false));
        this.listaColumnas.add(new Columna("fecha_modificacion", false, false));
    }    

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.turno.getNombreTurno());
        this.statement.setTime(2, Time.valueOf(this.turno.getHoraInicio()));
        this.statement.setTime(3, Time.valueOf(this.turno.getHoraFin()));
        this.statement.setInt(4, this.turno.getEstadoGeneral().getCodigo());
        this.statement.setInt(5, this.turno.getUsuarioCreacion());
        this.statement.setDate(6, Date.valueOf(this.turno.getFechaCreacion()));
        this.statement.setInt(7, this.turno.getUsuarioModificacion());
        this.statement.setDate(8, Date.valueOf(this.turno.getFechaModificacion()));
        this.statement.setInt(9, this.turno.getIdTurno());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.turno.getIdTurno());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
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
    }

    @Override
    public Integer modificar(TurnoDTO turno) {
        this.turno=turno;
        return super.modificar();
    }

    @Override
    public TurnoDTO obtenerPorId(Integer idTurno) {
        this.turno=new TurnoDTO();
        this.turno.setIdTurno(idTurno);
        super.obtenerPorId();
        return this.turno;
    }
    
    @Override
    public ArrayList<TurnoDTO> listarTodos() {
        return (ArrayList<TurnoDTO>) super.listarTodos(); 
    }
    
}
