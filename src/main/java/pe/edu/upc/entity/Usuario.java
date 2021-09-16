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
	private int id;
	
	@Column(name="username", nullable=false, length=50)
	private String username;
	
	@Column(name="password", nullable=false, length=50)
	private String password;
	
	@OneToOne
	@JoinColumn(name="idTipoUsuario", nullable=false)
	private TipoUsuario tipoUsuario;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String username, String password, TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
