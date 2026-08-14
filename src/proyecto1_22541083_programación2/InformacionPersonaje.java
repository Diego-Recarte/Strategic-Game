/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author denam
 */

import java.awt.*;
import javax.swing.*;
    public class InformacionPersonaje extends JDialog{
      public InformacionPersonaje (juego Padre, personaje[] personajes, int equipo){
        
        super(Padre, "Estadisticas", true);


            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(1000, 800);
          setLayout(new BorderLayout(10, 10));
          
          if (equipo == 1){
              
          
            getContentPane().setBackground(Color.WHITE);
          }else {
               getContentPane().setBackground(Color.black);
          }
            setLocationRelativeTo(Padre);
            InicializarGrid(personajes);
            InicializarBarra(equipo);
            

        
    }
    
    private void InicializarGrid(personaje[] personajes){
        
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 3, 10, 10));
        panel.setPreferredSize(new Dimension(1000, 800));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        int contador=0;
        for (int i = 0; i< personajes.length; i++){
            if (!personajes[i].Isalive()){
                contador++;
                panel.add(PersonajeMuerto(personajes[i]));

            }else{
                panel.add(PersonajeVivo(personajes[i]));
            }
                    
        }
        
        
        add(panel, BorderLayout.CENTER);

    }
    
    
    private JPanel PersonajeMuerto(personaje Personaje){

        JPanel casilla = new JPanel();
        casilla.setLayout(new OverlayLayout(casilla));
        casilla.setOpaque(false);

        JPanel vivo = PersonajeVivo(Personaje);

        JLabel muerte = new JLabel();

        ImageIcon x = new ImageIcon(
            getClass().getResource("/Imagenes/X.png")
        );
        Image Escalada = x.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        x = new ImageIcon(Escalada);

        muerte.setIcon(x);
        muerte.setAlignmentX(0.5f);
        muerte.setAlignmentY(0.5f);

        casilla.add(muerte);
        casilla.add(vivo);

        return casilla;
    }
    
   
    private void InicializarBarra(int equipo){
        JMenuBar barra;
        JButton botonb;
        barra = new JMenuBar();
            barra.setBorderPainted(false);
            barra.setMargin(new Insets(5, 5, 5, 5));
            
            if (equipo ==1){
                barra.setBackground(Color.WHITE);
                barra.setForeground(Color.black);
            }else{
                barra.setBackground(Color.black);
                barra.setForeground(Color.WHITE);
            }
            barra.setFont(new Font("Arial", Font.BOLD, 14));
            barra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
            
            
            
        botonb = new JButton("regresar");

        botonb.setFont(new Font("Arial", Font.BOLD, 15));

         if (equipo ==1){
                 botonb.setBackground(Color.WHITE);

                botonb.setForeground(Color.BLACK);

            }else{
             
         
                botonb.setBackground(Color.BLACK);

                botonb.setForeground(Color.white);
            }
        

        botonb.setFocusable(false);
        botonb.setBorderPainted(false);

        botonb.addActionListener(e -> {
            
        
                    this.dispose();
        });
        
        barra.add(botonb);
        setJMenuBar(barra);
            
    }
    
    
    private JPanel PersonajeVivo(personaje Personaje){
        
        
        return new estadisticas(Personaje);
        
    }
            
    
    
    
    
    
}


