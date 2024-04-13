package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorEventos;

public class VentanaAltaProducto extends JDialog {
	
	private JLabel nombre, precio, proveedor;
	private JTextField cajaTextoNombre, cajaTextoPrecio, cajaTextoProveedor;
	private JButton botonValidarAltaProducto;
	
	public VentanaAltaProducto() {
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("RESTECH");
		setLayout(null);
		inicializarComponentes();
		setVisible(true);
	}

	private void inicializarComponentes() {
		

		nombre = new JLabel("Nombre:");
		nombre.setBounds(100,100,250,50);
		add(nombre);
		
		cajaTextoNombre = new JTextField();
		cajaTextoNombre.setBounds(200,100,150,30);
		add(cajaTextoNombre);
		
		precio = new JLabel("Precio:");
		precio.setBounds(100,150,250,50);
		add(precio);
		
		cajaTextoPrecio = new JTextField();
		cajaTextoPrecio.setBounds(200,150,150,30);
		add(cajaTextoPrecio);
		
		proveedor = new JLabel("Proveedor:");
		proveedor.setBounds(100,200,250,50);
		add(proveedor);
		
		cajaTextoProveedor = new JTextField();
		cajaTextoProveedor.setBounds(200,200,150,30);
		add(cajaTextoProveedor);
		
		
		
		
		
		
		botonValidarAltaProducto = new JButton("Validar");
		botonValidarAltaProducto.setBounds(400,330,150,30);
		add(botonValidarAltaProducto);
		
	}
	
	public void IniciarListener(ControladorEventos controlador) {
		
		botonValidarAltaProducto.addActionListener(controlador);
}
}
