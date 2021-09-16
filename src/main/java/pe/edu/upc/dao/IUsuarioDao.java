package pe.edu.upc.dao;

import pe.edu.upc.entity.Usuario;

public interface IUsuarioDao {
	public Usuario login (Usuario usuario) ;
	public Usuario registrar(Usuario usuario);
	
}
