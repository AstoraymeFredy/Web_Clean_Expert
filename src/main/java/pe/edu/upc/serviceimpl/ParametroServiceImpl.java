package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Parametro;
import pe.edu.upc.daoimpl.ParametroDaoImpl;

@Named
public class ParametroServiceImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ParametroDaoImpl parametroDaoImpl ;
	
	public Parametro obtenerParametro(int idParametro) {
		return obtenerParametro(idParametro);
	}

	public List<Parametro> listar() {
		return parametroDaoImpl.listar();
	}

	public int editarParametro(Parametro parametro) {
		return parametroDaoImpl.editarParametro(parametro);
	}



}
