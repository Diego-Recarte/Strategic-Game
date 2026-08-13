/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public class ExcepcionSinEnemigos extends Exception {
     public ExcepcionSinEnemigos(){
       
        mensajeAdvertencia ma = new mensajeAdvertencia("No hay enemigos en rango");
    }
    
}
