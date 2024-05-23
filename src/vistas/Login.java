package vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controlador.ControladorEventos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_1;
	private JButton btnValidar;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/RESTECHWIndow(1).jpg")));
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(54,217,187));
		frame.getContentPane().setForeground(new Color(56, 61, 67));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(293, 207, 215, 38);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 35));
		lblNewLabel.setBounds(137, 214, 146, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("CÓDIGO");
		lblContrasea.setForeground(new Color(0,0,0));
		lblContrasea.setFont(new Font("DialogInput", Font.BOLD, 35));
		lblContrasea.setBounds(153, 280, 130, 31);
		frame.getContentPane().add(lblContrasea);
		
		lblNewLabel_1 = new JLabel("Bienvenido");
		
		lblNewLabel_1.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 73));
		lblNewLabel_1.setBounds(129, 72, 481, 82);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValidar.setBackground(new Color(255, 255, 255));
		btnValidar.setFont(new Font("Lucida Sans", Font.BOLD, 50));
		btnValidar.setBounds(183, 358, 376, 69);
		frame.getContentPane().add(btnValidar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(293, 273, 215, 38);
		frame.getContentPane().add(passwordField);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/imagenes/RESTECH_ImageICono.jpeg")));
		lblNewLabel_2.setBounds(253, 450, 250, 239);
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}

	
	//Getter and Setter

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}



	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBtnValidar() {
		return btnValidar;
	}

	public void setBtnValidar(JButton btnValidar) {
		this.btnValidar = btnValidar;
	}
		public void inciarListener(ControladorEventos controlador) {
			btnValidar.addActionListener(controlador);
		
	}
	}