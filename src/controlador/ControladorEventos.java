package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Home
import vista.VentanaAltaProducto;
import vista.VentanaLogin;


public class ControladorEventos implements ActionListener{
	
	private VentanaLogin ventanaLogin;
	private Home menu;
	private VentanaAltaProducto ventanaAltaProducto;

	
	

	public ControladorEventos ( VentanaLogin ventanalogin) {
		this.ventanaLogin = new VentanaLogin();
		this.menu = new Menu();
		this.ventanaAltaProducto = new VentanaAltaProducto();
		
		
	menu.iniciarListener(this);
	ventanaLogin.iniciarListener(this);
	ventanaAltaProducto.IniciarListener(this);
		
	
menu.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaLogin.getBotonA1());
		menu.setVisible(true);
		ventanaLogin.setVisible(false);
		
		if(e.getSource() == menu.getBotonAltaProducto());
		ventanaAltaProducto.setVisible(true);
		menu.setVisible(true);
			
	}
	


	
}
