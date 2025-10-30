package com.cibertec.edu.pe.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuadro_de_ventas")
public class venta_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long idVenta;
	@Column(name = "fecha_venta", nullable = false)
	private LocalDate fecha_venta;
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private usuario_entity cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_auto", nullable = false)
	private auto_entity auto;
	
	@Column(name = "precio_final", nullable = false)
	private Double precioFinal;
	@Column(name = "estado_venta", nullable = false, length = 20)
	private String estado;
	public venta_entity() {
		
	}
	public venta_entity(Long id_venta, LocalDate fecha_venta, usuario_entity cliente, auto_entity auto,
			Double precioFinal, String estado) {
		super();
		this.idVenta = id_venta;
		this.fecha_venta = fecha_venta;
		this.cliente = cliente;
		this.auto = auto;
		this.precioFinal = precioFinal;
		this.estado = estado;
	}
	public Long getIdVenta() { 
	    return idVenta;
	}
	public void setIdVenta(Long idVenta) { 
	    this.idVenta = idVenta;
	}
	public LocalDate getFechaVenta() { 
	    return fecha_venta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
	    this.fecha_venta = fechaVenta;
	}
	
	public usuario_entity getCliente() {
	    return cliente;
	}
	public void setCliente(usuario_entity cliente) {
	    this.cliente = cliente;
	}
	public auto_entity getAuto() {
		return auto;
	}
	public void setAuto(auto_entity auto) {
		this.auto = auto;
	}
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
