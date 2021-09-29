package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Horario;

public class HorarioDaoImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;


	public Horario obtener(int idUsuario) {
		Horario h = new Horario();
		h = em.getReference(Horario.class, idUsuario);
		return h;
	}

	@Transactional
	public void registrar(Horario horario) {
		em.persist(horario);
	}
	
	
	
	public List<Horario> findHorario() throws Exception{
		List<Horario> horarios = new ArrayList<>();
		TypedQuery<Horario> query = em.createQuery("SELECT h FROM Horario h", Horario.class);
		horarios = query.getResultList();
		return horarios;
	}

	@Transactional
	public void actualizar(Horario horario) {
		em.merge(horario);
	}
	
}
