package ar.edu.unlam.tallerweb1.repositorios;


import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);
	
	List<Usuario> devolverUsuario ();
	
	void eliminarUsuario(Long id);
	
	Long crearUsuario(Usuario usuario);
}
