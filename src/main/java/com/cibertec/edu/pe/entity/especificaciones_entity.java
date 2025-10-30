package com.cibertec.edu.pe.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="especificaciones")
public class especificaciones_entity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_especificaciones", unique = true, nullable=false)
    private Long id_especificaciones;
    
    @Column(name="velocidad_punta",nullable=false)
  
    private Double velocidadPunta; 
    
    @Column(name="capacidad_asientos",nullable=false)
   
    private int capacidadAsientos; 
    
    @Column(name="Caballos_de_fuerza", nullable = false)
    
    private double caballosDeFuerza; 
    
    @Column(name = "tipomotor", nullable = false, length = 30)
    private String tipoMotor;
    
    @Column(name = "color", nullable = true)
    private String color;
    
    @OneToOne(mappedBy="especificacion") 
    private auto_entity auto;
   
    public especificaciones_entity() {
        
    }
    
    public especificaciones_entity(Long id_especificaciones, Double velocidadPunta, int capacidadAsientos,
            double caballosDeFuerza, String tipoMotor, String color, auto_entity auto) {
        super();
        this.id_especificaciones = id_especificaciones;
        this.velocidadPunta = velocidadPunta;
        this.capacidadAsientos = capacidadAsientos;
        this.caballosDeFuerza = caballosDeFuerza;
        this.tipoMotor = tipoMotor;
        this.color = color;
        this.auto = auto;
    }
    
   
    public Long getId_especificaciones() {
        return id_especificaciones;
    }
    public void setId_especificaciones(Long id_especificaciones) {
        this.id_especificaciones = id_especificaciones;
    }

   
    public Double getVelocidadPunta() {
        return velocidadPunta;
    }
    public void setVelocidadPunta(Double velocidadPunta) {
        this.velocidadPunta = velocidadPunta;
    }

    
    public int getCapacidadAsientos() {
        return capacidadAsientos;
    }
    public void setCapacidadAsientos(int capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

   
    public double getCaballosDeFuerza() {
        return caballosDeFuerza;
    }
    public void setCaballosDeFuerza(double caballosDeFuerza) {
        this.caballosDeFuerza = caballosDeFuerza;
    }

    
    public String getTipoMotor() {
        return tipoMotor;
    }
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }
    
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    public auto_entity getAuto() {
        return auto;
    }
    public void setAuto(auto_entity auto) {
        this.auto = auto;
    }
}
