package modelo.persistance.interfaces;

import java.util.List;

import modelo.entidad.Usuario;

public interface DaoUsuario {
	
	public boolean insertar(Usuario u);
	public boolean borrar(int id);
	public boolean modificar(Usuario u);
	public Usuario buscar(int id);
	public List<Usuario> listar();
	public int obtenerPermisoPorId(int id);
	public Usuario buscarNombre(String nombre);
	public int buscarIdUsuarioPorNombre(String nombreUsuario);
	
	

}
