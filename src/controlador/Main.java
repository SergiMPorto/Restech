package controlador;

import vista.VentanaLogin;

public class Main {

	public static void main(String[] args) {
		
		VentanaLogin ventanaLogin = new VentanaLogin();
		ControladorEventos controlador = new ControladorEventos(ventanaLogin);
		
		ventanaLogin.IniciarListener(controlador);	
	}

}
