package pe.edu.upc.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.upc.entity.Cliente;
import pe.edu.upc.serviceimpl.ClienteServiceImpl;
import pe.edu.upc.util.Message;

@Named
@RequestScoped
public class ClienteController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteServiceImpl cService;
	
	public String registrar(Cliente cliente) {
		try {
			cService.registrar(cliente);
		} catch (Exception e) {
			Message.messageError("Error al crear:  " + e.getMessage());
		}
		
		return "/cliente";
	}
	
	public Cliente obtenerCliente (int idUsuario) throws Exception {
		return cService.obtenerCliente(idUsuario);
		
	}
	
}
