/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
public class Vampiro extends personaje{
    
    
    public Vampiro(String nombre, String acceso, int equipo){
        
        super(acceso, nombre, equipo);
        
        
        
    }

    
    @Override
    public  void inicializarStats(){
        
        vida=4;
        escudo =5;
        ataque=3;
                
    }
    
    public int  especial(personaje victima, int tipo){
        if (vida<4){
            vida++;
        }
        
        int resultado = victima.recibirataque(1, 0, true);
        
        
        return resultado;
    }
}
