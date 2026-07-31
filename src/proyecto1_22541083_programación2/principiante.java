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
import java.awt.*;
public class principiante extends JDialog{
    private JLabel label;
    private JButton cancelar;
    private JButton aceptar;
    private JPanel panelB;
    
    principiante(CrearCuenta padre){
        super(padre, "Principiante", true);


            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(300, 150);
            setLayout(new BorderLayout(10, 10));
            getContentPane().setBackground(Color.WHITE);
            setLocationRelativeTo(padre);
            inicializarJLabel();
            Inicializarbotones(padre);
            this.setVisible(true);
            
            
            
            
            
    }
    
    public void inicializarJLabel(){
        label = new JLabel("No podras cambiar esta decision");

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.BLACK);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 30));
        
        add(label, BorderLayout.NORTH);
    }
    
    public void Inicializarbotones(CrearCuenta padre){
        panelB = new JPanel();

        panelB.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelB.setPreferredSize(new Dimension(300, 50));
        panelB.setOpaque(false);
        
        
        
         aceptar = new JButton("Aceptar");

        aceptar.setFont(new Font("Arial", Font.BOLD, 14));
        aceptar.setPreferredSize(new Dimension(120, 35));
        aceptar.setMaximumSize(new Dimension(120, 35));

        aceptar.setForeground(Color.WHITE);
        aceptar.setBackground(Color.RED);

        aceptar.setFocusPainted(false);
        aceptar.setBorderPainted(false);
    
     

        aceptar.setHorizontalAlignment(SwingConstants.CENTER);

        aceptar.addActionListener(e -> {
            padre.Seguir();
            this.dispose();

        });

        cancelar = new JButton("Cancelar");

        cancelar.setFont(new Font("Arial", Font.BOLD, 14));
        cancelar.setPreferredSize(new Dimension(120, 35));
        cancelar.setMaximumSize(new Dimension(120, 35));

        cancelar.setForeground(Color.WHITE);
        cancelar.setBackground(Color.RED);

        cancelar.setFocusPainted(false);
        cancelar.setBorderPainted(false);
        
        

        cancelar.setHorizontalAlignment(SwingConstants.CENTER);

        cancelar.addActionListener(e -> {
            this.dispose();

        });
        
        panelB.add(cancelar);
        panelB.add(aceptar);
        add(panelB, BorderLayout.SOUTH);
    }
         
}
