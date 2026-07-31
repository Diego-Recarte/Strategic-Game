/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public class Muerte extends personaje{
    
    public Muerte (String nombre, String acceso){
        
        super(acceso, nombre);
        
        
        
    }

    
    @Override
    public  void inicializarStats(){
        
        vida=3;
        escudo =1;
        ataque=4;
                
    }
    
}
