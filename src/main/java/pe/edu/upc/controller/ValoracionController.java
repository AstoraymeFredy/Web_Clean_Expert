package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Valoracion;
import pe.edu.upc.service.IValoracionService;

@Named
@RequestScoped
public class ValoracionController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private IValoracionService vService;
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
	
	public String nuevaValoracion() {
		this.setValoracion (new Valoracion());
		return "nuevaValoracion.xhtml";
	}
	
	public void insertar () {
		vService.insertar(valoracion);
		limpiar();
	}
	
	public void limpiar() {
		this.init();
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
