package com.cibertec.edu.pe.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "concesionarios")
public class concesionario_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_concesionario", unique = true, nullable = false)
	private Long id_concesionario;
	@Column(name = "Distrito", nullable = false)
	private String Distrito;
	@ManyToOne
	@JoinColumn(name = "id_marca", nullable = false)
	private marca_entity marca;
	@Column(name = "direccion", nullable = false)
	private String direccion;
	@Column(name = "Aforo", nullable = false)
	private int aforo;
	@Column(name = "Capacida_maxima", nullable = false)
	private int capacidad;
	@OneToMany(mappedBy = "concesionario")
    private Set<horarioconcesionario_entity> horarios;
    public Long getId_concesionario() { 
        return id_concesionario;
    }
    public concesionario_entity() {
    	
    }
    public concesionario_entity(Long id_concesionario, String distrito, marca_entity marca, String direccion, int aforo,
			int capacidad, Set<horarioconcesionario_entity> horarios) {
		super();
		this.id_concesionario = id_concesionario;
		Distrito = distrito;
		this.marca = marca;
		this.direccion = direccion;
		this.aforo = aforo;
		this.capacidad = capacidad;
		this.horarios = horarios;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<horarioconcesionario_entity> getHorarios() {
		return horarios;
	}

	public void setHorarios(Set<horarioconcesionario_entity> horarios) {
		this.horarios = horarios;
	}

	public void setId_concesionario(Long id_concesionario) {
		this.id_concesionario = id_concesionario;
	}

	
    public void setIdConcesionario(Long id_concesionario) { 
    	this.id_concesionario = id_concesionario;
    }
	public String getDistrito() {
		return Distrito;
	}
	public void setDistrito(String distrito) {
		Distrito = distrito;
	}
	public marca_entity getMarca() {
		return marca;
	}
	public void setMarca(marca_entity marca) {
		this.marca = marca;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
}
