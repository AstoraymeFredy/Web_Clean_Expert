package pe.edu.upc.daoimpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Cliente;
public class ClienteDaoImpl implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	public Cliente obtenerCliente(int idUsuario) throws Exception {
		Query query = em.createQuery("select c from Cliente c where c.usuario.id_usuario = " + idUsuario, Cliente.class);
		Cliente cliente = (Cliente) query.getSingleResult();
		return cliente;
		
	}

	@Transactional
	public void registrar(Cliente cliente) throws Exception {
		em.persist(cliente);
	}
	
	@Transactional
	public Cliente actualizar(Cliente cliente)throws Exception {
		em.merge(cliente);
		return cliente;
	}
	
}
