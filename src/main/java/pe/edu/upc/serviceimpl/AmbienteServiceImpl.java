package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAmbienteDao;
import pe.edu.upc.entity.Ambiente;
import pe.edu.upc.service.IAmbienteService;

@Named
@RequestScoped
public class AmbienteServiceImpl implements IAmbienteService, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAmbienteDao aD;

	@Override
	public List<Ambiente> listar() {
		return aD.listar();
	}
}
