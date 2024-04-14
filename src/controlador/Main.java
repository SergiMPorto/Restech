package controlador;

import vista.VentanaLogin;

public class Main {

	public static void main(String[] args) {
		
	VentanaLogin login = new VentanaLogin();
	ControladorEventos controlador = new ControladorEventos(login);
	login.iniciarListener(controlador);
	
		
	
	


}
}
