package modelo.negocio;

import java.util.List;
import java.util.Optional;

import modelo.entidad.Proveedor;
import modelo.persistance.interfaces.DaoProveedor;
import modelo.persistance.mysql.DaoProveedorMySql;

public class GestorProveedor {
		
private DaoProveedor daoProveedor = new DaoProveedorMySql();
	
	
	public boolean insertar(Proveedor p) {
		
		boolean alta = daoProveedor.insertar(p);
		
		return alta;
	}


	public boolean borrar(int id) {
		
		boolean borrado = daoProveedor.borrar(id);
		
		return borrado;
		
	}
	
	public boolean modificar(Proveedor p) {
		
		boolean modificado = daoProveedor.modificar(p);
			
			return modificado;
		}
	
	
	public Optional<Proveedor> buscar(int id) {
		
		Optional<Proveedor> proveedor = daoProveedor.buscar(id);
		
		return proveedor;
	}
	
	public List<Proveedor> listar(){
		
		List<Proveedor> listaProveedor = daoProveedor.listar();
		
		return listaProveedor;
	}
}
