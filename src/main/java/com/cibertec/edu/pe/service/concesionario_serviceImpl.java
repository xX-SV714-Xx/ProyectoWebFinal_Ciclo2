package com.cibertec.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.concesionario_entity;
import com.cibertec.edu.pe.repository.concesionario_repository;
@Service
public class concesionario_serviceImpl implements concesionario_service {

	private final concesionario_repository repositorioConcesionario;
	
	public concesionario_serviceImpl(concesionario_repository repositorioConcesionario) {
		this.repositorioConcesionario = repositorioConcesionario;
	}
	
	@Override
	public concesionario_entity crear(concesionario_entity concesionario) {
	
		return repositorioConcesionario.save(concesionario);
	}

	@Override
	public concesionario_entity buscar(Long id) {
		return repositorioConcesionario.findById(id).orElse(null);
	}

	@Override
	public concesionario_entity actualizar(Long id, concesionario_entity concesionario) {
		
	    return repositorioConcesionario.save(concesionario);
	}

	@Override
	public List<concesionario_entity> consultar() {
		return repositorioConcesionario.findAll();
	}

	@Override
	public void eliminar(Long id) {
		
		 repositorioConcesionario.deleteById(id);
	}

	

}
