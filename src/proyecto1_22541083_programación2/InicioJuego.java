/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_22541083_programación2;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InicioJuego extends JDialog {

    private JPanel panelt;
    private JPanel panell;
    private JScrollPane scroll;
    private JLabel label;
    private JMenuBar barra;
    private JButton botonb;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JButton iniciar;
    private JLabel labelE;
    private JLabel labelnoJ;

    private Timer tempo;
    private JPanel panelIniciar;

    public InicioJuego(JFrame perfil, jugador user) {

        super(perfil, "Selección", true);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        Inicializartabla();
        Inicializarlabel();
        Inicializarbarra();
        InicializarBoton(user, perfil);
        inicializarTimer();

        ValoresTabla(user);
        actualizarMensajeJugadores();

        JPanel panelP = new JPanel();
        panelP.setLayout(new BorderLayout());
        panelP.setOpaque(false);

        panelP.add(panell, BorderLayout.NORTH);
        panelP.add(panelt, BorderLayout.CENTER);
        panelP.add(panelIniciar, BorderLayout.SOUTH);

        add(panelP, BorderLayout.CENTER);

        setLocationRelativeTo(perfil);
    }

    private void ValoresTabla(jugador user) {
        jugador[] Vtablas = Globales.historialJugadores.toArray(new jugador[0]);

        for (int i = 0; i < Vtablas.length - 1; i++) {
            for (int y = 0; y < Vtablas.length - 1; y++) {
                if (Vtablas[y].getPuntos() < Vtablas[y + 1].getPuntos()) {
                    jugador temporal = Vtablas[y];
                    Vtablas[y] = Vtablas[y + 1];
                    Vtablas[y + 1] = temporal;
                }
            }
        }

        InsertarTabla(Vtablas, 0, user);
    }

    private int InsertarTabla(jugador[] Vtablas, int index, jugador user) {
        if (index < Vtablas.length) {
            if (!Vtablas[index].getUser().equals(user.getUser())) {
                modelo.addRow(new Object[]{Vtablas[index].getUser()});
            }
            return InsertarTabla(Vtablas, index + 1, user);
        }
        return 0;
    }

    private void actualizarMensajeJugadores() {
        if (modelo.getRowCount() == 0) {
            labelnoJ.setText("No hay jugadores para empezar");
            iniciar.setEnabled(false);
        } else {
            labelnoJ.setText(" ");
            iniciar.setEnabled(true);
        }
    }

    private void InicializarBoton(jugador user, JFrame perfil) {

        panelIniciar = new JPanel();
        panelIniciar.setLayout(new BoxLayout(panelIniciar, BoxLayout.Y_AXIS));
        panelIniciar.setOpaque(false);
        panelIniciar.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 10));

        iniciar = new JButton("Iniciar");
        iniciar.setFont(new Font("Arial", Font.BOLD, 14));
        iniciar.setPreferredSize(new Dimension(120, 35));
        iniciar.setMaximumSize(new Dimension(120, 35));
        iniciar.setForeground(Color.WHITE);
        iniciar.setBackground(Color.RED);
        iniciar.setFocusPainted(false);
        iniciar.setBorderPainted(false);
        iniciar.setContentAreaFilled(false);
        iniciar.setOpaque(true);
        iniciar.setAlignmentX(Component.CENTER_ALIGNMENT);

        iniciar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                labelE.setText("Seleccione un segundo jugador");
                tempo.start();
            } else {
                jugador user2 = null;

                String texto = String.valueOf(tabla.getValueAt(fila, 0));

                for (int i = 0; i < Globales.jugadores.size(); i++) {
                    if (Globales.jugadores.get(i).getUser().equals(texto)) {
                        user2 = Globales.jugadores.get(i);
                        break;
                    }
                }

                if (user2 != null) {
                    juego j = new juego(user, user2);
                    j.setVisible(true);
                    perfil.dispose();
                    this.dispose();
                }
            }
        });

        labelE = new JLabel(" ");
        labelE.setFont(new Font("Arial", Font.BOLD, 14));
        labelE.setForeground(Color.RED);
        labelE.setOpaque(false);
        labelE.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelIniciar.add(iniciar);
        panelIniciar.add(Box.createVerticalStrut(8));
        panelIniciar.add(labelE);
    }

    public void inicializarTimer() {
        tempo = new Timer(2100, ev -> {
            labelE.setText(" ");
            repaint();
            tempo.stop();
        });
    }

    public void Inicializartabla() {
        panelt = new JPanel(new BorderLayout());
        panelt.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelt.setOpaque(false);

        modelo = new DefaultTableModel(new String[]{"Usuarios activos"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 20));
        tabla.setRowHeight(24);
        tabla.setGridColor(Color.GRAY);
        tabla.setBackground(Color.WHITE);
        tabla.setForeground(Color.BLACK);
        tabla.setSelectionBackground(Color.BLUE);
        tabla.setSelectionForeground(Color.WHITE);

        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(false);
        tabla.setCellSelectionEnabled(false);
        tabla.setFillsViewportHeight(true);

        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabla.getTableHeader().setBackground(Color.RED);
        tabla.getTableHeader().setForeground(Color.WHITE);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(centrado);

        DefaultTableCellRenderer headerRenderer =
                (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        scroll = new JScrollPane(tabla);
        panelt.add(scroll, BorderLayout.CENTER);
    }

    public void Inicializarlabel() {
        panell = new JPanel();
        panell.setLayout(new BoxLayout(panell, BoxLayout.Y_AXIS));
        panell.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
        panell.setOpaque(false);

        label = new JLabel("Seleccione segundo jugador");
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(Color.BLACK);
        label.setOpaque(false);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelnoJ = new JLabel(" ");
        labelnoJ.setFont(new Font("Arial", Font.BOLD, 15));
        labelnoJ.setForeground(Color.RED);
        labelnoJ.setOpaque(false);
        labelnoJ.setAlignmentX(Component.CENTER_ALIGNMENT);

        panell.add(label);
        panell.add(Box.createVerticalStrut(5));
        panell.add(labelnoJ);
    }

    public void Inicializarbarra() {
        barra = new JMenuBar();
        barra.setBorderPainted(false);
        barra.setMargin(new Insets(5, 5, 5, 5));
        barra.setBackground(Color.RED);
        barra.setForeground(Color.WHITE);
        barra.setFont(new Font("Arial", Font.BOLD, 14));
        barra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        botonb = new JButton("Regresar");
        botonb.setFont(new Font("Arial", Font.BOLD, 15));
        botonb.setBackground(Color.RED);
        botonb.setForeground(Color.WHITE);
        botonb.setFocusable(false);
        botonb.setBorderPainted(false);

        botonb.addActionListener(e -> this.dispose());

        barra.add(botonb);
        add(barra, BorderLayout.NORTH);
    }
}
