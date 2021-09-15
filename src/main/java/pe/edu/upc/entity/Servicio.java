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

@Entity
@Table(name="Servicio")
public class Servicio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@Column(name="precio", nullable=false)
	private float precio;
	
	@Column(name="hora_inicio", nullable=false)
	private Date hora_inicio;
	
	@Column(name="duracion", nullable=false)
	private int duracion;
	
	@Column(name="kit_limpieza_extra", nullable=false)
	private boolean kit_limpieza_extra;
	
	@Column(name="lavado", nullable=false)
	private boolean lavado;
	
	@Column(name="planchado", nullable=false)
	private boolean planchado;
	
	@Column(name="cocina", nullable=false)
	private boolean cocina;
	
	@Column(name="interior_refrigeradora", nullable=false)
	private boolean interior_refrigeradora;
	
	@Column(name="ventanas_manparas", nullable=false)
	private boolean ventanas_manparas;
	
	@Column(name="estado", nullable=false)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idPersonalLimpieza", nullable=false)
	private PersonalLimpieza personalLimpieza;
	
	@ManyToOne
	@JoinColumn(name="idPropiedad", nullable=false)
	private Propiedad propiedad;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicio(int id, Date fecha, float precio, Date hora_inicio, int duracion, boolean kit_limpieza_extra,
			boolean lavado, boolean planchado, boolean cocina, boolean interior_refrigeradora,
			boolean ventanas_manparas, String estado, PersonalLimpieza personalLimpieza, Propiedad propiedad,
			Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.precio = precio;
		this.hora_inicio = hora_inicio;
		this.duracion = duracion;
		this.kit_limpieza_extra = kit_limpieza_extra;
		this.lavado = lavado;
		this.planchado = planchado;
		this.cocina = cocina;
		this.interior_refrigeradora = interior_refrigeradora;
		this.ventanas_manparas = ventanas_manparas;
		this.estado = estado;
		this.personalLimpieza = personalLimpieza;
		this.propiedad = propiedad;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isLavado() {
		return lavado;
	}

	public void setLavado(boolean lavado) {
		this.lavado = lavado;
	}

	public boolean isPlanchado() {
		return planchado;
	}

	public void setPlanchado(boolean planchado) {
		this.planchado = planchado;
	}

	public boolean isCocina() {
		return cocina;
	}

	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}

	public boolean isInterior_refrigeradora() {
		return interior_refrigeradora;
	}

	public void setInterior_refrigeradora(boolean interior_refrigeradora) {
		this.interior_refrigeradora = interior_refrigeradora;
	}

	public boolean isVentanas_manparas() {
		return ventanas_manparas;
	}

	public void setVentanas_manparas(boolean ventanas_manparas) {
		this.ventanas_manparas = ventanas_manparas;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
