/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public class Zombie extends personaje {
    
    private final int indice;
    
    
    public Zombie (String nombre, String acceso, int equipo, Muerte muerte){
        
        super(acceso, nombre, equipo);
        
        indice = muerte.getZombies().size()-1;
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    @Override
    public  void inicializarStats(){
        
        vida=1;
        escudo =0;
        ataque=1;
                
    }
    
    
    public int  especial(personaje victima,int tipo){
        return 0;
    }
        
        
}
