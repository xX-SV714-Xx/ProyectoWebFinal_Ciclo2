package com.cibertec.edu.pe.service;

import java.util.List;

import com.cibertec.edu.pe.entity.auto_entity;

public interface auto_service {
    auto_entity crear(auto_entity auto);
    
    auto_entity buscar(Long id);
    
    auto_entity actualizar(Long id, auto_entity auto);
    
    List<auto_entity> consultar();
    
    void eliminar (Long id);
    
    auto_entity guardar(auto_entity auto); 
    
    }
