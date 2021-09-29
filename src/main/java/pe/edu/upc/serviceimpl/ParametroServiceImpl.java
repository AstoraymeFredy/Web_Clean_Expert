package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Parametro;
import pe.edu.upc.daoimpl.ParametroDaoImpl;

@Named
public class ParametroServiceImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ParametroDaoImpl parametroDaoImpl ;
	
	@Transactional
	public int insertar(Parametro parametro) throws Exception{
		return parametroDaoImpl.insertar(parametro);
	}
	
	public Parametro obtenerParametro(int idParametro) {
		return obtenerParametro(idParametro);
	}

	public int editarParametro(Parametro parametro) {
		return parametroDaoImpl.editarParametro(parametro);
	}
	
	public List<Parametro> findAll() throws Exception{
		return parametroDaoImpl.findAll();
	}

	

}
