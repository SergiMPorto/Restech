package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelo.entidad.Proveedor;
import modelo.persistance.interfaces.DaoProveedor;
import vistas.VentanaProveedor;

public class DaoProveedorMySql implements DaoProveedor {
	
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
    public boolean insertar(Proveedor pv) {
        if (!abrirConexion()) {
            return false;
        }

        boolean insertado = true;
        String query = "INSERT INTO proveedores (nombre, descripcion, numero_contacto, direccion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, pv.getNombre());
            ps.setString(2, pv.getDescripcion());
            ps.setString(3, pv.getTelefono());
            ps.setString(4, pv.getDireccion());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                insertado = false;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar proveedor: " + pv);
            e.printStackTrace();
            insertado = false;
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
        String query = "DELETE FROM proveedores WHERE id_proveedor = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                borrado = false;
            }
        } catch (SQLException e) {
            System.err.println("Error al borrar proveedor con id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }

        return borrado;
    }

    @Override
    public boolean modificar(Proveedor pv) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE proveedores SET nombre = ?, descripcion = ?, numero_contacto = ?, direccion = ? WHERE id_proveedor = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, pv.getNombre());
            ps.setString(2, pv.getDescripcion());
            ps.setString(3, pv.getTelefono());
            ps.setString(4, pv.getDireccion());
            ps.setInt(5, pv.getId());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                modificado = false;
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar proveedor: " + pv);
            e.printStackTrace();
            modificado = false;
        } finally {
            cerrarConexion();
        }

        return modificado;
    }

    @Override
    public Optional<Proveedor> buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        Proveedor pv = null;
        String query = "SELECT id_proveedor, nombre, descripcion, numero_contacto, direccion FROM proveedores WHERE id_proveedor = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pv = new Proveedor();
                pv.setId(rs.getInt("id_proveedor"));
                pv.setNombre(rs.getString("nombre"));
                pv.setDescripcion(rs.getString("descripcion"));
                pv.setTelefono(rs.getString("numero_contacto"));
                pv.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar proveedor con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return Optional.ofNullable(pv);
    }

    @Override
    public List<Proveedor> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<Proveedor> listaProveedores = new ArrayList<>();
        String query = "SELECT id_proveedor, nombre, descripcion, numero_contacto, direccion FROM proveedores";

        try (PreparedStatement ps = conexion.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor pv = new Proveedor();
                pv.setId(rs.getInt("id_proveedor"));
                pv.setNombre(rs.getString("nombre"));
                pv.setDescripcion(rs.getString("descripcion"));
                pv.setTelefono(rs.getString("numero_contacto"));
                pv.setDireccion(rs.getString("direccion"));
                listaProveedores.add(pv);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar proveedores");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaProveedores;
    }

	@Override
	public boolean insertar(VentanaProveedor nuevoProveedor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	  public List<Proveedor> buscarPorNombre(String nombre) {
        if (!abrirConexion()) {
            return null;
        }

        List<Proveedor> listaProveedores = new ArrayList<>();
        String query = "SELECT id_proveedor, nombre, descripcion, numero_contacto, direccion FROM proveedores WHERE nombre LIKE ?";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pv = new Proveedor();
                pv.setId(rs.getInt("id_proveedor"));
                pv.setNombre(rs.getString("nombre"));
                pv.setDescripcion(rs.getString("descripcion"));
                pv.setTelefono(rs.getString("numero_contacto"));
                pv.setDireccion(rs.getString("direccion"));
                listaProveedores.add(pv);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar proveedores por nombre");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaProveedores;
    }

	
}

