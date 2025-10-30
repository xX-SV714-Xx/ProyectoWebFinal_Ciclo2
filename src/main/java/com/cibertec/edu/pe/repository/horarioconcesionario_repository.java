package com.cibertec.edu.pe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // ⬅️ Nuevo Import
import org.springframework.data.repository.query.Param; // ⬅️ Nuevo Import

import com.cibertec.edu.pe.entity.horarioconcesionario_entity;

public interface horarioconcesionario_repository
extends JpaRepository<horarioconcesionario_entity, Long>{

  
    @Query("SELECT h FROM horarioconcesionario_entity h WHERE h.concesionario.id_concesionario = :idConc")
    List<horarioconcesionario_entity> buscarPorConcesionario(@Param("idConc") Long idConcesionario); 
    
}