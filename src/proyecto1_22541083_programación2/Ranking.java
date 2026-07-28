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

public class Ranking extends JDialog{
    private JPanel panelt;
    private JPanel panell;
    private JScrollPane scroll;
    private JLabel label;
    private JMenuBar barra;
    private JButton botonb;
    private DefaultTableModel modelo;
    private  JTable tabla;
    
    
            
    
    public Ranking(JFrame Perfil,jugador user){
        
    
        super(Perfil, "Ranking", true);


            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(800, 500);
            setLayout(new BorderLayout(10, 10));
            getContentPane().setBackground(Color.WHITE);
            Inicializartabla();
            Inicializarlabel();
            
            JPanel panelP = new JPanel();
            panelP.setLayout(new BoxLayout(panelP, BoxLayout.Y_AXIS));
            
            
            panelP.setOpaque(false);
            
            panelP.add(Box.createVerticalStrut(60));
            panelP.add(panell);
            
            
            panelP.add(panelt);
            add(panelP);
            
            Inicializarbarra();
            ValoresTabla(user);
            
            
            



            setLocationRelativeTo(Perfil);
            
            
    }
    private void ValoresTabla(jugador user){
        jugador [] Vtablas = Globales.jugadores.toArray( new jugador[0]); 
        
        for (int i=0; i<Vtablas.length-1; i++){
            for (int y = 0; y< Vtablas.length-1; y++){
                if (Vtablas[y].getPuntos() < Vtablas [y+1].getPuntos()){
                    jugador temporal = Vtablas[y];
                    Vtablas[y] = Vtablas [y+1];
                    Vtablas [y+1] = temporal;
                    
                    
                }
            }
        }
        InsertarTabla( Vtablas, 0, user);
        
        
        
    }
    
    private int InsertarTabla(jugador [] Vtablas, int index, jugador user){
        
        if (index < Vtablas.length){
            
            modelo.addRow(new Object[]{index+1, Vtablas[index].getUser(), Vtablas[index].getPuntos()});
            
            return InsertarTabla( Vtablas, index+1, user);
        }
        return 0;
        
       
        
        
        
        
    }
    
    
    
    
    
    public void Inicializartabla(){
        panelt = new JPanel();

        panelt.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelt.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelt.setPreferredSize(new Dimension(750, 300));
        panelt.setOpaque(false);
        
        
        modelo = new DefaultTableModel(new String[] {"Top", "User", "Points"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    
        tabla = new JTable(modelo);

        tabla.setFont(new Font("Arial", Font.PLAIN, 13));
        tabla.setRowHeight(20);
        tabla.setGridColor(Color.GRAY);
        tabla.setBackground(Color.WHITE);
        tabla.setForeground(Color.BLACK);
        tabla.getTableHeader().setReorderingAllowed(false);

        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabla.getTableHeader().setBackground(Color.RED);
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.setSelectionBackground(Color.CYAN);
        
        
        tabla.setFocusable(false);
        tabla.setRequestFocusEnabled(false);
        tabla.setRowSelectionAllowed(false);
        tabla.setColumnSelectionAllowed(false);
        tabla.setCellSelectionEnabled(false);
        
        tabla.setFillsViewportHeight(true);

        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(750, 225));
        panelt.add(scroll);
        
        
        
    }
    
    
    
    
    public void Inicializarlabel(){
        panell = new JPanel();

        panell.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panell.setPreferredSize(new Dimension(500, 80));
        panell.setOpaque(false);
        
        
        
        label = new JLabel("RANKING");

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
