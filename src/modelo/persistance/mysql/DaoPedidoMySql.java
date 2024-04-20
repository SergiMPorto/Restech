package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            conexion.close();
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
        String query = "INSERT INTO pedidos (id_usuario, id_proveedor, fecha_pedido, costo_total) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, pd.getId_usuario().getId());
            ps.setInt(2, pd.getId_proveedor().getId());
            ps.setDate(3, java.sql.Date.valueOf(pd.getFechaPedidoDate()));
            ps.setFloat(4, pd.getCostoTotal());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                insertar = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar Pedido: " + pd);
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
        String query = "DELETE FROM pedidos WHERE id_pedido = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                borrado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar Pedido con id " + id);
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
        String query = "UPDATE pedidos SET id_usuario = ?, id_proveedor = ?, fecha_pedido = ?, costo_total = ? WHERE id_pedido = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, pd.getId_usuario().getId());
            ps.setInt(2, pd.getId_proveedor().getId());
            ps.setDate(3, java.sql.Date.valueOf(pd.getFechaPedidoDate()));
            ps.setFloat(4, pd.getCostoTotal());
            ps.setInt(5, pd.getId());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                modificado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar Pedido: " + pd);
            modificado = false;
            e.printStackTrace();
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
        String query = "SELECT id_pedido, id_usuario, id_proveedor, fecha_pedido, costo_total FROM pedidos WHERE id_pedido = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setId_usuario(new Usuario(rs.getInt("id_usuario")));
                pedido.setId_proveedor(new Proveedor(rs.getInt("id_proveedor")));
                pedido.setFechaPedidoDate(rs.getDate("fecha_pedido").toLocalDate());
                pedido.setCostoTotal(rs.getFloat("costo_total"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar Pedido con id " + id);
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

        List<Pedido> listaPedido = new ArrayList<>();
        String query = "SELECT id_pedido, id_usuario, id_proveedor, fecha_pedido, costo_total FROM pedidos";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setId_usuario(new Usuario(rs.getInt("id_usuario")));
                pedido.setId_proveedor(new Proveedor(rs.getInt("id_proveedor")));
                pedido.setFechaPedidoDate(rs.getDate("fecha_pedido").toLocalDate());
                pedido.setCostoTotal(rs.getFloat("costo_total"));
                listaPedido.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Pedido");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaPedido;
    }

}
