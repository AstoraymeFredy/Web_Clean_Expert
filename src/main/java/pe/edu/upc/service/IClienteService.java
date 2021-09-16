package pe.edu.upc.service;

import pe.edu.upc.entity.Cliente;

public interface IClienteService {
	public Cliente obtenerCliente(int idUsuario);
	public void registrar (Cliente cliente);
}
