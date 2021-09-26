package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDistritoDao;
import pe.edu.upc.entity.Distrito;
import pe.edu.upc.service.IDistritoService;

@Named
@RequestScoped
public class DistritoServiceImpl implements IDistritoService, Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private IDistritoDao dD;
	
	@Override
	public List<Distrito> listar() {
		return dD.listar();
	}
}
