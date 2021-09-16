package pe.edu.upc.service;

import pe.edu.upc.entity.PersonalLimpieza;

public interface IPersonalLimpiezaService {
	public PersonalLimpieza obtenerPersonalLimpieza(int idPersonalLimpieza);
	public void registrar (PersonalLimpieza personalLimpieza);
}
