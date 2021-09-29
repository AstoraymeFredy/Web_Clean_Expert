package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.DetalleReserva;
import pe.edu.upc.entity.Reserva;
import pe.edu.upc.serviceimpl.DetalleReservaServiceImpl;
import pe.edu.upc.serviceimpl.ReservaServiceImpl;
import pe.edu.upc.util.Message;
import pe.edu.upc.util.Sesion;

@Named
@SessionScoped
public class ReservaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReservaServiceImpl rService;
	private Reserva reserva;
	
	@Inject
	private DetalleReservaServiceImpl dService;
	
	@Inject
	private Sesion sesion;
	
	private List<Reserva> listaPorCliente;
	private List<Reserva> listaPorPersonal;
	private List<DetalleReserva> listaDetalleReserva;
	
	@PostConstruct
	public void init() {
		this.reserva = new Reserva();
		//direccion,personal 
		
		this.listaPorCliente = new ArrayList<Reserva>();
		this.listaPorPersonal = new ArrayList<Reserva>();
		this.listaDetalleReserva = new ArrayList<DetalleReserva>();
		
		this.obtenerReservasPorCliente();	
	}
	
	public void obtenerReservasPorCliente() {
		try {
			listaPorCliente = rService.listarPorCliente(sesion.getCliente().getId());
		} catch(Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
	}
	
	public void obtenerReserva2(int idReserva) {
		try {
			reserva = rService.obtenerReserva(idReserva);
		} catch(Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
	}
	
	public String obtenerReserva(Reserva reserva) {
		String view = "";
		try {
			this.reserva = reserva;
			listaDetalleReserva = dService.listarDetalleReserva(reserva.getId_reserva());
			view = "/reservation/view?faces-redirect=true";
		} catch(Exception e) {
			Message.messageError("Error en reserva:" + e.getMessage());
		}
		return view;
	}
	
	public void obtenerReservasPorPersonal() {
		try {
			listaPorCliente = rService.listarPorPersonal(sesion.getPersonalLimpieza().getId_personal_limpieza());
		} catch(Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
	}
	
	public String nuevoReserva () {
		try {
			//Aquí llamo todos los datos para el select
			resetForm();
		} catch (Exception e) {
		}
		return "reservation/create";
	}
	
	public String editarReserva() {
		String view = "";
		try {
		
		} catch (Exception e) {
			   //Message.messageError("Error en producto " + e.getMessage());
		}
		return view;
	}
	
	
	public String listarReservasPorPersonal() {
		return "/service/list";
	}
	
	public String listarReservasPorCliente() {
		return "/reservation/list";
	}	
	
	public void resetForm() {
		this.reserva = new Reserva();
	}
	
	public String registrar () {
		String view = "";
		try {
			if(reserva.getId_reserva() != null) {
				//update
				//Message.messageInfo("Registro actualizado correctamente");
			} else {
				//insert
				//Message.messageInfo("Registro actualizado correctamente");
			}
			//llamar productos
			resetForm();
			view = "reservation/list";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return view;
	}
	


	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Reserva> getListaPorCliente() {
		return listaPorCliente;
	}

	public void setListaPorCliente(List<Reserva> listaPorCliente) {
		this.listaPorCliente = listaPorCliente;
	}

	public List<Reserva> getListaPorPersonal() {
		return listaPorPersonal;
	}

	public void setListaPorPersonal(List<Reserva> listaPorPersonal) {
		this.listaPorPersonal = listaPorPersonal;
	}

	public List<DetalleReserva> getListaDetalleReserva() {
		return listaDetalleReserva;
	}

	public void setListaDetalleReserva(List<DetalleReserva> listaDetalleReserva) {
		this.listaDetalleReserva = listaDetalleReserva;
	}	
	
	
}
