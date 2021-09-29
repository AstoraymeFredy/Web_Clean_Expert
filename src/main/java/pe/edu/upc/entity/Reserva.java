package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Reserva")
public class Reserva implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_reserva;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="precio", nullable=false)
	private float precio;
	
	@Column(name="hora_inicio", nullable=false)
	private String hora_inicio;
	
	@Column(name="duracion", nullable=false)
	private int duracion;
	
	@Column(name="kit_limpieza_extra", nullable=false)
	private boolean kit_limpieza_extra;
	
	@Column(name="estado", nullable=false)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_personal_limpieza", nullable=false)
	private PersonalLimpieza personalLimpieza;
	
	@ManyToOne
	@JoinColumn(name="id_propiedad", nullable=false)
	private Propiedad propiedad;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(Long id_reserva, Date fecha, float precio, String hora_inicio, int duracion, boolean kit_limpieza_extra,
			String estado, PersonalLimpieza personalLimpieza, Propiedad propiedad) {
		super();
		this.id_reserva = id_reserva;
		this.fecha = fecha;
		this.precio = precio;
		this.hora_inicio = hora_inicio;
		this.duracion = duracion;
		this.kit_limpieza_extra = kit_limpieza_extra;
		this.estado = estado;
		this.personalLimpieza = personalLimpieza;
		this.propiedad = propiedad;
	}

	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isKit_limpieza_extra() {
		return kit_limpieza_extra;
	}

	public void setKit_limpieza_extra(boolean kit_limpieza_extra) {
		this.kit_limpieza_extra = kit_limpieza_extra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
}
