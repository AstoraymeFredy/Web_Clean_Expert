package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.AmbienteDaoImpl;
import pe.edu.upc.entity.Ambiente;

@Named
@RequestScoped
public class AmbienteServiceImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AmbienteDaoImpl amb;

	public List<Ambiente> listarAmbientes() throws Exception {
		return amb.listar();
	}
}
