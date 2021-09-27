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
import pe.edu.upc.util.Message;

@Named
@RequestScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	@Inject
	private ClienteController controllerCliente;
	
	private PersonalLimpieza personalLimpieza;
	@Inject
	private PersonalLimpiezaController controllerPL;

	@Inject
	private UsuarioServiceImpl uService;
	private Usuario usuario;
	
	private String username;
	private String password;
	
	private TipoUsuario tipoUsuario;
	

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
		this.cliente = new Cliente();
		this.personalLimpieza = new PersonalLimpieza();
		this.tipoUsuario = new TipoUsuario();
	}
	
	public String registrar (int idTipo) {
		try {
			if(idTipo == 1) {
				tipoUsuario = new TipoUsuario(1, "Cliente");
			} else {
				tipoUsuario = new TipoUsuario(2, "Personal de limpieza");
			}
			this.usuario.setTipoUsuario(tipoUsuario);
			uService.registrar(usuario);
			if (this.usuario.getTipoUsuario().getId() == 1) {
				this.cliente.setUsuario(usuario);
				controllerCliente.registrar(this.cliente);
			} else {
				this.personalLimpieza.setUsuario(usuario);
				controllerPL.registrar(this.personalLimpieza);
			}
		} catch (Exception e) {
			Message.messageError("Error al crear 2:  " + e.getMessage());
		}
		
		Message.messageInfo("Usuario registrado correctamente");
		return "/index";
	}
	
	public String login () {
		String view = ""; 
		try {
			this.setUsuario(uService.login(username, password));
			Message.messageInfo(usuario.getUsername());
			if(this.usuario.getTipoUsuario().getId() == 1) {
				setCliente(controllerCliente.obtenerCliente(usuario.getId_usuario()));
				Message.messageInfo("1 " + cliente.getApellidos());
				view = "/reservation/list";
			} else {
				controllerPL.obtenerPersonalLimpieza(usuario.getId_usuario());
				Message.messageInfo("2 " + personalLimpieza.getApellidos());
				view = "/service/list";
			}
		} catch (Exception e) {
			Message.messageError("Error al crear " + e.getMessage());
		}
		return view;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	
	
}
