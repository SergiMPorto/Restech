package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import modelo.entidad.MateriaPrima;
import modelo.entidad.Pedido;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;
import modelo.persistance.mysql.DaoPedidoMySql;
import modelo.persistance.mysql.DaoProveedorMySql;
import modelo.persistance.mysql.DaoUsuarioMySql;
import vistas.Almacen;
import vistas.Home;
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
    
    private DaoMateriaPrimaMySql daoMateriaPrima;
    private DaoPedidoMySql daoPedido;
    private DaoProveedorMySql daoProveedor;
    private DaoUsuarioMySql daoUsuario;

    public ControladorEventos(Login login, Home home, Almacen almacen, VentanaPedido pedido, VentanaPlato plato, VentanaUsuario usuario,
            VentanaIngredientes ingredientes, VentanaProveedor ventanaProveedor) {
        this.login = login;
        this.home = home;
        this.almacen = almacen;
      //  this.ventanaPedido = pedido;
        this.ventanaPlato = plato;
        this.ventanaUsuario = usuario;
        this.ingredientes = ingredientes;
        this.ventanaProveedor = ventanaProveedor;
        
        this.daoMateriaPrima = new DaoMateriaPrimaMySql();
        this.daoPedido = new DaoPedidoMySql();
        this.daoProveedor = new DaoProveedorMySql();
        this.daoUsuario = new DaoUsuarioMySql();

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
        // Eventos para la ventana Login
        if (e.getSource() == login.getBtnValidar()) {
            System.out.println("Botón validar pulsado");
            
          
    		
            
            String nombreUsuario = login.getTxtUsuario().getText();
            String codigoUsuario =login.getPasswordField().getText();
            
            //Si existe Usuario
             
           Usuario usuario = daoUsuario.buscarNombre(nombreUsuario);
            if(usuario !=null) {
            	if(usuario.getCodigo().equals(codigoUsuario)) {
            		
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
        } else if (e.getSource() == home.getBtnPlatos()) {
            System.out.println("Botón plato pulsado");
            ventanaPlato.setVisible(true);
            ventanaPedido.setVisible(false);
            almacen.setVisible(false);
            ventanaUsuario.setVisible(false);
        } else if (e.getSource() == ventanaPlato.getIngredientes()) {
            System.out.println("Botón ingredientes pulsados");
            ingredientes.setVisible(true);
            
            
            
            
            
        } else if (e.getSource() == home.getBtnUsuario()) {
            System.out.println("Botón Usuario pulsado");
            
            Usuario  usuarioActual = usuarioLogueado();
            
            if(usuarioActual !=null && usuarioActual.getPermisos()==1) {
            	
            
            ventanaUsuario.setVisible(true);
            ventanaPedido.setVisible(false);
            almacen.setVisible(false);
            ventanaPlato.setVisible(false);
            
            }else {
            	JOptionPane.showMessageDialog(null, "No tiene permisos para acceder a esta ventana", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == home.getBtnAlmacen()) {
            System.out.println("Botón almacen pulsado");
            almacen.setVisible(true);
            ventanaPedido.setVisible(false);
            ventanaPlato.setVisible(false);
            ventanaUsuario.setVisible(false);
        } else if (e.getSource() == home.getBtnProveedor()) {
            System.out.println("Botón proveedor pulsado");
            ventanaProveedor.setVisible(true);
        }

        // Eventos para la ventana Almacen
        else if (e.getSource() == almacen.getBtnGuardar()) {
            System.out.println("Botón guardar almacen pulsado");
            try {
                String nombre = almacen.getProducto().getText();
                float precio = Float.parseFloat(almacen.getPrecio().getText());
                String proveedor = almacen.getProveedor().getText();
                String fechaCaducidad = almacen.getFechaCaducidad().getText();
                float cantidad = Float.parseFloat(almacen.getCantidad().getText());
                float merma = Float.parseFloat(almacen.getMerma().getText());

                // Crear una instancia de MateriaPrima con los datos obtenidos
                MateriaPrima materiaPrima = new MateriaPrima(0, nombre, precio, proveedor, LocalDate.parse(fechaCaducidad), cantidad, merma);

                // Actualizar la tabla
                DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();
                modelo.addRow(new Object[]{materiaPrima.getId(), nombre, precio, proveedor, fechaCaducidad, cantidad, merma});
                almacen.getTable().revalidate();

                // Añadir mensaje de éxito independientemente de si se inserta en la base de datos o no
                JOptionPane.showMessageDialog(null, "Materia prima añadida a la tabla con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                // Insertar la materia prima en la base de datos utilizando el DAO
                if (daoMateriaPrima.insertar(materiaPrima)) {
                    // Mostrar un mensaje de advertencia si no se puede insertar en la base de datos
                    JOptionPane.showMessageDialog(null, "Añadido correctamente a la base de datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    
                 // Limpiar las casillas después de darle al botón de guardar. 
                    almacen.getProducto().setText("");
                    almacen.getPrecio().setText("");
                    almacen.getProveedor().setText("");
                    almacen.getFechaCaducidad().setText("");
                    almacen.getCantidad().setText("");
                    almacen.getMerma().setText("");
                }
            } catch (NumberFormatException | DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos para precio, cantidad, merma y fecha (Formato: yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == almacen.getBtnBorrar()) {
            System.out.println("Botón de borrado pulsado");
            int filaSeleccionada = almacen.getTable().getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();
                modelo.removeRow(filaSeleccionada);
                if (!daoMateriaPrima.borrar(filaSeleccionada)) {
                    JOptionPane.showMessageDialog(null, "Error al borrar la materia prima de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Eventos para la ventana Proveedor
        else if (e.getSource() == ventanaProveedor.getBtnGuardar()) {
            System.out.println("Botón de guardar proveedor pulsado");
            try {
                String nombre = ventanaProveedor.getNombre().getText();
                String descripcion = ventanaProveedor.getDescripcion().getText();
                String telefono = ventanaProveedor.getTelefono().getText();
                String direccion = ventanaProveedor.getDireccion().getText();

                // Crear instancia de proveedor:
                Proveedor proveedor = new Proveedor(nombre, descripcion, telefono, direccion);

                // Actualizar la tabla 
                DefaultTableModel modelo = (DefaultTableModel) ventanaProveedor.getTable().getModel();
                modelo.addRow(new Object[]{proveedor.getId(), nombre, descripcion, telefono, direccion});
                ventanaProveedor.getTable().revalidate();

                // Mensajes de añadir proveedor con éxito.
                JOptionPane.showMessageDialog(null, "Proveedor añadido con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                // Insertar el proveedor en la base de datos
                if (!daoProveedor.insertar(proveedor)) {
                    JOptionPane.showMessageDialog(null, "Error al añadir el proveedor a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos para el teléfono", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaProveedor.getBtnBorrar()) {
            System.out.println("Botón de borrado proveedor pulsado");
            int filaSeleccionado = ventanaProveedor.getTable().getSelectedRow();
            if (filaSeleccionado != -1) {
                DefaultTableModel modelo = (DefaultTableModel) ventanaProveedor.getTable().getModel();
                modelo.removeRow(filaSeleccionado);
                if (!daoProveedor.borrar(filaSeleccionado)) {
                    JOptionPane.showMessageDialog(null, "Error al borrar el proveedor de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Eventos para la ventana Usuario
      
        
        else if (e.getSource() == ventanaUsuario.getBtnGuardar()) {
            System.out.println("Botón de guardar usuario pulsado");
            try {
                String nombre = ventanaUsuario.getTextNombre().getText();
                int permiso = Integer.parseInt(ventanaUsuario.getPermiso().getText());
                String codigo = ventanaUsuario.getCodigo().getText();

                // Crear instancia de Usuario 
                Usuario usuario = new Usuario(0, nombre, permiso, codigo);


                // Actualizar tabla
                DefaultTableModel modelo = (DefaultTableModel) ventanaUsuario.getTable().getModel();
                modelo.addRow(new Object[] { usuario.getId(), nombre, permiso, codigo});
                ventanaUsuario.getTable().revalidate();

                JOptionPane.showMessageDialog(null, "Usuario añadido con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);

                if(!daoUsuario.insertar(usuario)) {
                    JOptionPane.showMessageDialog(null, "Error al añadir el usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para el permiso", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaUsuario.getBtnBorrar()) {
            System.out.println("Botón de borrado de Usuario pulsado");
            int filaSeleccionada = ventanaUsuario.getTable().getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) ventanaUsuario.getTable().getModel();
                modelo.removeRow(filaSeleccionada);
                if (!daoUsuario.borrar(filaSeleccionada)) {
                    JOptionPane.showMessageDialog(null, "Error al borrar el usuario de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
      
          
        
         } 
         
        
        /* boton borrar ventana pedido
        
           else if (e.getSource() == almacen.getBtnBorrar()) {
             System.out.println("Botón de borrado pulsado");
             int filaSeleccionada = almacen.getTable().getSelectedRow();
             if (filaSeleccionada != -1) {
                 DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();
                 modelo.removeRow(filaSeleccionada);
                 if (!daoMateriaPrima.borrar(filaSeleccionada)) {
                     JOptionPane.showMessageDialog(null, "Error al borrar la materia prima de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                 }
             } else {
                 JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
             }
         }
      
        */
        
        
        
        
        
        
        
        
    
    
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

        ingredientes.getTablaIngredientes().setModel(modeloTablaIngredientes);
    }
    
    
    
}
    	
    

