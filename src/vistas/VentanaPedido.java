package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaPedido {

    private JFrame frmPedido;
    private JButton btnGuardar;
    private JButton btnNewButton;
    private JTextField textFecha;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPedido window = new VentanaPedido();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public VentanaPedido() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmPedido = new JFrame();
        frmPedido.setTitle("Pedido");
        frmPedido.getContentPane().setBackground(new Color(56, 61, 67));
        frmPedido.getContentPane().setForeground(new Color(56, 61, 67));
        frmPedido.setBounds(730, 50, 750, 750);
        frmPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmPedido.getContentPane().setLayout(null);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(Color.GRAY);
        btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnGuardar.setBounds(460, 657, 100, 30);
        frmPedido.getContentPane().add(btnGuardar);
        
        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setForeground(new Color(128, 128, 128));
        lblFecha.setFont(new Font("Forte", Font.PLAIN, 20));
        lblFecha.setBounds(418, 41, 133, 39);
        frmPedido.getContentPane().add(lblFecha);
        
        textFecha = new JTextField();
        textFecha.setToolTipText("Proveedor");
        textFecha.setHorizontalAlignment(SwingConstants.CENTER);
        textFecha.setColumns(10);
        textFecha.setBounds(477, 47, 171, 27);
        frmPedido.getContentPane().add(textFecha);
        
        btnNewButton = new JButton("Borrar");
        btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 15));
        btnNewButton.setBounds(570, 657, 100, 30);
        frmPedido.getContentPane().add(btnNewButton);
    }

    public void setVisible(boolean b) {
        frmPedido.setVisible(b);
    }
}
