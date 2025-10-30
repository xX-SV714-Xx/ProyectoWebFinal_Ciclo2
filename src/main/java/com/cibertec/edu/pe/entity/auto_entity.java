package com.cibertec.edu.pe.entity;


import jakarta.persistence.CascadeType; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "auto") 
public class auto_entity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "año_de_creacion", nullable = false)
    private int aniodecreacion;
    
    @Column(name = "precio", nullable = false)
    private double precio;


    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private marca_entity marca;
    
    @Column(name = "modelo", nullable = false, length = 90)
    private String modelo;
    
    @Column(name = "matricula", length = 6, unique = true, nullable = false)
    private String matricula;
    
   
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
    @JoinColumn(name = "especificacion_id")
    private especificaciones_entity especificacion;
    
   
    public auto_entity() {
       
    }

    public auto_entity(int aniodecreacion, double precio, Long id, String modelo, String matricula) {
        super();
        this.aniodecreacion = aniodecreacion;
        this.precio = precio;
        this.id = id;
        this.modelo = modelo;
        this.matricula = matricula;
    }

  
    public int getAniodecreacion() {
        return aniodecreacion;
    }

    public void setAniodecreacion(int aniodecreacion) {
        this.aniodecreacion = aniodecreacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    public marca_entity getMarca() {
        return marca;
    }

    public void setMarca(marca_entity marca) {
        this.marca = marca;
    }

    public especificaciones_entity getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(especificaciones_entity especificacion) {
        this.especificacion = especificacion;
    }
}
