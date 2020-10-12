package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorListar {

	@RequestMapping(path="listar-usuarios/", method= RequestMethod.GET)
	public ModelAndView listarUsuario() {
		ModelMap modelo = new ModelMap();
		
		Usuario luis = new Usuario();
		luis.setEmail("herreraluis.93@hotmail.com");
		luis.setRol("Admin");
		
		Usuario damian = new Usuario();
		damian.setEmail("damian@hotmail.com");
		damian.setRol("Otro rol");
		
		List<Usuario> lista = new LinkedList<>();
		lista.add(luis);
		lista.add(damian);
		
		modelo.put("USUARIOS", lista);
		
		return new ModelAndView("listaUsuario", modelo);
	}
}
