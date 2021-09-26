package pe.edu.upc.daoimpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.PersonalLimpieza;

public class PersonalLimpiezaDaoImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	public PersonalLimpieza obtenerPersonalLimpieza(int idUsuario) throws Exception {
		Query query = em.createQuery("select pl from PersonalLimpieza pl where pl.tipoUsuario.id_usuario = " + idUsuario, PersonalLimpieza.class);
		PersonalLimpieza personalLimpieza = (PersonalLimpieza) query.getSingleResult();
		return personalLimpieza;
	}

	@Transactional
	public void registrar(PersonalLimpieza personalLimpieza) throws Exception {
		em.persist(personalLimpieza);
	}
	
	
}
