/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import java.time.LocalDateTime;
public class jugador {
    private String user;
    private char [] password;
    private int puntos;
    private boolean activo;
    private int Npartidas;
    private int Ngana;
    private int Npierde;
    private int retiros;
    private LocalDateTime tiempo;
    
    public jugador(String user,char [] password ){
        this.user = user;
        this.password=password;
        this.tiempo= LocalDateTime.now();
        puntos = 0;
        activo = true;
        
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
    
    
    
    
    
   
    
}
