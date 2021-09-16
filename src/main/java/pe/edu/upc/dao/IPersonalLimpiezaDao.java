package pe.edu.upc.dao;

import pe.edu.upc.entity.PersonalLimpieza;

public interface IPersonalLimpiezaDao {
	public PersonalLimpieza obtenerPersonalLimpieza(int idPersonalLimpieza);
	public void registrar (PersonalLimpieza personalLimpieza);
}
