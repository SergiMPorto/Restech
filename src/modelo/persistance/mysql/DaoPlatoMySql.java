package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Plato;
import modelo.persistance.interfaces.DaoPlato;

public class DaoPlatoMySql implements DaoPlato{

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
    public boolean insertar(Plato pl) {
        if (!abrirConexion()) {
            return false;
        }

        String query = "INSERT INTO platos (nombre, precio, tiempo_preparacion) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, pl.getNombre());
            ps.setFloat(2, pl.getPrecio());
            ps.setInt(3, pl.getTiempoPreparacion());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar Plato: " + pl + " - " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public boolean borrar(int id) {
        if (!abrirConexion()) {
            return false;
        }

        String query = "DELETE FROM platos WHERE id_plato = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al borrar Plato con id " + id + ": " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public boolean modificar(Plato pl) {
        if (!abrirConexion()) {
            return false;
        }

        String query = "UPDATE platos SET nombre = ?, precio = ?, tiempo_preparacion = ? WHERE id_plato = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, pl.getNombre());
            ps.setFloat(2, pl.getPrecio());
            ps.setInt(3, pl.getTiempoPreparacion());
            ps.setInt(4, pl.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar Plato: " + pl + " - " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public Plato buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        Plato pl = null;
        String query = "SELECT id_plato, nombre, precio, tiempo_preparacion FROM platos WHERE id_plato = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pl = new Plato();
                pl.setId(rs.getInt("id_plato"));
                pl.setNombre(rs.getString("nombre"));
                pl.setPrecio(rs.getFloat("precio"));
                pl.setTiempoPreparacion(rs.getInt("tiempo_preparacion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Plato con id " + id + ": " + e.getMessage());
        } finally {
            cerrarConexion();
        }

        return pl;
    }

    @Override
    public List<Plato> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<Plato> listaPlatos = new ArrayList<>();
        String query = "SELECT id_plato, nombre, precio, tiempo_preparacion FROM platos";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Plato pl = new Plato();
                pl.setId(rs.getInt("id_plato"));
                pl.setNombre(rs.getString("nombre"));
                pl.setPrecio(rs.getFloat("precio"));
                pl.setTiempoPreparacion(rs.getInt("tiempo_preparacion"));
                listaPlatos.add(pl);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Platos: " + e.getMessage());
        } finally {
            cerrarConexion();
        }

        return listaPlatos;
    }
}