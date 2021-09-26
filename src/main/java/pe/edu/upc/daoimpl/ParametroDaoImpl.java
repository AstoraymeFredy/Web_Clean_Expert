package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.Parametro;

public class ParametroDaoImpl implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	public Parametro obtenerParametro(int idParametro) {
		Parametro p = new Parametro();
		p = em.getReference(Parametro.class, idParametro);
		return p;
	}

	public List<Parametro> listar() {
		List<Parametro> parametros = new ArrayList<>();
		TypedQuery<Parametro> query = em.createQuery("SELECT p FROM Parametro p", Parametro.class);
		parametros = query.getResultList();
		return parametros;
	}
	
	public int editarParametro(Parametro parametro) {
		em.merge(parametro);
		return parametro.getId_parametro();
	}

	
}