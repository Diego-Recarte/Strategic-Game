/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

import javax.swing. *;
import java.awt. *;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class juego extends JFrame{
    
    public juego() {
    
        super("El juego");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
        Ruleta ruleta = new Ruleta();
        ruleta.setVisible(true);
        add(ruleta, BorderLayout.WEST);


        setLocationRelativeTo(null);
        setVisible(true);
    }


}
