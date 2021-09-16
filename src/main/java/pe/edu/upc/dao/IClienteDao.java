package pe.edu.upc.dao;

import pe.edu.upc.entity.Cliente;

public interface IClienteDao {
	public Cliente obtenerCliente(int idUsuario);
	public void registrar (Cliente cliente);
}
