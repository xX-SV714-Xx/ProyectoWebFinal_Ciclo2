package com.cibertec.edu.pe.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.horarioconcesionario_entity;
import com.cibertec.edu.pe.repository.horarioconcesionario_repository; // Asumiendo que existe

@Service 
public class horarioconcesionario_serviceImpl implements horarioconcesionario_service {

    private final horarioconcesionario_repository repositorioHorario;
    
  
    public horarioconcesionario_serviceImpl(horarioconcesionario_repository repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

   
    @Override
    public horarioconcesionario_entity crear(horarioconcesionario_entity horario) {
        return repositorioHorario.save(horario);
    }
    
    
    @Override
    public horarioconcesionario_entity buscar(Long id_horario) {
        return repositorioHorario.findById(id_horario).orElse(null);
    }

   
    @Override
    public horarioconcesionario_entity actualizar(Long id_horario, horarioconcesionario_entity horario) {
       
        return repositorioHorario.save(horario);
    }
    
    
    @Override
    public List<horarioconcesionario_entity> consultar() {
        return repositorioHorario.findAll();
    }
   
    @Override
    public void eliminar (Long id_horario) {
        repositorioHorario.deleteById(id_horario);
    }


 
    @Override
    public List<horarioconcesionario_entity> buscarPorConcesionario(Long idConcesionario) {
       
        return repositorioHorario.buscarPorConcesionario(idConcesionario); 
    }
}