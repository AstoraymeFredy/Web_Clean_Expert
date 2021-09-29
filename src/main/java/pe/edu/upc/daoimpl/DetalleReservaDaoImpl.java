package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.entity.DetalleReserva;
import pe.edu.upc.entity.Propiedad;

public class DetalleReservaDaoImpl implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;


	public List<DetalleReserva> listarDetalleReserva(long idReserva) throws Exception{
		List<DetalleReserva> lista = new ArrayList<DetalleReserva>();
		TypedQuery<DetalleReserva> query =em.createQuery("select d from DetalleReserva d where d.reserva.id = ?1", DetalleReserva.class);
		query.setParameter(1, idReserva);
		lista=query.getResultList();
		System.out.println(lista);
		return lista;
	}
}
