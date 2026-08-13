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
public class opcionesRetirar extends JDialog{
        private JLabel label;
    private JButton Aceptar;
    private JButton Cancelar;
    private JPanel panelB;
    private JLabel error;

    opcionesRetirar (juego padre, int equipo) {
        super(padre, "Retirada", true);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        
        setAlwaysOnTop(true);

        inicializarJLabel(equipo);
        Inicializarbotones(padre, equipo);
        
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

        label = new JLabel("Desear retirarte");

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.LIGHT_GRAY);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 15));

       

        panelLabel.add(label);
       
        add(panelLabel, BorderLayout.NORTH);
    }

    public void Inicializarbotones(juego padre, int equipo) {
        
        panelB = new JPanel();

        panelB.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelB.setPreferredSize(new Dimension(300, 50));
        panelB.setOpaque(false);

        Aceptar = new JButton("Aceptar");

        Aceptar.setFont(new Font("Arial", Font.BOLD, 14));
        Aceptar.setPreferredSize(new Dimension(120, 35));
        Aceptar.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            Aceptar.setForeground(Color.BLACK);
            Aceptar.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            Aceptar.setForeground(Color.WHITE);
            Aceptar.setBackground(Color.BLACK);
        }

        Aceptar.setFocusPainted(false);
        Aceptar.setHorizontalAlignment(SwingConstants.CENTER);

        Aceptar.addActionListener(e -> {
            
            // poner fin de partida
            
        });

        Cancelar = new JButton("Cancelar");

        Cancelar.setFont(new Font("Arial", Font.BOLD, 14));
        Cancelar.setPreferredSize(new Dimension(120, 35));
        Cancelar.setMaximumSize(new Dimension(120, 35));

        if (equipo == 1) {
            Cancelar.setForeground(Color.BLACK);
            Cancelar.setBackground(Color.WHITE);
        } else if (equipo == 2) {
            Cancelar.setForeground(Color.WHITE);
           Cancelar.setBackground(Color.BLACK);
        }

        Cancelar.setFocusPainted(false);
        Cancelar.setHorizontalAlignment(SwingConstants.CENTER);

        Cancelar.addActionListener(e -> {
            this.dispose();
            
            

            
            
            
        });

        panelB.add(Aceptar);
        panelB.add(Cancelar);
        add(panelB, BorderLayout.SOUTH);
    }
}


