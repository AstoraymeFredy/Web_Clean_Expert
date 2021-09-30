package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.ValoracionDaoImpl;
import pe.edu.upc.entity.Valoracion;

@Named
@RequestScoped
public class ValoracionServiceImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private ValoracionDaoImpl vD;
	
	
	public List<Valoracion> listar() {
		return vD.listar();
	}

	public void insertar(Valoracion valoracion) {
		vD.insertar(valoracion);
	}	
}
