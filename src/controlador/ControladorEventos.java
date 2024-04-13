package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaAltaProducto;
import vista.VentanaLogin;
import vista.VentanaPrincipal;

public class ControladorEventos implements ActionListener{
	
	private VentanaLogin ventanaLogin;
	private VentanaAltaProducto ventanaAltaProducto;
	
	public ControladorEventos(VentanaLogin ventanaLogin) {
		this.ventanaLogin = ventanaLogin;
		
	}
	
	public ControladorEventos(VentanaAltaProducto ventanaAltaProducto) {
		this.ventanaAltaProducto = ventanaAltaProducto;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		VentanaAltaProducto ventanaAltaProducto = new VentanaAltaProducto();
		ventanaAltaProducto.setVisible(true);
		
	}

	
}
