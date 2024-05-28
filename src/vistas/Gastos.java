package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Gastos {

	private JFrame frameGastos;
	private JLabel titulo;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gastos window = new Gastos();
					window.frameGastos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gastos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameGastos = new JFrame();
	    frameGastos.setBackground(Color.WHITE);
	    frameGastos.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPedido.class.getResource("/imagenes/RESTECHVENTANA.jpg")));
	    frameGastos.setTitle("Gastos");
	    frameGastos.getContentPane().setBackground(new Color(54,217,187));
	    frameGastos.getContentPane().setForeground(new Color(54,217,187));
	    frameGastos.setBounds(730, 50, 750, 750);
	    frameGastos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frameGastos.getContentPane().setLayout(null);
	    frameGastos.setResizable(false);

	    JLabel lblNewLabel_3 = new JLabel("Gastos");
        lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 49));
        lblNewLabel_3.setBounds(277, 38, 178, 63);
        frameGastos.getContentPane().add(lblNewLabel_3);
	
	 titulo = new JLabel("New label");
     titulo.setIcon(new ImageIcon(VentanaPedido.class.getResource("/imagenes/RESTECH_ImageICono (1).jpeg")));
     titulo.setBounds(661, 0, 75, 75);
     frameGastos.getContentPane().add(titulo);
     
     JButton btnBorrar = new JButton("Borrar");
     btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
     btnBorrar.setBounds(607, 673, 100, 30);
     frameGastos.getContentPane().add(btnBorrar);
     
     JButton btnBuscar = new JButton("Buscar");
     btnBuscar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
     btnBuscar.setBounds(497, 673, 100, 30);
     frameGastos.getContentPane().add(btnBuscar);
     
     table = new JTable();
     table.setBounds(10, 171, 716, 492);
     frameGastos.getContentPane().add(table);
     
     textField = new JTextField();
     textField.setBounds(88, 111, 619, 30);
     frameGastos.getContentPane().add(textField);
     textField.setColumns(10);
}

	public void setVisible(boolean b) {
		frameGastos.setVisible(b);
		
	}
}
