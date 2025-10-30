package com.cibertec.edu.pe.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.especificaciones_entity;
import com.cibertec.edu.pe.repository.especificaciones_repository; // Asumiendo que existe

@Service 
public class especificaciones_serviceImpl implements especificaciones_service {

    private final especificaciones_repository repositorioEspecificaciones;
    
  
    public especificaciones_serviceImpl(especificaciones_repository repositorioEspecificaciones) {
        this.repositorioEspecificaciones = repositorioEspecificaciones;
    }

    @Override
    public especificaciones_entity crear(especificaciones_entity especificaciones) {
        return repositorioEspecificaciones.save(especificaciones);
    }
    
    @Override
    public especificaciones_entity buscar(Long id_especificaciones) {
        return repositorioEspecificaciones.findById(id_especificaciones).orElse(null);
    }

    @Override
    public especificaciones_entity actualizar(Long id_especificaciones, especificaciones_entity especificaciones) {
        return repositorioEspecificaciones.save(especificaciones);
    }
    
    @Override
    public List<especificaciones_entity> consultar() {
        return repositorioEspecificaciones.findAll();
    }
    
    @Override
    public void eliminar (Long id_especificaciones) {
        repositorioEspecificaciones.deleteById(id_especificaciones);
    }
}