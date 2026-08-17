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
import javax.swing.table.DefaultTableModel;

public class partidasR extends JDialog {
    
    
    private JPanel panel;
    private JPanel panell;
    private JPanel central;
    private JButton botonb;
    private JMenuBar barra;
    private DefaultTableModel modelo ;
    
    public partidasR(jugador user, JFrame Perfil){
        
    
        super(Perfil, "Partidas", true);

                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                setSize(800, 500);
              setLayout(new BorderLayout(10, 10));
              
              
              
         ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondoRollo.jpeg"));
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Image Escalada = imagen.getImage().getScaledInstance(pantalla.width,pantalla.height , Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        JLabel fondo = new JLabel(imagen);
        setContentPane(fondo);
        fondo.setLayout(new BorderLayout());
        setUndecorated(true);
                
        Inicializartablero(user);
        Inicializartitulo();
        Inicializarbarra();
        IncluirTablero(user);
                
        central = new JPanel();

        central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));
        central.setPreferredSize(new Dimension(800, 500));
        central.setOpaque(false);
        central.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        central.add(panell);
        central.add(panel);
        add(central);
        setLocationRelativeTo(Perfil);
        
    }
    public void IncluirTablero(jugador user){
        for (int i =0; i< Globales.Partidas.size(); i++){
            
        
            if (user.getUser().equals(Globales.Partidas.get(i).getGanador()) || user.getUser().equals(Globales.Partidas.get(i).getPerdedor()))  {
                modelo.addColumn(Globales.Partidas.get(i).getNumero(), new Object []{Globales.Partidas.get(i).getNumero(),Globales.Partidas.get(i).getGanador(), Globales.Partidas.get(i).getPerdedor(), Globales.Partidas.get(i).isIsretired()});
                
            }
        }
             
    }
    
    
    public void Inicializartablero(jugador user){
         panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(500, 350));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        
        modelo= new DefaultTableModel(new String[] { "Numero de partida"},  4)     {        
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
               
    

        
        modelo.setValueAt("Numero de partida", 0, 0);
        modelo.setValueAt("Ganador", 1, 0);
        modelo.setValueAt("Perdedor", 2, 0);
        modelo.setValueAt("Condicion de Victoria", 3, 0);
        
        JTable tabla = new JTable(modelo);
        
        tabla.setFont(new Font("Arial", Font.PLAIN, 13));
        tabla.setRowHeight(70);
        tabla.setTableHeader(null);
        
       
        tabla.setGridColor(Color.LIGHT_GRAY);
      
        tabla.setOpaque(false);
        tabla.setForeground(Color.BLACK);

        



        tabla.setFocusable(false);
        tabla.setRequestFocusEnabled(false);
        tabla.setRowSelectionAllowed(false);
        tabla.setColumnSelectionAllowed(false);
        tabla.setCellSelectionEnabled(false);
        
        tabla.setFillsViewportHeight(true);
        tabla.setOpaque(false);
        tabla.setShowGrid(false);
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(300, 180));
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setViewportBorder(null);
        
        
        
        JLabel label = new JLabel(user.getUser());

        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 30));
        
        
        panel.add(label);
        panel.add(scroll);
    

    }
    public void Inicializartitulo(){
        panell = new JPanel();

        panell.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panell.setPreferredSize(new Dimension(700, 80));
        panell.setOpaque(false);
        
        
        
         JLabel label = new JLabel("Historial de Partidas");

        label.setFont(new Font("Arial", Font.BOLD, 60));
        label.setForeground(Color.BLACK);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        panell.add(label);
        
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
            
            
            
            
        add (barra, BorderLayout.NORTH);
    }
    
    
    
}
