package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.inject.Inject;

import pe.edu.upc.daoimpl.PersonalLimpiezaDaoImpl;
import pe.edu.upc.entity.PersonalLimpieza;

public class PersonalLimpiezaServiceImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PersonalLimpiezaDaoImpl plD;

	public PersonalLimpieza obtenerPersonalLimpieza(int idUsuario) throws Exception {
		return plD.obtenerPersonalLimpieza(idUsuario);
	}

	public void registrar(PersonalLimpieza personalLimpieza) throws Exception {
		plD.registrar(personalLimpieza);
	}

}
