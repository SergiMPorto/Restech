package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.xdevapi.Statement;

import modelo.entidad.Pedido;
import modelo.entidad.Proveedor;
import modelo.entidad.Usuario;
import modelo.persistance.interfaces.DaoPedido;

public class DaoPedidoMySql implements DaoPedido {
	
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
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

   
    
    @Override
    public boolean insertar(Pedido pd) {
        if (!abrirConexion()) {
            return false;
        }

        boolean insertar = true;
        
        // Verificar si el usuario existe
        if (!usuarioExiste(pd.getIdUsuario())) {
            System.err.println("Usuario con id " + pd.getIdUsuario() + " no existe.");
            return false;
        }

        String query = "INSERT INTO pedido (id_usuario, id_proveedor, materia_prima, cantidad, fecha_pedido, precio) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, pd.getIdUsuario());
            ps.setInt(2, pd.getIdProveedor());
            ps.setString(3, pd.getMateriaPrima());
            ps.setDouble(4, pd.getCantidad());
            ps.setDate(5, java.sql.Date.valueOf(pd.getFechaPedido()));
            ps.setDouble(6, pd.getCostoTotal());

            int filasAfectadas = ps.executeUpdate();
            insertar = filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar Pedido: " + pd);
            e.printStackTrace();
            insertar = false;
        } finally {
            cerrarConexion();
        }
        return insertar;
    }

    private boolean usuarioExiste(int idUsuario) {
        String query = "SELECT COUNT(*) FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean borrar(int id) {
        if (!abrirConexion()) {
            return false;
        }

        boolean borrado = true;
        String query = "DELETE FROM pedido WHERE id_pedido = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();

            borrado = filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al borrar Pedido con id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }
        return borrado;
    }

    @Override
    public boolean modificar(Pedido pd) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE pedido SET id_usuario = ?, id_proveedor = ?, materia_prima = ?, cantidad = ?, fecha_pedido = ?, precio = ? WHERE id_pedido = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, pd.getIdUsuario());
            ps.setInt(2, pd.getIdProveedor());
            ps.setString(3, pd.getMateriaPrima());
            ps.setDouble(4, pd.getCantidad());
            ps.setDate(5, java.sql.Date.valueOf(pd.getFechaPedido()));
            ps.setDouble(6, pd.getCostoTotal());
            ps.setInt(7, pd.getId());
            
            int filasAfectadas = ps.executeUpdate();
            modificado = filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar Pedido: " + pd);
            e.printStackTrace();
            modificado = false;
        } finally {
            cerrarConexion();
        }
        return modificado;
    }

    @Override
    public Pedido buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        Pedido pedido = null;
        String query = "SELECT id_pedido, id_usuario, id_proveedor, materia_prima, cantidad, fecha_pedido, precio FROM pedido WHERE id_pedido = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setIdUsuario(rs.getInt("id_usuario"));
                pedido.setIdProveedor(rs.getInt("id_proveedor"));
                pedido.setMateriaPrima(rs.getString("materia_prima"));
                pedido.setCantidad(rs.getDouble("cantidad"));
                pedido.setFechaPedido(rs.getDate("fecha_pedido").toLocalDate());
                pedido.setCostoTotal(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Pedido con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return pedido;
    }

    @Override
    public List<Pedido> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<Pedido> listaPedidos = new ArrayList<>();
        String query = "SELECT id_pedido, id_usuario, id_proveedor, materia_prima, cantidad, fecha_pedido, precio FROM pedido";
        
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setIdUsuario(rs.getInt("id_usuario"));
                pedido.setIdProveedor(rs.getInt("id_proveedor"));
                pedido.setMateriaPrima(rs.getString("materia_prima"));
                pedido.setCantidad(rs.getDouble("cantidad"));
                pedido.setFechaPedido(rs.getDate("fecha_pedido").toLocalDate());
                pedido.setCostoTotal(rs.getDouble("precio"));
                
                listaPedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar Pedido");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaPedidos;
    }
    
    public int buscarIdUsuarioPorNombre(String nombreUsuario) {
	    if (!abrirConexion()) {
	        return -1; // Devolver un valor por defecto o lanzar una excepción, dependiendo de tus necesidades
	    }

	    int idUsuario = -1; // Valor por defecto si no se encuentra el usuario

	    String query = "SELECT id_usuario FROM usuarios WHERE nombre = ?";
	    try (PreparedStatement ps = conexion.prepareStatement(query)) {
	        ps.setString(1, nombreUsuario);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            idUsuario = rs.getInt("id_usuario");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al buscar ID de usuario por nombre: " + nombreUsuario);
	        e.printStackTrace();
	    } finally {
	        cerrarConexion();
	    }
	    return idUsuario;
	}

}
