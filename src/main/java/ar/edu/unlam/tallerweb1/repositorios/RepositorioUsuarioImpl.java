package ar.edu.unlam.tallerweb1.repositorios;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// implelemtacion del repositorio de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	// Como todo repositorio maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioUsuarioImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}

	@Override
	public List<Usuario> devolverUsuario() {

		final Session session = sessionFactory.getCurrentSession();
		return  session.createCriteria(Usuario.class).list();
				
	}
	
	@Override
	public void eliminarUsuario(Long id) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Usuario usuario = (Usuario )session.createCriteria(Usuario.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
		session.delete(usuario);
	}
	
	@Override
	public Long crearUsuario(Usuario usuario) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Long usuario2 = (Long)session.save(usuario);
		
		return usuario2;
	}
}
