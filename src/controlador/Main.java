package controlador;

import modelo.entidad.Usuario;
import vistas.Almacen;



import vistas.Home;
import vistas.ListaPlatos;
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
        VentanaProveedor proveedor = new VentanaProveedor(null, null, null, null);
        ListaPlatos listaPlatos = new ListaPlatos();

    


        // Obtener el usuario logueado
        Usuario usuarioLogueado = obtenerUsuarioLogueado();

        // Inicializar el controlador con el usuario logueado
        ControladorEventos controlador = new ControladorEventos(login, home, almacen, pedido, plato, usuario, ingredientes, proveedor, listaPlatos);

        // Establecer los listeners para las vistas
        login.inciarListener(controlador);
        almacen.iniciarListener(controlador);
        home.agregarListener(controlador);
        plato.iniciarListener(controlador);
        usuario.inciarListener(controlador);
        pedido.establecerControlador(controlador);


        ingredientes.iniciarListener(controlador);
        proveedor.iniciarListener(controlador);
    }

    private static Usuario obtenerUsuarioLogueado() {
       
        return new Usuario(1, "NombreUsuario");
    }
}
