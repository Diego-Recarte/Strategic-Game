/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

import javax.swing. *;
import java.awt. *;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
public class juego extends JFrame{
    
    private JPanel ruletas;
    private JButton botonB;
    private JButton botonN;
    
    private JPanel status;
    private JPanel statp2;
    private JPanel statp1;
    private JPanel statchat;
    
    private JLabel nombre1;
    private JLabel nombre2;
    
    
    private JPanel acciones1;
    private JButton mover1;
    private JButton atacar1;
    private JButton especial1;
    
    private JPanel acciones2;
    private JButton mover2;
    private JButton atacar2;
    private JButton especial2;
    private JButton retirar1;
    private JButton retirar2;
    
    private Ruleta ruletaP1;
    private Ruleta ruletaP2;
    private JPanel tablero;
    
    private jugador user1;
    private jugador user2;
    private ArrayList <personaje> personajes1 = new  ArrayList<>();
    private ArrayList <personaje> personajes2 = new  ArrayList<>();
    private casilla[][] casillas = new casilla[6][6];
    
    public juego(jugador user1, jugador user2) {
    
        super("El juego");
        this.user1= user1;
        this.user2= user2;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
        Inicializarruletas();
        InicializarTablero();
        Inicializarpersonajes();
        Inicializarstatus();
        

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void Inicializarpersonajes(){
        personaje LoboP1a = new HombreLobo("HombreLobo", "/Imagenes/personajes_casillas/hombrelobop1a.png");
        
        personaje VampiroP1a = new Vampiro("Vampiro", "/Imagenes/personajes_casillas/vampirop1a.png" );
        
        personaje MuerteP1a = new Muerte ("Muerte", "/Imagenes/personajes_casillas/muertep1a.png");
        
        personaje MuerteP1b = new Muerte ("Muerte", "/Imagenes/personajes_casillas/muertep1b.png");
        
        personaje VampiroP1b = new Vampiro("Vampiro", "/Imagenes/personajes_casillas/vampirop1b.png");
        
        personaje LoboP1b = new HombreLobo("HombreLobo", "/Imagenes/personajes_casillas/hombrelobop1b.png");
        
        personajes1.add(LoboP1a);
        
        personajes1.add(VampiroP1a);
        
        personajes1.add(MuerteP1a);
        
        
        
        personajes1.add(MuerteP1b);
        
        personajes1.add(VampiroP1b);
        
        personajes1.add(LoboP1b);
        
        casillas[5][0].addPersonaje(LoboP1a);
        casillas[5][1].addPersonaje(VampiroP1a);
        casillas[5][2].addPersonaje(MuerteP1a);
        casillas[5][3].addPersonaje(MuerteP1b);
        casillas[5][4].addPersonaje(VampiroP1b);
        casillas[5][5].addPersonaje(LoboP1b);
        
        
        
        personaje LoboP2a = new HombreLobo("HombreLobo","/Imagenes/personajes_casillas/hombrelobop2a.png" );
        
        personaje VampiroP2a = new  Vampiro("Vampiro", "/Imagenes/personajes_casillas/vampirop2a.png");
        
        personaje MuerteP2a =new  Muerte("Muerte","/Imagenes/personajes_casillas/muertep2a.png");
        
        personaje MuerteP2b = new  Muerte("Muerte","/Imagenes/personajes_casillas/muertep2b.png");
        
        personaje VampiroP2b = new  Vampiro("Vampiro","/Imagenes/personajes_casillas/vampirop2b.png");
        
        personaje LoboP2b = new HombreLobo("HombreLobo","/Imagenes/personajes_casillas/hombrelobop2b.png" );
        
        
        personajes2.add(LoboP2a);
        
        personajes2.add(VampiroP2a);
        
        personajes2.add(MuerteP2a);
        
        
        personajes2.add(MuerteP2b);
        
        personajes2.add(VampiroP2b);
        
        personajes2.add(LoboP2b);
        
        
        casillas[0][0].addPersonaje(LoboP2a);
        casillas[0][1].addPersonaje(VampiroP2a);
        casillas[0][2].addPersonaje(MuerteP2a);
        casillas[0][3].addPersonaje(MuerteP2b);
        casillas[0][4].addPersonaje(VampiroP2b);
        casillas[0][5].addPersonaje(LoboP2b);
        
        
        
                
        
        
        
        
        
    }
    
    
    public void Inicializarruletas(){
        
    ruletas = new JPanel();
        
    ruletas.setLayout(new BoxLayout(ruletas, BoxLayout.Y_AXIS));
    ruletas.setPreferredSize(new Dimension(350, 300));
    ruletas.setOpaque(false);
    ruletas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    retirar2 = new JButton ("Retirar");
        
    retirar2.setFont(new Font("Arial", Font.BOLD, 10));
    retirar2.setPreferredSize(new Dimension(100, 15));
     retirar2.setMaximumSize(new Dimension (100, 15));

    retirar2.setForeground(Color.WHITE);
    retirar2.setBackground(Color.DARK_GRAY);

     retirar2.setFocusPainted(false);
    retirar2.setBorderPainted(false);
        
     ruletas.add(retirar2);
     retirar2.setAlignmentX(Component.CENTER_ALIGNMENT);
     
     ruletas.add(Box.createVerticalStrut(15));
        
    Inicializarbotondetenernegro();
    ruletas.add(Box.createVerticalStrut(5));
     ruletaP2 = new Ruleta("/Imagenes/marco2.png", 2, personajes2);
    ruletaP2.setVisible(true);
    ruletas.add(ruletaP2);
    
    ruletaP1 = new Ruleta("/Imagenes/marco1.png", 1, personajes1);
    ruletaP1.setVisible(true);
    ruletas.add(ruletaP1);
    
    
    Inicializarbotondetenerblanco();
    ruletas.add(Box.createVerticalStrut(15));
    
    retirar1 = new JButton ("Retirar");
    retirar1.setFont(new Font("Arial", Font.BOLD, 10));
    retirar1.setPreferredSize(new Dimension(100, 15));
     retirar1.setMaximumSize(new Dimension (100, 15));

    retirar1.setForeground(Color.WHITE);
    retirar1.setBackground(Color.DARK_GRAY);

     retirar1.setFocusPainted(false);
    retirar1.setBorderPainted(false);
    
    ruletas.add(retirar1);
    retirar1.setAlignmentX(Component.CENTER_ALIGNMENT);
   
    add(ruletas, BorderLayout.WEST);
    
       
    }
    public void Inicializarbotondetenerblanco(){
        botonB = new JButton("Detener");

        botonB.setFont(new Font("Arial", Font.BOLD, 14));
        botonB.setPreferredSize(new Dimension(300, 35));
    
        botonB.setMaximumSize(new Dimension(300, 35));
    
        botonB.setForeground(Color.BLACK);
        botonB.setBackground(Color.WHITE);

        botonB.setFocusPainted(false);
        botonB.setBorderPainted(false);
        botonB.setOpaque(true);
        

        botonB.addActionListener(e -> {
            /**if (variableB){                               detiene ruleta 
                botonB.setBackground(Color.WHITE);
            }**/
            ruletaP1.inicio();
                    
            

        });
        
        
        ruletas.add(botonB);
        botonB.setAlignmentX(Component.CENTER_ALIGNMENT);
        

    }
    
    public void Inicializarstatus(){
        
       status = new JPanel();

        status.setLayout(new BoxLayout( status, BoxLayout.Y_AXIS));
         status.setPreferredSize(new Dimension(350, 900));
         status.setOpaque(false);
         status.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         
         
         statp2 = new JPanel();
         statp2.setBackground(Color.black);
         statp2.setPreferredSize(new Dimension(350, 300));
         
         statchat = new JPanel();
         statchat.setBackground(Color.black);
         statchat.setPreferredSize(new Dimension(350, 300));
         
         statp1 = new JPanel();
         statp1.setBackground(Color.black);
         statp1.setPreferredSize(new Dimension(350, 300));
         
         
         status.add(statp2);
         status.add(statchat);
         status.add(statp1);
         
         add(status, BorderLayout.EAST);
         
         
   
         
         
         
         
         
    }
    public void inicializarnombres(){
         nombre1= new JLabel(user1.getUser());

        nombre1.setFont(new Font("Arial", Font.BOLD, 20));
        nombre1.setForeground(Color.BLACK);
        nombre1.setOpaque(false);

        nombre1.setHorizontalAlignment(SwingConstants.CENTER);
        nombre1.setPreferredSize(new Dimension(300, 40));

            nombre2= new JLabel(user2.getUser());

           nombre2.setFont(new Font("Arial", Font.BOLD, 15));
           nombre2.setForeground(Color.BLACK);
           nombre2.setOpaque(false);

           nombre2.setHorizontalAlignment(SwingConstants.CENTER);
           nombre2.setPreferredSize(new Dimension(150,40));
           
        
    }
    public void Inicializarbotondetenernegro(){
        botonN = new JButton("Detener");

        botonN.setFont(new Font("Arial", Font.BOLD, 14));
        botonN.setPreferredSize(new Dimension(300, 35));
        botonN.setMaximumSize(new Dimension(300, 35));
        botonN.setForeground(Color.WHITE);
        botonN.setBackground(Color.BLACK);

        botonN.setFocusPainted(false);
        botonN.setBorderPainted(false);
        botonN.setOpaque(true);

        botonN.addActionListener(e -> {
            
            /**if (variableN==false){
                botonN.setBackground(Color.BLACK);
            }**/
            ruletaP1. fin();
            

        });
        ruletas.add(botonN);
        botonN.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        
    }
    public void inicializarbotones(JButton boton, Color colF, Color colB){
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setPreferredSize(new Dimension(200, 30));
        boton.setMaximumSize(new Dimension (200, 30));

        boton.setForeground(colF);
        boton.setBackground(colB);

        boton.setFocusPainted(false);
        boton.setBorderPainted(true);
        
     
      
       

        boton.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void InicializarTablero(){
        
        
        
        tablero = new JPanel();
        tablero.setLayout(new GridLayout(6, 6, 10, 10));
        tablero.setPreferredSize(new Dimension(600, 600));
        tablero.setMaximumSize(new Dimension(600, 600));
        tablero.setMinimumSize(new Dimension(600, 600));
        tablero.setOpaque(false);
        tablero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        iniciarcasillas(0);
     
        
        mover1= new JButton ("mover");
        atacar1= new JButton ("atacar");
        especial1 = new JButton ("especial");
        
        
        mover2= new JButton ("mover");
        atacar2= new JButton ("atacar");
        especial2 = new JButton ("especial");
        
        
        inicializarbotones(mover1, Color.BLACK, Color.white);
        inicializarbotones(atacar1, Color.BLACK, Color.white);
        inicializarbotones(especial1, Color.BLACK, Color.white);
        
        inicializarbotones(mover2, Color.WHITE, Color.BLACK);
        inicializarbotones(atacar2, Color.WHITE, Color.BLACK);
        inicializarbotones(especial2, Color.WHITE, Color.BLACK);
        
        acciones1= new JPanel();

        acciones1.setLayout(new BoxLayout(acciones1, BoxLayout.X_AXIS));
        acciones1.setPreferredSize(new Dimension(600, 210));
        acciones1.setOpaque(false);
      
        
        acciones2= new JPanel();

        acciones2.setLayout(new BoxLayout(acciones2, BoxLayout.X_AXIS));
        acciones2.setPreferredSize(new Dimension(600, 210));
        acciones2.setOpaque(false);
        
        
        
        acciones1.add(mover1);
        acciones1.add(Box.createHorizontalStrut(3));
        acciones1.add(atacar1);
        acciones1.add(Box.createHorizontalStrut(3));
        acciones1.add(especial1);
        
        acciones2.add(mover2);
        acciones2.add(Box.createHorizontalStrut(3));
        acciones2.add(atacar2);
        acciones2.add(Box.createHorizontalStrut(3));
        acciones2.add(especial2 );
        
        
        JPanel tableros= new JPanel();

        tableros.setLayout(new BoxLayout(tableros ,BoxLayout.Y_AXIS));
        tableros.setPreferredSize(new Dimension(350, 1500));
        tableros.setOpaque(false);
        tableros.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        inicializarnombres();
        
        nombre1.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombre2.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        
        
        tableros.add(nombre2);
        tableros.add(acciones2);
        tableros.add(tablero);
        tableros.add(acciones1);
        tableros.add(nombre1);
       
                
                
        
  
        
        
        
        
        add(tableros, BorderLayout.CENTER);
        
        
        
        
        
        
        
    }
    
    public int iniciarcasillas(int acum){
        
        if (acum<36){
            
            casilla c = new casilla();
            
            int fila = acum / 6;
            int columna = acum % 6;
            
            casillas[fila][columna]= c;
            tablero.add(c);
            return iniciarcasillas(acum+1);
            
            
        }
        return 0;
        
    }


}
