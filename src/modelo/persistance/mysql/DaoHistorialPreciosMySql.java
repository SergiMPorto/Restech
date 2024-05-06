package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.HistorialPrecio;
import modelo.entidad.MateriaPrima;
import modelo.persistance.interfaces.DaoHistorialPrecios;


public class DaoHistorialPreciosMySql implements DaoHistorialPrecios {
	
	private Connection conexion;

    public boolean abrirConexion() {
        String url = "jdbc:mysql://localhost:3306/bbdd";
        String usuario = "root";
        String password = "";
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertar(HistorialPrecio hp) {
        if (!abrirConexion()) {
            return false;
        }

        boolean insertar = true;
        String query = "INSERT INTO historial_precios (id_materia_prima, precio, fecha) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, hp.getMateriaPrima().getId());
            ps.setFloat(2, hp.getPrecio());
            ps.setDate(3, java.sql.Date.valueOf(hp.getFecha()));

            int filasAfectadas = ps.executeUpdate();
            insertar = filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar HistorialPrecio: " + hp);
            insertar = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return insertar;
    }

    @Override
    public boolean borrar(int id) {
        if (!abrirConexion()) {
            return false;
        }

        boolean borrado = true;
        String query = "DELETE FROM historial_precios WHERE id_historial = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            borrado = filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al borrar HistorialPrecio con id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }

        return borrado;
    }

    @Override
    public boolean modificar(HistorialPrecio hp) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE historial_precios SET id_materia_prima = ?, precio = ?, fecha = ? WHERE id_historial = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, hp.getMateriaPrima().getId());
            ps.setFloat(2, hp.getPrecio());
            ps.setDate(3, java.sql.Date.valueOf(hp.getFecha()));
            ps.setInt(4, hp.getId()); // Asegúrate de tener un método getId() en HistorialPrecio para obtener el ID de historial

            int filasAfectadas = ps.executeUpdate();
            modificado = filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar HistorialPrecio: " + hp);
            modificado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return modificado;
    }

    @Override
    public HistorialPrecio buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        HistorialPrecio hp = null;
        String query = "SELECT id_historial, id_materia_prima, precio, fecha FROM historial_precios WHERE id_historial = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hp = new HistorialPrecio();
                hp.setMateriaPrima(new MateriaPrima());
                hp.getMateriaPrima().setId(rs.getInt("id_materia_prima"));
                hp.setPrecio(rs.getFloat("precio"));
                hp.setFecha(rs.getDate("fecha").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar HistorialPrecio con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return hp;
    }

    @Override
    public List<HistorialPrecio> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<HistorialPrecio> listaHistorial = new ArrayList<>();
        String query = "SELECT id_historial, id_materia_prima, precio, fecha FROM historial_precios";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HistorialPrecio hp = new HistorialPrecio();
                hp.setMateriaPrima(new MateriaPrima());
                hp.getMateriaPrima().setId(rs.getInt("id_materia_prima"));
                hp.setPrecio(rs.getFloat("precio"));
                hp.setFecha(rs.getDate("fecha").toLocalDate());
                listaHistorial.add(hp);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar HistorialPrecio");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaHistorial;
    }

}
