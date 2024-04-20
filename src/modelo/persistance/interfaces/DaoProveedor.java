package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Proveedor;

public interface DaoProveedor {
	
	public boolean insertar(Proveedor pv);
	public boolean borrar(int id);
	public boolean modificar(Proveedor pv);
	public Proveedor buscar(int id);
	public List<Proveedor> listar();

}
