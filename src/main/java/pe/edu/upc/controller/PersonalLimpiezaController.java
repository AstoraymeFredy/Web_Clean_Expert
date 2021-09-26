package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.serviceimpl.PersonalLimpiezaServiceImpl;

@Named
@RequestScoped
public class PersonalLimpiezaController extends UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PersonalLimpiezaServiceImpl psService;
	// private PersonalLimpieza personalLimpieza;
	
	// @PostConstruct
	// public void init() {
	// 	this.personalLimpieza = new PersonalLimpieza();
	// }
	
	public String registrar() {
		try {
			psService.registrar(getPersonalLimpieza());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "personal.xhtml";
	}
	
	public void obtenerPersonalLimpieza () {
		try {
			this.setPersonalLimpieza(psService.obtenerPersonalLimpieza(getPersonalLimpieza().getId()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
