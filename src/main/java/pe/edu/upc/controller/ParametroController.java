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
	private ParametroServiceImpl parameterService;
	
	private Parametro parameter;
	private List<Parametro> listaParametro;
	
	
	@PostConstruct
	public void init() {		
		parameter = new Parametro();
		this.listaParametro = new ArrayList<Parametro>();
		getAllParameters();
	}
	
	public void resetForm() {
		this.parameter = new Parametro();
	}
	
	public void obtenerParametro()
	{
		parameter.getId_parametro();
	}

	public String listadoParametros()
	{
		System.out.println("hola");
		return "/parameters/listParameters";
	}
	
	public String editParameter (Parametro parameter) {
		this.setParametro(parameter);
		
		System.out.println("Entrando a metodo editar");
		System.out.println("Id: " + parameter.getId_parametro());
		System.out.println("Nombre: " + parameter.getNombre());
		System.out.println("Valor: " + parameter.getValor());
		String view = "";		
		try {
			if(this.getParametro() != null) {
				
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
			listaParametro = parameterService.findAll();
		}
		catch(Exception e)
		{
			Message.messageError("Error");
		}
	}
	
	
	public String guardarParametro() {
		System.out.println("guardar");
		System.out.println("valor"+ parameter.getValor());
		System.out.println("id" + this.parameter.getId_parametro());
		String view = "";
		try{
			if(parameter.getId_parametro() >= 1) {
				parameterService.editarParametro(parameter);
				Message.messageInfo("Actualizado");
			}
		else{
			parameterService.editarParametro(parameter);
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
		return parameter;
	}
	
	public void setParametro(Parametro parameter) {
		this.parameter = parameter;
	}

}
