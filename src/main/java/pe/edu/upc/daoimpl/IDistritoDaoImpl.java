package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.dao.IDistritoDao;
import pe.edu.upc.entity.Distrito;

public class IDistritoDaoImpl implements IDistritoDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> listar() {
		List<Distrito> lista = new ArrayList<Distrito>();
		Query q = em.createQuery("select d from Distrito d");
		lista = (List<Distrito>) q.getResultList();
		return lista;
	}
	
}
