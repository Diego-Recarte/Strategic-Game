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
import java.util.ArrayList;
public class CrearCuenta extends JFrame {
    
    private JLabel texto1;
    private JLabel texto2;
    private JPasswordField contra;
    private JTextField user;
    private JPanel panel;
    private JLabel label;
    private Timer tempo;
    private JMenuBar barra;
    private JButton botonb;
    
    
    public CrearCuenta (){
        setTitle ("Create Account");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
        Inicializarbotones();
        inicializarTimer();
       
        
        setLocationRelativeTo(null);
        setVisible(true);
        

        
        
        
        
        
       
        
        
    }
    public void inicializarTimer(){
        tempo = new Timer (2100, ev -> {
            label.setVisible(false);
            repaint();
            tempo.stop();
        });
    }
           
          
    
    public void Inicializarbotones(){
        JPanel panelLogin = new JPanel();
        JPanel Panelenvuelto =new JPanel(new GridBagLayout());
        Panelenvuelto.setOpaque(false);

        panelLogin.setBounds(100, 50, 300, 280);

        panelLogin.setLayout(new GridLayout(6, 1, 10, 10));

        panelLogin.setBackground(Color.WHITE);

        panelLogin.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelLogin.setPreferredSize( new Dimension (350,250));


        

        JLabel lblUsuario = new JLabel("Usuario");

        lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));

        panelLogin.add(lblUsuario);


        

        user = new JTextField();

        user.setFont(new Font("Arial", Font.PLAIN, 15));

        panelLogin.add(user);


        

        JLabel lblPassword = new JLabel("Contraseña");

        lblPassword.setFont(new Font("Arial", Font.BOLD, 16));

        panelLogin.add(lblPassword);


        

        contra = new JPasswordField();

        contra.setFont(new Font("Arial", Font.PLAIN, 15));

        panelLogin.add(contra);


        

        JCheckBox chkMostrar = new JCheckBox("Mostrar contraseña");

        chkMostrar.setBackground(Color.WHITE);

        chkMostrar.setFocusable(false);

        chkMostrar.addActionListener(e -> {

            if(chkMostrar.isSelected()){
                contra.setEchoChar((char)0);   
            }else{
                contra.setEchoChar('•');       
                
            }

        });

        panelLogin.add(chkMostrar);


     

        JButton btnIngresar = new JButton("Ingresar");

        btnIngresar.setFont(new Font("Arial", Font.BOLD, 15));

        btnIngresar.setBackground(new Color(52,152,219));

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusable(false);

        btnIngresar.addActionListener(e -> {
            
            
            if (ComprobarU() && ComprobarC()){
                Globales.jugadores.add(new jugador (user.getText(),contra.getPassword()));
                Perfil j = new Perfil(Globales.jugadores.getLast(), Globales.jugadores.size()-1);
                j.setVisible(true);
            }
            else{
                if (ComprobarU()==false && ComprobarC ()==false){
                    label.setText ("Falta User y Contra");
                    label.setVisible(true);
                    tempo.start();
                }
                
                label.setVisible (true);
                repaint();
                tempo.start();
                
            }
                    
                

            

        });
        
        label = new JLabel("Texto");

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.red);
        label.setOpaque(false);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 90));
        label.setVisible (false);
        panelLogin.add(label);
        

        panelLogin.add(btnIngresar);
        
        Panelenvuelto.add(panelLogin);


        

        add(Panelenvuelto, BorderLayout.CENTER);
    }
    
    
    private boolean ComprobarC(){
        
        if ( contra.getPassword() == null || contra.getPassword().length ==0){
            label.setText("Ingrese contraseña");
            return false;
            
            
            
        }else if (contra.getPassword().length != 5){
            label.setText("Debe tener 5 digitos");
            return false;
        }
            
        else{
            return true;
        }
            

       
    }
    private boolean ComprobarU(){
        
        if (user.getText().length() ==0){
            label.setText("Ingrese usuario");
            return false;
            
       }
            
        else{
            return true;
        }
            

       
    }
    private void Inicializarbarra(){
        barra = new JMenuBar();
            barra.setBorderPainted(false);
            barra.setMargin(new Insets(5, 5, 5, 5));
            barra.setBackground(new Color(52,152,219));
            barra.setForeground(Color.WHITE);
            barra.setFont(new Font("Arial", Font.BOLD, 14));
            barra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
            
            
            
        botonb = new JButton("regresar");

        botonb.setFont(new Font("Arial", Font.BOLD, 15));

        botonb.setBackground(new Color(52,152,219));

        botonb.setForeground(Color.WHITE);

        botonb.setFocusable(false);
        botonb.setBorderPainted(false);

        botonb.addActionListener(e -> {
            
        
            MenuInicio l = new MenuInicio();

            l.setVisible(true);
            this.dispose();
            
            
        });
            
        
            
        barra.add(botonb);
            
            
            
            
        add (barra, BorderLayout.NORTH);
            
            
    }
}
