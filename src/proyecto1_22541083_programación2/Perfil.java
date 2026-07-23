/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

import javax.swing. *;
import java.awt. *;
public class Perfil extends JFrame{
    
    private JLabel nombre;
    private JButton iniciar;
    private JLabel titulo;
    private JMenuBar barra;
    private JPanel panelB;
    private JMenu menu;
    private JMenuItem perfil;
    private JMenuItem Desabilitar;
    private JMenuItem Logout;
    public Perfil(){
        super("Tu perfil");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
        Inicialivarbarra();
        Inicializarinicio();
        


        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
    public void Inicialivarbarra(){
        
            barra = new JMenuBar();
            barra.setBorderPainted(false);
            barra.setMargin(new Insets(5, 5, 5, 5));
            barra.setBackground(Color.RED);
            barra.setForeground(Color.WHITE);
            barra.setFont(new Font("Arial", Font.BOLD, 14));
            barra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

            menu = new JMenu("Menu");
            menu.setForeground(Color.WHITE);
            menu.setFont(new Font("Arial", Font.BOLD, 14));
            menu.setOpaque(false);
            menu.setBorderPainted(false);
            menu.setHorizontalAlignment(SwingConstants.CENTER);

            perfil = new JMenuItem("Perfil");
            perfil.setForeground(Color.WHITE);
            perfil.setBackground(Color.RED);
            perfil.setFont(new Font("Arial", Font.BOLD, 14));
            perfil.setHorizontalAlignment(SwingConstants.LEFT);
            perfil.setBorderPainted(false);

            perfil.addActionListener(e -> {

            });
            Desabilitar = new JMenuItem("Deshabilitar");
            Desabilitar.setForeground(Color.WHITE);
            Desabilitar.setBackground(Color.RED);
            Desabilitar.setFont(new Font("Arial", Font.BOLD, 14));
            Desabilitar.setHorizontalAlignment(SwingConstants.LEFT);
            Desabilitar.setSize(40,80);
            Desabilitar.setBorderPainted(false);

            Desabilitar.addActionListener(e -> {

            });
            Logout = new JMenuItem("Log out");
            Logout.setForeground(Color.WHITE);
            Logout.setBackground(Color.RED);
            Logout.setFont(new Font("Arial", Font.BOLD, 14));
            Logout.setHorizontalAlignment(SwingConstants.LEFT);
            Logout.setBorderPainted(false);

            Logout.addActionListener(e -> {
                login l = new login ();
                l.setVisible(true);
                this.dispose();
            });

            JLabel texto = new JLabel("Texto");// argegar nombre de persona 
            texto.setForeground(Color.WHITE);
            texto.setOpaque(false);
            texto.setFont(new Font("Arial", Font.BOLD, 14));
            texto.setHorizontalAlignment(SwingConstants.CENTER);

            menu.add(perfil);
            menu.add(Desabilitar);
            menu.add(Logout);
        
    
            barra.add(texto);
            barra.add(Box.createHorizontalGlue());
            barra.add(menu);
            
            

            add(barra, BorderLayout.NORTH);

        
    }
    public void Inicializarinicio(){
        panelB= new JPanel ();
        panelB.setLayout(new BoxLayout(panelB, BoxLayout.Y_AXIS));
        panelB.setPreferredSize(new Dimension(500, 400));
        panelB.setOpaque(false);
        panelB.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        titulo = new JLabel("Texto");

        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        titulo.setForeground(Color.BLACK);
        titulo.setOpaque(false);

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(500, 400));
        
        
        
        iniciar = new JButton("JUGAR");

        iniciar.setFont(new Font("Arial", Font.BOLD, 14));
        iniciar.setPreferredSize(new Dimension(300, 150));
        iniciar.setMaximumSize(new Dimension(300, 150));

        iniciar.setForeground(Color.WHITE);
        iniciar.setBackground(Color.RED);

        iniciar.setFocusPainted(false);
        iniciar.setBorderPainted(false);
        iniciar.setContentAreaFilled(false);
        iniciar.setOpaque(true);

        iniciar.setHorizontalAlignment(SwingConstants.CENTER);

        iniciar.addActionListener(e -> {

        });
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        iniciar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelB.add(titulo);
        panelB.add (Box.createVerticalBox());
        panelB.add(iniciar);
        panelB.add (Box.createVerticalBox());
        panelB.add (Box.createVerticalBox());
        add(panelB, BorderLayout.CENTER);
        
        
        
        
    }
          
        
}
