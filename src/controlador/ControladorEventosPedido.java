package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.entidad.MateriaPrima;
import modelo.entidad.Pedido;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.mysql.DaoPedidoMySql;
import vistas.VentanaPedido;

public class ControladorEventosPedido implements ActionListener{
	
	private int indice;
	private LocalDate fechaLocal = LocalDate.now();
	private VentanaPedido ventanaPedido;
	private ControladorEventos controladorEventos;
	private DaoPedidoMySql daoPedido;
	
	public ControladorEventosPedido(VentanaPedido ventanaPedido) {
		this.ventanaPedido = ventanaPedido;
	}
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		indice = ventanaPedido.getTable().getSelectedRow();   
		
		
		
		String textProducto = ventanaPedido.getProducto().getText();
        String textCantidad = ventanaPedido.getCantidad().getText();
        String textPrecio = ventanaPedido.getPrecio().getText(); 
	
		 if (e.getSource() == ventanaPedido.getBtnAnadir()) {
		     System.out.println("Botón guardar almacen pulsado");
		 
				 if(ventanaPedido.getProducto().getText().isEmpty()){
				  	JOptionPane.showMessageDialog(null,"campo producto vacío", "Aviso",JOptionPane.INFORMATION_MESSAGE);
				  }
				 else  if (!textProducto.matches("[a-zA-Z]+")) {
				 JOptionPane.showMessageDialog(null, "El campo producto solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				 } 
				 else if(ventanaPedido.getCantidad().getText().isEmpty()){
				  	JOptionPane.showMessageDialog(null,"campo cantidad vacío", "Aviso",JOptionPane.INFORMATION_MESSAGE);
				 
				 }
				 else  if (!textCantidad.matches("\\d+")) {
				  JOptionPane.showMessageDialog(null, "El campo cantindad solo admite números", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				  } 
				  
				 
				 else if(ventanaPedido.getPrecio().getText().isEmpty()){
				  	JOptionPane.showMessageDialog(null,"campo precio vacío", "Aviso",JOptionPane.INFORMATION_MESSAGE);
				 }
				 else  if (!textPrecio.matches("\\d+")) {
				 JOptionPane.showMessageDialog(null, "El campo precio solo admite números", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				 } 
				 else {
					 
			     int idUsuario = 0;//controladorEventos.usuarioLogueado().getId();
			     String proveedor = (String) ventanaPedido.getCombo().getSelectedItem();
			     String producto = ventanaPedido.getProducto().getText();
			     float cantidad = Float.parseFloat(ventanaPedido.getCantidad().getText());
			     float precio = Float.parseFloat(ventanaPedido.getPrecio().getText());  
   
				  ventanaPedido.getTableModel().addRow(new String[] {"",
						  												Integer.toString(idUsuario),
						  												proveedor,
						                                                producto,
						  												Float.toString(cantidad),
						  												Float.toString(precio),
						  												fechaLocal.toString()
						  												});
	
				  ventanaPedido.getProducto().setText(null);
				  ventanaPedido.getCantidad().setText(null);
				  ventanaPedido.getPrecio().setText(null);  
				  } 
				}
          
          if (e.getSource() == ventanaPedido.getBtnBorrar()) {
              System.out.println("Botón borrar pulsado");
              
              if (indice != -1) {
  				
  				ventanaPedido.getTableModel().removeRow(indice);
  				}
  				else {
  					JOptionPane.showMessageDialog(null, "No has seleccionado ningún producto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
  				}
              
          }
          
          if (e.getSource() == ventanaPedido.getBtnGuardar()) {
              System.out.println("Botón guardar pulsado");
              
              if (indice != -1) {
  				
            	  Pedido p = new Pedido();
            	  
            	  int idUsuario = 0;//controladorEventos.usuarioLogueado().getId();
 			     int proveedor = (int) ventanaPedido.getCombo().getSelectedItem();
 			     String producto = ventanaPedido.getProducto().getText();
 			     float cantidad = Float.parseFloat(ventanaPedido.getCantidad().getText());
 			     float precio = Float.parseFloat(ventanaPedido.getPrecio().getText()); 
            	 
            	  p.setIdUsuario(idUsuario);
            	  p.setIdProveedor(proveedor);
            	  p.setMateriaPrima(producto);
            	  p.setCantidad(cantidad);
            	  p.setFechaPedido(fechaLocal);
            	  p.setCostoTotal(precio);
            	  
				  
            	  daoPedido.insertar(p);
            	  
  				}
  				else {
  					JOptionPane.showMessageDialog(null, "No hay ningún producto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
  				}
              
          }
          
	}


}
