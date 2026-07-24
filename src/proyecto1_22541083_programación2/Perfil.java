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
    private JMenuItem Cambio;
    private JMenuItem Ranking;
            
    private JMenu menu0;
    public Perfil(jugador user,int index){
        super("Tu perfil");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
        Inicialivarbarra(user, index);
        Inicializarinicio();
        


        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
    public void Inicialivarbarra(jugador user, int index){
        
            barra = new JMenuBar();
            barra.setBorderPainted(false);
            barra.setMargin(new Insets(5, 5, 5, 5));
            barra.setBackground(Color.RED);
            barra.setForeground(Color.WHITE);
            barra.setFont(new Font("Arial", Font.BOLD, 14));
            barra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

            menu = new JMenu("Mi Perfil");
            menu.setForeground(Color.WHITE);
            menu.setFont(new Font("Arial", Font.BOLD, 14));
            menu.setOpaque(false);
            menu.setBorderPainted(false);
            menu.setHorizontalAlignment(SwingConstants.CENTER);
            
            menu0 = new JMenu("Reportes");
            menu0.setForeground(Color.WHITE);
            menu0.setFont(new Font("Arial", Font.BOLD, 14));
            menu0.setOpaque(false);
            menu0.setBorderPainted(false);
            menu0.setHorizontalAlignment(SwingConstants.CENTER);

            perfil = new JMenuItem("ultimos juegos");
            perfil.setForeground(Color.WHITE);
            perfil.setBackground(Color.RED);
            perfil.setFont(new Font("Arial", Font.BOLD, 14));
            perfil.setHorizontalAlignment(SwingConstants.LEFT);
            perfil.setBorderPainted(false);

            perfil.addActionListener(e -> {

            });
            Ranking = new JMenuItem("Ranking");
            Ranking.setForeground(Color.WHITE);
            Ranking.setBackground(Color.RED);
            Ranking.setFont(new Font("Arial", Font.BOLD, 14));
            Ranking.setHorizontalAlignment(SwingConstants.LEFT);
            Ranking.setBorderPainted(false);

            Ranking.addActionListener(e -> {

            });
            Desabilitar = new JMenuItem("Deshabilitar");
            Desabilitar.setForeground(Color.WHITE);
            Desabilitar.setBackground(Color.RED);
            Desabilitar.setFont(new Font("Arial", Font.BOLD, 14));
            Desabilitar.setHorizontalAlignment(SwingConstants.LEFT);
            Desabilitar.setSize(40,80);
            Desabilitar.setBorderPainted(false);

            Desabilitar.addActionListener(e -> {
                Eliminar d = new Eliminar (this,index);
                d.setVisible(true);

            });
            
            Cambio = new JMenuItem("Cambiar Contra");
            Cambio.setForeground(Color.WHITE);
            
            Cambio.setBackground(Color.RED);
            Cambio.setFont(new Font("Arial", Font.BOLD, 14));
            Cambio.setHorizontalAlignment(SwingConstants.LEFT);
            Cambio.setSize(40,80);
            Cambio.setBorderPainted(false);

            Cambio.addActionListener(e -> {
                    cambioC cam = new cambioC(this, user);
                    cam.setVisible(true);
                    
                    
                    
            });
            Logout = new JMenuItem("Log out");
            Logout.setForeground(Color.WHITE);
            Logout.setBackground(Color.RED);
            Logout.setFont(new Font("Arial", Font.BOLD, 14));
            Logout.setHorizontalAlignment(SwingConstants.LEFT);
            Logout.setBorderPainted(false);

            Logout.addActionListener(e -> {
                MenuInicio l = new MenuInicio ();
        
                l.setVisible(true);
                this.dispose();
            });
            

            nombre = new JLabel(user.getUser());// argegar nombre de persona 
            nombre.setForeground(Color.WHITE);
            nombre.setOpaque(false);
            nombre.setFont(new Font("Arial", Font.BOLD, 14));
            nombre.setHorizontalAlignment(SwingConstants.CENTER);

            
            
            menu.add(Cambio);
            menu.add(Desabilitar);
            menu.add(Logout);
            menu0.add(Ranking);
            menu0.add(perfil);
        
    
            barra.add(nombre);
            barra.add(Box.createHorizontalGlue());
            barra.add(menu0);
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
