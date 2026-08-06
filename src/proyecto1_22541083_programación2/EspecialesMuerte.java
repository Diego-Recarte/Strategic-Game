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
import java.awt.*;
public class EspecialesMuerte extends JDialog {
    private JLabel label;
    private JButton lanza;
    private JButton zombie;
    private JPanel panelB;
    
    EspecialesMuerte(juego padre, personaje muerte, int equipo, int[] indexs,casilla[][] casillas){
        super(padre, "Especiales", true);


            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(300, 150);
            setLayout(new BorderLayout(10, 10));
            getContentPane().setBackground(Color.WHITE);
            if (equipo ==1){
                
                setLocation((padre.getWidth() - this.getWidth()) / 2, 300);
            }else if ( equipo ==2){
                 setLocation((padre.getWidth() - this.getWidth()) / 2, 900);
            }
            
            inicializarJLabel(equipo);
            Inicializarbotones(padre, equipo, muerte, indexs,casillas);
            this.setVisible(true);
            
            
            
            
            
    }
    
    public void inicializarJLabel(int equipo){
        label = new JLabel("Especiales de la muerte");

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.LIGHT_GRAY);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 30));
        
        add(label, BorderLayout.NORTH);
    }
    
    public void Inicializarbotones(juego padre, int equipo, personaje muerte, int[] indexs, casilla[][] casillas){
        panelB = new JPanel();

        panelB.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelB.setPreferredSize(new Dimension(300, 50));
        panelB.setOpaque(false);
        
        
        
         lanza = new JButton("Lanza");

        lanza.setFont(new Font("Arial", Font.BOLD, 14));
        lanza.setPreferredSize(new Dimension(120, 35));
        lanza.setMaximumSize(new Dimension(120, 35));
        if (equipo ==1){
            lanza.setForeground(Color.BLACK);
        lanza.setBackground(Color.WHITE);
        }else if (equipo==2){
            lanza.setForeground(Color.WHITE);
        lanza.setBackground(Color.BLACK);
        }

        

        lanza.setFocusPainted(false);
        
    
     

        lanza.setHorizontalAlignment(SwingConstants.CENTER);

        lanza.addActionListener(e -> {
            
            this.dispose();

        });

        zombie = new JButton("Zombie");

        zombie.setFont(new Font("Arial", Font.BOLD, 14));
        zombie.setPreferredSize(new Dimension(120, 35));
        zombie.setMaximumSize(new Dimension(120, 35));
        
        if (equipo ==1){
            zombie.setForeground(Color.BLACK);
        zombie.setBackground(Color.WHITE);
        }else if (equipo==2){
            zombie.setForeground(Color.WHITE);
        zombie.setBackground(Color.BLACK);
        }


        zombie.setFocusPainted(false);
  
        
        

        zombie.setHorizontalAlignment(SwingConstants.CENTER);

        zombie.addActionListener(e -> {
            PanelZombies pz = new PanelZombies(padre, muerte,  equipo, indexs,  casillas);
            
            
            this.dispose();

        });
        
        panelB.add(lanza);
        panelB.add(zombie);
        add(panelB, BorderLayout.SOUTH);
    }
         
}
