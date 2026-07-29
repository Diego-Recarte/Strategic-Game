/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */

import javax.swing. *;
import java.awt. *;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class casilla extends JButton {
    private personaje personaje;
    private boolean relleno;
    
    
    
    public casilla(){
        
        setPreferredSize(new Dimension(15, 15));
        setMaximumSize(new Dimension(15, 15));
        setEnabled(false);
        setFocusable(false);
        setFocusPainted(false);
        setBorderPainted(false);
        
        filled(false);
        
        
        if (personaje == null){
           
        }else{
           // personaje.getClass
        }
        
    }
    
    
    public void filled (boolean relleno){
        this.relleno = relleno;
        if (relleno){
            setBackground(Color.yellow);
        }else{
            setBackground(Color.gray);
        }
        repaint();
                
    }
     @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (relleno) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(255, 215, 0, 90));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        }
        
        
        public void addPersonaje(personaje personaje){
            this.personaje = personaje;
            
            repaint();
        }
        public void subPersonaje (){
            personaje = null;
            repaint();
            
        }
        
      
        
    
}
