/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public final class TipoJugador {
    private int puntos;
    private String tipo;
    private int turnos;

    public static final TipoJugador  normal = new TipoJugador (3, "normal",1);
    public static final TipoJugador  participante = new TipoJugador (1, "participante", 2);

    public TipoJugador (int puntos, String tipo, int turnos) {
        this.puntos = puntos;
        this.tipo = tipo;
        this.turnos = turnos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getTipo() {
        return tipo;
    }
    

    public int getTurnosIniciales() {
        return turnos;
    }
    
    
    

    
}
