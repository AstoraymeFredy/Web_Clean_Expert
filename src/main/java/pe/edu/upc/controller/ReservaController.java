package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.Reserva;
import pe.edu.upc.serviceimpl.ReservaServiceImpl;

@Named
@RequestScoped
public class ReservaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReservaServiceImpl rService;
	private Reserva reserva;
	
	private Reserva reservaSeleccionada;
	
	private List<Reserva> listaPorCliente;
	private List<Reserva> listaPorPersonal;
	
	@PostConstruct
	public void init() {
		this.reserva = new Reserva();
		//direccion,personal 
		
		this.listaPorCliente = new ArrayList<Reserva>();
		this.listaPorPersonal = new ArrayList<Reserva>();
	}
	
	public void obtenerReservasPorCliente(Cliente cliente) {
		try {
			listaPorCliente = rService.listarPorCliente(cliente.getId());
		} catch(Exception e) {
			//Message.messageError("Error al cargar las reservas de servicio");
		}
	}
	
	public void obtenerReservasPorPersonal(PersonalLimpieza personal) {
		try {
			//listaPorCliente = rService.listarPorPersonal(personal.getId());
		} catch(Exception e) {
			//Message.messageError("Error al cargar las reservas de servicio");
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
			if(this.reservaSeleccionada != null) {
				this.reserva = reservaSeleccionada;
				view = "/reservation/update";
			} else {
				//Message.messageError("Debe seleccionar una reserva");
			}
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
	
	public void reservaSeleccionada(SelectEvent e) {
		this.reservaSeleccionada = (Reserva)e.getObject();
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Reserva getReservaSeleccionada() {
		return reservaSeleccionada;
	}

	public void setReservaSeleccionada(Reserva reservaSeleccionada) {
		this.reservaSeleccionada = reservaSeleccionada;
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
	
}
