package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.TipoUsuario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.serviceimpl.ClienteServiceImpl;
import pe.edu.upc.serviceimpl.UsuarioServiceImpl;
import pe.edu.upc.util.Message;
import pe.edu.upc.util.Sesion;

@Named
@SessionScoped
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
	
	@Inject
	private Sesion sesion;
	

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
		this.cliente = new Cliente();
		this.personalLimpieza = new PersonalLimpieza();
		this.tipoUsuario = new TipoUsuario();
	}
	
	public String registrar (int idTipo) {
		String view = ""; 
		try {
			if(idTipo == 1) {
				tipoUsuario = new TipoUsuario(1, "Cliente");
			} else {
				tipoUsuario = new TipoUsuario(2, "Personal de limpieza");
			}
			Message.messageInfo(this.tipoUsuario.getNombre());
			this.usuario.setTipoUsuario(tipoUsuario);
			Message.messageInfo(this.usuario.getUsername());
			uService.registrar(usuario);
			Message.messageInfo(usuario.getUsername());
			if (this.usuario.getTipoUsuario().getId() == 1) {
				this.cliente.setUsuario(usuario);
				
				controllerCliente.registrar(this.cliente);
			} else {
				this.personalLimpieza.setUsuario(usuario);
				controllerPL.registrar(this.personalLimpieza);
			}
			Message.messageInfo("Usuario registrado correctamente");
			view = "/index?faces-redirect=true";
		} catch (Exception e) {
			Message.messageError("Error al crear el usuario:  " + e.getMessage());
		}
		
		
		return view;
	}
	
	public String login () {
		String view = ""; 
		try {
			this.setUsuario(uService.login(username, password));
			sesion.setUsuario(usuario);
			if(this.usuario.getTipoUsuario().getId() == 1) {
				setCliente(controllerCliente.obtenerCliente(usuario.getId_usuario()));
				sesion.setCliente(cliente);
				view = "/reservation/list?faces-redirect=true";
			} else {
				setPersonalLimpieza(controllerPL.obtenerPersonalLimpieza(usuario.getId_usuario()));
				sesion.setPersonalLimpieza(personalLimpieza);
				view = "/service/list?faces-redirect=true";
			}
		} catch (Exception e) {
			Message.messageError("Error al iniciar sesion" + e.getMessage());
		}
		Message.messageInfo("Bienvenido");
		this.username = "";
		this.password = "";
		return view;
	}
	
	public String actualizar(int idTipoUsuario) {
		String view = ""; 
		try {
			if(idTipoUsuario == 1) {
				// controllerCliente.actualizar(cliente);
			} else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return view;
	}
	
	public String modificarCliente() {
		// cliente = sesion.getCliente();
		return "/perfil/modifyClient";
	}
	
	public String logout() {
		sesion.setUsuario(new Usuario());
		sesion.setCliente(new Cliente());
		sesion.setPersonalLimpieza(new PersonalLimpieza());
		return "/index?faces-redirect=true";
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

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	
	
	
}
