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
public class login extends JFrame{
    private JLabel texto1;
    private JLabel texto2;
    private JPasswordField contra;
    private JTextField user;
    private JPanel panel;
    
    public login (){
        setTitle ("login");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);
        Inicializarbotones();
       
        
        setLocationRelativeTo(null);
        setVisible(true);
        

        
        
        
        
        
       
        
        
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


        

        JTextField txtUsuario = new JTextField();

        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 15));

        panelLogin.add(txtUsuario);


        

        JLabel lblPassword = new JLabel("Contraseña");

        lblPassword.setFont(new Font("Arial", Font.BOLD, 16));

        panelLogin.add(lblPassword);


        

        JPasswordField txtPassword = new JPasswordField();

        txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));

        panelLogin.add(txtPassword);


        

        JCheckBox chkMostrar = new JCheckBox("Mostrar contraseña");

        chkMostrar.setBackground(Color.WHITE);

        chkMostrar.setFocusable(false);

        chkMostrar.addActionListener(e -> {

            if(chkMostrar.isSelected()){
                txtPassword.setEchoChar((char)0);   
            }else{
                txtPassword.setEchoChar('•');       
                
            }

        });

        panelLogin.add(chkMostrar);


     

        JButton btnIngresar = new JButton("Ingresar");

        btnIngresar.setFont(new Font("Arial", Font.BOLD, 15));

        btnIngresar.setBackground(new Color(52,152,219));

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusable(false);

        btnIngresar.addActionListener(e -> {

            Perfil j = new Perfil();
                j.setVisible(true);

        });

        panelLogin.add(btnIngresar);
        
        Panelenvuelto.add(panelLogin);


        

        add(Panelenvuelto, BorderLayout.CENTER);
    }
}
    
       
    
            