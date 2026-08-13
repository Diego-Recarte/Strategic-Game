/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import java.awt.*;
import javax.swing. *;

public class mensajeAdvertencia extends JFrame {
    
    private JLabel label;
    private Timer aparecer;
    private Timer desaparecer;
    private Timer configurar;
    private int opacidad= 0;
    
    public mensajeAdvertencia(String mensaje){
        super("advertencia");

          
            setUndecorated(true);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800,100);
            setLocationRelativeTo(null);
            setBackground(new Color(0,0,0,0));
            InicializarComponente();
            Inicializarmensaje(mensaje);
            setAlwaysOnTop(true);
            setVisible(true);
            
            
    }
    private void InicializarComponente(){
        
       
        label= new JLabel(" ");
        label.setFont(new Font("Arial", Font.BOLD, 50));
      
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(1400, 80));
        label.setForeground( new Color(255, 0, 0, 0));
        
        add(label, BorderLayout.CENTER);

        
        
    }
    private void Inicializarmensaje(String mensaje){
        configurar= new Timer(200, ev->{
            
            label.setText(mensaje);
            aparecerMensaje();
                configurar.stop();
            
            
            
        });
        configurar.setRepeats(false);
        configurar.start();
    }
    private void aparecerMensaje(){
       
        label.setForeground( new Color(255, 0, 0, opacidad));
        
        
        aparecer= new Timer(30, ev->{
            opacidad +=15;
            if (opacidad < 255){
                label.setForeground( new Color(255, 0, 0, opacidad));
                this.repaint();
            }else{
                desaparecerMensaje();
                aparecer.stop();
            }
            
            
        });
        
        aparecer.start();
       
    }
    
    private void desaparecerMensaje(){
        
        desaparecer= new Timer(60, ev->{
            opacidad -=15;
            if (opacidad > 0){
                label.setForeground( new Color(255, 0, 0, opacidad));
                this.repaint();
            }else{
                
                this.dispose();
                desaparecer.stop();
            }
            
            
        });
        
        desaparecer.start();
    }

    
    
    
    
    
    
    
}
