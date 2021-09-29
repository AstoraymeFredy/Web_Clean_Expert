package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Propiedad;

public class PropiedadDaoImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	

	public List<Propiedad> listarPorCliente(int idCliente)throws Exception{
		List<Propiedad> propiedades =new ArrayList<>();
		Query query=em.createQuery("select p from Propiedad p WHERE p.cliente.id_cliente=:idcli", Propiedad.class);
		query.setParameter("idcli", idCliente);
		propiedades=(List<Propiedad>)query.getResultList();
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
