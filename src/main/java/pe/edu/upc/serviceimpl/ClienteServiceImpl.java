package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.ClienteDaoImpl;
import pe.edu.upc.entity.Cliente;

@Named
@RequestScoped
public class ClienteServiceImpl implements  Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private ClienteDaoImpl cD;

	public Cliente obtenerCliente(int idUsuario) throws Exception {
		return cD.obtenerCliente(idUsuario);
	}

	public void registrar(Cliente cliente) throws Exception {
		cD.registrar(cliente);
	}
	
	public Cliente actualizar (Cliente cliente) throws Exception {
		return cD.actualizar(cliente);
	}

}
