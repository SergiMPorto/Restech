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

        boolean insertar = true;
        String query = "INSERT INTO pedido_materias_primas (id_pedido, id_materia_prima, cantidad, costo_unitario, costo_total) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, pmp.getId_pedido().getId());
            ps.setInt(2, pmp.getId_materiaPrima().getId());
            ps.setFloat(3, pmp.getCantidad());
            ps.setFloat(4, pmp.getCostoUnitario());
            ps.setFloat(5, pmp.getCostoTotal());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                insertar = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar PedidoMateriaPrima: " + pmp);
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
        String query = "DELETE FROM pedido_materias_primas WHERE id_pedido_materia_prima = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                borrado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar PedidoMateriaPrima con id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }

        return borrado;
    }

    @Override
    public boolean modificar(PedidoMateriaPrima pmp) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE pedido_materias_primas SET id_pedido = ?, id_materia_prima = ?, cantidad = ?, costo_unitario = ?, costo_total = ? WHERE id_pedido_materia_prima = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, pmp.getId_pedido().getId());
            ps.setInt(2, pmp.getId_materiaPrima().getId());
            ps.setFloat(3, pmp.getCantidad());
            ps.setFloat(4, pmp.getCostoUnitario());
            ps.setFloat(5, pmp.getCostoTotal());
            ps.setInt(6, pmp.getId());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                modificado = false;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar PedidoMateriaPrima: " + pmp);
            modificado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return modificado;
    }

    @Override
    public PedidoMateriaPrima buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        PedidoMateriaPrima pmp = null;
        String query = "SELECT id_pedido_materia_prima, id_pedido, id_materia_prima, cantidad, costo_unitario, costo_total FROM pedido_materias_primas WHERE id_pedido_materia_prima = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pmp = new PedidoMateriaPrima();
                pmp.setId(rs.getInt("id_pedido_materia_prima"));
                pmp.setId_pedido(new Pedido(rs.getInt("id_pedido")));
                pmp.setId_materiaPrima(new MateriaPrima(rs.getInt("id_materia_prima")));
                pmp.setCantidad(rs.getFloat("cantidad"));
                pmp.setCostoUnitario(rs.getFloat("costo_unitario"));
                pmp.setCostoTotal(rs.getFloat("costo_total"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar PedidoMateriaPrima con id " + id);
            e.printStackTrace();
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

        List<PedidoMateriaPrima> listaPedidoMateriaPrima = new ArrayList<>();
        String query = "SELECT id_pedido_materia_prima, id_pedido, id_materia_prima, cantidad, costo_unitario, costo_total FROM pedido_materias_primas";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PedidoMateriaPrima pmp = new PedidoMateriaPrima();
                pmp.setId(rs.getInt("id_pedido_materia_prima"));
                pmp.setId_pedido(new Pedido(rs.getInt("id_pedido")));
                pmp.setId_materiaPrima(new MateriaPrima(rs.getInt("id_materia_prima")));
                pmp.setCantidad(rs.getFloat("cantidad"));
                pmp.setCostoUnitario(rs.getFloat("costo_unitario"));
                pmp.setCostoTotal(rs.getFloat("costo_total"));
                listaPedidoMateriaPrima.add(pmp);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar PedidoMateriaPrima");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaPedidoMateriaPrima;
    }

}
