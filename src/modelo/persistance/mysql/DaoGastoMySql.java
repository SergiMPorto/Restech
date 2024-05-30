package modelo.persistance.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Gasto;
import modelo.entidad.Pedido;
import modelo.persistance.interfaces.DaoGasto;

public class DaoGastoMySql implements DaoGasto {

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
    public boolean insertar(Gasto gasto) {
        if (!abrirConexion()) {
            return false;
        }
        boolean insertar = true;

        String query = "INSERT INTO gastos (id_pedido, costo, fecha) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, gasto.getPedido().getId());
            ps.setFloat(2, gasto.getCosto());
            ps.setDate(3, java.sql.Date.valueOf(gasto.getFecha()));

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                insertar = false;
            }
        } catch (SQLException e) {
            System.out.println("alta -> Error al insertar: " + gasto);
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
        String query = "DELETE FROM gastos WHERE id_gasto = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                borrado = false;
            }
        } catch (SQLException e) {
            System.out.println("baja -> No se ha podido borrar el id " + id);
            e.printStackTrace();
            borrado = false;
        } finally {
            cerrarConexion();
        }

        return borrado;
    }

    
    @Override
    public boolean modificar(Gasto gasto) {
        if (!abrirConexion()) {
            return false;
        }

        boolean modificado = true;
        String query = "UPDATE gastos SET id_pedido = ?, costo = ?, fecha = ? WHERE id_gasto = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, gasto.getPedido().getId());
            ps.setFloat(2, gasto.getCosto());
            ps.setDate(3, java.sql.Date.valueOf(gasto.getFecha()));
            ps.setInt(4, gasto.getIdGasto());

            int numeroFilasAfectadas = ps.executeUpdate();
            if (numeroFilasAfectadas == 0) {
                modificado = false;
            }
        } catch (SQLException e) {
            System.out.println("modificar -> Error al modificar el gasto: " + gasto);
            modificado = false;
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return modificado;
    }

    
    @Override
    public Gasto buscar(int id) {
        if (!abrirConexion()) {
            return null;
        }

        Gasto gasto = null;
        String query = "SELECT id_gasto, id_pedido, costo, fecha FROM gastos WHERE id_gasto = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gasto = new Gasto();
                gasto.setIdGasto(rs.getInt("id_gasto"));
                gasto.setPedido(new Pedido(rs.getInt("id_pedido"))); // Usar pedido directamente
                gasto.setCosto(rs.getFloat("costo"));
                gasto.setFecha(rs.getDate("fecha").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println("buscar -> Error al obtener el gasto con id " + id);
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return gasto;
    }

    
    @Override
    public List<Gasto> listar() {
        if (!abrirConexion()) {
            return null;
        }

        List<Gasto> listaGastos = new ArrayList<>();
        String query = "SELECT id_gasto, id_pedido, costo, fecha FROM gastos";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Gasto gasto = new Gasto();
                gasto.setIdGasto(rs.getInt("id_gasto"));
                gasto.setPedido(new Pedido(rs.getInt("id_pedido"))); // Usar pedido directamente
                gasto.setCosto(rs.getFloat("costo"));
                gasto.setFecha(rs.getDate("fecha").toLocalDate());
                listaGastos.add(gasto);
            }
        } catch (SQLException e) {
            System.out.println("listar -> Error al obtener los gastos");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaGastos;
    }

    @Override
    public List<Gasto> listarPorMes(int mes, int anio) {
        if (!abrirConexion()) {
            return null;
        }

        List<Gasto> listaGastos = new ArrayList<>();
        String query = "SELECT id_gasto, id_pedido, costo, fecha FROM gastos WHERE MONTH(fecha) = ? AND YEAR(fecha) = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, mes);
            ps.setInt(2, anio);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Gasto gasto = new Gasto();
                gasto.setIdGasto(rs.getInt("id_gasto"));
                gasto.setPedido(new Pedido(rs.getInt("id_pedido"))); // Usar pedido directamente
                gasto.setCosto(rs.getFloat("costo"));
                gasto.setFecha(rs.getDate("fecha").toLocalDate());
                listaGastos.add(gasto);
            }
        } catch (SQLException e) {
            System.out.println("listarPorMes -> Error al obtener los gastos del mes");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaGastos;
    }

  
    @Override
    public List<Gasto> listarPorProveedor(int idProveedor) {
        if (!abrirConexion()) {
            return null;
        }

        List<Gasto> listaGastos = new ArrayList<>();
        
        String query = "SELECT g.id_gasto, g.id_pedido, g.costo, g.fecha, p.ID_Proveedor, p.materia_prima, p.cantidad, p.precio " +
                       "FROM gastos g INNER JOIN pedido p ON g.id_pedido = p.ID_Pedido WHERE p.ID_Proveedor = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Gasto gasto = new Gasto();
                gasto.setIdGasto(rs.getInt("id_gasto"));
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setIdProveedor(rs.getInt("ID_Proveedor"));
                pedido.setMateriaPrima(rs.getString("materiaPrima"));
                pedido.setCantidad(rs.getFloat("cantidad"));
                pedido.setCostoTotal(rs.getFloat("costoTotal"));
                gasto.setPedido(pedido); 
                gasto.setCosto(rs.getFloat("costo"));
                gasto.setFecha(rs.getDate("fecha").toLocalDate()); 
                listaGastos.add(gasto);
            }
        } catch (SQLException e) {
            System.out.println("listarPorProveedor -> Error al obtener los gastos del proveedor");
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaGastos;
    }

    
    }
