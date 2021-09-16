package pe.edu.upc.serviceimpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;

@Named
@RequestScoped
public class ClienteServiceImpl implements IClienteService, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IClienteService cD;

	@Override
	public Cliente obtenerCliente(int idUsuario) {
		return cD.obtenerCliente(idUsuario);
	}

	@Override
	public void registrar(Cliente cliente) {
		cD.registrar(cliente);
	}

}
