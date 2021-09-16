package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IValoracionDao;
import pe.edu.upc.entity.Valoracion;
import pe.edu.upc.service.IValoracionService;

@Named
@RequestScoped
public class ValoracionServiceImpl implements IValoracionService, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IValoracionDao vD;
	
	@Override
	public List<Valoracion> listar() {
		return vD.listar();
	}
	@Override
	public void insertar(Valoracion valoracion) {
		vD.insertar(valoracion);
	}
	
	
}
