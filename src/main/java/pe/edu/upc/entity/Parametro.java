package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Parametro")
public class Parametro implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_parametro;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	@Column(name="valor", nullable=false, length=50)
	private int valor;
	
	@Column(name="unidad", nullable=false, length=50)
	private String unidad;

	public Parametro() {
		super();
	}

	public Parametro(Long id_parametro, String nombre, int valor, String unidad) {
		super();
		this.id_parametro = id_parametro;
		this.nombre = nombre;
		this.valor = valor;
		this.unidad = unidad;
	}

	public Long getId_parametro() {
		return id_parametro;
	}

	public void setId_parametro(Long id_parametro) {
		this.id_parametro = id_parametro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
}
