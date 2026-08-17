/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import java.util.Calendar;
import java.util.Date;

public final class jugador {
    private String user;
    private char [] password;
    private int puntos;
    private boolean activo;
    private int Npartidas;
    private int Ngana;
    private int Npierde;
    private int retiros;
    private Calendar tiempo;
    private TipoJugador tipo;
   
    
    public jugador(String user,char [] password, int tipo ){
        this.user = user;
        this.password=password;
        this.tiempo= Calendar.getInstance();
        puntos = 0;
        activo = true;
        if (tipo == 1){
            this.tipo = TipoJugador.normal;
            
        } else if (tipo == 2){
            this.tipo = TipoJugador.participante;
            
        }
    }

    public String getUser() {
        return user;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int getPuntos() {
        return puntos;
    }

    public Date getTiempo() {
        
        return tiempo.getTime();
    }
    
    public void setactivo(boolean activo){
        this.activo = activo;
    }

    public TipoJugador getTipo() {
        return tipo;
    }

    public boolean isActivo() {
        return activo;
    }
    
    public String getfechaCreacion (){
        int dia = tiempo.get(Calendar.DAY_OF_MONTH);
        int mes = tiempo.get(Calendar.MONTH) + 1;
        int anio = tiempo.get(Calendar.YEAR);

        return  dia + "/" + mes + "/" + anio;
    }
    
    public void Sumarpuntos(){
        puntos +=tipo.getPuntos();
    }
    
    
    
    
    
    
    
    
    
   
    
}
