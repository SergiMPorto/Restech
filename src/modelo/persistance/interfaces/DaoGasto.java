package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Gasto;

public interface DaoGasto {
	
	public boolean insertar(Gasto g);
	public boolean borrar(int id);
	public boolean modificar(Gasto g);
	public Gasto buscar(int id);
	List<Gasto> listar();
	List<Gasto> listarPorMes(int mes, int anio);
    List<Gasto> listarPorProveedor(int idProveedor);
	float obtenerSumaGastosPorProveedor(int idProveedor);
	}
