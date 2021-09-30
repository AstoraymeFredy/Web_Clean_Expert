package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoUsuario")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoUsuario;
	
	@Column(name="nombre", nullable=false, length=30)
	private String nombre;

	public TipoUsuario() {
		super();
	}

	public TipoUsuario(int idTipoUsuario, String nombre) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nombre = nombre;
	}

	public int getId() {
		return idTipoUsuario;
	}

	public void setId(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
