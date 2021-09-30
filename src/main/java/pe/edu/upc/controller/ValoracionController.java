package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.Reserva;
import pe.edu.upc.entity.Valoracion;
import pe.edu.upc.serviceimpl.ValoracionServiceImpl;
import pe.edu.upc.util.Message;


@Named
@SessionScoped
public class ValoracionController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ValoracionServiceImpl vService;
	private Valoracion valoracion;
	List<Valoracion> listaValoraciones;
	
	@PostConstruct
	public void init() {
		this.listaValoraciones = new ArrayList<Valoracion>();
		this.valoracion = new Valoracion();
		this.listar();
	}
	
	public void listar() {
		listaValoraciones = vService.listar();
	}
	
	public String nuevaValoracion(Reserva reserva) {
		this.setValoracion (new Valoracion());
		this.valoracion.setCliente(reserva.getPropiedad().getCliente());
		this.valoracion.setPersonalLimpieza(reserva.getPersonalLimpieza());
		return "/service/insertCalification?faces-redirect=true";
	}
	
	public String listadoReservas() {

		return "/reservation/list";
	}

	
	public void insertar () {
		vService.insertar(valoracion);
		limpiar();
	}
	
	 
	
	public void limpiar() {
		this.init();
	}

	public String guardarValoracion() {
		String view="";
		try{
			System.out.println(valoracion.getCalificacion());
			System.out.println(valoracion.getComentario());
    		vService.insertar(valoracion);
    		this.getListaValoraciones();
    		view = "/service/list?faces-redirect=true";
            limpiar();
    	}
    	catch(Exception e) {
			Message.messageError("Error en valoracion " + e.getMessage());
    	}
	 return view;
	}
	
	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

	public List<Valoracion> getListaValoraciones() {
		return listaValoraciones;
	}

	public void setListaValoraciones(List<Valoracion> listaValoraciones) {
		this.listaValoraciones = listaValoraciones;
	}
	
	
}
