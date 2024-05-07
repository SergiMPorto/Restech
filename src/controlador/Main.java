package controlador;

import java.util.ArrayList;

import vistas.Almacen;
import vistas.Home;
import vistas.VentanaIngredientes;
import vistas.Login;
import vistas.VentanaPedido;
import vistas.VentanaPlato;
import vistas.VentanaProveedor;
import vistas.VentanaUsuario;

public class Main {

	public static void main(String[] args) {
        Login login = new Login();
        Almacen almacen = new Almacen();
        VentanaPedido pedido = new VentanaPedido();
        VentanaPlato plato = new VentanaPlato();
        VentanaUsuario usuario = new VentanaUsuario();
        Home home = new Home();
        VentanaIngredientes ingredientes = new VentanaIngredientes();
        VentanaProveedor proveedor = new VentanaProveedor( null, null, null, null);
        

        ControladorEventos controlador = new ControladorEventos(login, home, almacen, pedido, plato, usuario, ingredientes, proveedor);

        login.inciarListener(controlador);
        home.agregarListener(controlador);
        plato.iniciarListerner(controlador);
        usuario.inciarListener(controlador);
    }
}