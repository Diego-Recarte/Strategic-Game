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
public class Resultado extends JDialog{
    private String Ganador;
    private JPanel panel;
    private JButton Revancha;
    private JButton Salir;
    
    private JLabel Lganador;
    private JLabel jugador;
    
    private int equipo;
    
    Resultado (juego padre, Partida partida, int equipo, jugador user1, jugador user2){
         super(padre,"El juego",true);
        this.Ganador= partida.getGanador();
        this.equipo=equipo;
        
        
         ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondoRollo.jpeg"));
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Image Escalada = imagen.getImage().getScaledInstance(pantalla.width,pantalla.height , Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        JLabel fondo = new JLabel(imagen);
        setContentPane(fondo);
        fondo.setLayout(new BorderLayout());
        setUndecorated(true);
         
    
        setLayout(new BorderLayout(10, 10));
        
        
        
        
        
        Dimension pantalla2 = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(pantalla2.width, pantalla2.height);
        setLocationRelativeTo(null);
        
        InicializarGanador();
        Inicializarbotones(padre, user1, user2);
        InicializarPanel();
        
        
        setVisible(true);
    }
    
    
    
    private void InicializarPanel(){
       

        panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

       
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

  
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(jugador, gbc);


        
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(Lganador, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;

        panel.add(Revancha, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;

        panel.add(Salir, gbc);


  
        GridBagConstraints gbcPanel = new GridBagConstraints();

        gbcPanel.gridx = 0;
        gbcPanel.gridy = 0;

        gbcPanel.weightx = 1.0;
        gbcPanel.weighty = 1.0;

        gbcPanel.anchor = GridBagConstraints.CENTER;
        gbcPanel.fill = GridBagConstraints.NONE;

        add(panel, BorderLayout.CENTER);

        
    }
    
    private void Inicializarbotones(juego padre, jugador user1, jugador user2){
        
        Revancha = new JButton("Revancha");
        

        Revancha.setFont(new Font("Arial", Font.BOLD, 14));
        Revancha.setPreferredSize(new Dimension(120, 35));
        Revancha.setMaximumSize(new Dimension(120, 35));

        

        Revancha.setFocusPainted(false);
        Revancha.setBorderPainted(false);
        Revancha.setContentAreaFilled(false);
        
        if (equipo==1){
        
        Revancha.setBackground(Color.BLACK);
        Revancha.setForeground(Color.white);
        }else{
            Revancha.setBackground(Color.white);
        Revancha.setForeground(Color.black);
        }

        Revancha.setHorizontalAlignment(SwingConstants.CENTER);

        Revancha.addActionListener(e -> {
            
            padre.dispose();
            this.dispose();
             juego jue = new juego( user1, user2);
            

        });
        
        
        
        Salir = new JButton("Salir");

        Salir.setFont(new Font("Arial", Font.BOLD, 14));
        Salir.setPreferredSize(new Dimension(120, 35));
        Salir.setMaximumSize(new Dimension(120, 35));

        

        Salir.setFocusPainted(false);
        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        
        if (equipo==1){
        
        Salir.setBackground(Color.BLACK);
        Salir.setForeground(Color.white);
        }else{
            Salir.setBackground(Color.white);
        Salir.setForeground(Color.black);
        }

        Salir.setHorizontalAlignment(SwingConstants.CENTER);

        Salir.addActionListener(e -> {
            
            int indiceUser1 = -1;

            for (int i = 0; i < Globales.jugadores.size(); i++) {

                if (Globales.jugadores.get(i) == user1) {
                    indiceUser1 = i;
                    break;
                }
            }
            
            
            
            padre.dispose();
            this.dispose();
            Perfil pf = new Perfil (user1, indiceUser1);
             
            
            
            

        });

        
        
        
    }
    
    private void InicializarGanador(){
        Lganador = new JLabel(Ganador);

        Lganador.setFont(new Font("Arial", Font.BOLD, 40));
        
        
        Lganador.setForeground(Color.red);
        Lganador.setOpaque(false);

        Lganador.setHorizontalAlignment(SwingConstants.CENTER);
        Lganador.setPreferredSize(new Dimension(500, 50));
        
        
        
        
        jugador = new JLabel("FELICIDADES");

         jugador .setFont(new Font("Arial", Font.BOLD, 50));
         
         
         jugador .setOpaque(false);

         jugador .setHorizontalAlignment(SwingConstants.CENTER);
         jugador .setPreferredSize(new Dimension(500, 50));

        

    }
            
            
}
