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
    private JLabel advertencia;
    private Timer tempo;
    private JMenuBar barra;
    private JButton botonb;
    private JRadioButton Normal;
    private JRadioButton practicante;
    private ButtonGroup grupoTipoCuenta;
    
    
    private String nombre;
    
    public CrearCuenta (){
        setTitle ("Create Account");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 630);
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

        panelLogin.setLayout(new GridLayout(8, 1, 8, 8));

        panelLogin.setBackground(Color.WHITE);

        panelLogin.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelLogin.setPreferredSize( new Dimension (350,520));


        

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
        chkMostrar.setOpaque(false);

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
        
        JPanel panelradio = new JPanel();
        panelradio.setLayout(new  FlowLayout(FlowLayout.LEFT));
        panelradio.setPreferredSize(new Dimension(100, 20));
        panelradio.setOpaque(false);
        
       Normal = new JRadioButton("Cuenta normal");
       practicante = new JRadioButton("Cuenta de practicante");
       
       
       Normal.setFont(new Font("Arial", Font.BOLD, 10));
        Normal.setPreferredSize(new Dimension(100, 15));
        Normal.setMaximumSize(new Dimension(100, 15));

        Normal.setForeground(Color.black);

        Normal.setFocusPainted(false);
        Normal.setBorderPainted(false);
        Normal.setContentAreaFilled(false);
        Normal.setOpaque(false);
        Normal.addActionListener(e -> {
            
            advertencia.setText(" ");
            advertencia.setVisible (false);
        });

        




        practicante.setFont(new Font("Arial", Font.BOLD, 10));
        practicante.setPreferredSize(new Dimension(140, 15));
        practicante.setMaximumSize(new Dimension(140, 15));

        practicante.setForeground(Color.black);
      
        practicante.setFocusPainted(false);
        practicante.setBorderPainted(false);
        practicante.setContentAreaFilled(false);
        practicante.setOpaque(false);
        practicante.addActionListener(e -> {
            
            advertencia.setText("* tu cuenta tendra 1 tiro extra pero recibira 1 punto por victoria");
            advertencia.setVisible (true);
        });

        

       
        grupoTipoCuenta = new ButtonGroup();
        grupoTipoCuenta.add(Normal);
        grupoTipoCuenta.add(practicante);
        
        Normal.setSelected(true);

        panelradio.add(Normal);
        panelradio.add(practicante);
        
        JLabel Jtipo = new JLabel("Tipo de usuario");

        Jtipo.setFont(new Font("Arial", Font.BOLD, 16));
        
        advertencia = new JLabel("  ");

        advertencia .setFont(new Font("Arial", Font.BOLD, 9));
        advertencia .setForeground(Color.red);
        advertencia .setOpaque(false);

        advertencia .setHorizontalAlignment(SwingConstants.CENTER);
        advertencia .setPreferredSize(new Dimension(150, 30));
        advertencia.setVisible (false);
        
        
        JPanel paneltipo = new JPanel();
        
        paneltipo.setOpaque(false);
        paneltipo.setLayout(new GridLayout(3, 1, 0, 0));
        paneltipo.setPreferredSize( new Dimension (330, 60));
        
        paneltipo.add(Jtipo);
        Jtipo.setHorizontalAlignment(SwingConstants.LEFT);
       
        paneltipo.add(panelradio);
        paneltipo.add(advertencia);
        panelLogin.add(paneltipo);
        
        
        


     

        JButton btnIngresar = new JButton("Ingresar");

        btnIngresar.setFont(new Font("Arial", Font.BOLD, 15));

        btnIngresar.setBackground(new Color(52,152,219));

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusable(false);

        btnIngresar.addActionListener(e -> {
             nombre = user.getText();
             nombre = nombre.trim();
            
            int compU = ComprobarU();
            int compC = ComprobarC();
            
            
                    
            if (compU==2 && compC==2){
                
                if (practicante.isSelected()){
                    principiante print = new principiante(this);
                }
                else{
                    
                    Seguir();
                    
                }
            }
            else{
                if (compU==0 && compC ==0){
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
        label.setOpaque(false);
        panelLogin.add(label);
        

        panelLogin.add(btnIngresar);
        panelLogin.setOpaque(false);
        
        Panelenvuelto.add(panelLogin);


        

        add(Panelenvuelto, BorderLayout.CENTER);
    }
    
    
    private int ComprobarC(){
        
        if (contra.getPassword().length ==0){
            label.setText("Ingrese contraseña");
            return 0;
            
            
            
        }else if (contra.getPassword().length != 5){
            label.setText("Debe tener 5 digitos");
            return 1;
        }
            
        else{
            return 2;
        }
            

       
    }
    private int ComprobarU(){
        
        if (nombre.length() ==0){
            label.setText("Ingrese usuario");
            return 0;
            
       } else if (isusuarioexistente (0)){
           
           label.setText("Usuario existente");
            return 1;
        
    }
            
        else{
            return 2;
        }
            

       
    }
    
    private boolean isusuarioexistente (int index){
        if (Globales.jugadores.size()> index){
            
        
            
            if (nombre. equals (Globales.jugadores.get(index).getUser())){
                return true;
            }else{
                return isusuarioexistente(index+1);
            }
            
            
        }
        else
        {
            return false;
                   
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
    
    public void Seguir(){
        
        if (practicante.isSelected()){
             Globales.jugadores.add(new jugador (nombre,contra.getPassword(),2));
            
        }else{
            Globales.jugadores.add(new jugador (nombre, contra.getPassword(), 1));
        }

                    
        Perfil j = new Perfil(Globales.jugadores.getLast(), Globales.jugadores.size()-1);
        j.setVisible(true);
        this.dispose();
    }
}
