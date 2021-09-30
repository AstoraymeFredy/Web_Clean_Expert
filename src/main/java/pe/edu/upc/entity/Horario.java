package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Horario")
public class Horario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_horario;
	
	@Column(name="lunes", nullable=false)
	private boolean lunes;
	
	@Column(name="martes", nullable=false)
	private boolean martes;
	
	@Column(name="miercoles", nullable=false)
	private boolean miercoles;
	
	@Column(name="jueves", nullable=false)
	private boolean jueves;
	
	@Column(name="viernes", nullable=false)
	private boolean viernes;
	
	@Column(name="sabado", nullable=false)
	private boolean sabado;
	
	@Column(name="domingo", nullable=false)
	private boolean domingo;
	
	@OneToOne
	@JoinColumn(name="idPersonalLimpieza", nullable=false)
	private PersonalLimpieza personalLimpieza;

	public Horario() {
		super();
	}

	public Horario(int id_horario, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes,
			boolean sabado, boolean domingo, PersonalLimpieza personalLimpieza) {
		super();
		this.id_horario = id_horario;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.sabado = sabado;
		this.domingo = domingo;
		this.personalLimpieza = personalLimpieza;
	}

	public int getId_horario() {
		return id_horario;
	}

	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}

	public boolean isLunes() {
		return lunes;
	}

	public void setLunes(boolean lunes) {
		this.lunes = lunes;
	}

	public boolean isMartes() {
		return martes;
	}

	public void setMartes(boolean martes) {
		this.martes = martes;
	}

	public boolean isMiercoles() {
		return miercoles;
	}

	public void setMiercoles(boolean miercoles) {
		this.miercoles = miercoles;
	}

	public boolean isJueves() {
		return jueves;
	}

	public void setJueves(boolean jueves) {
		this.jueves = jueves;
	}

	public boolean isViernes() {
		return viernes;
	}

	public void setViernes(boolean viernes) {
		this.viernes = viernes;
	}

	public boolean isSabado() {
		return sabado;
	}

	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}

	public boolean isDomingo() {
		return domingo;
	}

	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}

	public PersonalLimpieza getPersonalLimpieza() {
		return personalLimpieza;
	}

	public void setPersonalLimpieza(PersonalLimpieza personalLimpieza) {
		this.personalLimpieza = personalLimpieza;
	}
}
