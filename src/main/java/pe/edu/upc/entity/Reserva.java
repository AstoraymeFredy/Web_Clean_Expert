package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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
	
	@Temporal(TemporalType.TIME)
	@Column(name="hora_inicio", nullable=false)
	private Date hora_inicio;
	
	@Column(name="duracion", nullable=false)
	private int duracion;
	
	@Column(name="kit_limpieza_extra", nullable=false)
	private boolean kit_limpieza_extra;
	
	@Column(name="estado", nullable=false)
	private String estado;
	
	@Transient
	private String propietario_tarjeta;
		
	@Transient
	@Min(1111111111111L)
	@Max(9999999999999999L)
	private Long numero_tarjeta;
	
	@Transient
	@Temporal(TemporalType.DATE)
	private Date fecha_expiracion;
	
	@Transient
	@Size(min=3, max=3)
	private String cvv_tarjeta;
	
	@ManyToOne
	@JoinColumn(name="id_personal_limpieza", nullable=false)
	private PersonalLimpieza personalLimpieza;
	
	@ManyToOne
	@JoinColumn(name="id_propiedad", nullable=false)
	private Propiedad propiedad;

	public Reserva() {
		super();
	}

	public Reserva(Long id_reserva, Date fecha, float precio, Date hora_inicio, int duracion, boolean kit_limpieza_extra,
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

	public Date getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Date hora_inicio) {
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

	@Override
	public int hashCode() {
		return Objects.hash(duracion, estado, fecha, hora_inicio, id_reserva, kit_limpieza_extra, precio);
	}

	public String getPropietario_tarjeta() {
		return propietario_tarjeta;
	}

	public void setPropietario_tarjeta(String propietario_tarjeta) {
		this.propietario_tarjeta = propietario_tarjeta;
	}

	public Long getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(Long numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public Date getFecha_expiracion() {
		return fecha_expiracion;
	}

	public void setFecha_expiracion(Date fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
	}

	public String getCvv_tarjeta() {
		return cvv_tarjeta;
	}

	public void setCvv_tarjeta(String cvv_tarjeta) {
		this.cvv_tarjeta = cvv_tarjeta;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return duracion == other.duracion && Objects.equals(estado, other.estado) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora_inicio, other.hora_inicio) && Objects.equals(id_reserva, other.id_reserva)
				&& kit_limpieza_extra == other.kit_limpieza_extra
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
	}
}
