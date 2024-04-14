package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Usuario;

public interface DaoUsuario {
	
	public int insertar(Usuario u);
	public int borrar(int id);
	public Usuario modificar(Usuario u);
	public Usuario buscar(int id);
	public List<Usuario> listar();

}
