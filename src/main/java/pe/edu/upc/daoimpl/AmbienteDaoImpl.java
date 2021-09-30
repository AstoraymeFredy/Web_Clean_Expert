package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.entity.Ambiente;

public class AmbienteDaoImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Ambiente> listar() {
		List<Ambiente> lista = new ArrayList<Ambiente>();
		Query q = em.createQuery("select a from Ambiente a");
		lista = (List<Ambiente>) q.getResultList();
		return lista;
	}
}
