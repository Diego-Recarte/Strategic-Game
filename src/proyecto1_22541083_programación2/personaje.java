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
    protected ImageIcon imagen2;
    protected int  equipo;
    
    public personaje(String acceso, String nombre, int equipo, String acceso2){
        this.nombre=  nombre;
        this.equipo = equipo;
        
        alive= true;
        
        
        
        imagen = new ImageIcon(getClass().getResource(acceso));
        Image Escalada = imagen.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        
        imagen2 = new ImageIcon(getClass().getResource(acceso2));
        Image Escalada2 = imagen2.getImage().getScaledInstance(350, 100, Image.SCALE_SMOOTH);
        imagen2 = new ImageIcon(Escalada2);
        
        
        
        
        inicializarStats();
        
        
        
        
        
        
        
        
        
    }
    
    public abstract void inicializarStats();
        
    
    
     
        
    
    
    public final int recibirataque (int ataque, int combo, boolean directo){
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
        
    
    
    public final int getmovimientos() {
        
        return movimiento;
    }
    
    public final boolean Isalive(){
        return alive;
    }

    public final String getNombre() {
        return nombre;
    }

    public final int getAtaque() {
        return ataque;
    }

    public final int getVida() {
        return vida;
    }

    public final int getEscudo() {
        return escudo;
    }
    
    
    public abstract int  especial(personaje victima, int tipo);
    
    
    
    
    
    
    
    
    
   
    
    
}
