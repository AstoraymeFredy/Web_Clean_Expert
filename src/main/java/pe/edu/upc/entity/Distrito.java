package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Distrito")
public class Distrito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDistrito;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;

	public Distrito() {
		super();
	}

	public Distrito(int idDistrito, String nombre) {
		super();
		this.idDistrito = idDistrito;
		this.nombre = nombre;
	}

	public int getId() {
		return idDistrito;
	}

	public void setId(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
