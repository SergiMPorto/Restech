package vista;

import javax.swing.JButton;
import javax.swing.JDialog;

import controlador.ControladorEventos;

public class VentanaPrincipal extends JDialog{

	private JButton botonAltaProducto, BotonConsultaProducto, botonAltaPlato,
	botonConsultaPlato, botonAltaProveedor, botonConsultaProveedor, botonAltaUsuario;
	
public VentanaPrincipal(){
		
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("RESTECH");
		setLayout(null);
		inicializarComponentes();
		setVisible(true);
	}

	private void inicializarComponentes(){
		
		botonAltaProducto = new JButton("Productos");
		botonAltaProducto.setBounds(400,100,150,30);
		add(botonAltaProducto);
		
		BotonConsultaProducto = new JButton("Platos");
		BotonConsultaProducto.setBounds(400,150,150,30);
		add(BotonConsultaProducto);
		
		botonAltaPlato = new JButton("Proveedores");
		botonAltaPlato.setBounds(400,200,150,30);
		add(botonAltaPlato);
		
		botonConsultaPlato = new JButton("Usuarios");
		botonConsultaPlato.setBounds(400,250,150,30);
		add(botonConsultaPlato);
		
	}
	
	public void IniciarListener(ControladorEventos controlador) {
		
		botonAltaProducto.addActionListener(controlador);
}
}
