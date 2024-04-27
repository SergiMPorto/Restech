package vistas;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JFrame;

public class VentanaUsuario {

	private JFrame frmUsuario;
	private JTextField textNombre;
	private JButton btnCancelar;
	private JButton btnBorrar;
	private JLabel lblNewLabel_3;
	private JTextField Permiso;
	private JLabel lblPermiso;
	private JButton btnGuardar;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario window = new VentanaUsuario();
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
	public VentanaUsuario() {
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
		
	    btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(Color.GRAY);
		btnGuardar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setBounds(249, 630, 150, 27);
		frmUsuario.getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnCancelar.setBounds(409, 630, 150, 27);
		frmUsuario.getContentPane().add(btnCancelar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBackground(Color.GRAY);
		btnBorrar.setForeground(new Color(0, 0, 0));
		btnBorrar.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		btnBorrar.setBounds(570, 630, 150, 27);
		frmUsuario.getContentPane().add(btnBorrar);
		
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
	

	public void setVisible(boolean b) {
		frmUsuario.setVisible(b);
		
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JFrame getFrmUsuario() {
		return frmUsuario;
	}

	public void setFrmUsuario(JFrame frmUsuario) {
		this.frmUsuario = frmUsuario;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}

	public JTextField getPermiso() {
		return Permiso;
	}

	public void setPermiso(JTextField permiso) {
		Permiso = permiso;
	}

	public JLabel getLblPermiso() {
		return lblPermiso;
	}

	public void setLblPermiso(JLabel lblPermiso) {
		this.lblPermiso = lblPermiso;
	}
	
	
}