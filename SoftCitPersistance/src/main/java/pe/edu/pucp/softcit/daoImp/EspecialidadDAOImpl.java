/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softcit.dao.EspecialidadDAO;
import pe.edu.pucp.softcit.daoImp.util.Columna;
import pe.edu.pucp.softcit.model.EspecialidadDTO;
import pe.edu.pucp.softcit.model.EstadoGeneral;

/**
 *
 * @author salva
 */
public class EspecialidadDAOImpl extends DAOImplBase implements EspecialidadDAO {

    private EspecialidadDTO especialidad;

    public EspecialidadDAOImpl() {
        super("especialidad");
        this.retornarLlavePrimaria = true;
        this.especialidad = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_especialidad", true, false));
        this.listaColumnas.add(new Columna("nombre_especialidad", false, false));
        this.listaColumnas.add(new Columna("precio_consulta", false, false));
        this.listaColumnas.add(new Columna("estado", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.especialidad.getNombreEspecialidad());
        if (this.especialidad.getPrecioConsulta() != null) {
            this.statement.setDouble(2, this.especialidad.getPrecioConsulta());
        } else {
            throw new IllegalArgumentException("precioConsulta no puede ser null porque la BD no lo permite");
        }
        this.statement.setInt(3, EstadoGeneral.ACTIVO.getCodigo());

    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        
        this.statement.setString(1, this.especialidad.getNombreEspecialidad());
        if (this.especialidad.getPrecioConsulta() != null) {
            this.statement.setDouble(2, this.especialidad.getPrecioConsulta());
        } else {
            throw new IllegalArgumentException("precioConsulta no puede ser null porque la BD no lo permite");
        }
        this.statement.setInt(3, this.especialidad.getEstadoGeneral().getCodigo());
        this.statement.setInt(4, this.especialidad.getIdEspecialidad());

    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.especialidad.getIdEspecialidad());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.especialidad.getIdEspecialidad());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.especialidad = new EspecialidadDTO();
        this.especialidad.setIdEspecialidad(this.resultSet.getInt("id_especialidad"));
        this.especialidad.setNombreEspecialidad(this.resultSet.getString("nombre_especialidad"));
        this.especialidad.setPrecioConsulta(this.resultSet.getDouble("precio_consulta"));
        this.especialidad.setEstadoGeneral(EstadoGeneral.valueOfCodigo(this.resultSet.getInt("estado"))); //13
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.especialidad = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.especialidad);
    }

    @Override
    public Integer insertar(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
        return super.modificar();
    }
    
    @Override
    public ArrayList<EspecialidadDTO> listar() {
        return (ArrayList<EspecialidadDTO>) super.listarTodos();
    }

    

    

    @Override
    public Integer cambiarEstadoEspecialidad(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
        return super.modificar();
    }

    @Override
    public EspecialidadDTO obtenerPorId(Integer id) {
        this.especialidad = new EspecialidadDTO();
        this.especialidad.setIdEspecialidad(id);
        super.obtenerPorId();
        return this.especialidad;
    }

}
