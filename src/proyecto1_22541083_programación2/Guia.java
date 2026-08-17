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
public class Guia extends JDialog{
    public Guia (juego Padre,  int equipo){
        
        super(Padre, "Guia", true);


            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(1200, 800);
            
            ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondoRollo.jpeg"));
        Image Escalada = imagen.getImage().getScaledInstance(1200,800 , Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        JLabel fondo = new JLabel(imagen);
        setContentPane(fondo);
        fondo.setLayout(new BorderLayout());
          setLayout(new BorderLayout(10, 10));
          
         
            setLocationRelativeTo(Padre);
            InicializarGrid();
            InicializarBarra(equipo);
            

        
    }
    
    private void InicializarGrid(){
        
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(1, 4, 10, 10));
        panel.setPreferredSize(new Dimension(1200, 800));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panel.add(InformacionLobo());
        panel.add(InformacionVampiro());
        panel.add(InformacionMuerte());
        panel.add(InformacionZombie());
        
        
        add(panel, BorderLayout.CENTER);

    }
    
    
    private JPanel InformacionVampiro(){

        JPanel casilla = new JPanel();
        casilla.setLayout(new BorderLayout());
        casilla.setOpaque(false);

        JLabel imagenLabel= new JLabel();
        imagenLabel.setPreferredSize(new Dimension (300, 200));
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/personajes_personales/vampiro.jpeg"));//**********************************************************************
        Image Escalada = imagen.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        imagenLabel.setIcon(imagen);
        
        
        
        JLabel Nombre = new JLabel("Vampiro");
        Nombre.setFont(new Font("Arial", Font.BOLD, 18));
        Nombre.setForeground(Color.BLACK);
        Nombre.setOpaque(false);

        Nombre.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre.setPreferredSize(new Dimension(300, 150));
        Nombre.setMinimumSize(new Dimension(300, 150));
        Nombre.setMaximumSize(new Dimension(300, 150));
        
        
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setLineWrap(true);//hace salto de linea si se acaba el espacio
        info.setWrapStyleWord(true);//hace que se corte entre palabras, no entre letras
        
        info.setPreferredSize(new Dimension (300,200));
        info.setMaximumSize(new Dimension (300,200));
        info.setMinimumSize(new Dimension (300,200));
        info.setOpaque(false);
        
        info.setText("Vida: 4 \n"
                + "Escudo: 5 \n"
                + "Ataque: 3 \n"
                + "Especial: \n"
                + "Chupar Sangre(El vampiro succionará un punto de vida de un enemigo adjacente y recuperará un punto de vida)");


        casilla.add(imagenLabel, BorderLayout.NORTH);
        casilla.add(Nombre, BorderLayout.CENTER);
        casilla.add(info, BorderLayout.SOUTH);

        return casilla;
    }
    private JPanel InformacionMuerte(){

        JPanel casilla = new JPanel();
        casilla.setLayout(new BorderLayout());
        casilla.setOpaque(false);

        JLabel imagenLabel= new JLabel();
        imagenLabel.setPreferredSize(new Dimension (300, 200));
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/personajes_personales/muerte.jpeg"));//**********************************************************************
        Image Escalada = imagen.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        imagenLabel.setIcon(imagen);
        
        
        
        JLabel Nombre = new JLabel("Muerte");
        Nombre.setFont(new Font("Arial", Font.BOLD, 18));
        Nombre.setForeground(Color.BLACK);
        Nombre.setOpaque(false);

        Nombre.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre.setPreferredSize(new Dimension(300, 150));
        Nombre.setMinimumSize(new Dimension(300, 150));
        Nombre.setMaximumSize(new Dimension(300, 150));
        
        
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        
        info.setPreferredSize(new Dimension (300,200));
        info.setMaximumSize(new Dimension (300,200));
        info.setMinimumSize(new Dimension (300,200));
        info.setOpaque(false);
        
        info.setText("\"Vida: 3 \n" +
                 "Escudo: 1 \n" +
                 "Ataque: 4 \n" +
                 "Especial: \n" +
                 "Lanza (La muerte usa una lanza para alcanzar enemigos con un rango de hasta dos casllas de distancia inflingiendo un ataque de 2) \n"+
                 "Zombie (La muerte puede Invocar un zombie o pedirle que ataque. los zombies mueren al capturar a la muerte)");


        casilla.add(imagenLabel, BorderLayout.NORTH);
        casilla.add(Nombre, BorderLayout.CENTER);
        casilla.add(info, BorderLayout.SOUTH);

        return casilla;
    }
     private JPanel InformacionLobo(){

        JPanel casilla = new JPanel();
        casilla.setLayout(new BorderLayout());
        casilla.setOpaque(false);

        JLabel imagenLabel= new JLabel();
        imagenLabel.setPreferredSize(new Dimension (300, 200));
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/personajes_personales/lobo.jpeg"));//**********************************************************************
        Image Escalada = imagen.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        imagenLabel.setIcon(imagen);
        
        
        
        JLabel Nombre = new JLabel("Hombre Lobo");
        Nombre.setFont(new Font("Arial", Font.BOLD, 18));
        Nombre.setForeground(Color.BLACK);
        Nombre.setOpaque(false);

        Nombre.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre.setPreferredSize(new Dimension(300, 150));
        Nombre.setMinimumSize(new Dimension(300, 150));
        Nombre.setMaximumSize(new Dimension(300, 150));
        
        
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setLineWrap(true);//hace salto de linea si se acaba el espacio
        info.setWrapStyleWord(true);//hace que se corte entre palabras, no entre letras
        
        info.setPreferredSize(new Dimension (300,200));
        info.setMaximumSize(new Dimension (300,200));
        info.setMinimumSize(new Dimension (300,200));
        info.setOpaque(false);
        
        info.setText("\"Vida: 5 \n" +
                 "Escudo: 2 \n" +
                 "Ataque: 5 \n" +
                 "Especial: \n" +
                 "Velocidad nocturna(El Hombre Lobo puede desplazarse dos casillas hacia a delante siempre y cuando exista espacio libre, se ejectua automaticamente al moverse");


        casilla.add(imagenLabel, BorderLayout.NORTH);
        casilla.add(Nombre, BorderLayout.CENTER);
        casilla.add(info, BorderLayout.SOUTH);

        return casilla;
    }
      private JPanel InformacionZombie(){

        JPanel casilla = new JPanel();
        casilla.setLayout(new BorderLayout());
        casilla.setOpaque(false);

        JLabel imagenLabel= new JLabel();
        imagenLabel.setPreferredSize(new Dimension (300, 200));
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/personajes_personales/zombie.jpeg"));//**********************************************************************
        Image Escalada = imagen.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        imagenLabel.setIcon(imagen);
        
        
        
        JLabel Nombre = new JLabel("Zombie");
        Nombre.setFont(new Font("Arial", Font.BOLD, 18));
        Nombre.setForeground(Color.BLACK);
        Nombre.setOpaque(false);

        Nombre.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre.setPreferredSize(new Dimension(300, 150));
        Nombre.setMinimumSize(new Dimension(300, 150));
        Nombre.setMaximumSize(new Dimension(300, 150));
        
        
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setPreferredSize(new Dimension (300,200));
        info.setMaximumSize(new Dimension (300,200));
        info.setMinimumSize(new Dimension (300,200));
        info.setOpaque(false);
        
        info.setText("Vida: 1 \n" +
                "Escudo: 0 \n" +
                "Ataque: 1 \n"  +
                "Caracteristicas: \n" +
                "El zombie depende que una muerte lo invoque y solo se puede utilizar atravez de la muerte que lo invocó. Si la muerte que lo invoco es adjacente a un enemigo, el zombie no puede atacarle. El zombie no puede moverse");


        casilla.add(imagenLabel, BorderLayout.NORTH);
        casilla.add(Nombre, BorderLayout.CENTER);
        casilla.add(info, BorderLayout.SOUTH);

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
    
    
   
            
    
    
    
    
    
}

    
