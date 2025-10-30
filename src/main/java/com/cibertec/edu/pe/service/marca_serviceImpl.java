package com.cibertec.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.marca_entity;

import com.cibertec.edu.pe.repository.marca_repository;

@Service
public class marca_serviceImpl implements marca_service{
    
    private final marca_repository repositoriomarca;
	
	public marca_serviceImpl(marca_repository repositoriomarca) {
		this.repositoriomarca = repositoriomarca;
	}
	@Override
	public marca_entity crear(marca_entity marca) {
		// TODO Auto-generated method stub
		 return repositoriomarca.save(marca);
	}

	@Override
	public marca_entity buscar(Long id_marca) {
		// TODO Auto-generated method stub
		return repositoriomarca.findById(id_marca).orElse(null);
	}

	@Override
	public marca_entity actualizar(Long id_marca, marca_entity marca) {
		// TODO Auto-generated method stub
		 return repositoriomarca.save(marca);
	}

	@Override
	public List<marca_entity> consultar() {
		// TODO Auto-generated method stub
		return repositoriomarca.findAll();
	}

	@Override
	public void eliminar(Long id_marca) {
		// TODO Auto-generated method stub
		 repositoriomarca.deleteById(id_marca);
	}

}
