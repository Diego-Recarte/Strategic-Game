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
import java.util.ArrayList;
import java.util.Arrays;
public class login extends JFrame{
    private JLabel texto1;
    private JLabel texto2;
    private JPasswordField contra;
    private JTextField user;
    private JPanel panel;
    private JLabel label;
    private Timer tempo;
    private JMenuBar barra;
    private JButton botonb;
    
    public login (){
        setTitle ("login");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLayout(new BorderLayout(10, 10));
        
        
         ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondoRollo.jpeg"));
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Image Escalada = imagen.getImage().getScaledInstance(pantalla.width,pantalla.height , Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        JLabel fondo = new JLabel(imagen);
        setContentPane(fondo);
        fondo.setLayout(new BorderLayout());
        setUndecorated(true);
        
        
        Inicializarbotones();
        inicializarTimer();
        Inicializarbarra();
        
      
        
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        chkMostrar.setOpaque(false);
        panelLogin.add(chkMostrar);
        


     

        JButton btnIngresar = new JButton("Ingresar");

        btnIngresar.setFont(new Font("Arial", Font.BOLD, 15));

        btnIngresar.setBackground(Color.red);

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusable(false);

        btnIngresar.addActionListener(e -> {
            int index;
            index =Encontrar (0);
            
            if (Globales.jugadores.isEmpty()){
                label.setText("No existen usuarios activos");
                label.setVisible(true);
                tempo.start();
            }
            else if (index ==-1){
                label.setText("No se encontro Usuario");
                label.setVisible(true);
                tempo.start();
            }
            else {
                if (Arrays.equals(Globales.jugadores.get(index).getPassword(),contra.getPassword())){
                    Perfil j = new Perfil(Globales.jugadores.get(index), index);
                    j.setVisible(true);
                    this.dispose();
                }else{
                    label.setText("Contraseña incorrecta");
                    label.setVisible(true);
                    tempo.start();
                }
                
                
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
        
         panelLogin.setOpaque(false);
        
        Panelenvuelto.add(panelLogin);


        

        add(Panelenvuelto, BorderLayout.CENTER);
    }
    
    private void Inicializarbarra(){
        barra = new JMenuBar();
            barra.setBorderPainted(false);
            barra.setMargin(new Insets(5, 5, 5, 5));
            barra.setBackground(Color.red);
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
            
    
    
    private int  Encontrar(int name){
        if (name< Globales.jugadores.size()){
            if (Globales.jugadores.get(name).getUser().equals(user.getText())){

                return name;
            }
            else
                return Encontrar (name+1);
        }
        else
            return -1;
            
        
        
    }
    
    
}
    
       
    
            