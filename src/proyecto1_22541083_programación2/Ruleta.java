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
    private final int radio= 60;
    private int turno =1;
   private ArrayList<personaje> personajesR;

            
    
    
    public Ruleta(String accesoMarco, int turno, ArrayList<personaje> personajes){
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension (350,320));
    personajesR = personajes;
    angulo=0.00;
    
    tempo = new Timer (10, ev ->{ 
    angulo = angulo + 0.10;
    repaint();
    });
        
            ruleta=inicializarimagen("/Imagenes/ruleta.png");
            marco=inicializarimagen(accesoMarco );
            X = inicializarimagen("/Imagenes/X.png");
    
    
      
       

        setOpaque(false);
    
    }
    @Override
    protected void paintComponent(Graphics g){
        int Panelcx = getWidth()/2;
        int Panelcy = getHeight()/2;
        int anchoRuleta = 250;
        int altoRuleta = 250;

        int xRuleta = Panelcx - anchoRuleta / 2;
        int yRuleta = Panelcy - altoRuleta / 2;
        
        int xMarco = Panelcx - 360 / 2;
        int yMarco = Panelcy - 360 / 2;
       
                
        super.paintComponent(g);
        g.drawImage(marco, xMarco, yMarco,360,360, null);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.rotate(angulo, Panelcx, Panelcy);
        g2.drawImage(ruleta,xRuleta, yRuleta,250,250, null);
        agregarX(g2, Panelcx, Panelcy, 0);                   
        g2.dispose();
        
        g.drawImage(marco, Panelcx-marco.getWidth()/2, Panelcy-marco.getHeight()/2,150,150, null);
        
        
        
        
    }
    
    public  BufferedImage inicializarimagen(String ruta){
        try{
            
        
            return ImageIO.read(getClass().getResource(ruta));
        }catch (Exception e){
            return null;
        }
        
        
    }
    
   
     public int agregarX(Graphics2D g2, int xruleta, int yruleta, int acum ){
        if (acum<6){
            
         if (personajesR.get(acum).Isalive() == false){                       
                double anguloR = Math.toRadians(acum+1*60 - 30);


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
