package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class UsuarioServiceImpl implements IUsuarioService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUsuarioDao uD;

	@Override
	public Usuario login(Usuario usuario) {
		return uD.login(usuario);
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		return uD.registrar(usuario);
	}
}
