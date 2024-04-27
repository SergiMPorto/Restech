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
	 private JButton btnAlmacen;
	    private JButton btnPlatos;
	    private JButton btnPedido;
	    private JButton btnUsuario;
	    private JButton btnProveedor;

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
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel.setBounds(307, 33, 187, 46);
		frmMen.getContentPane().add(lblNewLabel);
		
		btnAlmacen = new JButton("Producto");
		btnAlmacen.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Almacen (1).jpeg")));
		btnAlmacen.setToolTipText("Producto");
		ImageIcon icon = new ImageIcon("D:\\Restech\\Imagenes\\Almacen.jpeg");
		Image image = icon.getImage();
		ImageIcon iconoEscalado = new ImageIcon(image);
		btnAlmacen.setText("Almacen");
		btnAlmacen.setForeground(new Color(0, 0, 0));
		btnAlmacen.setBackground(new Color(128, 128, 128));
		btnAlmacen.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnAlmacen.setBounds(80, 68, 150, 150);
		frmMen.getContentPane().add(btnAlmacen);
		
		btnPlatos = new JButton("Platos");
		btnPlatos.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Plato.jpeg")));
		btnPlatos.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnPlatos.setBounds(492, 68, 150, 150);
		frmMen.getContentPane().add(btnPlatos);

		btnPedido = new JButton("Pedido");
		btnPedido.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Provedores.jpeg")));
		btnPedido.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnPedido.setBounds(80, 477, 150, 150);
		frmMen.getContentPane().add(btnPedido);

		btnUsuario = new JButton("Usuario");
		btnUsuario.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Personal.jpeg")));
		btnUsuario.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnUsuario.setBounds(492, 477, 150, 150);
		frmMen.getContentPane().add(btnUsuario);
		
	    btnProveedor = new JButton("Proveedor");
		btnProveedor.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnProveedor.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Proveedores.jpg")));
		btnProveedor.setBounds(271, 247, 150, 150);
		frmMen.getContentPane().add(btnProveedor);

		
		JLabel lblPlato = new JLabel("PLATO");
		lblPlato.setForeground(SystemColor.textHighlightText);
		lblPlato.setBounds(492, 247, 164, 39);
		lblPlato.setFont(new Font("Forte", Font.PLAIN, 30));
		frmMen.getContentPane().add(lblPlato);
		
		JLabel lblProveedor = new JLabel("PEDIDO");
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
		
		JLabel lblProveedores = new JLabel("PROVEEDORES");
		lblProveedores.setForeground(SystemColor.textHighlightText);
		lblProveedores.setFont(new Font("Forte", Font.PLAIN, 30));
		lblProveedores.setBounds(246, 407, 211, 39);
		frmMen.getContentPane().add(lblProveedores);
		
		
	}
		
	
	 public void agregarListener(ControladorEventos controlador) {
	        btnAlmacen.addActionListener(controlador);
	        btnPlatos.addActionListener(controlador);
	        btnPedido.addActionListener(controlador);
	        btnUsuario.addActionListener(controlador);
	    }

	public void setVisible(boolean b) {
		frmMen.setVisible(b);
		
	}

	public JFrame getFrmMen() {
		return frmMen;
	}

	public void setFrmMen(JFrame frmMen) {
		this.frmMen = frmMen;
	}



	
	//Getter and Setter
	
	public JButton getBtnProveedor() {
		return btnProveedor;
	}
	
	


	public void setBtnProveedor(JButton btnProveedor) {
		this.btnProveedor = btnProveedor;
	}

	public JButton getBtnPlatos() {
		return btnPlatos;
	}

	public JButton getBtnAlmacen() {
		return btnAlmacen;
	}

	public void setBtnAlmacen(JButton btnAlmacen) {
		this.btnAlmacen = btnAlmacen;
	}

	public void setBtnPlatos(JButton btnPlatos) {
		this.btnPlatos = btnPlatos;
	}

	public JButton getBtnPedido() {
		return btnPedido;
	}

	public void setBtnPedido(JButton btnPedido) {
		this.btnPedido = btnPedido;
	}

	public JButton getBtnUsuario() {
		return btnUsuario;
	}

	public void setBtnUsuario(JButton btnUsuario) {
		this.btnUsuario = btnUsuario;

	}
	
	

	
	public void iniciarListener(ControladorEventos controlador) {
		btnPedido.addActionListener(controlador);
		btnAlmacen.addActionListener(controlador);
		btnPlatos.addActionListener(controlador);
		btnUsuario.addActionListener(controlador);
		btnProveedor.addActionListener(controlador);
	}
}

	
	
	




