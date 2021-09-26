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
	private int id_parametro;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	@Column(name="valor", nullable=false, length=50)
	private String valor;

	public Parametro() {
		super();
	}

	public Parametro(int id_parametro, String nombre, String valor) {
		super();
		this.id_parametro = id_parametro;
		this.nombre = nombre;
		this.valor = valor;
	}

	public int getId_parametro() {
		return id_parametro;
	}

	public void setId_parametro(int id_parametro) {
		this.id_parametro = id_parametro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
