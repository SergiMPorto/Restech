package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//import modelo.entidad.Ingrediente;

import modelo.entidad.MateriaPrima;
import modelo.entidad.Plato;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.interfaces.DaoMateriaPrima;
import modelo.persistance.interfaces.DaoUsuario;

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
    private LocalDate fechaCaducidad = LocalDate.now();
    private DateTimeFormatter formato;
  
    private LocalDate fechaLocal = LocalDate.now();

    public ControladorEventos(Login login, Home home, Almacen almacen, VentanaPedido pedido, VentanaPlato plato, VentanaUsuario usuario,
            VentanaIngredientes ingredientes, VentanaProveedor ventanaProveedor, ListaPlatos listaPlatos) {
        this.login = login;
        this.home = home;
        this.almacen = almacen;
        this.ventanaPedido = pedido;
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

     

        
        cargarProveedoresEnPedido1();
        
        // Crear formato de fecha en español
      formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        

    }
   
    
    private void cargarProveedoresEnPedido1() {
        List<Proveedor> proveedores = daoProveedor.listar();
        for (Proveedor proveedor : proveedores) {
            ventanaPedido.getCombo().addItem(proveedor.getId() + " " + proveedor.getNombre());
        }
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
            if (login.getTxtUsuario().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Usuario vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!login.getTxtUsuario().getText().matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "El campo Usuario solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (login.getPasswordField().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Código vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
            String nombreUsuario = login.getTxtUsuario().getText();
            String codigoUsuario = login.getPasswordField().getText();
            Usuario usuario = daoUsuario.buscarNombre(nombreUsuario);
	            if (usuario != null) {
	                if (usuario.getCodigo().equals(codigoUsuario)) {
	                    login.setVisible(false);
	                    home.setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Código incorrecto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	            }
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
        
     // Eventos ventana Plato
        else if (e.getSource() == home.getBtnPlatos()) {
            System.out.println("Botón plato pulsado");
            ventanaPlato.setVisible(true);
            ventanaPedido.setVisible(false);
            almacen.setVisible(false);
            ventanaUsuario.setVisible(false);
        } else if (e.getSource() == ventanaPlato.getIngredientes()) {
            ingredientes.cargarDatosEnTablaIngredientes();
            ingredientes.setVisible(true);
        } else if (e.getSource() == ingredientes.getGuardar()) {
            agregarIngredienteAPlato();
        } else if (e.getSource() == home.getBtnUsuario()) {
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
        } else if (e.getSource() == ventanaPlato.getGuardar()) {
            // Validar y guardar el plato
        	
        	
            guardarPlato();
            
        } else if (e.getSource() == ventanaPlato.getListarPlatos()) {
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
                if (almacen.getProducto().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo producto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!almacen.getProducto().getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El campo producto solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (almacen.getPrecio().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo precio vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!validarFloat(almacen.getPrecio().getText())) {
                    JOptionPane.showMessageDialog(null, "El campo precio NO contiene un número válido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (almacen.getProveedor().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo proveedor vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!almacen.getProveedor().getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El campo proveedor solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (almacen.getFechaCaducidad().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo fecha caducidad vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!validarFecha(almacen.getFechaCaducidad().getText())) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha válida en el formato dd/MM/yyyy", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (almacen.getCantidad().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo cantidad vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!validarFloat(almacen.getCantidad().getText())) {
                    JOptionPane.showMessageDialog(null, "El campo cantidad NO contiene un número válido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (almacen.getMerma().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo merma vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!validarFloat(almacen.getMerma().getText())) {
                    JOptionPane.showMessageDialog(null, "El campo merma NO contiene un número válido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

                String producto = almacen.getProducto().getText();
                float precio = Float.parseFloat(almacen.getPrecio().getText());
                String proveedor = almacen.getProveedor().getText();

                float cantidad = Float.parseFloat(almacen.getCantidad().getText());
                float merma = Float.parseFloat(almacen.getMerma().getText());

                // Formatear fecha para mostrarla en la tabla en formato español
                String fechaCaducidadTexto = almacen.getFechaCaducidad().getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaCaducidad = LocalDate.parse(fechaCaducidadTexto, formatter);

                // Insertar la nueva materia prima en la base de datos
                int idAsignado = daoMateriaPrima.insertarDevolucionId(new MateriaPrima(producto, precio, proveedor, fechaCaducidad, cantidad, merma));

                if (idAsignado != -1) { // Si la inserción fue exitosa
                    // Obtener el modelo de la tabla y agregar la fila con el ID asignado
                    DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();
                    modelo.addRow(new Object[]{idAsignado, producto, precio, proveedor, fechaCaducidad, cantidad, merma});

                    // Borrar datos de los campos
                    almacen.getProducto().setText("");
                    almacen.getPrecio().setText("");
                    almacen.getProveedor().setText("");
                    almacen.getFechaCaducidad().setText("");
                    almacen.getCantidad().setText("");
                    almacen.getMerma().setText("");

                    JOptionPane.showMessageDialog(null, "Materia prima añadida correctamente a la base de datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar la materia prima a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Excepción genérica
                 JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para precio, cantidad y merma", "Error", JOptionPane.ERROR_MESSAGE);
                 System.out.println(ex);
                // ex.printStackTrace();
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
                    JOptionPane.showMessageDialog(null, "Error al borrar la materia prima", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // Eventos para la ventana Proveedor
        else if (e.getSource() == ventanaProveedor.getBtnGuardar()) {
   	  	
            	if (ventanaProveedor.getNombre().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo nombre vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }else if (!ventanaProveedor.getNombre().getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El campo nombre solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }          	
                else if (ventanaProveedor.getDescripcion().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo descripción vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!ventanaProveedor.getDescripcion().getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El campo descripción solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }           	
                else if (ventanaProveedor.getTelefono().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo teléfono vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else if (!ventanaProveedor.getTelefono().getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El campo teléfono solo admite números", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }            	
                else if (ventanaProveedor.getDireccion().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo dirección vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } 
            
	                String nombre = ventanaProveedor.getNombre().getText();
	                String descripcion = ventanaProveedor.getDescripcion().getText();
	                String telefono = ventanaProveedor.getTelefono().getText();
	                String direccion = ventanaProveedor.getDireccion().getText();
	              	 
	                Proveedor proveedor = new Proveedor(nombre, descripcion, telefono, direccion);
	               
	
	                 if (daoProveedor.insertar(proveedor)) {
	                    JOptionPane.showMessageDialog(null, "Proveedor añadido correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE); /// quitar???
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error al añadir el proveedor a la base de datos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	                }
	                 

	                ventanaProveedor.cargarProveedores();  
	                cargarProveedoresEnPedido1();
	                
        

	                ventanaProveedor.cargarProveedores(); 

	                ventanaProveedor.getNombre().setText(null);
	                ventanaProveedor.getDescripcion().setText(null);
	                ventanaProveedor.getTelefono().setText(null);
	                ventanaProveedor.getDireccion().setText(null);
	                
	                cargarProveedoresEnPedido1();

        }
           else if (e.getSource() == ventanaProveedor.getBtnBorrar()) {
            int filaSeleccionada = ventanaProveedor.getTable().getSelectedRow();
            if (filaSeleccionada != -1) {
                DefaultTableModel modelo = (DefaultTableModel) ventanaProveedor.getTable().getModel();
                int idProveedor = (Integer) modelo.getValueAt(filaSeleccionada, 0);
                modelo.removeRow(filaSeleccionada);
                if (daoProveedor.borrar(idProveedor)) {
                    JOptionPane.showMessageDialog(null, "Proveedor borrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al borrar el proveedor", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Eventos para la ventana Usuario
        else if (e.getSource() == ventanaUsuario.getBtnGuardar()) {
            try {
            	
            	 if (ventanaUsuario.getTextNombre().getText().isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Campo nombre vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                 } else if (!ventanaUsuario.getTextNombre().getText().matches("[a-zA-Z]+")) {
                     JOptionPane.showMessageDialog(null, "El campo nombre solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                 } else if (ventanaUsuario.getPermiso().getText().isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Campo permiso vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                 } else if (!ventanaUsuario.getPermiso().getText().matches("[01]")) {
                     JOptionPane.showMessageDialog(null, "El campo permiso solo admite 0 o 1", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                 } else if (ventanaUsuario.getCodigo().getText().isEmpty()) {
                     JOptionPane.showMessageDialog(null, "Campo código vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                 } else {
                     String nombre = ventanaUsuario.getTextNombre().getText();
                     int permiso = Integer.parseInt(ventanaUsuario.getPermiso().getText());
                     String codigo = ventanaUsuario.getCodigo().getText();

                     Usuario usuario = new Usuario(0, nombre, permiso, codigo);

                     int idAsignado = daoUsuario.insertarDevolucionId(usuario); // Insertar el usuario y obtener el ID asignado

                     if (idAsignado != -1) { // Si la inserción fue exitosa
                         // Obtener el modelo de la tabla y agregar la fila con el ID asignado
                         DefaultTableModel modelo = (DefaultTableModel) ventanaUsuario.getTable().getModel();
                         modelo.addRow(new Object[]{idAsignado, nombre, permiso, codigo});

                         JOptionPane.showMessageDialog(null, "Usuario añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                         ventanaUsuario.limpiarCampos();
                     } else {
                         JOptionPane.showMessageDialog(null, "Error al agregar el usuario a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                     }
               
	            }  
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "fallo en las validadciones???", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "Error al borrar el usuario", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
      //ventana Pedido
        else if (e.getSource() == ventanaPedido.getBtnAnadir()) {
            if (ventanaPedido.getProducto().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo producto vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!textProducto.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "El campo producto solo admite letras", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (ventanaPedido.getCantidad().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo cantidad vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!validarFloat(ventanaPedido.getCantidad().getText())) {
                JOptionPane.showMessageDialog(null, "El campo cantidad solo admite números", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (ventanaPedido.getPrecio().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo precio vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (!validarFloat(ventanaPedido.getPrecio().getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio solo admite números", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {

            	String usuario = ControladorEventos.this.usuarioLogueado().getNombre();;

            	int idUsuario = ControladorEventos.this.usuarioLogueado().getId();
                String idUsuarioString = String.valueOf(idUsuario);

                String proveedor = (String) ventanaPedido.getCombo().getSelectedItem();
                String producto = ventanaPedido.getProducto().getText();
                float cantidad = Float.parseFloat(ventanaPedido.getCantidad().getText());
                float precio = Float.parseFloat(ventanaPedido.getPrecio().getText());
                LocalDate fechaPedido = LocalDate.now();

                ventanaPedido.getTableModel().addRow(new Object[]{
                        idUsuarioString,
                        usuario,
                        proveedor,
                        producto,
                        cantidad,
                        precio,
                        fechaPedido.toString()
                });

                ventanaPedido.getProducto().setText(null);
                ventanaPedido.getCantidad().setText(null);
                ventanaPedido.getPrecio().setText(null);
            }
        } else if (e.getSource() == ventanaPedido.getBtnGuardar()) {
        	
            DefaultTableModel modelo = ventanaPedido.getTableModel();
            int rowCount = modelo.getRowCount();

            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, "No hay ningún producto para guardar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }          
            for (int i = 0; i < rowCount; i++) {
            int idUsuario = ControladorEventos.this.usuarioLogueado().getId();
            	
            
                System.out.println(idUsuario);


                String cellValue = (String) modelo.getValueAt(i, 2);
                String[] parts = cellValue.split(" ");
                int proveedor = Integer.parseInt(parts[0]);
                String producto = (String) modelo.getValueAt(i, 3);
                float cantidad = (float) modelo.getValueAt(i, 4);
                float precio = (float) modelo.getValueAt(i, 5);
                LocalDate fechaPedido = LocalDate.now();

                Pedido p = new Pedido();
               p.setIdUsuario(idUsuario);
                p.setIdProveedor(proveedor);
                p.setMateriaPrima(producto);
                p.setCantidad(cantidad);
                p.setFechaPedido(fechaPedido);
                p.setCostoTotal(precio);
                
               
                if (!daoPedido.insertar(p)) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el pedido en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            JOptionPane.showMessageDialog(null, "Pedido guardado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            modelo.setRowCount(0);
            
        }
        else if (e.getSource() == ventanaPedido.getBtnBorrar()) {
            if (indice != -1) {
            	JOptionPane.showMessageDialog(null, "Producto borrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                ventanaPedido.getTableModel().removeRow(indice);
                indice = -1;
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }}
            
    
    
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
    
    
    //Cargar proveedores 
    private void cargarProveedoresEnPedido() {
        List<Proveedor> proveedores = daoProveedor.listar();
        for (Proveedor proveedor : proveedores) {
            ventanaPedido.getCombo().addItem(proveedor.getId() + " " + proveedor.getNombre());
        }
    }
    
   /* private void cargarProveedores() {
        List<Proveedor> proveedores = daoProveedor.listar();
        gastos.getProveedores().removeAllItems();
        for (Proveedor proveedor : proveedores) {
            gastos.getProveedores().addItem(proveedor.getId() + " - " + proveedor.getNombre());
        }
    }*/
    
    


  

    

    


 // VENTANA CONFIRMACION BORRAR 
    private boolean mostrarConfirmacionBorrado() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar el producto?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        return opcion == JOptionPane.YES_OPTION;

        } 
    
    //METODOS VENTANA PLATO-->
    
  
    
    private void guardarPlato() {
        String nombre = ventanaPlato.getNombre().getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        float precio = 0;
        int tiempoPreparacion = 0;
        String textoPrecio = ventanaPlato.getTextPrecio().getText().trim();
        System.out.println("Texto del precio ingresado: " + textoPrecio);
     // Reemplazar la coma decimal por un punto decimal
        textoPrecio = textoPrecio.replace(",", ".");

        // Validación del precio como float
        try {
        	 precio = Float.parseFloat(textoPrecio);
        	 System.out.println("Precio parseado correctamente: " + precio);
            if (precio <= 0) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo mayor que cero.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido para el precio (ej. 19.99).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación del tiempo de preparación como int
        try {
            tiempoPreparacion = Integer.parseInt(ventanaPlato.getTiempoPreparacion().getText().trim());
            if (tiempoPreparacion <= 0) {
                JOptionPane.showMessageDialog(null, "El tiempo de preparación debe ser un número entero positivo mayor que cero.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa un número entero válido para el tiempo de preparación.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        System.out.println("nombre: " + nombre + " Precio: " + precio + " tiempo preparación: " + tiempoPreparacion);

        Plato plato = new Plato(nombre, precio, tiempoPreparacion);

        // Extraer materia prima de la tabla
        List<MateriaPrima> materiaPrimaList = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) ventanaPlato.getTable().getModel();

        DaoMateriaPrima daoMateriaPrima = new DaoMateriaPrimaMySql();

        for (int i = 0; i < model.getRowCount(); i++) {
            Object materiaPrimaNombreObj = model.getValueAt(i, 0);
            Object cantidadUtilizadaObj = model.getValueAt(i, 1);

            // Verificar si algún valor es null antes de usarlo
            if (materiaPrimaNombreObj != null && cantidadUtilizadaObj != null) {
                String materiaPrimaNombre = materiaPrimaNombreObj.toString();
                float cantidadUtilizada = Float.parseFloat(cantidadUtilizadaObj.toString());

                // Obtener MateriaPrima por nombre
                MateriaPrima materiaPrima = daoMateriaPrima.obtenerPorNombre(materiaPrimaNombre);
                if (materiaPrima != null) {
                    // Asignar la cantidad utilizada
                    materiaPrima.setCantidadUtilizada(cantidadUtilizada);
                    materiaPrimaList.add(materiaPrima);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Materia Prima no encontrada en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: Alguno de los valores en la tabla es null.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Otra acción adecuada según tu lógica
            }
        }

        plato.setMateriaPrima(materiaPrimaList);

        System.out.println(plato);

        if (daoPlato.insertar(plato)) {
            JOptionPane.showMessageDialog(null, "Plato añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
        } else {
            JOptionPane.showMessageDialog(null, "Error al añadir el plato", "Error", JOptionPane.ERROR_MESSAGE);
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
    

    
    
    
    private void limpiarFormulario() {
        ventanaPlato.getNombre().setText("");
        //ventanaPlato.getPrecio().setText("");
        ventanaPlato.getTiempoPreparacion().setText("");
        ((DefaultTableModel) ventanaPlato.getTable().getModel()).setRowCount(0);
    }

 // Método modificado para listar platos
    private void listaPlatos() {
        List<Plato> platos = daoPlato.listar();
        if (platos != null) {
            // Asumiendo que tienes una ventana o algún lugar donde mostrar los platos.
            // Aquí puedes mostrar los platos en una nueva ventana o un cuadro de diálogo.
            // Para simplicidad, se imprimen en la consola.
            for (Plato plato : platos) {
                System.out.println(plato);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al listar los platos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
 
   
//obtener id de usuario
    
    public int obtenerIdUsuarioPorNombre(String nombreUsuario) {
        // Crear una instancia del DAO de Usuario
        DaoUsuario daoUsuario = new DaoUsuarioMySql(); // Suponiendo que tienes una implementación específica de MySQL
        
        // Llamar al método buscarIdUsuarioPorNombre del DAO para obtener el ID del usuario
        int idUsuario = daoUsuario.buscarIdUsuarioPorNombre(nombreUsuario);
        
        // Devolver el ID del usuario si se encontró, de lo contrario, devolver -1
        return idUsuario;
    }

    public boolean validarFloat(String text) {
   	 try {
            Float.parseFloat(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
   	
   }
    public boolean validarDouble(String text) {
    	 try {
             Double.parseDouble(text);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
    }
    public boolean validarFecha(String fecha) throws ParseException {
        // Utiliza el formato para verificar si la cadena es una fecha válida
		formato.parse(fecha);
		return true;
    }

    
    

}
    	
    