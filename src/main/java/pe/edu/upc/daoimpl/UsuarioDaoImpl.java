package pe.edu.upc.daoimpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entity.Usuario;

public class UsuarioDaoImpl implements IUsuarioDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Override
	public Usuario login(Usuario usuario) {
		Query q = em.createQuery("select u from Usuario u");
		Usuario u = new Usuario();
		return u;
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		em.persist(usuario);
		Usuario u = new Usuario();
		return u;
	}

	
}
