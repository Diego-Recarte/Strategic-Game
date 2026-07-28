/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author denam
 */
import javax.swing. *;
import java.awt. *;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
public class Ruleta extends JPanel {
    private BufferedImage ruleta;
    private BufferedImage marco;
    private BufferedImage X;
    private Timer tempo;
    private Double angulo;
    private JButton botonB;
    private JButton botonN;
    private final int radio= 80;
    private int turno =1;

            
    
    
    public Ruleta(){
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension (300,700));
 
    angulo=0.00;
    
    tempo = new Timer (10, ev ->{ 
    angulo = angulo + 0.10;
    repaint();
    });
        
            ruleta=inicializarimagen("/Imagenes/ruleta.png");
            marco=inicializarimagen("/Imagenes/marco.png");
            X = inicializarimagen("/Imagenes/x.png");
    
    
        Inicializarbotones();
        setOpaque(false);
    
    }
    @Override
    protected void paintComponent(Graphics g){
        int Panelcx = getWidth()/2;
        int Panelcy = getHeight()/2;
        int anchoRuleta = 240;
        int altoRuleta = 240;

        int xRuleta = Panelcx - anchoRuleta / 2;
        int yRuleta = Panelcy - altoRuleta / 2;
       
                
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.rotate(angulo, Panelcx, Panelcy);
        g2.drawImage(ruleta,xRuleta, yRuleta,240,240, null);
        //agregarX(g2, Panelcx, Panelcy, 0);                   trabajar con lista de personaje
        g2.dispose();
        
        g.drawImage(marco, Panelcx-marco.getWidth()/2-3, Panelcy-marco.getHeight()/2,315,315, null);
        
        
        
    }
    
    public  BufferedImage inicializarimagen(String ruta){
        try{
            
        
            return ImageIO.read(getClass().getResource(ruta));
        }catch (Exception e){
            return null;
        }
        
        
    }
    
   /** public Arraylist<personaje>  esTurno(){               trabajar con la clase
        if (turno ==1){
            return personajes1;
        }
        else{
            return personajes2;
        }
    } 
**/
    /**  public int agregarX(Graphics2D g2, int xruleta, int yruleta, int acum ){
        if (acum<6){
            
         if (esTurno().get(acum).alive() == false){                          con lista de personajes
                double anguloR = Math.toRadians(acum+1*60 - 60);


                int x = xruleta +
                        (int)(Math.cos(anguloR)*radio);

                int y = yruleta +
                        (int)(Math.sin(anguloR)*radio);


                g2.drawImage(
                    X,
                    x-20,
                    y-20,
                    40,
                    40,
                    null
                );
            }
            return agregarX (g2, xruleta, yruleta, acum+1);
        }
        else{
            return 0;
        } 
            
        
        
        
        
    } **/
    public void Inicializarbotones(){
        botonB = new JButton("Detener");

        botonB.setFont(new Font("Arial", Font.BOLD, 14));
        botonB.setPreferredSize(new Dimension(120, 35));
        botonB.setForeground(Color.BLACK);
        botonB.setBackground(Color.WHITE);

        botonB.setFocusPainted(false);
        botonB.setBorderPainted(false);
        botonB.setOpaque(true);

        botonB.addActionListener(e -> {
            /**if (variableB){                               detiene ruleta 
                botonB.setBackground(Color.WHITE);
            }**/
            inicio();
            

        });
        botonN = new JButton("Detener");

        botonN.setFont(new Font("Arial", Font.BOLD, 14));
        botonN.setPreferredSize(new Dimension(120, 35));
        botonN.setForeground(Color.WHITE);
        botonN.setBackground(Color.BLACK);

        botonN.setFocusPainted(false);
        botonN.setBorderPainted(false);
        botonN.setOpaque(true);

        botonN.addActionListener(e -> {
            
            /**if (variableN==false){
                botonN.setBackground(Color.BLACK);
            }**/
            fin();
            

        });
        
        add(botonB, BorderLayout.SOUTH);
        add (botonN, BorderLayout.NORTH);

    }
    
    public void fin(){
        tempo.stop();
        System.out.println(angulo);
       //                                            aqui luego se enviara a el tablero para decidir que mover
        System.out.println(RevisarAngulo());
        
        
        
    }
    public void inicio(){
        tempo.start();
        System.out.println("hola");
    }
    public Double ConversionAngulo(double rad){
        
        
        if (rad>0 && rad<=360){
            return rad;
        }
        else if (rad<=0){
            return ConversionAngulo(rad+360);
        }
        else {
            return ConversionAngulo(rad-360);
        }
        
        
        

        
        
                
    }
    
    public int RevisarAngulo(){
        double nangulo;
        
        nangulo = ConversionAngulo(Math.toDegrees(angulo));
        
        int tipo;
        
        if (nangulo>330 || nangulo <= 30){
            tipo=1;
        }
        else if ( nangulo>30 && nangulo <=90){
            tipo=2;
        }
        else if (nangulo>90 && nangulo <=150){
            tipo=3;
        }
        else if (nangulo>150 && nangulo <=210){
            tipo= 4;
        }
        else if (nangulo>210 && nangulo <=270){
            tipo = 5;
        }
        else if (nangulo>270 && nangulo <=330){
            tipo = 6;
        }
        else{
            tipo =0;
        }
        return tipo;
    }
}
