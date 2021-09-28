package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.util.Message;
import pe.edu.upc.entity.Parametro;
import pe.edu.upc.serviceimpl.ParametroServiceImpl;

@Named
@RequestScoped
public class ParametroController  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ParametroServiceImpl parametroService;
	
	private Parametro parametro;
	private List<Parametro> listaParametro;
	
	
	@PostConstruct
	public void init() {
		
		this.parametro = new Parametro();
		this.listaParametro = new ArrayList<Parametro>();
		getAllParameters();
	}
	
	public void resetForm() {
		this.parametro = new Parametro();
	}
	
	public void obtenerParametro()
	{
		parametro.getId_parametro();
	}

	
	public String editParameter () {
		String view = "";
		try {
			if(this.getParametro() == parametro) {
				parametro.setValor(view);
				view = "/parameters/modifyParameter";
			}
			else {
				Message.messageError("Error");
			}
		}
		catch(Exception ex) {
			Message.messageError("Error: " + ex.getMessage());
		}
		return view;
	}
	
	public void getAllParameters() {
		try
		{
			listaParametro = parametroService.findAll();
		}
		catch(Exception e)
		{
			Message.messageError("Error");
		}
	}
	
	public String guardarParametro() {
		String view = "";
		try{
			if(parametro.getId_parametro()!= 0) {
				parametroService.editarParametro(parametro);
			}
		else{
			parametroService.insertar(parametro);
		}
		this.getAllParameters();
		resetForm();
		view = "/parameters/listParameters";
		}
		catch(Exception e) {
		}
		return view;
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
