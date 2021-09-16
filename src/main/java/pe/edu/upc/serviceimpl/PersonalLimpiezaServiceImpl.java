package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.inject.Inject;

import pe.edu.upc.dao.IPersonalLimpiezaDao;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.service.IPersonalLimpiezaService;

public class PersonalLimpiezaServiceImpl implements IPersonalLimpiezaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPersonalLimpiezaDao plD;

	@Override
	public PersonalLimpieza obtenerPersonalLimpieza(int idPersonalLimpieza) {
		return plD.obtenerPersonalLimpieza(idPersonalLimpieza);
	}

	@Override
	public void registrar(PersonalLimpieza personalLimpieza) {
		plD.registrar(personalLimpieza);
	}

}
