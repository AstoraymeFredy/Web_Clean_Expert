package pe.edu.upc.dao;

import pe.edu.upc.entity.Horario;

public interface IHorarioDao {

	public Horario obtener(int idUsuario);
	
	public void registrar (Horario horario);
	
	public void actualizar (Horario horario);
	
}
