package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Propiedad;

public interface IPropiedadDao {
	public List<Propiedad> listar(int idCliente);
	public void eliminar (int idPropiedad);
	public void insertar (Propiedad propiedad);
	public void actualizar (Propiedad propiedad);
}
