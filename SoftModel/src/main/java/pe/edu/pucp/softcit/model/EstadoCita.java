/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

import java.util.Objects;

/**
 *
 * @author Mcerv
 */
public enum EstadoCita {
    RESERVADO(0), DISPONIBLE(1), PAGADO(2);
    
    private Integer codigo;

    private EstadoCita(Integer codigo){
        this.codigo = codigo;
    }
    
    public Integer getCodigo(){
        return this.codigo;
    }
    
    public static EstadoCita valueOfCodigo(Integer codigo){
        for(EstadoCita estado:values()){
            if(Objects.equals(estado.getCodigo(), codigo))
                return estado;
        }
        throw new IllegalArgumentException("Código de estado inválido: " + codigo);
    }
}
