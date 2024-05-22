package controlador;

import vistas.VentanaPedido;

public class MainPedido {

	public static void main(String[] args) {
			
		 VentanaPedido ventanaPedido = new VentanaPedido();
		 
		 ControladorEventosPedido controladorPedido = new ControladorEventosPedido(ventanaPedido);
		 
		 ventanaPedido.establecerControlador(controladorPedido);
		 
		// ControladorEventos controladorEventos = new ControladorEventos();
	}

}
