/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt. *;
public class estadisticas extends JPanel{
    
     private JLabel imagenCarta1;
    private JLabel nombreCarta1;
    private JLabel ataque1;
    private JLabel escudo1;
    private JLabel vida1;
 
  
    private personaje personaje;
    
    public estadisticas(personaje personaje){
        this.personaje= personaje;
         setPreferredSize(new Dimension(350, 230));
         setMinimumSize(new Dimension(350, 230));
        setMaximumSize(new Dimension(350, 230));
         
         setOpaque(false);
         inicializarStats(personaje);
    }
    
    private void inicializarStats( personaje personaje){

        
         inicializarEstadisticas( personaje);
         Actualizar();
         
       
         
         add(imagenCarta1);
        add(vida1);
         add(escudo1);
         add(ataque1);

         
         
    
        
         
    }
      private void inicializarEstadisticas( personaje personaje){
       
       
       imagenCarta1= new JLabel();
       imagenCarta1.setText(" ");
       imagenCarta1.setPreferredSize(new Dimension (350, 100));
       imagenCarta1.setMaximumSize(new Dimension (350, 100));
       imagenCarta1.setMinimumSize(new Dimension (350, 100));
       
        
       
      ataque1 = new JLabel(" ");
       ajustesLabel(ataque1);
       
       escudo1= new JLabel(" ");
       ajustesLabel(escudo1);
       
       vida1= new JLabel(" ");
       ajustesLabel(vida1);
       
       
       
       
     vida1.setHorizontalAlignment(SwingConstants.CENTER);
     ataque1.setHorizontalAlignment(SwingConstants.CENTER);
     escudo1.setHorizontalAlignment(SwingConstants.CENTER);
    
       
   
     
        
    }
    
   
    private void ajustesLabel(JLabel label){
        label.setPreferredSize(new Dimension (350, 30));
        label.setMaximumSize(new Dimension (350, 30));
        label.setMinimumSize(new Dimension (350, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
       
      
        label.setFont(new Font("Arial", Font.BOLD, 14));
        
        
    }
    
    
    
    public void Actualizar(){
        vida1.setText("Vida: "+personaje.getVida());
        escudo1.setText("Escudo: "+personaje.getEscudo());
        ataque1.setText("Ataque: "+personaje.getAtaque());
        
    }
}
