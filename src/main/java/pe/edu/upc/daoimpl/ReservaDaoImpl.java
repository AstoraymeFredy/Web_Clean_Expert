package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Reserva;

public class ReservaDaoImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Transactional
	public Reserva insertar(Reserva reserva) throws Exception {
		em.persist(reserva);
		Reserva s = new Reserva();
		return s;
	}
	
	public Reserva obtenerReserva(int idReserva) throws Exception {
		Query query = em.createQuery("select r from Reserva r where r.id_reserva = " + idReserva, Reserva.class);
		Reserva reserva = (Reserva) query.getSingleResult();
		return reserva;		
	}

	public List<Reserva> listarPorPersonal(int idPersonalLimpieza) throws Exception {
		List<Reserva> lista = new ArrayList<Reserva>();
		TypedQuery<Reserva> query =em.createQuery("select r from Reserva r where r.personalLimpieza.id = ?1", Reserva.class);
		query.setParameter(1, idPersonalLimpieza);
		lista = query.getResultList();
		return lista;
	}
	
	public List<Reserva> listarPorCliente(int idCliente) throws Exception{
		List<Reserva> lista = new ArrayList<Reserva>();
		TypedQuery<Reserva> query =em.createQuery("select r from Reserva r where r.cliente.id = ?1", Reserva.class);
		query.setParameter(1, idCliente);
		lista = query.getResultList();
		return lista;
	}
}
