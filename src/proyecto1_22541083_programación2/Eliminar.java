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
    private JMenuBar barra;
    private JButton botonb;

    public Eliminar (JFrame Perfil, int index) {
        super(Perfil, "Deshabilitar", true);
        
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondoRollo.jpeg"));
        Image Escalada = imagen.getImage().getScaledInstance(500,700 , Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        JLabel fondo = new JLabel(imagen);
        setContentPane(fondo);
        fondo.setLayout(new BorderLayout());
        setUndecorated(true);
      
        
        
        inicializarTimer();
        Inicializarbarra();
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
        labelE.setForeground(Color.RED);
        labelE.setOpaque(false);

        campo = new JTextField();
        campo.setFont(new Font("Arial", Font.PLAIN, 15));

        boton = new JButton("Deshabilitar");
        boton.setBackground(Color.RED);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {
            if (campo.getText().equals(Globales.jugadores.get(index).getUser()) ){
                Globales.jugadores.get(index).setactivo(false);
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
                tempo.start();
                
            }
            
        });

        setLayout(new BorderLayout(10, 10));
        panel.add(label);
        panel.add(campo);
        panel.add(boton);
        panel.add(labelE);
        panel.setOpaque(false);
        
        conten.add(panel);
        conten.setOpaque(false);
        
        add(conten);

        setSize(500, 650);
        setLocationRelativeTo(Perfil);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setJMenuBar(barra);
    }
    
    public void inicializarTimer(){
        tempo = new Timer (2100, ev -> {
            labelE.setText("");
            repaint();
            tempo.stop();
        });
    }
    
    public void Inicializarbarra(){
        barra = new JMenuBar();
            barra.setBorderPainted(false);
            barra.setMargin(new Insets(5, 5, 5, 5));
            barra.setBackground(Color.red);
            barra.setForeground(Color.WHITE);
            barra.setFont(new Font("Arial", Font.BOLD, 14));
            barra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
            
            
            
        botonb = new JButton("regresar");

        botonb.setFont(new Font("Arial", Font.BOLD, 15));

        botonb.setBackground(Color.red);

        botonb.setForeground(Color.WHITE);

        botonb.setFocusable(false);
        botonb.setBorderPainted(false);

        botonb.addActionListener(e -> {
            
        
            
            this.dispose();
            
            
        });
            
        
            
        barra.add(botonb);
            
            
            
            
        
    }
    

    
}
