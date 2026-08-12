/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */

    

import javax.swing.*;
import java.awt.*;

public class especial extends JDialog {
    private JLabel label;
    private JButton lanza;
    private JButton zombie;
    private JPanel panelB;
    private JLabel error;

    especial(juego padre, personaje muerte, int equipo, casilla[][] casillas) {
        super(padre, "especiales", true);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        if (equipo == 1) {
            setLocation((padre.getWidth() - this.getWidth()) / 2, 300);
        } else if (equipo == 2) {
            setLocation((padre.getWidth() - this.getWidth()) / 2, 900);
        }
        setAlwaysOnTop(true);

        inicializarJLabel(equipo);
        Inicializarbotones(padre, equipo, muerte, casillas);

    }

    public void inicializarJLabel(int equipo) {
        JPanel panelLabel = new JPanel();
        panelLabel.setPreferredSize(new Dimension(150, 30));
        panelLabel.setOpaque(false);
        panelLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        label = new JLabel("control de zombies");

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.LIGHT_GRAY);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 15));

        error = new JLabel(" ");

        error.setFont(new Font("Arial", Font.BOLD, 6));
        error.setForeground(Color.red);
        error.setOpaque(false);

        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setPreferredSize(new Dimension(150, 15));

        panelLabel.add(label);
        panelLabel.add(error);

        add(panelLabel, BorderLayout.NORTH);
    }

    public void Inicializarbotones(juego padre, int equipo, personaje muerte, casilla[][] casillas) {
        Muerte parca = (Muerte) muerte;
        panelB = new JPanel();

        panelB.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelB.setPreferredSize(new Dimension(300, 50));
        panelB.setOpaque(false);

        lanza = new JButton("Lanza");

        lanza.setFont(new Font("Arial", Font.BOLD, 14));
        lanza.setPreferredSize(new Dimension(120, 35));
        lanza.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            lanza.setForeground(Color.BLACK);
            lanza.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            lanza.setForeground(Color.WHITE);
            lanza.setBackground(Color.BLACK);
        }

        lanza.setFocusPainted(false);
        lanza.setHorizontalAlignment(SwingConstants.CENTER);

        lanza.addActionListener(e -> {
            this.dispose();
            padre.rangoLanza(0);
            
        });

        zombie = new JButton("Zombie");

        zombie.setFont(new Font("Arial", Font.BOLD, 14));
        zombie.setPreferredSize(new Dimension(120, 35));
        zombie.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            zombie.setForeground(Color.BLACK);
            zombie.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            zombie.setForeground(Color.WHITE);
            zombie.setBackground(Color.BLACK);
        }

        zombie.setFocusPainted(false);
        zombie.setHorizontalAlignment(SwingConstants.CENTER);

        zombie.addActionListener(e -> {
            this.dispose();

            PanelZombies PZ = new PanelZombies(padre, muerte, equipo, casillas);
            PZ.setLocationRelativeTo(this);
            PZ.setVisible(true);
            
            
        });

        panelB.add(lanza);
        panelB.add(zombie);
        add(panelB, BorderLayout.SOUTH);
    }
}

