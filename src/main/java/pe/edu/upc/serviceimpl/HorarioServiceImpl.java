package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.HorarioDaoImpl;
import pe.edu.upc.entity.Horario;

@Named
@RequestScoped
public class HorarioServiceImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HorarioDaoImpl horariodaoimpl;
	
	public Horario obtener(int idUsuario) {
		return horariodaoimpl.obtener(idUsuario);
	}
	
	public void registrar(Horario horario) {
		horariodaoimpl.registrar(horario);
	}
	
	public void actualizar(Horario horario) {
		horariodaoimpl.actualizar(horario);
	}
	
	public List<Horario> findHorario() throws Exception{
		return horariodaoimpl.findHorario();
	}
}

