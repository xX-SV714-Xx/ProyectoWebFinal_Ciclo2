package com.cibertec.edu.pe.service;

import java.util.List;

import com.cibertec.edu.pe.entity.especificaciones_entity;

public interface especificaciones_service {

	especificaciones_entity crear(especificaciones_entity especificaciones);
    
	especificaciones_entity buscar(Long id_especificaciones);
    
	especificaciones_entity actualizar(Long id_especificaciones, especificaciones_entity especificaciones);
    
    List<especificaciones_entity> consultar();
    
    void eliminar (Long id_especificaciones);

}
