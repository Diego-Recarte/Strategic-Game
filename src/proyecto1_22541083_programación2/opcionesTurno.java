/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */

import java.awt.*;
import javax.swing.*;

public class opcionesTurno extends JDialog {
    private JLabel label;
    private JButton retirarse;
    private JButton Darturno;
    private JPanel panelB;
    private JLabel error;

    opcionesTurno (juego padre, int equipo, jugador user1, jugador user2) {
        super(padre, "Opciones", true);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        
        setAlwaysOnTop(true);

        inicializarJLabel(equipo);
        Inicializarbotones(padre, equipo, user1, user2);
        
        if (equipo == 1) {
            setLocation((padre.getWidth() - this.getWidth()) / 2, 300);
        } else if (equipo == 2) {
            setLocation((padre.getWidth() - this.getWidth()) / 2, 900);
        }
        

    }

    public void inicializarJLabel(int equipo) {
        JPanel panelLabel = new JPanel();
        panelLabel.setPreferredSize(new Dimension(150, 30));
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        label = new JLabel("opciones de turnos");

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.LIGHT_GRAY);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 15));

       

        panelLabel.add(label);
       
        add(panelLabel, BorderLayout.NORTH);
    }

    public void Inicializarbotones(juego padre, int equipo, jugador user1, jugador user2) {
        
        panelB = new JPanel();

        panelB.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelB.setPreferredSize(new Dimension(300, 50));
        panelB.setOpaque(false);

        retirarse = new JButton("Retirarse");

        retirarse.setFont(new Font("Arial", Font.BOLD, 14));
        retirarse.setPreferredSize(new Dimension(120, 35));
        retirarse.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            retirarse.setForeground(Color.BLACK);
            retirarse.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            retirarse.setForeground(Color.WHITE);
            retirarse.setBackground(Color.BLACK);
        }

        retirarse.setFocusPainted(false);
        retirarse.setHorizontalAlignment(SwingConstants.CENTER);

        retirarse.addActionListener(e -> {
            
            opcionesRetirar or = new opcionesRetirar(padre,equipo, user1, user2);
            or.setVisible(true);
            this.dispose();
            
            
        });

        Darturno = new JButton("Zombie");

        Darturno.setFont(new Font("Arial", Font.BOLD, 14));
        Darturno.setPreferredSize(new Dimension(120, 35));
        Darturno.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            Darturno.setForeground(Color.BLACK);
            Darturno.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            Darturno.setForeground(Color.WHITE);
            Darturno.setBackground(Color.BLACK);
        }

        Darturno.setFocusPainted(false);
        Darturno.setHorizontalAlignment(SwingConstants.CENTER);

        Darturno.addActionListener(e -> {
            this.dispose();
            
            padre.removeAciones(equipo);
            padre.finturno();

            
            
            
        });

        panelB.add(retirarse);
        panelB.add(Darturno);
        add(panelB, BorderLayout.SOUTH);
    }
}

    

