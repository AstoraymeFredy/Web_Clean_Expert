package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Ambiente;
import pe.edu.upc.entity.DetalleReserva;
import pe.edu.upc.entity.Horario;
import pe.edu.upc.entity.PersonalLimpieza;
import pe.edu.upc.entity.Propiedad;
import pe.edu.upc.entity.Reserva;
import pe.edu.upc.entity.Parametro;
import pe.edu.upc.serviceimpl.AmbienteServiceImpl;
import pe.edu.upc.serviceimpl.DetalleReservaServiceImpl;
import pe.edu.upc.serviceimpl.HorarioServiceImpl;
import pe.edu.upc.serviceimpl.ParametroServiceImpl;
import pe.edu.upc.serviceimpl.PropiedadServiceImpl;
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
	private HorarioServiceImpl hService;
	
	@Inject
	private ParametroServiceImpl paService;
	
	@Inject
	private DetalleReservaServiceImpl dService;
	
	@Inject
	private AmbienteServiceImpl aService;
	
	@Inject
	private PropiedadServiceImpl pService;
	private Propiedad propiedad;
	private PersonalLimpieza personalLimpieza;
	
	@Inject
	private Sesion sesion;
	
	private List<Reserva> listaPorCliente;
	private List<Reserva> listaPorPersonal;
	private List<PersonalLimpieza> listaPersonalDisponible;
	private List<DetalleReserva> listaDetalleReserva;
	private List<Propiedad> listaDirecciones;	
	private List<Parametro> listaParametros;

	
	@PostConstruct
	public void init() {
		this.reserva = new Reserva();

		this.listaPorCliente = new ArrayList<Reserva>();
		this.listaPorPersonal = new ArrayList<Reserva>();
		this.listaDetalleReserva = new ArrayList<DetalleReserva>();
		this.listaDirecciones = new ArrayList<Propiedad>();
		this.listaPersonalDisponible = new ArrayList<PersonalLimpieza>();
		this.listaParametros = new ArrayList<Parametro>();
	
		if (sesion.getUsuario().getTipoUsuario().getId()==1) {
			this.obtenerReservasPorCliente();
		} else {
			this.obtenerReservasPorPersonal();
		}	
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
	
	public String obtenerReserva(Reserva reserva, int idtipoUsuario) {
		String view = "";
		try {
			this.reserva = reserva;
			listaDetalleReserva = dService.listarDetalleReserva(reserva.getId_reserva());
			if(idtipoUsuario==1) {
				view = "/reservation/view?faces-redirect=true";
			} else {
				view = "/service/view?faces-redirect=true";
			}
			
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
			listaDetalleReserva.clear();
			List<Ambiente> listaDeAmbientes =aService.listarAmbientes();
			 for (int i = 0; i < listaDeAmbientes.size(); i++) {
		         DetalleReserva detalle = new DetalleReserva();
		         detalle.setAmbiente(listaDeAmbientes.get(i));
		         listaDetalleReserva.add(detalle);
		     }
			listaDirecciones = pService.listar(sesion.getCliente().getId());
			listaParametros = paService.listarParametros();
		}
		catch (Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
		return "/reservation/create?faces-redirect=true";
	}
	
	public void listarPersonal () {
		try {
			List<Horario> horariosFiltrados = new ArrayList<Horario>();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(reserva.getFecha());
			horariosFiltrados = hService.findHorariobyDate(calendar.get(calendar.DAY_OF_WEEK));	
			
			List<Reserva> reservasFiltradas = new ArrayList<Reserva>();
			reservasFiltradas = rService.listarPorFecha(reserva.getFecha());
			
			List<PersonalLimpieza> personalLimpiezaporHorario = new ArrayList<PersonalLimpieza>();
			
			for (int i = 0; i< horariosFiltrados.size(); i++) {
				personalLimpiezaporHorario.add(horariosFiltrados.get(i).getPersonalLimpieza());
			}
			
			for (int i = 0; i< personalLimpiezaporHorario.size(); i++) {
				boolean notFinded = true;
				for (int j = 0; j<reservasFiltradas.size(); j++) {
					if(reservasFiltradas.get(i).getPersonalLimpieza().getId_personal_limpieza() == personalLimpiezaporHorario.get(j).getId_personal_limpieza()) {
						notFinded = false;
					}
				}
				if (notFinded) {
					listaPersonalDisponible.add(personalLimpiezaporHorario.get(i));
				}
			}	
		}
		catch (Exception e) {
			Message.messageError("Error :" + e.getMessage());
		}
	}
	
	public String pagar() {
		return "/reservation/payment";
	}
	
	public String registrar () {
		String view = "";
		try {
			reserva.setPropiedad(propiedad);
			reserva.setPersonalLimpieza(personalLimpieza);
			reserva.setEstado("Por realizar");
			this.reserva = rService.insertar(reserva);
			
			for (int i = 0; i < listaDetalleReserva.size(); i++) {
		         DetalleReserva detalle_reserva=listaDetalleReserva.get(i);
		         detalle_reserva.setReserva(reserva);
		         dService.insertar(detalle_reserva);
		     }
		} catch (Exception e) {
			Message.messageError("Error en parametro " + e.getMessage());
		}
		this.obtenerReservasPorCliente();
		this.propiedad = new Propiedad();
		return view;
	}
	
	public String listarReservasPorPersonal() {
		return "/service/list";
	}
	
	public String listarReservasPorCliente() {
		return "/reservation/list";
	}	
	
	public void simularPrecio(AjaxBehaviorEvent e) {

		float precio_total = 0;
		float duracion_total = 0;
		int duracion_aproximada = 0;
		if(listaParametros.size()>0) {
			int duracion_limpieza=listaParametros.get(0).getValor();
			int costo_hora=listaParametros.get(1).getValor();
			int costo_kit=listaParametros.get(2).getValor();
			
			for (int i = 0; i < listaDetalleReserva.size(); i++) {
		         DetalleReserva detalle_reserva=listaDetalleReserva.get(i);
		         duracion_total= duracion_total + duracion_limpieza * detalle_reserva.getCantidad();    
		     }
			duracion_aproximada= (int) Math.ceil(duracion_total/60);
			precio_total=duracion_aproximada*costo_hora;
			if(reserva.isKit_limpieza_extra()) {
				precio_total=precio_total+costo_kit;
			}
		}
		this.reserva.setDuracion(duracion_aproximada);
		this.reserva.setPrecio(precio_total);
	}
	
	public void resetForm() {
		this.reserva = new Reserva();
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
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

	public List<Propiedad> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<Propiedad> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	public List<PersonalLimpieza> getListaPersonalDisponible() {
		return listaPersonalDisponible;
	}

	public void setListaPersonalDisponible(List<PersonalLimpieza> listaPersonalDisponible) {
		this.listaPersonalDisponible = listaPersonalDisponible;
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
	}	
}
