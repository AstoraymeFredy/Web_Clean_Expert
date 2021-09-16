package pe.edu.upc.service;

import pe.edu.upc.entity.Usuario;

public interface IUsuarioService {
	public Usuario login (Usuario usuario) ;
	public Usuario registrar(Usuario usuario);
}
