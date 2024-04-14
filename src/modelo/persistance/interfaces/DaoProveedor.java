package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Proveedor;

public interface DaoProveedor {
	
	public int insertar(Proveedor pv);
	public int borrar(int id);
	public Proveedor modificar(Proveedor pv);
	public Proveedor buscar(int id);
	public List<Proveedor> listar();

}
