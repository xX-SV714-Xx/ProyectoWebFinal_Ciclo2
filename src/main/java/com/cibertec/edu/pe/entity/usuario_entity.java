package com.cibertec.edu.pe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class usuario_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente", unique=true , nullable=false)
	private Long id_cliente;
	
	@Column(name="nombres",length=50,nullable=false)
	private String nombres;
	
	@Column(name="apellidos",length=50,nullable=false)
	private String apellidos;
	
	@Column(name="email", length=100,nullable=false)
	private String email;
	
	@Column(name="telefono", length=9, nullable=false)
	private String telefono;
	
	@Column(name="direccion", length=100, nullable=false)
	private String direccion;
	public usuario_entity() {
		
	}
	public usuario_entity(Long id_cliente, String nombres, String apellidos, String email, String telefono,
			String direccion) {
		super();
		this.id_cliente = id_cliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
