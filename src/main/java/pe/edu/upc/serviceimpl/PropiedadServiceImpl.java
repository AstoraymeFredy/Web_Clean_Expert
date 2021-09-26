package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPropiedadDao;
import pe.edu.upc.entity.Propiedad;
import pe.edu.upc.service.IPropiedadService;

@Named
@RequestScoped
public class PropiedadServiceImpl implements IPropiedadService, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IPropiedadDao pD;
	
	@Override
	public List<Propiedad> listar(int idCliente) {
		return pD.listar(idCliente);
	}
	
	@Override
	public void eliminar(int idPropiedad) {
		pD.eliminar(idPropiedad);
	}
	
	@Override
	public void insertar(Propiedad propiedad) {
		pD.insertar(propiedad);
	}
	
	@Override
	public void actualizar(Propiedad propiedad) {
		pD.actualizar(propiedad);
	}
	
}
