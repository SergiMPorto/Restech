package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import modelo.entidad.Proveedor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.entidad.*;
import modelo.persistance.mysql.DaoProveedorMySql;
import modelo.persistance.mysql.DaoUsuarioMySql;
import vistas.Almacen;
import vistas.Home;
import vistas.VentanaIngredientes;
import vistas.Login;
import vistas.VentanaPedido;
import vistas.VentanaPlato;
import vistas.VentanaProveedor;
import vistas.VentanaUsuario;
import controlador.SesionUsuario;



public class ControladorEventos implements ActionListener {
	 private Login login;
	    private Home home;
	    private Almacen almacen;
	    private VentanaPedido pedido;
	    private VentanaPlato plato;
	    private VentanaUsuario usuario;
	    private VentanaIngredientes ingredientes;
	    private VentanaProveedor proveedor;
	    

	    public ControladorEventos(Login login, Home home, Almacen almacen, VentanaPedido pedido, VentanaPlato plato, VentanaUsuario usuario,
	            VentanaIngredientes ingredientes, VentanaProveedor proveedor) {
	        this.login = login;
	        this.home = home;
	        this.almacen = almacen;
	        this.pedido = pedido;
	        this.plato = plato;
	        this.usuario = usuario;
	        this.ingredientes = ingredientes;
	        this.proveedor=proveedor;

	        // Ocultar todas las vistas excepto la de inicio de sesión al iniciar
	        usuario.setVisible(false);
	        pedido.setVisible(false);
	        almacen.setVisible(false);
	        plato.setVisible(false);
	        home.setVisible(false);
	        login.setVisible(true);
	        proveedor.setVisible(false);
	        ingredientes.setVisible(false);

	        // Establecer los ActionListener
	        login.inciarListener(this);
	        home.iniciarListener(this);
	        proveedor.iniciarListener(this);
	        almacen.iniciarListener(this);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Eventos para la ventana Login
	        if (e.getSource() == login.getBtnValidar()) {
	            System.out.println("Botón validar pulsado");
	            login.setVisible(false);
	            home.setVisible(true);
	        }
	        // Eventos para la ventana Home
	        else if (e.getSource() == home.getBtnPedido()) {
	            System.out.println("Botón Pedido pulsado");
	            pedido.setVisible(true);
	            almacen.setVisible(false);
	            plato.setVisible(false);
	            usuario.setVisible(false);
	        } else if (e.getSource() == home.getBtnPlatos()) {
	            System.out.println("Botón plato pulsado");
	            plato.setVisible(true);
	            pedido.setVisible(false);
	            almacen.setVisible(false);
	            usuario.setVisible(false);

	        } else if (e.getSource() == plato.getIngredientes()) {
	            System.out.println("Boton ingredientes pulsados");
	            ingredientes.setVisible(true);
	        }else if (e.getSource() == home.getBtnUsuario()) {
	        	SesionUsuario usuarioActual = SesionUsuario.getUsuarioActual();
	            if (usuarioActual.getPermisos() != 1) {
	                JOptionPane.showMessageDialog(null, "No tienes permisos suficientes para acceder a esta área.",
	                        "Acceso denegado", JOptionPane.ERROR_MESSAGE);
	            } else {
	                System.out.println("Botón Usuario pulsado");
	                usuario.setVisible(true);
	                pedido.setVisible(false);
	                almacen.setVisible(false);
	                plato.setVisible(false);
	            }
	        
	        } else if (e.getSource() == home.getBtnAlmacen()) {
	            System.out.println("Botón almacen pulsado");
	            almacen.setVisible(true);
	            pedido.setVisible(false);
	            plato.setVisible(false);
	            usuario.setVisible(false);
	        } else if (e.getSource() == home.getBtnProveedor()) {
	            System.out.println("Botón proveedor pulsado");
	            proveedor.setVisible(true);
	        }

	        // Eventos para la ventana Almacen
	        else if (e.getSource() == almacen.getBtnGuardar()) {
	            // Tu lógica para guardar en almacén
	        }
	        // Eventos para la ventana Proveedor
	        else if (e.getSource() == proveedor.getBtnGuardar()) {
	            String nombre = proveedor.getNombre().getText();
	            String descripcion = proveedor.getDescripcion().getText();
	            String telefono = proveedor.getTelefono().getText();
	            String direccion = proveedor.getDireccion().getText();

	            if (nombre.isEmpty() || telefono.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "El nombre y el teléfono son campos obligatorios.",
	                        "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
	            } else {
	                // Crear el objeto Proveedor y añadir a la base de datos
	                VentanaProveedor nuevoProveedor = new VentanaProveedor(nombre, descripcion, telefono, direccion);
	                DaoProveedorMySql daoProveedor = new DaoProveedorMySql();
	                if (daoProveedor.insertar(nuevoProveedor)) {
	                    // Añadir la información del nuevo proveedor a la tabla de la interfaz
	                    DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
	                    modelo.addRow(new Object[] { nombre, descripcion, telefono, direccion });

	                    // Limpiar campos de texto
	                    proveedor.getNombre().setText("");
	                    proveedor.getDescripcion().setText("");
	                    proveedor.getTelefono().setText("");
	                    proveedor.getDireccion().setText("");

	                    JOptionPane.showMessageDialog(null, "Proveedor añadido con éxito.", "Proveedor Guardado",
	                            JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se pudo añadir el proveedor a la base de datos.",
	                            "Error al Guardar", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        } else if (e.getSource() == proveedor.getBtnBorrar()) {
	            
	        }
	    
	        else if (e.getSource() == usuario.getBtnGuardar()) {
	            String nombre = usuario.getTextNombre().getText();
	            String permisoTexto = usuario.getPermiso().getText();
	            int permiso;
	            try {
	                permiso = Integer.parseInt(permisoTexto);
	            } catch (NumberFormatException nfe) {
	                JOptionPane.showMessageDialog(null, "Permiso debe ser numérico.");
	                return;
	            }

	            if (nombre.isEmpty() || permisoTexto.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "El nombre y el permiso son campos obligatorios.",
	                        "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
	            } else {
	                Usuario nuevoUsuario = new Usuario();
	                nuevoUsuario.setNombre(nombre);
	                nuevoUsuario.setPermisos(permiso);

	                DaoUsuarioMySql daoUsuario = new DaoUsuarioMySql();
	                if (daoUsuario.insertar(nuevoUsuario)) {
	                    JOptionPane.showMessageDialog(null, "Usuario añadido con éxito.", "Usuario Guardado",
	                            JOptionPane.INFORMATION_MESSAGE);
	                   
	                    usuario.getTextNombre().setText("");
	                    usuario.getPermiso().setText("");
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se pudo añadir el usuario a la base de datos.",
	                            "Error al Guardar", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }}}
	    
	