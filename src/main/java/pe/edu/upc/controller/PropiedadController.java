package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Propiedad;
import pe.edu.upc.serviceimpl.DistritoServiceImpl;
import pe.edu.upc.serviceimpl.PropiedadServiceImpl;
import pe.edu.upc.util.Message;
import pe.edu.upc.util.Sesion;

@Named
@SessionScoped
public class PropiedadController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private PropiedadServiceImpl pService;
	private Propiedad propiedad;
	List<Propiedad> listaPropiedades;

	@Inject
	private DistritoServiceImpl dService;
	private Distrito distrito;
	List<Distrito> listaDistritos;

	@Inject
	private Sesion sesion;
	private Cliente cliente;

	@PostConstruct
	public void init() {
		this.listaDistritos = new ArrayList<Distrito>();
		this.distrito = new Distrito();
		this.listarDistritos();
		
		this.cliente= new Cliente();
		this.listaPropiedades = new ArrayList<Propiedad>();
		this.propiedad = new Propiedad();
		this.listar();
	}

	public String listaProp()
	{
			return  "/addresses/listAddresses?faces-redirect=true";
	}

	public String nuevaPropiedad() {
		try {
			this.listaDistritos = dService.listar();
			this.propiedad = new Propiedad();
		}
		catch (Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
		return "/addresses/addModifyProperty?faces-redirect=true";
	}

	public String guardar_I_M() {
		String view = "";
		try {
			if(propiedad.getId() != 0) {
				propiedad.setDistrito(distrito);
				pService.actualizar(propiedad);
				Message.messageInfo("Actualizado");
			}
			else {
				propiedad.setCliente(sesion.getCliente());
				propiedad.setDistrito(distrito);
				pService.insertar(propiedad);
				Message.messageInfo("Ingresado");
			}
			this.listar();
			this.propiedad = new Propiedad ();
			view = "/addresses/listAddresses?faces-redirect=true";
		}
		catch(Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
		return view;
	}

	public String editProperty(Propiedad p) {
		String view = "";
		try {
			this.propiedad = p;
			view = "/addresses/addModifyProperty?faces-redirect=true";
			Message.messageError("Debe seleccionar un parametro");
		}
		catch (Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
		}
		return view;
	}

	public void listar () {
		try {
		listaPropiedades = pService.listar(sesion.getCliente().getId());
		}
		catch(Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
	}

	public void listarDistritos () {
		try {
			listaDistritos = dService.listar();
		}
		catch(Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
	}

	public String eliminar (Propiedad p) {
		String view = "";
		try {
			this.propiedad=p;
			pService.eliminar(propiedad.getId());
			Message.messageInfo("Eliminado correctamente");
			this.listar();
			view = "/addresses/listAddresses?faces-redirect=true";
		}
		catch(Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
		return view;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
