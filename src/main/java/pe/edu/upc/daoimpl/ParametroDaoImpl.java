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

	public int insertar(Parametro parametro) throws Exception {
		em.persist(parametro);
		return parametro.getId_parametro();
	}
	
	public int editarParametro(Parametro parametro) {
		em.merge(parametro);
		return parametro.getId_parametro();
	}
	
	public List<Parametro> findAll() throws Exception{
		List<Parametro> parametros = new ArrayList<>();
		TypedQuery<Parametro> query = em.createQuery("SELECT pa FROM Parametro pa", Parametro.class);
		parametros = query.getResultList();
		return parametros;
	}
	
	public Parametro obtenerParametro(int idParametro) {
		Parametro p = new Parametro();
		p = em.getReference(Parametro.class, idParametro);
		return p;
	}
	
}