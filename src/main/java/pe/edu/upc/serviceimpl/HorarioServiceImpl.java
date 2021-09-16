package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Horario;
import pe.edu.upc.service.IHorarioService;

@Named
@RequestScoped
public class HorarioServiceImpl implements IHorarioService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IHorarioService hD;
	
	@Override
	public Horario obtener(int idUsuario) {
		return hD.obtener(idUsuario);
	}
	
	@Override
	public void registrar(Horario horario) {
		hD.registrar(horario);
	}
	
	@Override
	public void actualizar(Horario horario) {
		hD.actualizar(horario);
	}
}
