package com.cibertec.edu.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="marca")
public class marca_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_marca", unique=true, nullable=false )
	private Long id_marca;
	
	@Column(name="nombre",length=25, nullable=false)
	private String nombre;
	
	@Column(name="pais_de_provinencia",length=35, nullable = false)
	private String pais_de_proveniencia;
    public marca_entity() {
    	
    }
	public marca_entity(Long id_marca, String nombre, String pais_de_proveniencia) {
		super();
		this.id_marca = id_marca;
		this.nombre = nombre;
		this.pais_de_proveniencia = pais_de_proveniencia;
	}

	public Long getId_marca() {
		return id_marca;
	}

	public void setId_marca(Long id_marca) {
		this.id_marca = id_marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais_de_proveniencia() {
		return pais_de_proveniencia;
	}

	public void setPais_de_proveniencia(String pais_de_proveniencia) {
		this.pais_de_proveniencia = pais_de_proveniencia;
	}
	
    
}
