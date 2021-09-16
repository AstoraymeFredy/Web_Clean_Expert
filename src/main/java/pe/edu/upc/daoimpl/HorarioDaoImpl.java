package pe.edu.upc.daoimpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IHorarioDao;
import pe.edu.upc.entity.Horario;

public class HorarioDaoImpl implements IHorarioDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Override
	public Horario obtener(int idUsuario) {
		Horario h = new Horario();
		h = em.getReference(Horario.class, idUsuario);
		return h;
	}

	@Transactional
	@Override
	public void registrar(Horario horario) {
		em.persist(horario);
	}

	@Transactional
	@Override
	public void actualizar(Horario horario) {
		em.merge(horario);
	}
	
}
