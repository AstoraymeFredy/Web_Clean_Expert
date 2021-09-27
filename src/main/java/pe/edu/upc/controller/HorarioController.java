package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Horario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IHorarioService;

@Named
@RequestScoped
public class HorarioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IHorarioService hService;
	private Horario horario;
	
	@PostConstruct
	public void init() {
		this.horario = new Horario();
	}
	
	public void obtenerHorario (Usuario usuario) {
		this.setHorario(hService.obtener(usuario.getId_usuario()));
	}
	
	public String registrarHorario () {
		hService.registrar(horario);
		limpiarHorario();
		return "personal.xhtml";
	}
	
	public String actualizar () {
		hService.actualizar(horario);
		limpiarHorario();
		return "personal.xhtml";
	}
	
	public void limpiarHorario() {
		this.init();
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	

}
