/*package vista;

import javax.swing.JButton;
import javax.swing.JDialog;

import controlador.ControladorEventos;

public class Menu extends JDialog{

	

	private JButton botonAltaProducto, BotonConsultaProducto, botonAltaPlato,
	botonConsultaPlato, botonAltaProveedor, botonConsultaProveedor, botonAltaUsuario;
	
public Menu(){
		
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
	
	
	//Getter AND Setter
	public JButton getBotonAltaProducto() {
		return botonAltaProducto;
	}

	public void setBotonAltaProducto(JButton botonAltaProducto) {
		this.botonAltaProducto = botonAltaProducto;
	}

	public JButton getBotonConsultaProducto() {
		return BotonConsultaProducto;
	}

	public void setBotonConsultaProducto(JButton botonConsultaProducto) {
		BotonConsultaProducto = botonConsultaProducto;
	}

	public JButton getBotonAltaPlato() {
		return botonAltaPlato;
	}

	public void setBotonAltaPlato(JButton botonAltaPlato) {
		this.botonAltaPlato = botonAltaPlato;
	}

	public JButton getBotonConsultaPlato() {
		return botonConsultaPlato;
	}

	public void setBotonConsultaPlato(JButton botonConsultaPlato) {
		this.botonConsultaPlato = botonConsultaPlato;
	}

	public JButton getBotonAltaProveedor() {
		return botonAltaProveedor;
	}

	public void setBotonAltaProveedor(JButton botonAltaProveedor) {
		this.botonAltaProveedor = botonAltaProveedor;
	}

	public JButton getBotonConsultaProveedor() {
		return botonConsultaProveedor;
	}

	public void setBotonConsultaProveedor(JButton botonConsultaProveedor) {
		this.botonConsultaProveedor = botonConsultaProveedor;
	}

	public JButton getBotonAltaUsuario() {
		return botonAltaUsuario;
	}

	public void setBotonAltaUsuario(JButton botonAltaUsuario) {
		this.botonAltaUsuario = botonAltaUsuario;
	}
	
	
	
	
	
	public void iniciarListener(ControladorEventos controlador) {
		
		botonAltaProducto.addActionListener(controlador);
}
}*/
