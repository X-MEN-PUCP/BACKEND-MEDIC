/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author salva
 */
public enum EstadoLogico {
    AUSENTE(0),
    DISPONIBLE(1),
    DE_VACACIONES(4),
    DE_BAJA(2),
    EN_CAPACITACION(3);
    

    private final int codigo;

    private EstadoLogico(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static EstadoLogico valueOfCodigo(int codigo) {
        for (EstadoLogico estado : values()) {
            if (estado.getCodigo() == codigo) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código de estado lógico inválido: " + codigo);
    }
}
