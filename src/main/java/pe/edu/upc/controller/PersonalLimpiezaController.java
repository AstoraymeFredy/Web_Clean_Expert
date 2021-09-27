package pe.edu.upc.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.serviceimpl.PersonalLimpiezaServiceImpl;
import pe.edu.upc.util.Message;

@Named
@RequestScoped
public class PersonalLimpiezaController extends UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PersonalLimpiezaServiceImpl psService;

	public void registrar(PersonalLimpieza personal) {
		try {
			psService.registrar(personal);
		} catch (Exception e) {
			Message.messageError("Error al crear:  " + e.getMessage());
		}
	}
	

	public void obtenerPersonalLimpieza (int idUsuario) {
		try {
			setPersonalLimpieza(psService.obtenerPersonalLimpieza(idUsuario));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	
	
	
	
}
