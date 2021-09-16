package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Servicio;

public interface IServicioDao {
	public Servicio insertar(Servicio servicio);
	public List<Servicio> listarPersonal(int idPersonalLimpieza);
	public List<Servicio> listarCliente(int idCliente);
}
