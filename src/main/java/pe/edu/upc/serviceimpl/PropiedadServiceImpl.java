package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

//import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daoimpl.PropiedadDaoImpl;
import pe.edu.upc.entity.Propiedad;

@Named
public class PropiedadServiceImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private PropiedadDaoImpl prop;

	public List<Propiedad> listar(int idCliente)throws Exception {
		return prop.listarPorCliente(idCliente);
	}

	public void eliminar(int idPropiedad)throws Exception {
		prop.eliminar(idPropiedad);
	}

	public int insertar(Propiedad propiedad) throws Exception{
		return prop.insertar(propiedad);
	}

	public void actualizar(Propiedad propiedad) throws Exception{
		prop.actualizar(propiedad);
	}
}
