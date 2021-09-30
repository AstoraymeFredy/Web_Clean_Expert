package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.Distrito;

public class DistritoDaoImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
	public List<Distrito> listarDistritos() throws Exception{
		List <Distrito> distritos=new ArrayList<>();
		TypedQuery<Distrito> query=em.createQuery("SELECT d FROM Distrito d", Distrito.class);
		distritos=query.getResultList();
		return distritos;
	}
}
