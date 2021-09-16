package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IServicioDao;
import pe.edu.upc.entity.Servicio;
import pe.edu.upc.service.IServicioService;

@Named
@RequestScoped
public class ServicioServiceImpl implements IServicioService, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IServicioDao sD;
	
	@Override
	public Servicio insertar(Servicio servicio) {
		return sD.insertar(servicio);
	}
	
	@Override
	public List<Servicio> listarPersonal(int idPersonalLimpieza) {
		// TODO Auto-generated method stub
		return sD.listarPersonal(idPersonalLimpieza);
	}
	
	@Override
	public List<Servicio> listarCliente(int idCliente) {
		// TODO Auto-generated method stub
		return sD.listarCliente(idCliente);
	}
	
}
