package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Horario;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.serviceimpl.PersonalLimpiezaServiceImpl;
import pe.edu.upc.util.Message;
import pe.edu.upc.util.Sesion;

@Named
@RequestScoped
public class PersonalLimpiezaController extends UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PersonalLimpiezaServiceImpl psService;
	
	@Inject
	Sesion sesion;
	
	PersonalLimpieza personalLimpieza;
	
	@PostConstruct
	public void init() {
		personalLimpieza = sesion.getPersonalLimpieza();
	}

	public void registrar(PersonalLimpieza personal) {
		try {
			Horario horario = new Horario();
			psService.registrar(personal, horario);
		} catch (Exception e) {
			Message.messageError("Error al crear:  " + e.getMessage());
		}
	}
	

	public PersonalLimpieza obtenerPersonalLimpieza (int idUsuario) throws Exception  {
		return psService.obtenerPersonalLimpieza(idUsuario);
	}
	
	public String modificarPersonal () {
		return "/perfil/modifyPersonal?faces-redirect=true";
	}
	
	public String actualizar () {
		try {
			sesion.setPersonalLimpieza(psService.actualizar(personalLimpieza));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/perfil/viewPerfilPS?faces-redirect=true";
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
	}

	
}
