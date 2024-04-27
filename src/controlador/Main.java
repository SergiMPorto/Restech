package controlador;

import vista.Login;
import vista.Usuario;
import vista.Plato;
import vista.Proveedor;

import java.util.ArrayList;

import vista.Almacen;
import vista.Home;
import vista.Ingredientes;
import vista.Pedido;

public class Main {

    public static void main(String[] args) {
    	
   Login login = new Login(); 	
   Almacen almacen = new Almacen();
   Pedido pedido = new Pedido();
   Plato plato = new Plato();
   Usuario usuario = new Usuario();
   Home home = new Home();
   Ingredientes ingredientes = new Ingredientes(new ArrayList<String>());
   Proveedor proveedor = new Proveedor(null, null, null, null);
   
   ControladorEventos controlador = new ControladorEventos(login, home, almacen, pedido, plato, usuario, ingredientes,proveedor);
   
   
   login.inciarListener(controlador);
   home.agregarListener(controlador);
   plato.iniciarListerner(controlador);
   
       
}
}
