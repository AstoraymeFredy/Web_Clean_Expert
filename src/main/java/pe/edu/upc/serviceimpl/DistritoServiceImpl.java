package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.IDistritoDaoImpl;
import pe.edu.upc.entity.Distrito;

@Named
public class DistritoServiceImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDistritoDaoImpl dis;
	
	public List<Distrito> listar()throws Exception {
		return dis.listarDistritos();
	}
}
