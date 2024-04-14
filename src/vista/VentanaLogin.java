package vista;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorEventos;

public class VentanaLogin extends JFrame{
	
	private JLabel usuario, password;
	private JTextField cajaTextoNombre, cajaTextoTelefono;
	private JButton botonA1;
	
	public VentanaLogin(){
		
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("RESTECH");
		setLayout(null);
		inicializarComponentes();
		setVisible(true);
	}
	
	private void inicializarComponentes() {
		
	usuario = new JLabel("Usuario:");
	usuario.setBounds(400,100, 250, 50);
	add(usuario);
	
	
	password = new JLabel("Password:");
	password.setBounds(400,200,250,50);
	add(password);
	
	cajaTextoNombre = new JTextField();
	cajaTextoNombre.setBounds(400,150,150,30);
	add(cajaTextoNombre);
	
	cajaTextoTelefono = new JTextField();
	cajaTextoTelefono.setBounds(400,250,150,30);
	add(cajaTextoTelefono);
	
	botonA1 = new JButton("Validar");
	botonA1.setBounds(400,330,150,30);
	add(botonA1);
		
	}
	
	//Getter and Setter
	
	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JTextField getCajaTextoNombre() {
		return cajaTextoNombre;
	}

	public void setCajaTextoNombre(JTextField cajaTextoNombre) {
		this.cajaTextoNombre = cajaTextoNombre;
	}

	public JTextField getCajaTextoTelefono() {
		return cajaTextoTelefono;
	}

	public void setCajaTextoTelefono(JTextField cajaTextoTelefono) {
		this.cajaTextoTelefono = cajaTextoTelefono;
	}

	public JButton getBotonA1() {
		return botonA1;
	}

	public void setBotonA1(JButton botonA1) {
		this.botonA1 = botonA1;
	}

	public void iniciarListener(ControladorEventos controlador) {
		
		botonA1.addActionListener(controlador);
}
}

