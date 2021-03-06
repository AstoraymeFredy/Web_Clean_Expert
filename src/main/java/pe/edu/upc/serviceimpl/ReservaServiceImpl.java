package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.ReservaDaoImpl;
import pe.edu.upc.entity.Reserva;

@Named
@RequestScoped
public class ReservaServiceImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ReservaDaoImpl rD;
	
	public Reserva insertar(Reserva reserva) throws Exception {
		return rD.insertar(reserva);
	}
	
	public Reserva obtenerReserva(int idReserva) throws Exception {
		return rD.obtenerReserva(idReserva);
	}
	
	public List<Reserva> listarPorPersonal(int idPersonalLimpieza) throws Exception {
		return rD.listarPorPersonal(idPersonalLimpieza);
	}
	
	public List<Reserva> listarPorCliente(int idCliente) throws Exception {
		return rD.listarPorCliente(idCliente);
	}
	
	public List<Reserva> listarPorFecha(Date fecha) throws Exception{
		return rD.listarPorFecha(fecha);
	}
}
