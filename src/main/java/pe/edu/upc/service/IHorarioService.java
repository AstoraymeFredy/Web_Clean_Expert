package pe.edu.upc.service;

import pe.edu.upc.entity.Horario;

public interface IHorarioService {
	
	public Horario obtener(int idUsuario);
	
	public void registrar (Horario horario);
	
	public void actualizar (Horario horario);

}
