/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
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
    private JPanel cardRuletas;
    private CardLayout cambioruleta;
    
    
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
    
    private Timer tiempo;
    private int veces = 0;
    
    private ArrayList <casilla> posiciones = new  ArrayList<>(); 
    private ArrayList <casilla> areaataque = new  ArrayList<>();
    private ArrayList <JButton> acciones = new  ArrayList<>();
    private int turno=1;
    
    private int [] indexs= new int[2]; 
    
    private int rondas1;
    private int rondas2;
    private int rondast1;
    private int rondast2;
    
    private boolean ruleta1detener;
    private boolean ruleta2detener;
    
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
        
        iniciarcantidadronda(1);
        cambiarRuleta();

        
        rondas1=this.user1.getTipo().getTurnosIniciales();
        rondas2=this.user2.getTipo().getTurnosIniciales();
        
        
        
                
        
        
        
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void finturno(){
        casillas[indexs[0]][indexs[1]].border(false);
        if (turno ==1){
            
            if (rondast1 > 0){
                //mensaje de toca a jugador 1 otra vez
                iniciarturno(1);
            }else{
                //mensaje de turno de jugador 2
                
                iniciarcantidadronda(2);
            }
                
            
            
            
            
        }else if (turno == 2){
            if (rondast2 > 0){
                //mensaje de toca a jugador 2 otra vez
                iniciarturno(2);
            }else{
                //mensaje de turno de jugador 1
                
                iniciarcantidadronda(1);
            }
        }
        
    }
    public void iniciarturno(int toca){
       
        if (toca ==1){
            
            ruleta1detener= true;
            
            ruletaP1.inicio();
            botonB.setBackground(Color.yellow);
            botonB.setForeground(Color.black);
           
            turno =1;
            rondast1--;
        }else if (toca == 2){
            ruleta2detener= true;
            ruletaP2.inicio();
            botonN.setBackground(Color.yellow);
            botonN.setForeground(Color.black);
            
            turno =2;
            rondast2--;
        }
        
        cambiarRuleta();

    }
    public void iniciarcantidadronda(int toca){
        rondasbonus(toca);
        if (toca ==1){
            
            
            
                rondast1=rondas1;
                iniciarturno(1);
                
            
        }else if (toca == 2){
            rondast2=rondas2;
            iniciarturno(2);
        }
    }
    
    
    public void rondasbonus(int toca){
        if (toca ==1){
            int vivos = Contarvivos(personajes1);
            switch(vivos){
                case 4:
                    rondas1 += 1;
                    break;
                case 2:
                    rondas1 += 1;
                    break;
                default:
                    break;
            }
        
            
            
            
        }else if (toca ==2){
           int vivos =  Contarvivos( personajes2);
           switch(vivos){
                case 4:
                    rondas2 += 1;
                    break;
                case 2:
                    rondas2 += 1;
                    break;
                default:
                    break;
            }
           
            
        }
        
      
        
        
    }
    private int Contarvivos(ArrayList<personaje> personajes){
        int vivos=0;
        for (int i = 0; i<6; i++){
            if (personajes.get(i).Isalive()){
                vivos++;
            }
        }
        return vivos;
    }
    
    public void VerificarFin(){
        int vivos;
        if (turno==1){
            vivos = Contarvivos( personajes2);
            if (vivos==0){
                partidaFin(user1,user2, false);
            }
            
            
        }else if (turno ==2){
            vivos = Contarvivos( personajes1);
            if (vivos ==0){
                partidaFin(user2,user1, false);
            }
        }
    }
    
    private void partidaFin(jugador ganador, jugador perdedor, boolean isRetirado){
        
        
        
        
    }
    
    //personajes
    public void Inicializarpersonajes(){
        personaje LoboP1a = new HombreLobo("LoboP1a", "/Imagenes/personajes_casillas/hombrelobop1a.png", 1);
        
        personaje VampiroP1a = new Vampiro("VampiroP1a", "/Imagenes/personajes_casillas/vampirop1a.png", 1 );
        
        personaje MuerteP1a = new Muerte ("MuerteP1a", "/Imagenes/personajes_casillas/muertep1a.png", 1);
        
        personaje MuerteP1b = new Muerte ("MuerteP1b", "/Imagenes/personajes_casillas/muertep1b.png", 1);
        
        personaje VampiroP1b = new Vampiro("VampiroP1b", "/Imagenes/personajes_casillas/vampirop1b.png", 1);
        
        personaje LoboP1b = new HombreLobo("LoboP1b", "/Imagenes/personajes_casillas/hombrelobop1b.png", 1);
        
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
        
        
        
        personaje LoboP2a = new HombreLobo("LoboP2a","/Imagenes/personajes_casillas/hombrelobop2a.png", 2 );
        
        personaje VampiroP2a = new  Vampiro("VampiroP2a", "/Imagenes/personajes_casillas/vampirop2a.png", 2);
        
        personaje MuerteP2a =new  Muerte("MuerteP2a","/Imagenes/personajes_casillas/muertep2a.png", 2);
        
        personaje MuerteP2b = new  Muerte("MuerteP2b","/Imagenes/personajes_casillas/muertep2b.png", 2);
        
        personaje VampiroP2b = new  Vampiro("VampiroP2b","/Imagenes/personajes_casillas/vampirop2b.png", 2);
        
        personaje LoboP2b = new HombreLobo("LoboP2b","/Imagenes/personajes_casillas/hombrelobop2b.png", 2 );
        
        
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
    cambioruleta = new CardLayout();
    cardRuletas = new JPanel(cambioruleta);
    cardRuletas.setOpaque(false);
    
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
    
    
    ruletaP1 = new Ruleta("/Imagenes/marco1.png", 1, personajes1);
    ruletaP1.setVisible(true);
    cardRuletas.add(ruletaP1, "1");
    cardRuletas.add(ruletaP2, "2");
    ruletas.add(cardRuletas);
    
    
    
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
    private void cambiarRuleta(){
        if (turno ==1){
             cambioruleta.show(cardRuletas, "1");
        }else if (turno ==2){
             cambioruleta.show(cardRuletas, "2");
        }
       
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
        botonB.setContentAreaFilled(true);
  
        botonB.setRolloverEnabled(false);
        
        

        botonB.addActionListener(e -> {
            
            
            if (ruleta1detener){
                    ruleta1detener= false;
                    ruletaP1.fin();

                    botonB.setBackground(Color.WHITE);
                    botonB.setForeground(Color.black);
                    personaje personaje =encontrarPersonaje(1, ruletaP1.RevisarAngulo());
                    if (personaje == null){

                        iniciarturno(1);
                    }else{

                        casillas[indexs[0]][indexs[1]].border(true);
                        addAcciones (1);
                    }
            }
                
                
                
                
            
            
                    
            

        });
        
        
        ruletas.add(botonB);
        botonB.setAlignmentX(Component.CENTER_ALIGNMENT);
        

    }
    
    private void addAcciones (int equipo){
        if (equipo == 1){
            mover1.setBackground(Color.yellow);
            atacar1.setBackground(Color.yellow);
            mover1.setForeground(Color.black);
            atacar1.setForeground(Color.black);
            if (casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("LoboP1a")||casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("LoboP1b") ){
                
                mover1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    
                    movimiento(indexs[0],indexs[1], 0, true);
                });
                
                atacar1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    
                    ataque (indexs[0],indexs[1],0,0, false);
                    
                    
                    
                });
                
                
                
            }else if (casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("VampiroP1b")||casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("VampiroP1a") ){
                especial1.setBackground(Color.yellow);
                especial1.setForeground(Color.black);
                mover1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                     movimiento(indexs[0],indexs[1], 0, false);
                    
                    
                    
                    
                });
                
                atacar1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    ataque (indexs[0],indexs[1],0,0, false);
                    
                });
                
                especial1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    ataque (indexs[0],indexs[1],0,0, true);
                    
                    
                });
                
                
                
                
            }else{
                especial1.setBackground(Color.yellow);
                especial1.setForeground(Color.black);
                
                mover1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                     movimiento(indexs[0],indexs[1], 0, false);
                    
                });
                
                atacar1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    ataque (indexs[0],indexs[1],0,0,false);
                    
                });
                
                especial1.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    especial esp = new especial(this, casillas[indexs[0]] [indexs[1]].getPersonaje(), 1, casillas);
                    esp.setLocationRelativeTo(this);
                    esp.setVisible(true);
                    
                    
                   
                    
                    
                    
                });
                
                
            }
            
            
            
            
        }else if (equipo ==2){
            
            mover2.setBackground(Color.yellow);
            atacar2.setBackground(Color.yellow);
            mover2.setForeground(Color.black);
            atacar2.setForeground(Color.black);
            
            if (casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("LoboP2a")||casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("LoboP2b") ){
                mover2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    movimiento(indexs[0],indexs[1], 0, true);
                    
                    
                });
                
                atacar2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    ataque (indexs[0],indexs[1],0,0, false);
                    
                });
                
                
                
            }else if(casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("VampiroP2b")||casillas[indexs[0]][indexs[1]].getPersonaje().getNombre().equals("VampiroP2a")) {
                especial2.setBackground(Color.yellow);
                especial2.setForeground(Color.black);
                mover2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                     movimiento(indexs[0],indexs[1], 0, false);
                    
                });
                
                atacar2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    ataque (indexs[0],indexs[1],0,0, false);
                });
                
                especial2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    ataque (indexs[0],indexs[1],0,0, false);
                    
                });
            }
            else{
                especial2.setBackground(Color.yellow);
                especial2.setForeground(Color.black);
                mover2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                     movimiento(indexs[0],indexs[1], 0, false);
                    
                });
                
                atacar2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    ataque (indexs[0],indexs[1],0,0, false);
                    
                });
                
                especial2.addActionListener(e->{
                    limpiarMovimientos();
                    limpiarAtaques();
                    especial es = new especial(this, casillas[indexs[0]] [indexs[1]].getPersonaje(), 2, casillas);
                    es.setLocationRelativeTo(this);
                    es.setVisible(true);
                    
                    
                });
                
            }
        }
    }
    
    private void quitarActionListeners(AbstractButton boton) {
        for (ActionListener listener : boton.getActionListeners()) {
            boton.removeActionListener(listener);
        }
        
    }
    
   public void removeAciones(int equipo){
       if (equipo ==1){
           
           quitarActionListeners(mover1);
           quitarActionListeners(atacar1);
           quitarActionListeners(especial1);
           
           mover1.setBackground(Color.white);
           atacar1.setBackground(Color.white);
           especial1.setBackground(Color.white);
           
           mover1.setForeground(Color.black);
           atacar1.setForeground(Color.black);
           especial1.setForeground(Color.black);
           
       }else if (equipo ==2){
           quitarActionListeners(mover2);
           quitarActionListeners(atacar2);
           quitarActionListeners(especial2);
           
           mover2.setBackground(Color.black);
           atacar2.setBackground(Color.black);
           especial2.setBackground(Color.black);
           
           mover2.setForeground(Color.white);
           atacar2.setForeground(Color.white);
           especial2.setForeground(Color.white);
       }
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
        botonN.setContentAreaFilled(true);
  
        botonN.setRolloverEnabled(false);

        botonN.addActionListener(e -> {
            
            if (ruleta2detener){
            
                ruleta2detener= false;
                ruletaP2. fin();
                botonN.setBackground(Color.black);
                botonN.setForeground(Color.white);
                personaje personaje =encontrarPersonaje(2, ruletaP2.RevisarAngulo());
                if (personaje == null){
                    iniciarturno(2);
                }else{

                 casillas[indexs[0]][indexs[1]].border(true);
                 addAcciones (2);
                }
            }
             
            

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
    
    //obtener casilla de personaje
    
    public personaje encontrarPersonaje(int turno, int numero){
        
        
        if (turno==1){
            switch (numero){
                case 1:
                    indexs = localizarPersonaje ("MuerteP1b");
                    
                    break;
                case 2:
                    indexs = localizarPersonaje ("LoboP1b");
                    break;
                case 3:
                    indexs = localizarPersonaje ("VampiroP1b");
                    break;
                case 4:
                    indexs = localizarPersonaje ("MuerteP1a");
                    break;
                case 5:
                    indexs = localizarPersonaje ("LoboP1a");
                    break;
                case 6:
                    indexs = localizarPersonaje ("VampiroP1a");
                    break;
            }
        }else if (turno ==2){
            switch (numero){
                case 1:
                    indexs = localizarPersonaje ("MuerteP2a");
                    
                    break;
                case 2:
                    indexs = localizarPersonaje ("LoboP2a");
                    break;
                case 3:
                    indexs = localizarPersonaje ("VampiroP2b");
                    break;
                case 4:
                    indexs = localizarPersonaje ("MuerteP2b");
                    break;
                case 5:
                    indexs = localizarPersonaje ("LoboP2b");
                    break;
                case 6:
                    indexs = localizarPersonaje ("VampiroP2a");
                    break;
            }
            
            
            
            
        }
        personaje personajeuso =casillas[indexs[0]] [indexs[1]].getPersonaje();
            if (personajeuso.Isalive()){
                return personajeuso;
            }else{
                return null;
            }
        
        
        
        
    }
    
    public int[] localizarPersonaje (String nombre){
        int [] index = new int[2];
        
        for (int i = 0; i<6; i++){
            for (int z=0; z<6; z++){
                if (casillas[i][z].getPersonaje()== null){
                    
                }else{
                    
                
                    if (casillas[i][z].getPersonaje().getNombre().equals(nombre)){
                        index[0]=i;
                        index[1]=z;
                    }
                }

            }
            
        }
        return index; 
    }
    
    
    
    
    
    
    
    
    
    //movimiento
    
    
    public int movimiento(int fila, int columna, int acum, boolean islobo){
        casilla intermedia;
        if (acum<8){
            
            switch (acum){
                case 0:
                       intermedia = AsignarPosicion(fila+1, columna, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila+2, columna, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
                    
                case 1:
                    intermedia = AsignarPosicion(fila+1, columna+1, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila+2, columna+2, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
                
                case 2:
                    intermedia = AsignarPosicion(fila, columna+1, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila, columna+2, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
                    
                case 3:
                    intermedia = AsignarPosicion(fila-1, columna+1, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila-2, columna+2, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
                    
                case 4:
                    intermedia = AsignarPosicion(fila-1, columna, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila-2, columna, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
                    
                case 5:
                    intermedia = AsignarPosicion(fila-1, columna-1, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila-2, columna-2, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
                    
                case 6:
                    intermedia = AsignarPosicion(fila, columna-1, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila, columna-2, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
                    
                case 7:
                    intermedia = AsignarPosicion(fila+1, columna-1, casillas[fila][columna], islobo,casillas[fila][columna] );
                       if (intermedia != null && islobo){
                           AsignarPosicion(fila+2, columna-2, casillas[fila][columna], islobo, intermedia );
                       }
                    break;
            }
            return movimiento( fila,  columna,  acum+1,islobo);
        }
        return 0;
        
        
    }
    
    public casilla AsignarPosicion(int fila, int columna, casilla inicio, boolean islobo, casilla intermedio){
        if (fila < 0 || fila >= casillas.length || columna < 0 || columna >= casillas[0].length){
            return null;
        }
        else if (casillas[fila][columna].getPersonaje() == null){
                  casillas[fila][columna].filled(true);
                  
                   ActionListener movimiento = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            casilla actual = (casilla) e.getSource();
                            desplazamiento(inicio, actual, islobo, intermedio, this);
                        }
                    };
                  casillas[fila][columna].addActionListener(movimiento);
                  posiciones.add(casillas[fila][columna]);
                  return casillas[fila][columna] ;

        }
        else{
            return null;
        }
        
    }
    
    public void desplazamiento(casilla inicio, casilla fin, boolean islobo, casilla intermedio, ActionListener movimiento){
        
        if (islobo==false){
            
            personaje temp= inicio.getPersonaje();
            inicio.subPersonaje();
            inicio.border(false);
            fin.addPersonaje(temp);
            limpiarMovimientos();
            removeAciones(turno);
            VerificarFin();
            finturno();
            
        }else{
            personaje tempo = inicio.getPersonaje();
            
            
            veces = 0;
            tiempo = new Timer(300, null);
            tiempo.addActionListener(e -> {
                veces++;

                if (veces == 1) {
                    inicio.subPersonaje();
                    inicio.border(false);
                    intermedio.addPersonaje(tempo);
                } else if (veces == 2) {
                    intermedio.subPersonaje();
                    fin.addPersonaje(tempo);
                    veces = 0;
                    tiempo.stop();
                    limpiarMovimientos();
                    removeAciones(turno);
                    VerificarFin();
                    finturno();//fin turno al final de timer
                }
            });
            tiempo.start();
           

            
        }
        
        
        
        
    }
    public void limpiarMovimientos() {
            for (casilla c : posiciones) {
                c.filled(false);
                for (ActionListener al : c.getActionListeners()) {
                    c.removeActionListener(al);
                }
            }
            posiciones.clear();
        }
    
    // ataque
    public int ataque (int fila, int columna, int acum, int invalido, boolean isvampiro){
        
        if (acum<8){
            
            switch (acum){
                case 0:
                        invalido+=Asignarataque(fila+1, columna, casillas[fila][columna],isvampiro  );
                       
                    break;
                    
                case 1:
                     invalido+=Asignarataque(fila+1, columna+1, casillas[fila][columna],isvampiro  );
                       
                    break;
                
                case 2:
                     invalido+=Asignarataque(fila, columna+1, casillas[fila][columna],isvampiro  );
                       
                    break;
                    
                case 3:
                     invalido+=Asignarataque(fila-1, columna+1, casillas[fila][columna],isvampiro  );
                       
                    break;
                    
                case 4:
                    invalido+=Asignarataque(fila-1, columna, casillas[fila][columna],isvampiro  );
                       
                    break;
                    
                case 5:
                     invalido+=Asignarataque(fila-1, columna-1, casillas[fila][columna],isvampiro  );
                       
                    break;
                    
                case 6:
                     invalido+=Asignarataque(fila, columna-1, casillas[fila][columna],isvampiro  );
                       
                    break;
                    
                case 7:
                     invalido+=Asignarataque(fila+1, columna-1, casillas[fila][columna],isvampiro );
                       
                    break;
            }
            return ataque( fila,  columna,  acum+1, invalido, isvampiro);
        }
        else if (invalido == 8){
            //texto de no se encontro oponentes
        }
        return 0;
        
        
    }
    public int buscaratacante(int fila, int columna, casilla atacante){
        if (fila < 0 || fila >= casillas.length || columna < 0 || columna >= casillas[0].length){
            return 1;
            
        }
        else if (casillas[fila][columna].getPersonaje() == null ){
            return 1;
                  

        }
        else if (casillas[fila][columna].getPersonaje().equipo!=atacante.getPersonaje().getEquipo()){
            return 0;
        }
        else{
            return 1;
        }
                
               
              
    }
    
     public int Asignarataque(int fila, int columna, casilla atacante, boolean tipo){
        if (buscaratacante(fila, columna,  atacante)==0){
        
            
            if (tipo== false){
                
                    
        
                        casillas[fila][columna].atacable(true);

                        ActionListener ataque = new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 casilla actual = (casilla) e.getSource();
                                 atacando(atacante, actual, this);
                             }
                         };
                       casillas[fila][columna].addActionListener(ataque);
                       areaataque.add(casillas[fila][columna]);

                       return 0;
                       
            }else if (tipo == true){
                        
                
                    
                        casillas[fila][columna].atacable(true);

                        ActionListener chupar = new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent e) {
                                 casilla actual = (casilla) e.getSource();
                                 chupar(atacante, actual, this);
                             }
                         };
                       casillas[fila][columna].addActionListener(chupar);
                       areaataque.add(casillas[fila][columna]);

                       return 0;
                        
            }
            
            
            
        }
        return 1;
        
        
        
     }
        
    
     
     public void chupar(casilla atacante, casilla atacado, ActionListener chupar){
         limpiarAtaques();
         int resultado;
            resultado = atacante.getPersonaje().especial(atacado.getPersonaje(),0);
            
            
            switch (resultado){
                
                case 1:
                    break;
                case 2:
                    atacado.subPersonaje();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    
                    break;
                    //mensajes para el chat y muerte en caso de ser necesario
        

            
            }
            VerificarFin();
            finturno();
         
     }
     
     public void atacando(casilla atacante, casilla atacado, ActionListener ataque){
        limpiarAtaques();
        System.out.println("atacando() ejecutado");
  
        int resultado;
        resultado = atacado.getPersonaje().recibirataque(atacante.getPersonaje().getAtaque(),0, false);
        System.out.println("se ataco");
            
            
            switch (resultado){
                
                case 1:
                    break;
                case 2:
                    atacado.subPersonaje();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    
                    break;
                    //mensajes para el chat y muerte en caso de ser necesario
        

            
            }
            removeAciones(turno);
            VerificarFin();
            finturno();
        
        
        
    }
     
     public void limpiarAtaques() {
        for (casilla c : areaataque) {
            c.atacable(false);
            for (ActionListener al : c.getActionListeners()) {
                c.removeActionListener(al);
            }
        }
        areaataque.clear();
    }
     
     
     
    //espeiales 
     public int rangoLanza( int acum){
         int fila = indexs[0];
         int columna = indexs[1];
         
        casilla intermedia;
        if (acum<8){
            
            switch (acum){
                case 0:
                       intermedia = Asignarlanzamiento(fila+1, columna, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                           Asignarlanzamiento(fila+2, columna, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
                    
                case 1:
                    intermedia = Asignarlanzamiento(fila+1, columna+1, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                            Asignarlanzamiento(fila+2, columna+2, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
                
                case 2:
                    intermedia = Asignarlanzamiento(fila, columna+1, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                           Asignarlanzamiento(fila, columna+2, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
                    
                case 3:
                    intermedia = Asignarlanzamiento(fila-1, columna+1, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                           Asignarlanzamiento(fila-2, columna+2, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
                    
                case 4:
                    intermedia =  Asignarlanzamiento(fila-1, columna, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                           Asignarlanzamiento(fila-2, columna, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
                    
                case 5:
                    intermedia = Asignarlanzamiento(fila-1, columna-1, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                           Asignarlanzamiento(fila-2, columna-2, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
                    
                case 6:
                    intermedia = Asignarlanzamiento(fila, columna-1, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                            Asignarlanzamiento(fila, columna-2, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
                    
                case 7:
                    intermedia = Asignarlanzamiento(fila+1, columna-1, casillas[fila][columna],casillas[fila][columna] );
                       if (intermedia != null){
                           Asignarlanzamiento(fila+2, columna-2, casillas[fila][columna],casillas[fila][columna] );
                       }
                    break;
            }
            return rangoLanza(acum+1);
        }
        return 0;
        
        
    }
     public casilla Asignarlanzamiento(int fila, int columna, casilla atacante,  casilla intermedia){
        if (buscaratacante(fila, columna,  atacante)==0){

            casillas[fila][columna].atacable(true);

            ActionListener ataque = new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     casilla actual = (casilla) e.getSource();
                     lanzar(atacante, actual, this);
                 }
             };
           casillas[fila][columna].addActionListener(ataque);
           areaataque.add(casillas[fila][columna]);

           return (casillas[fila][columna]);
               
        }
        return null;
        
     }
     
     
     public void lanzar(casilla atacante, casilla atacado, ActionListener ataque){
        limpiarAtaques();
        
  
            int resultado;
            resultado = atacado.getPersonaje().recibirataque(atacante.getPersonaje().getAtaque(),0, false);
            
            
            switch (resultado){
                
                case 1:
                    break;
                case 2:
                    atacado.subPersonaje();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    
                    break;
                    //mensajes para el chat y muerte en caso de ser necesario
        

            
            }
            
            removeAciones(turno);
            VerificarFin();
            finturno();
            
            
        
        
        
    }
     
     
     //muerte especial 2(zombie);
     public boolean  seleccionarZombie(Muerte muerte){
         boolean iszombie= false;
         for (personaje zombie: muerte.getZombies()){
            for(int i=0; i<6 ; i++){
                for (int y = 0 ; y<6 ; y ++){

                    if (casillas[i][y].getPersonaje()!=null){
                        if (casillas[i][y].getPersonaje()==zombie){
                            casillas[i][y].border(true);
                            
                            
                            
                            casillas[i][y].addActionListener(e -> {
                                ataquezombie( 0, 0, muerte);
                            });
                            posiciones.add(casillas[i][y]);
                            
                            iszombie= true;
                                    
                        }
                    }


                }
            }
            
         }
         return iszombie;
     }
     
     public boolean asignarZombie(Muerte muerte){
         
         boolean Espacio= false;
         for (int fila =0; fila<6; fila++){
             for (int columna =0; columna<6; columna++){
                 if (casillas[fila][columna].getPersonaje()==null){
                     
                     final casilla destino = casillas[fila][columna];
                  casillas[fila][columna].filled(true);
                   ActionListener aparecer = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Casilla clickeada: fila=");
                            CrearZombie(destino, this, muerte);
                        }
                    };
                  casillas[fila][columna].addActionListener(aparecer);
                  posiciones.add(casillas[fila][columna]);
                  Espacio= true;
                     
                 }
                 
                 
             }
             
         }
         return Espacio;
         
     }
     
     
     public void CrearZombie(casilla casilla, ActionListener movimiento, Muerte muerte){
           System.out.println("CrearZombie llamado");
       
         muerte.addZombie();
          for (int fila =0; fila<6; fila++){
             for (int columna =0; columna<6; columna++){
                 
                  casillas[fila][columna].filled(false);
             }
          }
         casilla.addPersonaje(muerte.getZombies().get(muerte.getZombies().size() - 1));
         limpiarMovimientos();
         removeAciones(turno);
         finturno();
         
        
         
         
         
         
         
     }
     //ataque zombie
     public int ataquezombie ( int acum, int invalido, Muerte muerte){
         limpiarMovimientos();
        int fila = indexs[0];
        int columna = indexs[1];
        if (acum<8){
            
            switch (acum){
                case 0:
                    if(hayMuerte( fila+2,  columna, muerte)){
                        invalido+=Asignarataque(fila+1, columna, casillas[fila][columna],false  );
                    }
                       
                    break;
                    
                case 1:
                    if(hayMuerte( fila+2,  columna+2, muerte)){
                     invalido+=Asignarataque(fila+1, columna+1, casillas[fila][columna],false  );
                    }
                       
                    break;
                
                case 2:
                    if(hayMuerte( fila,  columna+2, muerte)){
                     invalido+=Asignarataque(fila, columna+1, casillas[fila][columna],false  );
                    }
                       
                    break;
                    
                case 3:
                
                    if(hayMuerte( fila-2,  columna+ 2, muerte)){
                     invalido+=Asignarataque(fila-1, columna+1, casillas[fila][columna],false  );
                    }
                       
                    break;
                    
                case 4:
                
                    if(hayMuerte( fila-2,  columna, muerte)){
                    invalido+=Asignarataque(fila-1, columna, casillas[fila][columna],false  );
                    }
                     
                       
                    break;
                    
                case 5:
                    if(hayMuerte( fila-2,  columna-2, muerte)){
                     invalido+=Asignarataque(fila-1, columna-1, casillas[fila][columna],false  );
                    }
                       
                    break;
                    
                case 6:
                    if(hayMuerte( fila,  columna-2, muerte)){
                     invalido+=Asignarataque(fila, columna-1, casillas[fila][columna],false );
                    }
                       
                    break;
                    
                case 7:
                    if(hayMuerte( fila+2,  columna-2, muerte)){
                     invalido+=Asignarataque(fila+1, columna-1, casillas[fila][columna],false );
                    }
                       
                    break;
            }
            return ataquezombie( acum+1, invalido, muerte);
        }
        else if (invalido == 8){
            //texto de no se encontro oponentes
        }
        return 0;
        
        
    }
    private boolean hayMuerte(int fila, int columna, Muerte muerte){
       if (fila < 0 || fila >= casillas.length ||columna < 0 || columna >= casillas[0].length) {
            return true;
        }else{
           
       
        if ( casillas[fila][columna]==null){
            return true;
        }else if (casillas[fila][columna].getPersonaje()==muerte){
            return false;
        }else{
            return true;
        }
       }
       
        
    }
     
     
     
     


}
