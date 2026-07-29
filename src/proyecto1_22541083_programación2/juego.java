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
    private Ruleta ruletaP1;
    private Ruleta ruletaP2;
    private JPanel tablero;
    private ArrayList <personaje> personajes1 = new  ArrayList<>();
    private ArrayList <personaje> personajes2 = new  ArrayList<>();
    
    public juego(jugador user1, jugador user2) {
    
        super("El juego");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 810);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
        Inicializarruletas();
        InicializarTablero();
        


        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void Inicializarruletas(){
        
    ruletas = new JPanel();
        
    ruletas.setLayout(new BoxLayout(ruletas, BoxLayout.Y_AXIS));
    ruletas.setPreferredSize(new Dimension(350, 300));
    ruletas.setOpaque(false);
    ruletas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
    Inicializarbotondetenernegro();
    ruletas.add(Box.createVerticalStrut(5));
     ruletaP2 = new Ruleta("/Imagenes/marco2.png", 2);
    ruletaP2.setVisible(true);
    ruletas.add(ruletaP2);
    
    ruletaP1 = new Ruleta("/Imagenes/marco1.png", 1);
    ruletaP1.setVisible(true);
    ruletas.add(ruletaP1);
    
    Inicializarbotondetenerblanco();
    
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
    public void InicializarTablero(){
        
        
        tablero = new JPanel();
        tablero.setLayout(new GridLayout(6, 6, 10, 10));
        tablero.setPreferredSize(new Dimension(500, 500));
        tablero.setOpaque(false);
        tablero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        iniciarcasillas(0);
        
        add(tablero, BorderLayout.CENTER);
        
        
        
        
        
        
        
    }
    
    public int iniciarcasillas(int acum){
        
        if (acum<36){
            
            tablero.add(new casilla());
            return iniciarcasillas(acum+1);
            
            
        }
        return 0;
        
    }


}
