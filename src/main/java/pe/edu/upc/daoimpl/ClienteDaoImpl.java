package pe.edu.upc.daoimpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IClienteDao;
import pe.edu.upc.entity.Cliente;

public class ClienteDaoImpl implements IClienteDao, Serializable  {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Override
	public Cliente obtenerCliente(int idUsuario) {
		Cliente c = new Cliente();
		c = em.getReference(Cliente.class, idUsuario);
		return c;
		
	}

	@Transactional
	@Override
	public void registrar(Cliente cliente) {
		em.persist(cliente);
	}
	
}
