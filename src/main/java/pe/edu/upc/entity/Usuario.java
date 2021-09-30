package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_usuario;
	
	@Column(name="username", nullable=false, length=50)
	private String username;
	
	@Column(name="password", nullable=false, length=50)
	private String password;
	
	@OneToOne
	@JoinColumn(name="idTipoUsuario", nullable=false)
	private TipoUsuario tipoUsuario;

	public Usuario() {
		super();
	}

	public Usuario(int id_usuario, String username, String password, TipoUsuario tipoUsuario) {
		super();
		this.id_usuario = id_usuario;
		this.username = username;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
