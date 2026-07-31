/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import javax.swing. *;
import java.awt. *;
import javax.swing.JPanel;
public class MenuInicio extends JFrame {
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JPanel panel;
            
    
    
    public MenuInicio(){
        
    super("inicio"); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 500);
    setLayout(new BorderLayout(10, 10));
    getContentPane().setBackground(Color.WHITE);
    Inicializarbotones();
     setLocationRelativeTo(null);
     setVisible(true);
     System.out.println(getClass().getResource("/Imagenes/personajes_casillas/hombrelobop1a.png"));
    }
    
    
    
    
    private void Inicializarbotones(){
        JPanel Panelenvuelto =new JPanel(new GridBagLayout());
        boton1 = new JButton("Login");

        boton1.setFont(new Font("Arial", Font.BOLD, 14));
        boton1.setPreferredSize(new Dimension(600, 150));
        boton1.setMaximumSize(new Dimension(600, 150));

        boton1.setForeground(Color.WHITE);
        boton1.setBackground(new Color(52,152,219));

        boton1.setFocusPainted(false);
        boton1.setBorderPainted(false);
        boton1.setContentAreaFilled(false);
        boton1.setOpaque(true);

        boton1.setHorizontalAlignment(SwingConstants.CENTER);

        boton1.addActionListener(e -> {
            login l = new login();
            l.setVisible(true);
            this.dispose();
        });
        
        
        
        
        boton2 = new JButton("Crear Cuenta");

        boton2.setFont(new Font("Arial", Font.BOLD, 14));
        boton2.setPreferredSize(new Dimension(600, 150));
        boton2.setMaximumSize(new Dimension(600, 150));

        boton2.setForeground(Color.WHITE);
        boton2.setBackground(new Color(52,152,219));

        boton2.setFocusPainted(false);
        boton2.setBorderPainted(false);
        boton2.setContentAreaFilled(false);
        boton2.setOpaque(true);

        boton2.setHorizontalAlignment(SwingConstants.CENTER);

        boton2.addActionListener(e -> {
                CrearCuenta c = new CrearCuenta();
                c.setVisible(true);
                this.dispose();
        });
        
        
        boton3 = new JButton("Salir");

        boton3.setFont(new Font("Arial", Font.BOLD, 14));
        boton3.setPreferredSize(new Dimension(600, 150));
        boton3.setMaximumSize(new Dimension(600, 150));

        boton3.setForeground(Color.WHITE);
        boton3.setBackground(new Color(52,152,219));

        boton3.setFocusPainted(false);
        boton3.setBorderPainted(false);
        boton3.setContentAreaFilled(false);
        boton3.setOpaque(true);

        boton3.setHorizontalAlignment(SwingConstants.CENTER);

        boton3.addActionListener(e -> {
            System.exit(0);
        });
        
        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(400, 230));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        panel.add(boton1);
        panel.add(Box.createVerticalStrut(20));
        panel.add(boton2);
        panel.add(Box.createVerticalStrut(20));
        panel.add(boton3);
        Panelenvuelto.add(panel);
        add (Panelenvuelto, BorderLayout.CENTER);
        
    }
            
}
