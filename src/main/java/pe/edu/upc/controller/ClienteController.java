package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;

@Named
@RequestScoped
public class ClienteController  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClienteService cService;
	private Cliente cliente;
	
	@PostConstruct
	public void init() {
		this.cliente = new Cliente();
	}
	
	public String registrar() {
		cService.registrar(cliente);
		return "cliente.xhtml";
	}
	
	public void obtenerCliente () {
		this.setCliente(cService.obtenerCliente(cliente.getId()));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
