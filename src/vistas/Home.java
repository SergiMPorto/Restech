package vistas;

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
		frmMen.setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
		frmMen.getContentPane().setBackground(new Color(54,217,187));
		frmMen.getContentPane().setForeground(new Color(56, 61, 67));
		frmMen.setBounds(100, 100, 750, 750);
		frmMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMen.getContentPane().setLayout(null);
		frmMen.setResizable(false);
		
	    Color startColor = new Color(54, 217, 187);
        Color endColor = new Color(220, 234, 242);
        JPanel mainPanel = new Gradiel(startColor, endColor);
        mainPanel.setLayout(null);
        frmMen.setContentPane(mainPanel);
		JLabel lblNewLabel = new JLabel("Menú");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 49));
		lblNewLabel.setBounds(307, 33, 132, 46);
		frmMen.getContentPane().add(lblNewLabel);
		
		btnAlmacen = new JButton("Producto");
		btnAlmacen.setIcon(new ImageIcon(Home.class.getResource("/imagenes/almacen .jpg")));
		btnAlmacen.setToolTipText("Producto");
		ImageIcon icon = new ImageIcon("D:\\Restech\\Imagenes\\Almacen.jpeg");
		Image image = icon.getImage();
		ImageIcon iconoEscalado = new ImageIcon(image);
		btnAlmacen.setText("");
		btnAlmacen.setForeground(new Color(0, 0, 0));
		btnAlmacen.setBackground(new Color(128, 128, 128));
		btnAlmacen.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnAlmacen.setBounds(80, 68, 150, 150);
		frmMen.getContentPane().add(btnAlmacen);
		
		btnPlatos = new JButton("");
		btnPlatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlatos.setIcon(new ImageIcon(Home.class.getResource("/imagenes/NuevoPlato (1).jpg")));
		btnPlatos.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnPlatos.setBounds(492, 68, 150, 150);
		frmMen.getContentPane().add(btnPlatos);

		btnPedido = new JButton("");
		btnPedido.setIcon(new ImageIcon(Home.class.getResource("/imagenes/Pedidos(1).jpg")));
		btnPedido.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnPedido.setBounds(80, 477, 150, 150);
		frmMen.getContentPane().add(btnPedido);

		btnUsuario = new JButton("");
		btnUsuario.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Personal.jpeg")));
		btnUsuario.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnUsuario.setBounds(492, 477, 150, 150);
		frmMen.getContentPane().add(btnUsuario);
		
	    btnProveedor = new JButton("");
		btnProveedor.setFont(new Font("Lucida Sans", Font.BOLD, 30));
		btnProveedor.setIcon(new ImageIcon(Home.class.getResource("/imagenes/Proveedores(1).jpg")));
		btnProveedor.setBounds(271, 247, 150, 150);
		frmMen.getContentPane().add(btnProveedor);

		
		JLabel lblPlato = new JLabel("PLATO");
		lblPlato.setBackground(new Color(0, 0, 0));
		lblPlato.setForeground(new Color(0, 0, 0));
		lblPlato.setBounds(519, 228, 109, 39);
		lblPlato.setFont(new Font("DialogInput", Font.BOLD, 35));
		frmMen.getContentPane().add(lblPlato);
		
		JLabel lblProveedor = new JLabel("PEDIDO");
		lblProveedor.setForeground(new Color(0, 0, 0));
		lblProveedor.setBounds(87, 637, 143, 39);
		lblProveedor.setFont(new Font("DialogInput", Font.BOLD, 35));
		frmMen.getContentPane().add(lblProveedor);
		
		JLabel lblAlmacen = new JLabel("ALMACEN");
		lblAlmacen.setForeground(new Color(0, 0, 0));
		lblAlmacen.setBounds(80, 228, 150, 39);
		lblAlmacen.setFont(new Font("DialogInput", Font.BOLD, 35));
		frmMen.getContentPane().add(lblAlmacen);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setBounds(492, 637, 150, 39);
		lblUsuario.setFont(new Font("DialogInput", Font.BOLD, 35));
		frmMen.getContentPane().add(lblUsuario);
		
		JLabel lblProveedores = new JLabel("PROVEEDORES");
		lblProveedores.setForeground(new Color(0, 0, 0));
		lblProveedores.setFont(new Font("DialogInput", Font.BOLD, 35));
		lblProveedores.setBounds(238, 407, 234, 39);
		frmMen.getContentPane().add(lblProveedores);
		
		
	}
		
	
	 public void agregarListener(ControladorEventos controlador) {
	        btnAlmacen.addActionListener(controlador);
	        btnPlatos.addActionListener(controlador);
	        btnPedido.addActionListener(controlador);
	        btnUsuario.addActionListener(controlador);
	        btnProveedor.addActionListener(controlador);
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

	
	
	