package controlador;

import vista.VentanaLogin;
import vista.Home;
import vista.VentanaAltaProducto;

public class Main {

    public static void main(String[] args) {
        VentanaLogin login = new VentanaLogin();
        Home home = new Home();
        VentanaAltaProducto altaProducto = new VentanaAltaProducto();
        
        ControladorEventos controlador = new ControladorEventos(login, home, altaProducto);
        
        login.iniciarListener(controlador);
        home.agregarListener(controlador);
    }
}
