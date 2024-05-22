package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import modelo.entidad.MateriaPrima;
import modelo.entidad.Plato;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;
import modelo.persistance.mysql.DaoPlatoMySql;
import modelo.entidad.Pedido;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;
import modelo.persistance.mysql.DaoPedidoMySql;
import modelo.persistance.mysql.DaoProveedorMySql;
import modelo.persistance.mysql.DaoUsuarioMySql;
import vistas.Almacen;
import vistas.Home;
import vistas.ListaPlatos;
import vistas.Login;
import vistas.VentanaIngredientes;
import vistas.VentanaPedido;
import vistas.VentanaPlato;
import vistas.VentanaProveedor;
import vistas.VentanaUsuario;

public class ControladorEventos implements ActionListener {
	
    private Login login;
    private Home home;
    private Almacen almacen;
    private VentanaPedido ventanaPedido;
    private VentanaPlato ventanaPlato;
    private VentanaUsuario ventanaUsuario;
    private VentanaIngredientes ingredientes;
    private VentanaProveedor ventanaProveedor;
    private ListaPlatos listaPlatos;
 
    private DaoMateriaPrimaMySql daoMateriaPrima;
    private DaoPedidoMySql daoPedido;
    private DaoProveedorMySql daoProveedor;
    private DaoUsuarioMySql daoUsuario;
    private DaoPlatoMySql daoPlato;
    private int indice;
    private LocalDate fechaLocal = LocalDate.now();

