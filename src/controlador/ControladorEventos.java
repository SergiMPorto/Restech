package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.entidad.MateriaPrima;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.interfaces.DaoProveedor;
import modelo.persistance.mysql.DaoMateriaPrimaMySql;
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
    private VentanaPedido vantanaPedido;
    private VentanaPlato ventanaPlato;
    private VentanaUsuario ventanaUsuario;
    private VentanaIngredientes ingredientes;
    private VentanaProveedor ventanaProveedor;
    private DaoMateriaPrimaMySql daoMateriaPrima;
    private DaoProveedorMySql daoProveedor;
  //  private DaoUsuarioMySql daoUsuario;

    public ControladorEventos(Login login, Home home, Almacen almacen, VentanaPedido pedido, VentanaPlato plato, VentanaUsuario usuario,
            VentanaIngredientes ingredientes, VentanaProveedor ventanaProveedor) {
        this.login = login;
        this.home = home;
        this.almacen = almacen;
        this.vantanaPedido = pedido;
        this.ventanaPlato = plato;
        this.ventanaUsuario = usuario;
        this.ingredientes = ingredientes;
        this.ventanaProveedor = ventanaProveedor;
        this.daoMateriaPrima = new DaoMateriaPrimaMySql();
        this.daoProveedor = new DaoProveedorMySql();
      // this.daoUsuario = new DaoUsuarioMySql();

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
            vantanaPedido.setVisible(true);
            almacen.setVisible(false);
            ventanaPlato.setVisible(false);
            ventanaUsuario.setVisible(false);
        } else if (e.getSource() == home.getBtnPlatos()) {
            System.out.println("Botón plato pulsado");
            ventanaPlato.setVisible(true);
            vantanaPedido.setVisible(false);
            almacen.setVisible(false);
            ventanaUsuario.setVisible(false);
            
        }else if(e.getSource()==ventanaPlato.getIngredientes()) {
        	System.out.println("Boton ingredientes pulsados");
        	ingredientes.setVisible(true);
        } else if (e.getSource() == home.getBtnUsuario()) {
            System.out.println("Botón Usuario pulsado");
            ventanaUsuario.setVisible(true);
            vantanaPedido.setVisible(false);
            almacen.setVisible(false);
            ventanaPlato.setVisible(false);
        } else if (e.getSource() == home.getBtnAlmacen()) {
            System.out.println("Botón almacen pulsado");
            almacen.setVisible(true);
            vantanaPedido.setVisible(false);
            ventanaPlato.setVisible(false);
            ventanaUsuario.setVisible(false);
        } else if (e.getSource() == home.getBtnProveedor()) {
            System.out.println("Botón proveedor pulsado");
            ventanaProveedor.setVisible(true);
        }

        // Eventos para la ventana Almacen
        else if (e.getSource() == almacen.getBtnGuardar()) {
        	
            System.out.println("Boton guardar almacen pulsado");
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
                if (!daoMateriaPrima.insertar(materiaPrima)) {
                    // Mostrar un mensaje de advertencia si no se puede insertar en la base de datos
                    JOptionPane.showMessageDialog(null, "Error al añadir materia prima a la base de datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para precio, cantidad y merma", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha válida en el formato yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            //Borrar producto en almacen 
        }else if(e.getSource()==almacen.getBtnBorrar()) {
        	System.out.println("Botón de borrado pulsado");
        	
        	 if (mostrarConfirmacionBorrado()) {
                 int filaSeleccionada = almacen.getTable().getSelectedRow();
                 if (filaSeleccionada != -1) {
                     DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();

                     // OBTENER ID
                     int idProducto = (int) modelo.getValueAt(filaSeleccionada, 0);
                     
                     modelo.removeRow(filaSeleccionada);

                     // BORRAR PRODUCTO POR ID
                     if (!daoMateriaPrima.borrar(idProducto)) {
                         JOptionPane.showConfirmDialog(null, "Error al borrar la materia prima en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                 } else {
                     JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
        }

         //Eventos para la ventana Proveedor
        else if (e.getSource() == ventanaProveedor.getBtnGuardar()) {
            try {
                System.out.println("Botón Guardar Pulsado");
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
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre y el telefono", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ventanaProveedor.getBtnBorrar()) {
            System.out.println("Botón de borrado proveedor pulsado");

            if (mostrarConfirmacionBorrado()) {
                int filaSeleccionada = ventanaProveedor.getTable().getSelectedRow();
                if (filaSeleccionada != -1) {
                    DefaultTableModel modelo = (DefaultTableModel) ventanaProveedor.getTable().getModel();
                    
                    //OBTENER ID PROVEEDOR
                    int idProveedor = (int) modelo.getValueAt(filaSeleccionada, 0);

                    modelo.removeRow(filaSeleccionada);

                    // BORRAR PROVEEDOR DE LA BBDD POR ID
                    if (!daoProveedor.borrar(idProveedor)) {
                        JOptionPane.showMessageDialog(null, "Error al borrar el proveedor de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
       
    }
    
 // VENTANA CONFIRMACION BORRAR 
    private boolean mostrarConfirmacionBorrado() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar el producto?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        return opcion == JOptionPane.YES_OPTION;
    }

	
}