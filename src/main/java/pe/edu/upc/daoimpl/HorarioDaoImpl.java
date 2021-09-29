package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Horario;

public class HorarioDaoImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;

	@Transactional
	public Horario obtener(int idUsuario) throws Exception{
		System.out.println("entrando dao");

		Query query = em.createQuery("select h from Horario h where h.personalLimpieza.id_personal_limpieza = " + idUsuario, Horario.class);
        Horario h= (Horario) query.getSingleResult();
		
	        //
		System.out.println("saliendo dao");
		System.out.println(h.getId_horario());
		return h;
	}

	@Transactional
	public void registrar(Horario horario) throws Exception{
		em.persist(horario);
	}
	@Transactional
	public List<Horario> findHorario() throws Exception{
		List<Horario> horarios = new ArrayList<>();
		TypedQuery<Horario> query = em.createQuery("SELECT h FROM Horario h", Horario.class);
		horarios = query.getResultList();
		return horarios;
	}

	@Transactional
	public void actualizar(Horario horario) throws Exception{
		em.merge(horario);
	}
	
}
