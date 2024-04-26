package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.MateriaPrima;
import modelo.entidad.Merma;
import modelo.persistance.interfaces.DaoMerma;

public class DaoMermaMySql implements DaoMerma {
	
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
	    public boolean insertar(Merma merm) {
	        if (!abrirConexion()) {
	            return false;
	        }

	        boolean insertar = true;
	        String query = "INSERT INTO mermas (id_materiaPrima, cantidad) VALUES (?, ?)";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setInt(1, merm.getMateriaPrima().getId());
	            ps.setFloat(2, merm.getCantidad());
	            int filasAfectadas = ps.executeUpdate();

	            if (filasAfectadas == 0) {
	                insertar = false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al insertar merma: " + merm);
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
	        String query = "DELETE FROM mermas WHERE id_merma = ?";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setInt(1, id);
	            int filasAfectadas = ps.executeUpdate();

	            if (filasAfectadas == 0) {
	                borrado = false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al borrar merma con id " + id);
	            e.printStackTrace();
	        } finally {
	            cerrarConexion();
	        }
	        return borrado;
	    }

	    @Override
	    public boolean modificar(Merma merm) {
	        if (!abrirConexion()) {
	            return false;
	        }

	        boolean modificado = true;
	        String query = "UPDATE mermas SET id_materiaPrima = ?, cantidad = ? WHERE id_merma = ?";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setInt(1, merm.getMateriaPrima().getId());
	            ps.setFloat(2, merm.getCantidad());
	            ps.setInt(3, merm.getId());

	            int filasAfectadas = ps.executeUpdate();
	            if (filasAfectadas == 0) {
	                modificado = false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al modificar merma: " + merm);
	            modificado = false;
	            e.printStackTrace();
	        } finally {
	            cerrarConexion();
	        }
	        return modificado;
	    }

	    @Override
	    public Merma buscar(int id) {
	        if (!abrirConexion()) {
	            return null;
	        }

	        Merma merm = null;
	        String query = "SELECT id_merma, id_materiaPrima, cantidad FROM mermas WHERE id_merma = ?";
	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                merm = new Merma();
	                merm.setId(rs.getInt(1));
	                merm.setMateriaPrima(new MateriaPrima());  // Asigna un objeto MateriaPrima y luego establece su ID
	                merm.getMateriaPrima().setId(rs.getInt(2));
	                merm.setCantidad(rs.getFloat(3));
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al buscar merma con id " + id);
	            e.printStackTrace();
	        } finally {
	            cerrarConexion();
	        }
	        return merm;
	    }

	    @Override
	    public List<Merma> listar() {
	        if (!abrirConexion()) {
	            return null;
	        }

	        List<Merma> listaMermas = new ArrayList<>();
	        String query = "SELECT id_merma, id_materiaPrima, cantidad FROM mermas";

	        try {
	            PreparedStatement ps = conexion.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Merma merm = new Merma();
	                merm.setId(rs.getInt(1));
	                merm.setMateriaPrima(new MateriaPrima());
	                merm.getMateriaPrima().setId(rs.getInt(2));
	                merm.setCantidad(rs.getFloat(3));

	                listaMermas.add(merm);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al listar mermas");
	            e.printStackTrace();
	        } finally {
	            cerrarConexion();
	        }

	        return listaMermas;
	    }

}
