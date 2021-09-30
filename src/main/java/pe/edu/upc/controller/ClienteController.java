package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.upc.entity.Cliente;
import pe.edu.upc.serviceimpl.ClienteServiceImpl;
import pe.edu.upc.util.Message;
import pe.edu.upc.util.Sesion;

@Named
@RequestScoped
public class ClienteController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteServiceImpl cService;
	
	@Inject
	Sesion sesion;
	
	Cliente cliente;
	
	@PostConstruct
	public void init() {
		cliente = sesion.getCliente();
	}
	
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
	
	public String modificarCliente () {
		return "/perfil/modifyClient?faces-redirect=true";
	}
	
	public String accederDirecciones() {
		return "/addresses/listAddresses?faces-redirect=true";
	}
	
	public String actualizar () {
		try {
			sesion.setCliente(cService.actualizar(cliente));
		} catch (Exception e) {
			Message.messageError("Error al editar:  " + e.getMessage());
		}
		return "/perfil/viewPerfilC?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
