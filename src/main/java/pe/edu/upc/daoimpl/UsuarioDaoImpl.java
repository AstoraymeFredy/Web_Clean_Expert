package pe.edu.upc.daoimpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.entity.Usuario;

public class UsuarioDaoImpl implements  Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;


	public Usuario login(String username, String password) throws Exception {
		Query query = em.createQuery("select u from Usuario u WHERE u.username=?1 AND u.password=?2", Usuario.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		Usuario usuario = (Usuario) query.getSingleResult();
		return usuario;
	}

	public Usuario registrar(Usuario usuario) throws Exception {
		em.persist(usuario);
		return usuario;
	}

	
}
