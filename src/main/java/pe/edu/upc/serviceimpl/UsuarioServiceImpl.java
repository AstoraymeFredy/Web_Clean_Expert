package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.daoimpl.UsuarioDaoImpl;
import pe.edu.upc.entity.Usuario;

@Named
@RequestScoped
public class UsuarioServiceImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDaoImpl uD;

	public Usuario login(String username, String password) throws Exception {
		return uD.login(username, password);
	}

	@Transactional
	public Usuario registrar(Usuario usuario) throws Exception {
		return uD.registrar(usuario);
	}
}
