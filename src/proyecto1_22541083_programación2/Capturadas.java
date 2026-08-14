/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author denam
 */
import javax.swing.*;
import java.awt.*;

public class Capturadas extends JDialog {
    
    
    public Capturadas (juego Padre, personaje[] personajes, int equipo){
        
        super(Padre, "Celdas", true);


            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(800, 800);
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
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        int contador=0;
        for (int i = 0; i< personajes.length; i++){
            if (!personajes[i].Isalive()){
                contador++;
                panel.add(CrearJaula(personajes[i]));

            }
        }
        
        if (contador== 0){
            panel.add(InicializarLabel());
        }
        add(panel, BorderLayout.CENTER);

    }
    
    
    private JPanel CrearJaula(personaje Personaje){
        
        JPanel jaula = new JPanel(new BorderLayout());
        
        Image Imagenpersonaje = Personaje.imagen.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon persona = new ImageIcon(Imagenpersonaje);
        
        ImageIcon  celda = new ImageIcon(getClass().getResource("/Imagenes/celda.png"));
        Image Escalada = celda.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        celda = new ImageIcon(Escalada);
        
        jaula.setOpaque(false);
        
        
        JLabel capturado = new JLabel();
        capturado.setIcon(persona);
        capturado.setBounds(60, 50, 120, 150);
        capturado.setOpaque(false);
        
        JLabel barrotes = new JLabel();
        barrotes.setIcon(celda);
        barrotes.setBounds(0, 0, 200, 200);
        barrotes.setOpaque(false);
        
        JLayeredPane capas = new JLayeredPane();
        capas.setPreferredSize(new Dimension(300, 300));
        
        capas.add(capturado, JLayeredPane.DEFAULT_LAYER);
        capas.add(barrotes, JLayeredPane.PALETTE_LAYER);
        jaula.add (capas, BorderLayout.CENTER);
        
        return jaula;
        
    }
    
    private JLabel InicializarLabel(){
        JLabel label = new JLabel("JAULAS VACÍAS (No has capturado piezas)");

        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.red);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(600, 100));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        return label;

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
    
    
    
    
    
    
}
