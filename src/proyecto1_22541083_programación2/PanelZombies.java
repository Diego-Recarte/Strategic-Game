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

public class PanelZombies extends JDialog {
    private JLabel label;
    private JButton invocar;
    private JButton atacar;
    private JPanel panelB;
    private JLabel error;

    PanelZombies(juego padre, personaje muerte, int equipo, casilla[][] casillas) {
        super(padre, "control de zombies", true);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        if (equipo == 1) {
            setLocation((padre.getWidth() - this.getWidth()) / 2, 300);
        } else if (equipo == 2) {
            setLocation((padre.getWidth() - this.getWidth()) / 2, 900);
        }

        inicializarJLabel(equipo);
        Inicializarbotones(padre, equipo, muerte, casillas);

        // NO llamar setVisible aquí
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

        invocar = new JButton("invocar");

        invocar.setFont(new Font("Arial", Font.BOLD, 14));
        invocar.setPreferredSize(new Dimension(120, 35));
        invocar.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            invocar.setForeground(Color.BLACK);
            invocar.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            invocar.setForeground(Color.WHITE);
            invocar.setBackground(Color.BLACK);
        }

        invocar.setFocusPainted(false);
        invocar.setHorizontalAlignment(SwingConstants.CENTER);

        invocar.addActionListener(e -> {
            this.dispose();
                
            try{
                padre.asignarZombie(parca);
            }catch(ExcepcionSinInvocar ex){
                
            }
            
        });

        atacar = new JButton("atacar");

        atacar.setFont(new Font("Arial", Font.BOLD, 14));
        atacar.setPreferredSize(new Dimension(120, 35));
        atacar.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            atacar.setForeground(Color.BLACK);
            atacar.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            atacar.setForeground(Color.WHITE);
            atacar.setBackground(Color.BLACK);
        }

        atacar.setFocusPainted(false);
        atacar.setHorizontalAlignment(SwingConstants.CENTER);

        atacar.addActionListener(e -> {
            boolean vivo = false;

            for (int i = 0; i < parca.getZombies().size(); i++) {
                if (parca.getZombies().get(i).Isalive()) {
                    vivo = true;
                    break;
                }
            }

            if (vivo) {
              
                try{
                padre.seleccionarZombie(parca);
                this.dispose();
                }
                catch(ExcepcionSinZombies ex){
                    this.dispose();
                }
                
                
                
            }else{
                try{
                    this.dispose();
                  throw new ExcepcionSinZombies ();
                }
                catch(ExcepcionSinZombies  ex){
                    
                }
            }
                
            
        });

        panelB.add(invocar);
        panelB.add(atacar);
        add(panelB, BorderLayout.SOUTH);
    }
}
