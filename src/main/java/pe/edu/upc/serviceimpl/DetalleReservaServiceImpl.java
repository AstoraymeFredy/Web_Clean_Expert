package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.DetalleReservaDaoImpl;
import pe.edu.upc.entity.DetalleReserva;
import pe.edu.upc.entity.Reserva;

@Named
@RequestScoped
public class DetalleReservaServiceImpl implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private DetalleReservaDaoImpl dD;
	
	public DetalleReserva insertar(DetalleReserva detalleReserva) throws Exception {
		return dD.insertar(detalleReserva);
	}
	
	public List<DetalleReserva> listarDetalleReserva(long idReserva) throws Exception {
		// TODO Auto-generated method stub
		return dD.listarDetalleReserva(idReserva);
	}
}
