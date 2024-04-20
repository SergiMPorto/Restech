package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.MateriaPrima;
import modelo.persistance.interfaces.DaoMateriaPrima;

public class DaoMateriaPrimaMySql implements DaoMateriaPrima {
	
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
	    public boolean insertar(MateriaPrima mp) {
	        if (!abrirConexion()) {
	            return false;
	        }

	        boolean insertar = true;
	        String query = "INSERT INTO materia_prima (nombre, precio, proveedor, fecha_caducidad, cantidad_utilizada, merma) VALUES (?, ?, ?, ?, ?, ?)";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setString(1, mp.getNombre());
	            ps.setFloat(2, mp.getPrecio());
	            ps.setString(3, mp.getProveedor());
	            ps.setDate(4, java.sql.Date.valueOf(mp.getFechaCaducidad()));
	            ps.setFloat(5, mp.getCantidadUtilizada());
	            ps.setFloat(6, mp.getMerma());

	            int numeroFilasAfectadas = ps.executeUpdate();
	            if (numeroFilasAfectadas == 0) {
	                insertar = false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al insertar MateriaPrima: " + mp);
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
	        String query = "DELETE FROM materia_prima WHERE id_materia_prima = ?";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setInt(1, id);

	            int numeroFilasAfectadas = ps.executeUpdate();
	            if (numeroFilasAfectadas == 0) {
	                borrado = false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al borrar MateriaPrima con id " + id);
	            e.printStackTrace();
	            borrado = false;
	        } finally {
	            cerrarConexion();
	        }

	        return borrado;
	    }

	    @Override
	    public boolean modificar(MateriaPrima mp) {
	        if (!abrirConexion()) {
	            return false;
	        }

	        boolean modificado = true;
	        String query = "UPDATE materia_prima SET nombre = ?, precio = ?, proveedor = ?, fecha_caducidad = ?, cantidad_utilizada = ?, merma = ? WHERE id_materia_prima = ?";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setString(1, mp.getNombre());
	            ps.setFloat(2, mp.getPrecio());
	            ps.setString(3, mp.getProveedor());
	            ps.setDate(4, java.sql.Date.valueOf(mp.getFechaCaducidad()));
	            ps.setFloat(5, mp.getCantidadUtilizada());
	            ps.setFloat(6, mp.getMerma());
	            ps.setInt(7, mp.getId());

	            int numeroFilasAfectadas = ps.executeUpdate();
	            if (numeroFilasAfectadas == 0) {
	                modificado = false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al modificar MateriaPrima: " + mp);
	            modificado = false;
	            e.printStackTrace();
	        } finally {
	            cerrarConexion();
	        }

	        return modificado;
	    }

	    @Override
	    public MateriaPrima buscar(int id) {
	        if (!abrirConexion()) {
	            return null;
	        }

	        MateriaPrima materiaPrima = null;
	        String query = "SELECT id_materia_prima, nombre, precio, proveedor, fecha_caducidad, cantidad_utilizada, merma FROM materia_prima WHERE id_materia_prima = ?";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setInt(1, id);

	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                materiaPrima = new MateriaPrima();
	                materiaPrima.setNombre(rs.getString("nombre"));
	                materiaPrima.setPrecio(rs.getFloat("precio"));
	                materiaPrima.setProveedor(rs.getString("proveedor"));
	                materiaPrima.setFechaCaducidad(rs.getDate("fecha_caducidad").toLocalDate());
	                materiaPrima.setCantidadUtilizada(rs.getFloat("cantidad_utilizada"));
	                materiaPrima.setMerma(rs.getFloat("merma"));
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al buscar MateriaPrima con id " + id);
	            e.printStackTrace();
	        } finally {
	            cerrarConexion();
	        }

	        return materiaPrima;
	    }

	    @Override
	    public List<MateriaPrima> listar() {
	        if (!abrirConexion()) {
	            return null;
	        }

	        List<MateriaPrima> listaMateriaPrima = new ArrayList<>();
	        String query = "SELECT id_materia_prima, nombre, precio, proveedor, fecha_caducidad, cantidad_utilizada, merma FROM materia_prima";

	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                MateriaPrima materiaPrima = new MateriaPrima();
	                materiaPrima.setNombre(rs.getString("nombre"));
	                materiaPrima.setPrecio(rs.getFloat("precio"));
	                materiaPrima.setProveedor(rs.getString("proveedor"));
	                materiaPrima.setFechaCaducidad(rs.getDate("fecha_caducidad").toLocalDate());
	                materiaPrima.setCantidadUtilizada(rs.getFloat("cantidad_utilizada"));
	                materiaPrima.setMerma(rs.getFloat("merma"));
	                listaMateriaPrima.add(materiaPrima);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al listar MateriaPrima");
	            e.printStackTrace();
	        } finally {
	            cerrarConexion();
	        }

	        return listaMateriaPrima;
	    }

}
