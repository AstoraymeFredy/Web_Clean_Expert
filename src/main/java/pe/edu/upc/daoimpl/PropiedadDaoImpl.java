package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Propiedad;

public class PropiedadDaoImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	/*
	public List<Propiedad> listdar(int idCliente) {
		List<Propiedad> lista = new ArrayList<Propiedad>();
		Query q = em.createQuery("select p from Propiedad p where p.id = " + idCliente);
		lista = (List<Propiedad>) q.getResultList();
		return lista;
	}
	*/
	
	/*public List<Propiedad> listar(int idCliente) throws Exception{
		List <Propiedad> prop=new ArrayList<>();
		TypedQuery<Propiedad> query=em.createQuery("FROM Propiedad p", Propiedad.class);
		prop=query.getResultList();
		return prop;
	}*/
	
	public List<Propiedad> listarPorCliente(int idCliente)throws Exception{
		List<Propiedad> propiedades =new ArrayList<>();
		TypedQuery<Propiedad> query=em.createQuery("FROM Propiedad p WHERE p.idcliente LIKE ?1", Propiedad.class);
		query.setParameter(1, "%" +idCliente+"%");
		propiedades=query.getResultList();
		return propiedades;
	}
	
	
	
	
	
	@Transactional
	public void eliminar(int idPropiedad) {
		Propiedad propiedad = new Propiedad();
		propiedad = em.getReference(Propiedad.class, idPropiedad);
		em.remove(propiedad);
	}
	
	@Transactional
	public void insertar(Propiedad propiedad)throws Exception {
		em.persist(propiedad);
	}

	
	public void actualizar(Propiedad propiedad)throws Exception {
		em.merge(propiedad);
	}
	
	
}
