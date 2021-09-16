package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.service.IPersonalLimpiezaService;

public class PersonalLimpiezaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPersonalLimpiezaService psService;
	private PersonalLimpieza personalLimpieza;
	
	@PostConstruct
	public void init() {
		this.personalLimpieza = new PersonalLimpieza();
	}
	
	public String registrar() {
		psService.registrar(personalLimpieza);
		return "personal.xhtml";
	}
	
	public void obtenerPersonalLimpieza () {
		this.setPersonalLimpieza(psService.obtenerPersonalLimpieza(personalLimpieza.getId()));
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
	}
	
	
	
}
