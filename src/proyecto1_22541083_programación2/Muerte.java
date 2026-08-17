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
    private String acceso2;
    
    public Muerte (String nombre, String acceso, int equipo, String acceso2){
        this.acceso2 = acceso2;
        super(acceso, nombre, equipo, acceso2);
        
        
        
    }
    
    public void addZombie(){
        if (equipo ==1){
            zombies.add(new Zombie("zombie","/Imagenes/personajes_casillas/zombie1.png",equipo,this, acceso2));
        }else if (equipo ==2){
            zombies.add(new Zombie("zombie","/Imagenes/personajes_casillas/zombie2.png",equipo,this, acceso2));
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
