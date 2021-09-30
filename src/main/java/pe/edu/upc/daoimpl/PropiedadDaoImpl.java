package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Propiedad;
import pe.edu.upc.entity.Reserva;
import pe.edu.upc.entity.Usuario;

public class PropiedadDaoImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Propiedad> listarPorCliente(int idCliente)throws Exception{
		List<Propiedad> propiedades =new ArrayList<>();
		Query query=em.createQuery("select p from Propiedad p WHERE p.cliente.id_cliente=:idcli", Propiedad.class);
		query.setParameter("idcli", idCliente);
		propiedades=(List<Propiedad>)query.getResultList();
		return propiedades;
		}

	@Transactional
	public void eliminar(Propiedad propiedad)throws Exception {
		if (em.contains(propiedad)) {
			em.remove(propiedad);
		} else {
			Propiedad p = em.getReference(propiedad.getClass(), propiedad.getId());
			em.remove(p);
		}
	}

	@Transactional
	public int insertar(Propiedad propiedad)throws Exception {
		em.persist(propiedad);
		return propiedad.getId();
	}

	@Transactional
	public void actualizar(Propiedad propiedad)throws Exception {
		em.merge(propiedad);
	}
}
