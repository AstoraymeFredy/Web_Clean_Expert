package pe.edu.upc.util;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.Usuario;
import java.io.Serializable;

@Named
@SessionScoped
public class Sesion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Usuario usuario;
	Cliente cliente;
	PersonalLimpieza personalLimpieza;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	
	
	
}
