package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.TipoUsuario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.serviceimpl.UsuarioServiceImpl;

@Named
@RequestScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cliente cliente;
	private ClienteController controllerCliente;
	
	@Inject
	private PersonalLimpieza personalLimpieza;
	private PersonalLimpiezaController controllerPL;
	
	@Inject
	private UsuarioServiceImpl uService;
	private Usuario usuario;
	
	private String username;
	private String password;
	
	private TipoUsuario tipoUsuario;
	
	private List<TipoUsuario> tiposUsuario;
	
	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
		this.cliente = new Cliente();
		this.personalLimpieza = new PersonalLimpieza();
		
		this.getAllUsers();
	}
	
	public void getAllUsers() {
		try {
			//products = productService.findAll();
		} catch(Exception e) {
			// Message.messageError("Error al carcar productos");
		}
	}
	
	public String registrar () {
		String view = "";
		try {
			this.usuario.setTipoUsuario(tipoUsuario);
			uService.registrar(usuario);
			if (this.usuario.getTipoUsuario().getId() == 1) {
				cliente.setUsuario(usuario);
				// controllerCliente.(cliente);
				view = controllerCliente.registrar();
			} else {
				personalLimpieza.setUsuario(usuario);
				// controllerPL.setPersonalLimpieza(personalLimpieza);
				view = controllerPL.registrar();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return view;
	}
	
	public String login () {
		String view = ""; 
		try {
			this.setUsuario(uService.login(username, password));
			if(this.usuario.getTipoUsuario().getId() == 1) {
				cliente.setUsuario(usuario);
				controllerCliente.setCliente(cliente);
				controllerCliente.obtenerCliente();
				view = "cliente.xhtml";
			} else {
				personalLimpieza.setUsuario(usuario);
				controllerPL.setPersonalLimpieza(personalLimpieza);
				controllerPL.obtenerPersonalLimpieza();
				view = "personal.xhtml";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return view;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
		
	
	
}
