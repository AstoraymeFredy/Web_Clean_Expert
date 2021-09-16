package pe.edu.upc.daoimpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPersonalLimpiezaDao;
import pe.edu.upc.entity.PersonalLimpieza;

public class PersonalLimpiezaDaoImpl implements IPersonalLimpiezaDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Override
	public PersonalLimpieza obtenerPersonalLimpieza(int idPersonalLimpieza) {
		PersonalLimpieza ps = new PersonalLimpieza();
		ps = em.getReference(PersonalLimpieza.class, idPersonalLimpieza);
		return ps;
	}

	@Transactional
	@Override
	public void registrar(PersonalLimpieza personalLimpieza) {
		em.persist(personalLimpieza);
	}
	
	
}
