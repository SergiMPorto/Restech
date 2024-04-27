package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.MateriaPrima;
import modelo.entidad.Pedido;
import modelo.entidad.PedidoMateriaPrima;
import modelo.persistance.interfaces.DaoPedidoMateriaPrima;

public class DaoPedidoMateriaPrimaMySql implements DaoPedidoMateriaPrima {
	
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
    public boolean insertar(PedidoMateriaPrima pmp) {
        if (!abrirConexion()) {
            return false;
        }

        String query = "INSERT INTO pedido_materias_primas (id_pedido, id_materiaPrima, cantidad, costoUnitario, costoTotal) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, pmp.getPedido().getId());
            ps.setInt(2, pmp.getMateriaPrima().getId());
            ps.setFloat(3, pmp.getCantidad());
            ps.setFloat(4, pmp.getCostoUnitario());
            ps.setFloat(5, pmp.getCostoTotal());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar PedidoMateriaPrima: " + e.getMessage());
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

        String query = "DELETE FROM pedido_materias_primas WHERE id_pedidoMateriaPrima = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al borrar PedidoMateriaPrima con id " + id + ": " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public boolean modificar(PedidoMateriaPrima pmp) {
        if (!abrirConexion()) {
            return false;
        }

        String query = "UPDATE pedido_materias_primas SET id_pedido = ?, id_materiaPrima = ?, cantidad = ?, costoUnitario = ?, costoTotal = ? WHERE id_pedidoMateriaPrima = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, pmp.getPedido().getId());
            ps.setInt(2, pmp.getMateriaPrima().getId());
            ps.setFloat(3, pmp.getCantidad());
            ps.setFloat(4, pmp.getCostoUnitario());
            ps.setFloat(5, pmp.getCostoTotal());
            ps.setInt(6, pmp.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar PedidoMateriaPrima: " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public PedidoMateriaPrima buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        PedidoMateriaPrima pmp = null;
        String query = "SELECT id_pedidoMateriaPrima, id_pedido, id_materiaPrima, cantidad, costoUnitario, costoTotal FROM pedido_materias_primas WHERE id_pedidoMateriaPrima = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));

                MateriaPrima materiaPrima = new MateriaPrima();
                materiaPrima.setId(rs.getInt("id_materiaPrima"));

                pmp = new PedidoMateriaPrima(pedido, materiaPrima, rs.getFloat("cantidad"), rs.getFloat("costoUnitario"), rs.getFloat("costoTotal"));
                pmp.setId(rs.getInt("id_pedidoMateriaPrima"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar PedidoMateriaPrima con id " + id + ": " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        return pmp;
    }

    @Override
    public List<PedidoMateriaPrima> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<PedidoMateriaPrima> listaPMP = new ArrayList<>();
        String query = "SELECT id_pedidoMateriaPrima, id_pedido, id_materiaPrima, cantidad, costoUnitario, costoTotal FROM pedido_materias_primas";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));

                MateriaPrima materiaPrima = new MateriaPrima();
                materiaPrima.setId(rs.getInt("id_materiaPrima"));

                PedidoMateriaPrima pmp = new PedidoMateriaPrima(pedido, materiaPrima, rs.getFloat("cantidad"), rs.getFloat("costoUnitario"), rs.getFloat("costoTotal"));
                pmp.setId(rs.getInt("id_pedidoMateriaPrima"));

                listaPMP.add(pmp);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar PedidoMateriaPrima: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        return listaPMP;
    }

}
