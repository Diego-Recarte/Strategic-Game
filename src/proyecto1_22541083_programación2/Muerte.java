/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import java.util.ArrayList;
public class Muerte extends personaje{
    
    private ArrayList<Zombie> zombies= new ArrayList  <>();
    
    public Muerte (String nombre, String acceso, int equipo){
        
        super(acceso, nombre, equipo);
        
        
        
    }
    
    public void addZombie(){
        if (equipo ==1){
            zombies.add(new Zombie("zombie","/Imagenes/personajes_casillas/zombie1.png",equipo,this));
        }else if (equipo ==2){
            zombies.add(new Zombie("zombie","/Imagenes/personajes_casillas/zombie2.png",equipo,this));
        }
        
    }

    public Zombie getZombies(int index) {
        return zombies.get(index);
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
    
    

    
    @Override
    public  void inicializarStats(){
        
        vida=3;
        escudo =1;
        ataque=4;
                
    }
    
    
    public int  especial(personaje victima,int tipo){
        
        if (tipo == 0){
            
            int resultado = victima.recibirataque(2, 0, true);

            return resultado;
        }else
        {
            return 1;
        }
    }
    
}
