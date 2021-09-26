package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Parametro;
import pe.edu.upc.serviceimpl.ParametroServiceImpl;

@Named
@RequestScoped
public class ParametroController  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ParametroServiceImpl parametroService;
	
	List<Parametro> listaParametro;
	Parametro parametro;
	
	@PostConstruct
	public void init() {
		this.listaParametro = new ArrayList<Parametro>();
		this.parametro = new Parametro();
		this.listar();
	}
	
	public void obtenerParametro()
	{
		parametro.getId_parametro();
	}

	
	
	public void listar() {
		listaParametro = parametroService.listar();
	}
	
	public List<Parametro> getListaParametro() {
		return listaParametro;
	}

	public void setListaParametro(List<Parametro> listaParametro) {
		this.listaParametro = listaParametro;
	}
	
	public Parametro getParametro() {
		return parametro;
	}
	
	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

}
