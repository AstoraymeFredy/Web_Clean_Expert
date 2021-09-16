package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IServicioDao;
import pe.edu.upc.entity.Servicio;

public class ServicioDaoImpl implements IServicioDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Transactional
	@Override
	public Servicio insertar(Servicio servicio) {
		em.persist(servicio);
		Servicio s = new Servicio();
		return s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> listarPersonal(int idPersonalLimpieza) {
		List<Servicio> lista = new ArrayList<Servicio>();
		Query q =  em.createQuery("select p from Servicio p where p.personalLimpieza.id = " + idPersonalLimpieza);
		lista = (List<Servicio>) q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> listarCliente(int idCliente) {
		List<Servicio> lista = new ArrayList<Servicio>();
		Query q =  em.createQuery("select p from Servicio p where p.cliente.id = " + idCliente);
		lista = (List<Servicio>) q.getResultList();
		return lista;
	}
}
