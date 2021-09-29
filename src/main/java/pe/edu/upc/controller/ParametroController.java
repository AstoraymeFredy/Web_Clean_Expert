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

import pe.edu.upc.util.Message;
import pe.edu.upc.entity.Parametro;
import pe.edu.upc.serviceimpl.ParametroServiceImpl;

@Named
@SessionScoped
public class ParametroController implements Serializable {
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

	public void obtenerParametro() {
		parameter.getId_parametro();
	}

	public String listadoParametros() {

		return "/parameters/listParameters";
	}

	public String editParameter(Parametro parameter) {
		String view = "";
		try {

			this.parameter = parameter;
			view = "/parameters/modifyParameter?faces-redirect=true";

			Message.messageError("Debe seleccionar un parametro");

		} catch (Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
		}
		return view;
	}

	public void getAllParameters() {
		try {
			listaParametro = parameterService.findAll();
		} catch (Exception e) {
			Message.messageError("Error");
		}
	}

	public String guardarParametro() {

		String view = "";
		try {
			if (parameter.getId_parametro() != null) {
				parameterService.editarParametro(parameter);
				Message.messageInfo("Registro actualizado correctamente");
			} else {

				parameterService.insertar(parameter);
				Message.messageInfo("Registro actualizado correctamente");
			}
			this.getAllParameters();
			resetForm();
			view = "/parameters/listParameters?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
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
