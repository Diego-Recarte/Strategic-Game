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
    
    public personaje(String acceso, String nombre){
        this.nombre=  nombre;
        alive= true;
        
        if (vida == 0){
            alive=false;
        }
        imagen = new ImageIcon(getClass().getResource("/imagenes/jugar.png"));
        
        
        
        
        
        
        
        
        
        
    }
    
    public abstract void inicializarStats();
        
    
    
     
        
    
    
    public void recibirataque (int ataque){
        if (escudo<=0  ){
            vida-= ataque;

        }else{
            escudo -= ataque;
            
            if (escudo < 0){
                ataque = escudo*-1;
                escudo=0;
                recibirataque(ataque); 
                
            }

        }
    }
    
    
    public int getmovimiento() {
        
        return movimiento;
    }
    
    public boolean Isalive(){
        return alive;
    }
    
    
    
    
    
   
    
    
}
