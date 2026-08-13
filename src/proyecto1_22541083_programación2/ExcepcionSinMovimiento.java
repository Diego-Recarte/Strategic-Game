/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public class ExcepcionSinMovimiento extends Exception{
    
    public ExcepcionSinMovimiento(){
         mensajeAdvertencia ma = new mensajeAdvertencia("No hay casillas donde moverse");
    }
}
