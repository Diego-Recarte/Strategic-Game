/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import javax.swing.ImageIcon;
import java.awt.Image;


public abstract class personaje {
    protected int movimiento;
    private String nombre;
    protected int vida;
    protected int ataque;
    protected int escudo;
    protected especial tipo; 
    protected boolean alive;
    protected int fila;
    protected int columna;
    protected ImageIcon imagen;
    protected int  equipo;
    
    public personaje(String acceso, String nombre, int equipo){
        this.nombre=  nombre;
        this.equipo = equipo;
        
        alive= true;
        
        
        
        imagen = new ImageIcon(getClass().getResource(acceso));
        Image Escalada = imagen.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        
        
        inicializarStats();
        
        
        
        
        
        
        
        
        
    }
    
    public abstract void inicializarStats();
        
    
    
     
        
    
    
    public int recibirataque (int ataque, int combo, boolean directo){
        System.out.println("dentro del metodo"+ ataque);
        if (ataque == 0){
            //mensaje de roptura de escudo
            return 1;
        }
        else if (escudo<=0 || directo  ){
            System.out.println(ataque);
        
            vida-= ataque;
            if (vida <= 0){
                vida = 0;
                alive = false;
                //mensaje y muerte
                System.out.println("Personaje murió, eliminando del tablero");
                
                return 2;
                
            }else{
                if (combo == 1){
                    //mensaje de quitar vida y escudo
                    return 3;
                }
                //mensaje de quitar vida
                return 4;
            }

        }else{
            escudo -= ataque;
            
            if (escudo < 0){
                ataque = escudo*-1;
                escudo=0;
                
                return recibirataque(ataque, 1, false); 
                
                
            }else{
                //mensaje de quitar escudo
                return 1;
            }

        }
    }

    public int getEquipo() {
        return equipo;
    }
        
    
    
    public int getmovimientos() {
        
        return movimiento;
    }
    
    public boolean Isalive(){
        return alive;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }

    public int getEscudo() {
        return escudo;
    }
    
    
    public abstract int  especial(personaje victima, int tipo);
    
    
    
    
    
    
    
    
    
   
    
    
}
