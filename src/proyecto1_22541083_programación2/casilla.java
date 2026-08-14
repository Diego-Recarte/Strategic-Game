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
    private boolean atacable;
    private Timer timer;
    private int  contador ;
    
    
    
    public casilla(){
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        setPreferredSize(new Dimension(15, 15));
        setMaximumSize(new Dimension(15, 15));
        
        setFocusable(false);
        setFocusPainted(false);
        setBorderPainted(false);
        
        filled(false);
        atacable (false);
        
        
        
        
    }
    
    
    public void filled (boolean relleno){
        this.relleno = relleno;
        if (relleno){
            setBackground(Color.yellow);
            setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        }else{
            setBackground(Color.gray);
        }
        repaint();
                
    }
    public void border (boolean relleno){
        this.relleno = relleno;
        if (relleno){
            
            setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        }else{
            setBorder(null);
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
            if (atacable){
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor( new Color(255, 0, 0, 150));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        }
        
        public void atacable (boolean atacable){
            this.atacable = atacable;
            if (relleno){

                setBorder(BorderFactory.createLineBorder(Color.red, 3));
            }else{
                setBorder(null);
            }
            repaint();

        }
        
        public void RepresentarAtaque(){
            
            setIcon (null);
            repaint();
            contador = 0;
            timer = new Timer (200, ev->{
                
                if (contador %2==0){
                    setIcon (null);
                    repaint();
                }else{
                    setIcon(personaje.imagen);
                repaint();
                }
                contador++;
                
                if (contador==4){
                    timer.stop();
                }
            });
            
            timer.start();
            
            
            
            
            
        }
        
        
        
        
        
        
        public void addPersonaje(personaje personaje){
            this.personaje = personaje;
            setIcon(personaje.imagen);
            setDisabledIcon(personaje.imagen);
            
            repaint();
        }
        public void subPersonaje (){
            personaje = null;
            setIcon(null);
            repaint();
            
        }

    public personaje getPersonaje() {
        return personaje;
    }
        
        
        
      
        
    
}
