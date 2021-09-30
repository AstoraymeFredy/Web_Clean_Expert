package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.Usuario;

public class UsuarioDaoImpl implements  Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;


	public Usuario login(String username, String password) throws Exception {
		Query query = em.createQuery("select u from Usuario u WHERE u.username=:name AND u.password=:pass", Usuario.class);
		query.setParameter("name", username);
		query.setParameter("pass", password);
		Usuario usuario = (Usuario) query.getSingleResult();
		return usuario;
	}

	public Usuario registrar(Usuario usuario) throws Exception {
		List<Usuario> lista = new ArrayList<Usuario>();
		TypedQuery<Usuario> q =em.createQuery("select u from Usuario u where u.username=:name AND u.password=:pass", Usuario.class);
		q.setParameter("name", usuario.getUsername());
		q.setParameter("pass", usuario.getPassword());
		lista = q.getResultList();
		if (!lista.isEmpty()) {
			throw new RuntimeException("El usuario ya existe");
		}
		em.persist(usuario);
		return usuario;
	}

	
}
