package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.IPersonalLimpiezaService;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClienteService cService;
	private Cliente cliente;
	
	@Inject
	private IPersonalLimpiezaService plService;
	private PersonalLimpieza personalLimpieza;
	
	@Inject
	private IUsuarioService uService;
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
		this.cliente = new Cliente();
		this.personalLimpieza = new PersonalLimpieza();
	}
	
	public String registrar () {
		this.setUsuario(uService.registrar(usuario));		
		if (usuario.getTipoUsuario().getId() == 1) {
			cliente.setUsuario(this.usuario);
			cService.registrar(cliente);
			return "cliente.xhtml";
		} else {
			personalLimpieza.setUsuario(this.usuario);
			plService.registrar(personalLimpieza);
			return "personal.xhtml";
		}
	}
	
	public String login () {
		this.setUsuario(uService.login(usuario));
		if (usuario.getTipoUsuario().getId() == 1) {
			return "cliente.xhtml";
		} else {
			return "personal.xhtml";
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
