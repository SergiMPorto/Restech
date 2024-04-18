package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Home;
import vista.VentanaAltaProducto;
import vista.VentanaLogin;

public class ControladorEventos implements ActionListener {
    
    private VentanaLogin ventanaLogin;
    private Home home;
    private VentanaAltaProducto ventanaAltaProducto;

    public ControladorEventos(VentanaLogin ventanaLogin, Home home, VentanaAltaProducto ventanaAltaProducto) {
        this.ventanaLogin = ventanaLogin;
        this.home = home;
        this.ventanaAltaProducto = ventanaAltaProducto;

        home.agregarListener(this);
        ventanaLogin.iniciarListener(this);
        ventanaAltaProducto.IniciarListener(this);

        home.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaLogin.getBotonA1()) {
           home.setVisible(true);
            ventanaLogin.setVisible(false);
        }

        if (e.getSource() == home.getBotonAltaProducto()) {
            ventanaAltaProducto.setVisible(true);
            home.setVisible(true);
        }
    }
}
