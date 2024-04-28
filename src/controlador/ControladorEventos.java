package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


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
        this.proveedor = proveedor;

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
            
        }else if(e.getSource()==plato.getIngredientes()) {
        	System.out.println("Boton ingredientes pulsados");
        	ingredientes.setVisible(true);
        } else if (e.getSource() == home.getBtnUsuario()) {
            System.out.println("Botón Usuario pulsado");
            usuario.setVisible(true);
            pedido.setVisible(false);
            almacen.setVisible(false);
            plato.setVisible(false);
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
        	
            System.out.println("Boton guardar almacen pulsado");
            try {
                String producto = almacen.getProducto().getText();
                int precio = Integer.parseInt(almacen.getPrecio().getText());
                String proveedor = almacen.getProveedor().getText();
                String fechaCaducidad = almacen.getFechaCaducidad().getText();
                int cantidad = Integer.parseInt(almacen.getCantidad().getText());
                int merma = Integer.parseInt(almacen.getMerma().getText());

                if (producto.isEmpty() || fechaCaducidad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Crear una nueva instancia de Almacen con los datos proporcionados
                    Almacen materiaPrima = new Almacen(producto, precio, proveedor, fechaCaducidad, cantidad, merma);
                    // Obtener el modelo de la tabla
                    DefaultTableModel modelo = (DefaultTableModel) almacen.getTable().getModel();
                    // Agregar la fila al modelo de la tabla
                    modelo.addRow(new Object[]{producto, precio, proveedor, fechaCaducidad, cantidad, merma});
                    
                    almacen.getTable().revalidate();
                    // Limpiar los campos
                    almacen.getProducto().setText("");
                    almacen.getPrecio().setText("");
                    almacen.getProveedor().setText("");
                    almacen.getFechaCaducidad().setText("");
                    almacen.getCantidad().setText("");
                    almacen.getMerma().setText("");
                    JOptionPane.showMessageDialog(null, "Materia prima añadida con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para precio, cantidad y merma", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


        // Eventos para la ventana Proveedor
        else if (e.getSource() == proveedor.getBtnGuardar()) {
            System.out.println("Botón Guardar Pulsado");
            String nombre = proveedor.getNombre().getText();
            String descripcion = proveedor.getDescripcion().getText();
            String telefono = proveedor.getTelefono().getText();
            String direccion = proveedor.getDireccion().getText();

            if (proveedor.getNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else if (proveedor.getTelefono().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El telefono del contacto está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
               
               VentanaProveedor nuevoProveedor = new VentanaProveedor(nombre, descripcion, telefono, direccion);

               
                DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
                
                modelo.addRow(new String[]{nombre, descripcion, telefono, direccion});
               
                proveedor.getNombre().setText("");
                proveedor.getDescripcion().setText("");
                proveedor.getTelefono().setText("");
                proveedor.getDireccion().setText("");

                JOptionPane.showMessageDialog(null, "Proveedor añadido con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == proveedor.getBtnBorrar()) {
            System.out.println("Botón borrar pulsado");
          
            int filaSeleccionada = proveedor.getTable().getSelectedRow();
            if (filaSeleccionada != -1) { 
               
                DefaultTableModel modelo = (DefaultTableModel) proveedor.getTable().getModel();
                modelo.removeRow(filaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