    public ControladorEventos(Login login, Home home, Almacen almacen, VentanaPedido pedido, VentanaPlato plato, VentanaUsuario usuario,
            VentanaIngredientes ingredientes, VentanaProveedor ventanaProveedor, ListaPlatos listaPlatos) {
        this.login = login;
        this.home = home;
        this.almacen = almacen;
      //  this.ventanaPedido = pedido;
        this.ventanaPlato = plato;
        this.listaPlatos= listaPlatos;
        this.ventanaUsuario = usuario;
        this.ingredientes = ingredientes;
        this.ventanaProveedor = ventanaProveedor;
        
        this.daoMateriaPrima = new DaoMateriaPrimaMySql();
        this.daoPedido = new DaoPedidoMySql();
        this.daoProveedor = new DaoProveedorMySql();
        this.daoUsuario = new DaoUsuarioMySql();
        this.daoPlato = new DaoPlatoMySql();
        

        // Ocultar todas las vistas excepto la de inicio de sesión al iniciar
        usuario.setVisible(false);
        pedido.setVisible(false);
        almacen.setVisible(false);
        plato.setVisible(false);
        home.setVisible(false);
        login.setVisible(true);
        ventanaProveedor.setVisible(false);
        ingredientes.setVisible(false);

        // Establecer los ActionListener
        login.inciarListener(this);
        home.iniciarListener(this);
        ventanaProveedor.iniciarListener(this);
        almacen.iniciarListener(this);
        ventanaUsuario.inciarListener(this);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	String textProducto = ventanaPedido.getProducto().getText();
        String textCantidad = ventanaPedido.getCantidad().getText();
        String textPrecio = ventanaPedido.getPrecio().getText();
        
        indice = ventanaPedido.getTable().getSelectedRow();  
        
        // Eventos para la ventana Login
        if (e.getSource() == login.getBtnValidar()) {
            System.out.println("Botón validar pulsado");
            String nombreUsuario = login.getTxtUsuario().getText();
            String codigoUsuario = login.getPasswordField().getText();
            Usuario usuario = daoUsuario.buscarNombre(nombreUsuario);
            if (usuario != null) {
                if (usuario.getCodigo().equals(codigoUsuario)) {
                    login.setVisible(false);
                    home.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Código incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Eventos para la ventana Home
        else if (e.getSource() == home.getBtnPedido()) {
            System.out.println("Botón Pedido pulsado");
            ventanaPedido.setVisible(true);
            almacen.setVisible(false);
            ventanaPlato.setVisible(false);
            ventanaUsuario.setVisible(false);
        }
        
        //Eventos ventana Plato
        else if (e.getSource() == home.getBtnPlatos()) {
            System.out.println("Botón plato pulsado");
            ventanaPlato.setVisible(true);
            ventanaPedido.setVisible(false);
            almacen.setVisible(false);
            ventanaUsuario.setVisible(false);
        }
        else if (e.getSource() == ventanaPlato.getIngredientes()) {
            ingredientes.cargarDatosEnTablaIngredientes();
            ingredientes.setVisible(true);
        }
        else if (e.getSource() == ingredientes.getGuardar()) {
            agregarIngredienteAPlato();
        }
        else if (e.getSource() == home.getBtnUsuario()) {
            System.out.println("Botón Usuario pulsado");
            Usuario usuarioActual = usuarioLogueado();
            if (usuarioActual != null && usuarioActual.getPermisos() == 1) {
                ventanaUsuario.cargarUsuario();
                ventanaUsuario.setVisible(true);
                ventanaPedido.setVisible(false);
                almacen.setVisible(false);
                ventanaPlato.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para acceder a esta ventana", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //Guardar plato
        else if (e.getSource() == ventanaPlato.getGuardar()) {
            String nombre = ventanaPlato.getNombre().getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String precioTexto = ventanaPlato.getPrecio().getText().trim();
            String tiempoTexto = ventanaPlato.getTiempoPreparacion().getText().trim();
            float precio = 0;
            int tiempoPreparacion = 0;

            // Validación del precio como float
            try {
                precio = Float.parseFloat(precioTexto);
                if (precio <= 0) {
                    System.out.println("Valor ingresado para el precio: '" + precioTexto + "'");
                    JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo mayor que cero.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido para el precio (ej. 19.99).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validación del tiempo de preparación como int
            try {
                tiempoPreparacion = Integer.parseInt(tiempoTexto);
                if (tiempoPreparacion <= 0) {
                    JOptionPane.showMessageDialog(null, "El tiempo de preparación debe ser un número entero positivo mayor que cero.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número entero válido para el tiempo de preparación.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Plato plato = new Plato(0, nombre, precio, tiempoPreparacion);
            if (daoPlato.insertar(plato)) {
                JOptionPane.showMessageDialog(null, "Plato añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al añadir el plato", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if(e.getSource()==ventanaPlato.getListarPlatos()){
        	System.out.println("Ventana listar ingredientes pulsado");
        	listaPlatos.setVisible(true);
        	
        }
    
        
        else if (e.getSource() == home.getBtnAlmacen()) {
            System.out.println("Botón almacen pulsado");
            almacen.cargarMateriasPrimas();
            almacen.setVisible(true);
            ventanaPedido.setVisible(false);
            ventanaPlato.setVisible(false);
            ventanaUsuario.setVisible(false);
        }
        else if (e.getSource() == home.getBtnProveedor()) {
            System.out.println("Botón proveedor pulsado");
            ventanaProveedor.setVisible(true);
        }
        // Eventos para la ventana Almacen
        else if (e.getSource() == almacen.getBtnGuardar()) {
            try {
                String nombre = almacen.getProducto().getText();
                float precio = Float.parseFloat(almacen.getPrecio().getText());
                String proveedor = almacen.getProveedor().getText();
                LocalDate fechaCaducidad = LocalDate.parse(almacen.getFechaCaducidad().getText());
                float cantidad = Float.parseFloat(almacen.getCantidad().getText());
                float merma = Float.parseFloat(almacen.getMerma().getText());
                MateriaPrima materiaPrima = new MateriaPrima(0, nombre, precio, proveedor, fechaCaducidad, cantidad, merma);
                DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();
                modelo.addRow(new Object[]{materiaPrima.getId(), nombre, precio, proveedor, fechaCaducidad, cantidad, merma});
                //Borrar datos
                almacen.getProducto().setText("");
                almacen.getPrecio().setText("");
                almacen.getProveedor().setText("");
                almacen.getFechaCaducidad().setText("");
                almacen.getCantidad().setText("");
                almacen.getMerma().setText("");
                if (daoMateriaPrima.insertar(materiaPrima)) {
                    JOptionPane.showMessageDialog(null, "Materia prima añadida correctamente a la base de datos", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para precio, cantidad y merma", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha válida en el formato yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == almacen.getBtnBorrar()) {
            int filaSeleccionada = almacen.getTable().getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();
                int idMateriaPrima = (Integer) modelo.getValueAt(filaSeleccionada, 0);
                modelo.removeRow(filaSeleccionada);
                if (daoMateriaPrima.borrar(idMateriaPrima)) {
                    JOptionPane.showMessageDialog(null, "Materia prima borrada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al borrar la materia prima", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // Eventos para la ventana Proveedor
        else if (e.getSource() == ventanaProveedor.getBtnGuardar()) {
            try {
                String nombre = ventanaProveedor.getNombre().getText();
                String descripcion = ventanaProveedor.getDescripcion().getText();
                String telefono = ventanaProveedor.getTelefono().getText();
                String direccion = ventanaProveedor.getDireccion().getText();
                Proveedor proveedor = new Proveedor(nombre, descripcion, telefono, direccion);
                DefaultTableModel modelo = (DefaultTableModel) ventanaProveedor.getTable().getModel();
                modelo.addRow(new Object[]{proveedor.getId(), nombre, descripcion, telefono, direccion});
                ventanaProveedor.getTable().revalidate();

                if (daoProveedor.insertar(proveedor)) {
                    JOptionPane.showMessageDialog(null, "Proveedor añadido correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al añadir el proveedor a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número de teléfono válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaProveedor.getBtnBorrar()) {
            int filaSeleccionada = ventanaProveedor.getTable().getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) ventanaProveedor.getTable().getModel();
                int idProveedor = (Integer) modelo.getValueAt(filaSeleccionada, 0);
                modelo.removeRow(filaSeleccionada);
                if (daoProveedor.borrar(idProveedor)) {
                    JOptionPane.showMessageDialog(null, "Proveedor borrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al borrar el proveedor", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // Eventos para la ventana Usuario
        else if (e.getSource() == ventanaUsuario.getBtnGuardar()) {
            try {
                String nombre = ventanaUsuario.getTextNombre().getText();
                int permiso = Integer.parseInt(ventanaUsuario.getPermiso().getText());
                String codigo = ventanaUsuario.getCodigo().getText();
                Usuario usuario = new Usuario(0, nombre, permiso, codigo);
                DefaultTableModel modelo = (DefaultTableModel) ventanaUsuario.getTable().getModel();
                modelo.addRow(new Object[]{usuario.getId(), nombre, permiso, codigo});
                if (daoUsuario.insertar(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario añadido correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un permiso válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == ventanaUsuario.getBtnBorrar()) {
            int filaSeleccionada = ventanaUsuario.getTable().getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) ventanaUsuario.getTable().getModel();
                int idUsuario = (Integer) modelo.getValueAt(filaSeleccionada, 0);
                modelo.removeRow(filaSeleccionada);
                if (daoUsuario.borrar(idUsuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario borrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al borrar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        
      
     else if (e.getSource() == ventanaPedido.getBtnAnadir()) {
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
        
        
        
        
    
    

    //Agregar ingredientes al plato 
    private void agregarIngredienteAPlato() {
        int selectedRow = ingredientes.getTablaIngredientes().getSelectedRow();
        if (selectedRow != -1) { // Verifica que haya una fila seleccionada
            String producto = (String) ingredientes.getTablaIngredientes().getValueAt(selectedRow, 0);
            try {
                int cantidad = Integer.parseInt(ingredientes.getCantidad().getText()); // Asume que el campo cantidad ya contiene un número válido.
                ventanaPlato.agregarProducto(producto, cantidad); // Llama al método en VentanaPlato para añadir el producto
                JOptionPane.showMessageDialog(null, "Ingrediente agregado al plato");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un ingrediente para agregar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//Obtner método para usuario logueado. 
    
    public Usuario usuarioLogueado() {
    	String nombreUsurio = login.getTxtUsuario().getText();
    	String codigoUsuario = login.getPasswordField().getText();
    	
    	Usuario usuario = daoUsuario.buscarNombre(nombreUsurio);
    	
    	if(usuario != null && usuario.getCodigo().equals(codigoUsuario)) {
    	  
    	 return usuario;
    	 
	    }else 
	    	return null;
	    	
    }
    
    //cargar tabla en Ingredientes
    
    public void cargarDatosEnTablaIngredientes() {
        List<MateriaPrima> listadoMateriasPrimas = daoMateriaPrima.listar();
        DefaultTableModel modeloTablaIngredientes = (DefaultTableModel) ingredientes.getTablaIngredientes().getModel();
        modeloTablaIngredientes.setRowCount(0); 

        for (MateriaPrima materiaPrima : listadoMateriasPrimas) {
            modeloTablaIngredientes.addRow(new Object[] {
                materiaPrima.getNombre(),
                materiaPrima.getCantidadUtilizada()
               
            });

        }
    }


  

    

    


 // VENTANA CONFIRMACION BORRAR 
    private boolean mostrarConfirmacionBorrado() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar el producto?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        return opcion == JOptionPane.YES_OPTION;

        } 
    

   

    
    
    

}
    	
    

