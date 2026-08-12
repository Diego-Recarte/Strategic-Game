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
    private JButton capturadas1;
    private JButton guia;
    private JButton info;
    private JPanel statsP1;
    private personaje personaje;
    
    public estadisticas(personaje personaje){
        this.personaje= personaje;
         setPreferredSize(new Dimension(350, 250));
         setMinimumSize(new Dimension(350, 250));
        setMaximumSize(new Dimension(350, 250));
         
         setOpaque(false);
         inicializarStats();
    }
    
    private void inicializarStats(){

        
         inicializarEstadisticas();
         Actualizar();
         
       
         
         add(imagenCarta1);
        add(vida1);
         add(escudo1);
         add(ataque1);
         add(statsP1);
         
         
    
        
         
    }
      private void inicializarEstadisticas(){
       
       
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
       
       
       statsP1= new JPanel();
       statsP1.setLayout(new BoxLayout(statsP1, BoxLayout.X_AXIS));
       statsP1.setPreferredSize(new Dimension (300, 40));
       statsP1.setMaximumSize(new Dimension (300, 40));
       statsP1.setMinimumSize(new Dimension (300, 40));
       statsP1.setOpaque(false);
       
     
       
       capturadas1= new JButton();
       ajustesPanel("Capturadas", capturadas1);
       guia= new JButton();
       ajustesPanel("Guia", guia);
       info= new JButton();
       ajustesPanel("Info", info);
       
       
       statsP1.add(capturadas1);
       statsP1.add(guia);
       statsP1.add(info);
       
     vida1.setHorizontalAlignment(SwingConstants.CENTER);
     ataque1.setHorizontalAlignment(SwingConstants.CENTER);
     escudo1.setHorizontalAlignment(SwingConstants.CENTER);
     guia.setHorizontalAlignment(SwingConstants.CENTER);
     capturadas1.setHorizontalAlignment(SwingConstants.CENTER);
       
       
   
     
        
    }
    
    private void ajustesPanel (String nombre, JButton boton){
        boton.setText(nombre);

        boton.setFont(new Font("Arial", Font.BOLD, 10));
        boton.setPreferredSize(new Dimension(130, 22));
        boton.setMaximumSize(new Dimension(130, 22));

        boton.setForeground(Color.gray);
        boton.setBackground(Color.black);

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
     

        boton.setHorizontalAlignment(SwingConstants.CENTER);

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
