package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Ingrediente;
import modelo.entidad.MateriaPrima;
import modelo.entidad.Plato;
import modelo.persistance.interfaces.DaoIngrediente;

public class DaoIngredienteMySql implements DaoIngrediente{
	
	private Connection conexion;

    public boolean abrirConexion() {
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

    public boolean cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean insertar(Ingrediente i) {
        if (!abrirConexion()) {
            return false;
        }

        boolean insertar = true;
        String query = "INSERT INTO ingredientes (id_plato, id_materia_prima, cantidad) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, i.getId_plato().getId());
            ps.setInt(2, i.getId_materiaPrima().getId());
            ps.setFloat(3, i.getCantidad());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                insertar = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar Ingrediente: " + i);
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
        String query = "DELETE FROM ingredientes WHERE id_ingrediente = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                borrado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar Ingrediente con id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }

        return borrado;
    }

    @Override
    public boolean modificar(Ingrediente i) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE ingredientes SET id_plato = ?, id_materia_prima = ?, cantidad = ? WHERE id_ingrediente = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, i.getId_plato().getId());
            ps.setInt(2, i.getId_materiaPrima().getId());
            ps.setFloat(3, i.getCantidad());
            ps.setInt(4, i.getId());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                modificado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar Ingrediente: " + i);
            modificado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return modificado;
    }

    @Override
    public Ingrediente buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        Ingrediente ingrediente = null;
        String query = "SELECT id_ingrediente, id_plato, id_materia_prima, cantidad FROM ingredientes WHERE id_ingrediente = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ingrediente = new Ingrediente();
                ingrediente.setId_plato(new Plato());
                ingrediente.getId_plato().setId(rs.getInt("id_plato"));
                ingrediente.setId_materiaPrima(new MateriaPrima());
                ingrediente.getId_materiaPrima().setId(rs.getInt("id_materia_prima"));
                ingrediente.setCantidad(rs.getFloat("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar Ingrediente con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return ingrediente;
    }

    @Override
    public List<Ingrediente> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<Ingrediente> listaIngredientes = new ArrayList<>();
        String query = "SELECT id_ingrediente, id_plato, id_materia_prima, cantidad FROM ingredientes";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setId_plato(new Plato());
                ingrediente.getId_plato().setId(rs.getInt("id_plato"));
                ingrediente.setId_materiaPrima(new MateriaPrima());
                ingrediente.getId_materiaPrima().setId(rs.getInt("id_materia_prima"));
                ingrediente.setCantidad(rs.getFloat("cantidad"));
                listaIngredientes.add(ingrediente);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Ingrediente");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaIngredientes;
    }

}
