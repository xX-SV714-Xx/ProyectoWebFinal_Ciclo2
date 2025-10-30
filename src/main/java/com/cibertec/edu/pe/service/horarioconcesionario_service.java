package com.cibertec.edu.pe.service;

import java.util.List;

import com.cibertec.edu.pe.entity.horarioconcesionario_entity;

public interface horarioconcesionario_service {
	horarioconcesionario_entity crear(horarioconcesionario_entity horario);
    
	horarioconcesionario_entity buscar(Long id_horario);
    
	horarioconcesionario_entity actualizar(Long id_horario, horarioconcesionario_entity horario);
    
    List<horarioconcesionario_entity> consultar();
    
    void eliminar (Long id_horario);
    
    List<horarioconcesionario_entity> buscarPorConcesionario(Long idConcesionario);
}
