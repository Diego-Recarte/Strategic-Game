/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public class HombreLobo extends personaje{
    
    
    public HombreLobo(String nombre, String acceso, int equipo){
        
        super(acceso, nombre, equipo);
        
        
        
    }

    
    @Override
    public  void inicializarStats(){
        
        vida=5;
        escudo =2;
        ataque=5;
                
    }
    
    public int  especial(personaje victima, int tipo){
        return 0;
    }
}
