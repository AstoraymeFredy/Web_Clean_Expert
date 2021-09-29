package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Valoracion;

public class ValoracionDaoImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@SuppressWarnings("unchecked")

	public List<Valoracion> listar() {
		List<Valoracion> lista = new ArrayList<Valoracion>();
		Query q = em.createQuery("select v from Valoracion v");
		lista = (List<Valoracion>) q.getResultList();
		return lista;
	}

	@Transactional

	public void insertar(Valoracion valoracion) {
		em.persist(valoracion);
	}
}
