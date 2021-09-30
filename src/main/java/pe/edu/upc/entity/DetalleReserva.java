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
@Table(name="DetalleReserva")
public class DetalleReserva implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cantidad", nullable=false)
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="idAmbiente", nullable=false)
	private Ambiente ambiente;
	
	@ManyToOne
	@JoinColumn(name="idReserva", nullable=false)
	private Reserva reserva;

	public DetalleReserva() {
		super();
	}

	public DetalleReserva(int id, int cantidad, Ambiente ambiente, Reserva reserva) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.ambiente = ambiente;
		this.reserva = reserva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
