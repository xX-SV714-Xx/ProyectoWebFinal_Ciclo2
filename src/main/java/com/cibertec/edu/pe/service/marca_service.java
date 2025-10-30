package com.cibertec.edu.pe.service;

import java.util.List;

import com.cibertec.edu.pe.entity.marca_entity;

public interface marca_service {
	marca_entity crear(marca_entity marca);
    
	marca_entity buscar(Long id_marca);
    
	marca_entity actualizar(Long id_marca, marca_entity marca);
    
    List<marca_entity> consultar();
    
    void eliminar (Long id);
}
