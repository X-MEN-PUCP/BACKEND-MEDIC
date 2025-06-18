/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
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
public class InterconsultaDAOImpl extends DAOImplBase implements InterconsultaDAO{

    private InterconsultaDTO interconsulta;
    
    public InterconsultaDAOImpl() {
        super("interconsulta");
        this.retornarLlavePrimaria = true;
        this.interconsulta = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("id_interconsulta",true,false));
        this.listaColumnas.add(new Columna("id_cita",true,false));
        this.listaColumnas.add(new Columna("razon_interconsulta",false,false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1,new EspecialidadDTO(this.interconsulta.getEspecialidadInterconsulta()).getIdEspecialidad());
        this.statement.setInt(2,new CitaDTO(this.interconsulta.getCita()).getIdCita());
        this.statement.setString(3,this.interconsulta.getRazonInterconsulta());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1,new EspecialidadDTO(this.interconsulta.getEspecialidadInterconsulta()).getIdEspecialidad());
        this.statement.setInt(2,new CitaDTO(this.interconsulta.getCita()).getIdCita());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.interconsulta = new InterconsultaDTO();
        
        //Cargar Especialidad - Interconsulta
        Integer idEspecialidad = this.resultSet.getInt("id_especialidad");
        EspecialidadDAO especialidadDAO = new EspecialidadDAOImpl();
        EspecialidadDTO especialidad = especialidadDAO.obtenerPorId(idEspecialidad);
        this.interconsulta.setEspecialidadInterconsulta(especialidad);
        
        //Cargar Cita
        Integer idCita = this.resultSet.getInt("id_cita");
        CitaDAO citaDAO = new CitaDAOImpl();
        CitaDTO cita = citaDAO.obtenerPorId(idCita);
        this.interconsulta.setCita(cita);
        
        //Cargar razon
        this.interconsulta.setRazonInterconsulta(this.resultSet.getString("razon_interconsulta"));
    }
    
    @Override
    public Integer insertar(InterconsultaDTO interconsulta) {
       this.interconsulta=interconsulta;
       return super.insertar();
    }

    @Override
    public InterconsultaDTO obtenerPorId(Integer idEspecialidad, Integer idCita) {
        this.interconsulta = new InterconsultaDTO();
        
        CitaDTO cita = new CitaDTO();
        cita.setIdCita(idCita);
        
        EspecialidadDTO especialidad = new EspecialidadDTO();
        especialidad.setIdEspecialidad(idEspecialidad);
        
        this.interconsulta.setCita(cita);
        this.interconsulta.setEspecialidadInterconsulta(especialidad);
        
        return this.interconsulta;
    }
    
    @Override
    public ArrayList<InterconsultaDTO> listarTodos() {
        return (ArrayList<InterconsultaDTO>) super.listarTodos(); 
    }
}
