/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class cambioC extends JDialog {
   
    private JPasswordField contra1;
    private JPasswordField contraV;
    private JPasswordField Ncontra;
    private JCheckBox Mcontra;
    private JCheckBox McontraV;
    private JCheckBox MNcontra;
    private JPanel panel;
    private JButton boton;
    private JLabel label;
    private Timer tempo;
   

    public cambioC(JFrame Perfil, jugador user) {
        super(Perfil, "Cambio de Contraseña", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondos/fondoRollo.jpeg"));
        Image Escalada = imagen.getImage().getScaledInstance(500,500 , Image.SCALE_SMOOTH);
        imagen = new ImageIcon(Escalada);
        JLabel fondo = new JLabel(imagen);
        setContentPane(fondo);
        fondo.setLayout(new BorderLayout());
      

        inicializarTimer();
        inicializarbotones(user);
   

        pack();
        setLocationRelativeTo(Perfil);
    }

    public void inicializarTimer() {
        tempo = new Timer(2100, ev -> {
            label.setText(" ");
            tempo.stop();
        });
    }

    private void mostrarMensaje(String texto) {
        label.setText(texto);
        
        if (tempo.isRunning()) {
            tempo.stop();
        }
        tempo.start();
    }

    public void inicializarbotones(jugador user) {
        setLayout(new BorderLayout(10, 10));

        label = new JLabel(" ");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(false);
        add(label, BorderLayout.NORTH);

        panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel l1 = new JLabel("Contraseña actual:");
        JLabel l2 = new JLabel("Nueva contraseña:");
        JLabel l3 = new JLabel("Repita nueva contraseña:");

        contra1 = new JPasswordField(15);
        Ncontra = new JPasswordField(15);
        contraV = new JPasswordField(15);

        Mcontra = new JCheckBox("Mostrar");
        MNcontra = new JCheckBox("Mostrar");
        McontraV = new JCheckBox("Mostrar");

        Mcontra.setOpaque(false);
        MNcontra.setOpaque(false);
        McontraV.setOpaque(false);

        Mcontra.addActionListener(e -> contra1.setEchoChar(Mcontra.isSelected() ? (char) 0 : '•'));
        MNcontra.addActionListener(e -> Ncontra.setEchoChar(MNcontra.isSelected() ? (char) 0 : '•'));
        McontraV.addActionListener(e -> contraV.setEchoChar(McontraV.isSelected() ? (char) 0 : '•'));

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(l1, gbc);
        gbc.gridy = 1;
        panel.add(contra1, gbc);
        gbc.gridy = 2;
        panel.add(Mcontra, gbc);

        gbc.gridy = 3;
        panel.add(l2, gbc);
        gbc.gridy = 4;
        panel.add(Ncontra, gbc);
        gbc.gridy = 5;
        panel.add(MNcontra, gbc);

        gbc.gridy = 6;
        panel.add(l3, gbc);
        gbc.gridy = 7;
        panel.add(contraV, gbc);
        gbc.gridy = 8;
        panel.add(McontraV, gbc);

        add(panel, BorderLayout.CENTER);

        boton = new JButton("Cambiar");
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.RED);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {
            char[] actual = contra1.getPassword();
            char[] nueva = Ncontra.getPassword();
            char[] repetir = contraV.getPassword();

            if (actual.length == 0 && nueva.length == 0 && repetir.length == 0) {
                mostrarMensaje("Ingrese todas las contraseñas");
            } else if (actual.length == 0) {
                mostrarMensaje("Ingrese la contraseña actual");
            } else if (nueva.length == 0) {
                mostrarMensaje("Ingrese la nueva contraseña");
            } else if (repetir.length == 0) {
                mostrarMensaje("Repita la nueva contraseña");
            } else if (!Arrays.equals(actual, user.getPassword())) {
                mostrarMensaje("La contraseña actual no es correcta");
            } else if (nueva.length != 5 || repetir.length != 5) {
                mostrarMensaje("La contraseña necesita 5 dígitos");
            } else if (!Arrays.equals(nueva, repetir)) {
                mostrarMensaje("Las nuevas contraseñas no coinciden");
            } else {
                user.setPassword(nueva);
                JOptionPane.showMessageDialog(
                    this,
                    "Contraseña cambiada exitosamente",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE
                );
                dispose();
            }
        });

        JPanel sur = new JPanel();
        sur.setOpaque(false);
        sur.add(boton);
        add(sur, BorderLayout.SOUTH);
    }
    
   
  
}