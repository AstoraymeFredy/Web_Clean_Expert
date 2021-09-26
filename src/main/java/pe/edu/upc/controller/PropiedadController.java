package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Propiedad;
import pe.edu.upc.service.IDistritoService;
import pe.edu.upc.service.IPropiedadService;

public class PropiedadController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private IPropiedadService pService;
	private Propiedad propiedad;
	List<Propiedad> listaPropiedades;
	
	@Inject
	private IDistritoService dService;
	private Distrito distrito;
	List<Distrito> listaDistritos;
	
	@PostConstruct
	public void init() {
		this.listaDistritos = new ArrayList<Distrito>();
		this.distrito = new Distrito();
		this.listarDistritos();
		
		this.listaPropiedades = new ArrayList<Propiedad>();
		this.propiedad = new Propiedad();
		this.listar(this.propiedad.getCliente());
	}
	
	public String nuevaPropiedad () {
		this.setPropiedad(new Propiedad());
		return "horario.xhtml";
	}
	
	public void insertar() {
		pService.insertar(propiedad);
		limpiar();
		this.listar(propiedad.getCliente());
	}
	
	public void actualizar() {
		pService.actualizar(propiedad);
		limpiar();
		this.listar(propiedad.getCliente());
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void listar (Cliente cliente) {
		listaPropiedades = pService.listar(cliente.getId());
	}
	
	public void listarDistritos () {
		listaDistritos = dService.listar();
	}
	
	public void eliminar (Cliente cliente) {
		pService.eliminar(cliente.getId());
		this.listar(cliente);
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public List<Propiedad> getListaPropiedades() {
		return listaPropiedades;
	}

	public void setListaPropiedades(List<Propiedad> listaPropiedades) {
		this.listaPropiedades = listaPropiedades;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}
	
	
	
}
