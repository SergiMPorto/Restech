package modelo.persistance.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Merma;
import modelo.persistance.interfaces.DaoMerma;

public class DaoMermaMySql implements DaoMerma {
	
private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
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
		if(!abrirConexion()){
			return false;
		}
		boolean insertar = true;
		
		String query = "insert into mermas (id_materiaPrima,cantidad) "
				+ " values(?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setObject(1, merm.getId_materiaPrima());//--> Hay que mirar de introducir solo el id de la materia prima
			ps.setFloat(2, merm.getCantidad());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				insertar = false;
			}
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			insertar = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return insertar;
	}

	@Override
	public boolean borrar(int id) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete from merma where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			System.out.println("baja -> No se ha podido borrar"
					+ " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}
	

	@Override
	public boolean modificar(Merma merm) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update mermas set id_materiaPrima=?, cantidad=?, "
				+ " WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setObject(1, merm.getId_materiaPrima());
			ps.setFloat(2, merm.getCantidad());
			ps.setInt(3, merm.getIdMerma());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
			else
				modificado = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modificar -> error al modificar la "
					+ " merma " + merm);
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}

	@Override
	public Merma buscar(int id) {
		if(!abrirConexion()){
			return null;
		}		
		Merma merm = null;
		
		String query = "select id_merma,id_materiaPrima,cantidad, from mermas "
				+ "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				merm = new Merma();
				merm.setIdMerma(rs.getInt(1));
				merm.setId_materiaPrima(rs.getObject(2));//--> Mirar esta linea
				merm.setCantidad(rs.getFloat(4));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener la "
					+ "persona con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return merm;
	}

	@Override
	public List<Merma> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Merma> listaMermas = new ArrayList<>();
		
		String query = "select ID,NOMBRE,EDAD,PESO from personas";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Merma persona = new Merma();
				persona.setIdMerma(rs.getInt(1));
				persona.setId_materiaPrima(rs.getObject(2));//--> Mirar esta otra linea
				persona.setCantidad(rs.getFloat(3));
				
				listaMermas.add(persona);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaMermas;
	}

}
