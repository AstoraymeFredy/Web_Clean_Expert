package pe.edu.upc.serviceimpl;

import java.io.Serializable;
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
		// TODO Auto-generated method stub
		return rD.listarPorPersonal(idPersonalLimpieza);
	}
	
	public List<Reserva> listarPorCliente(int idCliente) throws Exception {
		// TODO Auto-generated method stub
		return rD.listarPorCliente(idCliente);
	}
	
}
