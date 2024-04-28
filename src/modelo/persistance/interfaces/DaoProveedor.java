package modelo.persistance.interfaces;

import java.util.List;
import java.util.Optional;

import modelo.entidad.Proveedor;
import vistas.VentanaProveedor;

public interface DaoProveedor {
	
	boolean insertar(Proveedor proveedor);
    boolean borrar(int id);
    boolean modificar(Proveedor proveedor);
    Optional<Proveedor> buscar(int id);
    List<Proveedor> listar();
	boolean insertar(VentanaProveedor nuevoProveedor);


}
