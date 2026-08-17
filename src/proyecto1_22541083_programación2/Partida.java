/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public final class Partida {
    
    private int numero;
    private jugador ganador ;
    private jugador perdedor;
    private boolean isretired;
    
    
    public Partida( jugador ganador,jugador perdedor,boolean isretired){
        this.numero = Globales.Partidas.size()+1;
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.isretired = isretired;
        
        ganador.Sumarpuntos();
    }

    public final int getNumero() {
        return numero;
    }

    public final String getGanador() {
        
        return ganador.getUser();
    }

    public final String getPerdedor() {
        return perdedor.getUser();
    }

    public final String isIsretired() {
        if (isretired){
            return "Retiro";
        }
        
        return "Completo";
    }
    
    
           
            
            
    
}
