package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Valoracion;

public interface IValoracionService {
	public List<Valoracion> listar();
	public void insertar (Valoracion valoracion);
}
