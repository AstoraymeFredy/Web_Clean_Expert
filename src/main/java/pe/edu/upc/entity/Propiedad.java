package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Propiedad")
public class Propiedad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPropiedad;
	
	@Column(name="direccion", nullable=false, length=150)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idDistrito", nullable=false)
	private Distrito distrito;

	public Propiedad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Propiedad(int idPropiedad, String direccion, Cliente cliente, Distrito distrito) {
		super();
		this.idPropiedad = idPropiedad;
		this.direccion = direccion;
		this.cliente = cliente;
		this.distrito = distrito;
	}

	public int getId() {
		return idPropiedad;
	}

	public void setId(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	
	
}
