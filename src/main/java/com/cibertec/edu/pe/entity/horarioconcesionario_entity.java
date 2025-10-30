package com.cibertec.edu.pe.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Horario")

public class horarioconcesionario_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horario", unique = true, nullable = false)
	private Long id_horario;

	@Column(name = "dia_semana", nullable = false)
	private String dia_semana;

	@Column(name = "hora_apertura", nullable = false)
	private LocalTime horas_apertura;
	@Column(name = "hora_cierre", nullable = false)
	private LocalTime hora_cierre;

	@ManyToOne
	@JoinColumn(name = "id_concesionario", nullable = false)
	private concesionario_entity concesionario;

	public horarioconcesionario_entity() {

	}

	public horarioconcesionario_entity(Long id_horario, String tipoHorario, LocalTime horas_apertura,
			LocalTime hora_cierre, concesionario_entity concesionario) {
		super();
		this.id_horario = id_horario;
	
		this.dia_semana = tipoHorario;
		this.horas_apertura = horas_apertura;
		this.hora_cierre = hora_cierre;
		this.concesionario = concesionario;
	}

	public Long getId_horario() {
		return id_horario;
	}

	public void setId_horario(Long id_horario) {
		this.id_horario = id_horario;
	}



	public String getTipoHorario() { 
		return dia_semana;
	}

	public void setTipoHorario(String tipoHorario) { 
		this.dia_semana = tipoHorario;
	}

	
	public LocalTime getHoras_apertura() {
		return horas_apertura;
	}

	public void setHoras_apertura(LocalTime horas_apertura) {
		this.horas_apertura = horas_apertura;
	}

	public LocalTime getHora_cierre() {
		return hora_cierre;
	}

	public void setHora_cierre(LocalTime hora_cierre) {
		this.hora_cierre = hora_cierre;
	}

	public void setConcesionario(concesionario_entity concesionario) { 
 this.concesionario = concesionario;
	}

	public concesionario_entity getConcesionario() { 
 return concesionario;
	}
}
