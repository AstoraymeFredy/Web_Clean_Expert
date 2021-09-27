package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.serviceimpl.ClienteServiceImpl;

@Named
@RequestScoped
public class ClienteController extends UsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteServiceImpl cService;
	// private Cliente cliente;
	
	// @PostConstruct
	// public void init() {
	// 	this.cliente = new Cliente();
	// }
	
	public String registrar() {
		try {
			cService.registrar(getCliente());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "cliente.xhtml";
	}
	
	public void obtenerCliente () {
		try {
			setCliente(cService.obtenerCliente(getCliente().getUsuario().getId()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
