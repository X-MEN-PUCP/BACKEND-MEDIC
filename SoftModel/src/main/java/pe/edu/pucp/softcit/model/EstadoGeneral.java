/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softcit.model;

/**
 *
 * @author salva
 */
public enum EstadoGeneral {
    INACTIVO(0),
    ACTIVO(1),
    PENDIENTE_VERIFICACION(2);

    private final int codigo;

    private EstadoGeneral(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static EstadoGeneral valueOfCodigo(int codigo) {
        for (EstadoGeneral estado : values()) {
            if (estado.getCodigo() == codigo) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código de estado general inválido: " + codigo);
    }
}
