package com.cibertec.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.edu.pe.entity.auto_entity;

public interface auto_repository 
    extends  JpaRepository<auto_entity, Long>{

}
