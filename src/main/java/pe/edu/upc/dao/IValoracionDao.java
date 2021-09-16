package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Valoracion;

public interface IValoracionDao {
	public List<Valoracion> listar();
	public void insertar (Valoracion valoracion);
}
