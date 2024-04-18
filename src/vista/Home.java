package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;

import controlador.ControladorEventos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class Home {

	private JFrame frmMen;
	 private JButton btnProducto;
	    private JButton btnPlatos;
	    private JButton btnProveedores;
	    private JButton btnUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmMen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMen = new JFrame();
		frmMen.setTitle("Menú");
		frmMen.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Restech\\Imagenes\\RESTECHVENTANA.jpg"));
		frmMen.getContentPane().setBackground(new Color(56, 61, 67));
		frmMen.getContentPane().setForeground(new Color(56, 61, 67));
		frmMen.setBounds(100, 100, 750, 750);
		frmMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú");
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Forte", Font.ITALIC, 41));
		lblNewLabel.setBounds(295, 31, 187, 46);
		frmMen.getContentPane().add(lblNewLabel);
		
		JButton btnProducto = new JButton("Producto");
		btnProducto.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Almacen (1).jpeg")));
		btnProducto.setToolTipText("Producto");
		
	
		ImageIcon icon = new ImageIcon("D:\\Restech\\Imagenes\\Almacen.jpeg");
		Image image = icon.getImage().getScaledInstance(btnProducto.getWidth(), btnProducto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(image);
		btnProducto.setText("Producto");
		btnProducto.setForeground(new Color(0, 0, 0));
		btnProducto.setBackground(new Color(128, 128, 128));
		btnProducto.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnProducto.setBounds(80, 68, 150, 150);
		frmMen.getContentPane().add(btnProducto);
		
		JButton btnNewButton = new JButton("Platos");
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Plato.jpeg")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnNewButton.setBounds(492, 68, 150, 150);
		frmMen.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Provedores ");
		btnNewButton_1.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Provedores.jpeg")));
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnNewButton_1.setBounds(80, 477, 150, 150);
		frmMen.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Usuario");
		btnNewButton_2.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Personal.jpeg")));
		btnNewButton_2.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnNewButton_2.setBounds(492, 477, 150, 150);
		frmMen.getContentPane().add(btnNewButton_2);
		
		JLabel lblPlato = new JLabel("PLATO");
		lblPlato.setForeground(SystemColor.textHighlightText);
		lblPlato.setBounds(492, 247, 164, 39);
		lblPlato.setFont(new Font("Forte", Font.PLAIN, 30));
		frmMen.getContentPane().add(lblPlato);
		
		JLabel lblProveedor = new JLabel("PROVEEDOR");
		lblProveedor.setForeground(SystemColor.textHighlightText);
		lblProveedor.setBounds(66, 650, 198, 39);
		lblProveedor.setFont(new Font("Forte", Font.PLAIN, 30));
		frmMen.getContentPane().add(lblProveedor);
		
		JLabel lblAlmacen = new JLabel("ALMACEN");
		lblAlmacen.setForeground(SystemColor.textHighlightText);
		lblAlmacen.setBounds(66, 247, 164, 39);
		lblAlmacen.setFont(new Font("Forte", Font.PLAIN, 30));
		frmMen.getContentPane().add(lblAlmacen);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(SystemColor.textHighlightText);
		lblUsuario.setBounds(478, 650, 164, 39);
		lblUsuario.setFont(new Font("Forte", Font.PLAIN, 30));
		frmMen.getContentPane().add(lblUsuario);
	}
		
	
	 public void agregarListener(ControladorEventos controlador) {
	        btnProducto.addActionListener(controlador);
	        btnPlatos.addActionListener(controlador);
	        btnProveedores.addActionListener(controlador);
	        btnUsuario.addActionListener(controlador);
	    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public Object getBotonAltaProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	}

	
	
	




