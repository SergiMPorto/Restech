package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Usuario;
import modelo.persistance.interfaces.DaoUsuario;

public class DaoUsuarioMySql implements DaoUsuario {
	
	private Connection conexion;

    private boolean abrirConexion() {
        String url = "jdbc:mysql://localhost:3306/bbdd";
        String usuario = "root";
        String password = "";
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean insertar(Usuario u) {
        if (!abrirConexion()) {
            return false;
        }

        boolean insertado = true;
        String query = "INSERT INTO usuarios (nombre, permisos) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getPermisos());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                insertado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar Usuario: " + u);
            insertado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return insertado;
    }

    @Override
    public boolean borrar(int id) {
        if (!abrirConexion()) {
            return false;
        }

        boolean borrado = true;
        String query = "DELETE FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                borrado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar Usuario con id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }

        return borrado;
    }

    @Override
    public boolean modificar(Usuario u) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE usuarios SET nombre = ?, permisos = ? WHERE id_usuario = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getPermisos());
            ps.setInt(3, u.getId());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                modificado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar Usuario: " + u);
            modificado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return modificado;
    }

    @Override
    public Usuario buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        Usuario u = null;
        String query = "SELECT id_usuario, nombre, permisos FROM usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setPermisos(rs.getInt("permisos"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar Usuario con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return u;
    }

    @Override
    public List<Usuario> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<Usuario> listaUsuarios = new ArrayList<>();
        String query = "SELECT id_usuario, nombre, permisos FROM usuarios";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setPermisos(rs.getInt("permisos"));
                listaUsuarios.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Usuarios");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaUsuarios;
    }

}
