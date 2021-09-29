package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Propiedad;
import pe.edu.upc.util.Message;


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
	/*
	public List<Propiedad> listarPorCliente(int idCliente) throws Exception{
		List <Propiedad> prop=new ArrayList<>();
		TypedQuery<Propiedad> query=em.createQuery("FROM Propiedad p WHERE p.idcliente LIKE ?1", Propiedad.class);
		query.setParameter(1, "%" +idCliente+"%");
		prop=(List<Propiedad>)query.getResultList();
		return prop;
	}*/

	
	
	public List<Propiedad> listarPorCliente(int idCliente)throws Exception{
		List<Propiedad> propiedades =new ArrayList<>();
		Query query=em.createQuery("select p from Propiedad p WHERE p.cliente.id_cliente=:idcli", Propiedad.class);
		query.setParameter("idcli", idCliente);
		propiedades=(List<Propiedad>)query.getResultList();
		return propiedades;
		}
		
		
		//Error :Could not locate ordinal parameter [1], expecting one of []
	
	
	
	
	
	
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
