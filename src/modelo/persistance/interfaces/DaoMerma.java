package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Merma;

public interface DaoMerma {
	
	public int insertar(Merma merm);
	public int borrar(int id);
	public Merma modificar(Merma merm);
	public Merma buscar(int id);
	public List<Merma> listar();

}
