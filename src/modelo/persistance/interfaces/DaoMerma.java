package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Merma;

public interface DaoMerma {
	
	public boolean insertar(Merma merm);
	public boolean borrar(int id);
	public boolean modificar(Merma merm);
	public Merma buscar(int id);
	public List<Merma> listar();

}
