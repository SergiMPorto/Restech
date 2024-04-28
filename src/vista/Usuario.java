package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Usuario {
	
	private JFrame frmUsuario;
	private JTextField textNombre;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JTextField Permiso;
	private JLabel lblPermiso;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario window = new Usuario();
					window.frmUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Usuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUsuario= new JFrame();
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Restech\\Imagenes\\RESTECHVENTANA.jpg"));
		frmUsuario.getContentPane().setBackground(new Color(56, 61, 67));
		frmUsuario.getContentPane().setForeground(new Color(56, 61, 67));
		frmUsuario.setForeground(new Color(102, 153, 204));
		frmUsuario.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 18));
		frmUsuario.setTitle("PLATO");
		frmUsuario.setBounds(750, 50, 750, 750);
		frmUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		
		JLabel Nombre = new JLabel("NOMBRE");
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setForeground(new Color(128, 128, 128));
		Nombre.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		Nombre.setBounds(184, 134, 117, 27);
		frmUsuario.getContentPane().add(Nombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(314, 137, 400, 27);
		frmUsuario.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		Nombre.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(Color.GRAY);
		btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setBounds(249, 630, 150, 27);
		frmUsuario.getContentPane().add(btnGuardar);
		
		btnNewButton = new JButton("CANCELAR");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnNewButton.setBounds(409, 630, 150, 27);
		frmUsuario.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("BORRAR");
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnNewButton_1.setBounds(570, 630, 150, 27);
		frmUsuario.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("USUARIO");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_3.setBounds(320, 53, 462, 47);
		frmUsuario.getContentPane().add(lblNewLabel_3);
		
		Permiso = new JTextField();
		Permiso.setColumns(10);
		Permiso.setBounds(314, 227, 55, 27);
		frmUsuario.getContentPane().add(Permiso);
		
		lblPermiso = new JLabel("PERMISO");
		lblPermiso.setForeground(Color.GRAY);
		lblPermiso.setFont(new Font("Lucida Sans", Font.BOLD, 18));
		lblPermiso.setBounds(211, 227, 90, 27);
		frmUsuario.getContentPane().add(lblPermiso);
		
	}
   // Getter and Setter
	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}


	public void setVisible(boolean b) {
		frmUsuario.setVisible(b);
		
	}
	
	
}
