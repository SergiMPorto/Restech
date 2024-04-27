package controlador;

import modelo.entidad.Usuario;

public class SesionUsuario {
    private static Usuario usuarioActual = null;

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static Usuario getUsuarioActual() {
       
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay sesión activa");
        }
        return usuarioActual;
    }

  
    public static int getPermisos() {
        if (usuarioActual == null) {
           
            throw new IllegalStateException("No hay sesión activa para obtener permisos");
        }
        return usuarioActual.getPermisos();
    }
}