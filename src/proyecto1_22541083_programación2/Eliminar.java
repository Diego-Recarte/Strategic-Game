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
public class Eliminar extends JDialog {
    
    private JLabel label;
    private JTextField campo;
    private JButton boton;
    private JLabel labelE;
    private Timer tempo;
    private JPanel panel;
    private JPanel conten;

    public Eliminar (JFrame Perfil, int index) {
        super(Perfil, "Deshabilitar", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        conten = new JPanel(new GridBagLayout());

        conten.setOpaque(false);
        panel.setOpaque(true);
        
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(new Dimension(450, 680));
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        label = new JLabel("Ecribe el nombre de tu cuenta para deshabilitarla: "+ Globales.jugadores.get(index).getUser());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(false);
        
        labelE = new JLabel("");
        labelE.setHorizontalAlignment(SwingConstants.CENTER);
        labelE.setOpaque(false);

        campo = new JTextField();
        campo.setFont(new Font("Arial", Font.PLAIN, 15));

        boton = new JButton("Deshabilitar");
        boton.setBackground(Color.RED);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {
            if (campo.getText().equals(Globales.jugadores.get(index).getUser()) ){
                Globales.jugadores.remove(index);
                JOptionPane.showMessageDialog(
                    this,
                    "Cuenta deshabilitada exitosamente",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE
                        
                );
                MenuInicio M = new MenuInicio();
                M.setVisible(true);
                Perfil.dispose();
                dispose();
                
                
            }
            else{
                labelE.setText("El valor no es igual");
                
            }
            
        });

        setLayout(new BorderLayout(10, 10));
        panel.add(label);
        panel.add(campo);
        panel.add(boton);
        
        conten.add(panel);
        
        add(conten);

        setSize(500, 650);
        setLocationRelativeTo(Perfil);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    public void inicializarTimer(){
        tempo = new Timer (2100, ev -> {
            label.setText("");
            repaint();
            tempo.stop();
        });
    }
    

    
}
