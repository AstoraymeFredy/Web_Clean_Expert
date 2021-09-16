package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.Servicio;
import pe.edu.upc.service.IServicioService;

@Named
@RequestScoped
public class ServicioController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IServicioService sService;
	private Servicio servicio;
	
	private List<Servicio> listaCliente;
	private List<Servicio> listaPersonal;
	
	@PostConstruct
	public void init() {
		this.servicio = new Servicio();
		
		this.listaCliente = new ArrayList<Servicio>();
		this.listaPersonal = new ArrayList<Servicio>();
	}
	
	public String nuevoServicio () {
		this.setServicio(new Servicio());
		return "crearServicio.xhtml";
	}
	
	public void registrar () {
		sService.insertar(servicio);
		limpiar();
	}
	
	public void listarCliente(Cliente cliente) {
		listaCliente = sService.listarCliente(cliente.getId());
	}
	
	public void listarPersonal(PersonalLimpieza personal) {
		listaPersonal = sService.listarPersonal(personal.getId());
	}
	
	public void limpiar () {
		this.init();
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Servicio> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Servicio> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<Servicio> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(List<Servicio> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}
	
	
	
	
}
