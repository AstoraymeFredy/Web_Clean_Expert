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
@Table(name="Valoracion")
public class Valoracion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="comentario", nullable=true, length=200)
	private String comentario;
	
	@Column(name="calificacion", nullable=false)
	private int calificacion;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idPersonalLimpieza", nullable=false)
	private PersonalLimpieza personalLimpieza;

	public Valoracion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Valoracion(int id, String comentario, int calificacion, Cliente cliente, PersonalLimpieza personalLimpieza) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.cliente = cliente;
		this.personalLimpieza = personalLimpieza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
	}
	
	
	
}
