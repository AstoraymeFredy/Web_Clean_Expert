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
@Table(name="PersonalLimpieza")
public class PersonalLimpieza implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_personal_limpieza;
	
	@Column(name="nombre", nullable=false, length=80)
	private String nombre;
	
	@Column(name="apellidos", nullable=false, length=100)
	private String apellidos;
	
	@Column(name="descripcion", nullable=false, length=150)
	private String descripcion;
	
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Column(name="celular", nullable=false, length=20)
	private String celular;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;

	public PersonalLimpieza() {
		super();
	}

	public PersonalLimpieza(int id_personal_limpieza, String nombre, String apellidos, String descripcion, String email,
			String celular, Usuario usuario) {
		super();
		this.id_personal_limpieza = id_personal_limpieza;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.email = email;
		this.celular = celular;
		this.usuario = usuario;
	}

	public int getId_personal_limpieza() {
		return id_personal_limpieza;
	}

	public void setId_personal_limpieza(int id_personal_limpieza) {
		this.id_personal_limpieza = id_personal_limpieza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
