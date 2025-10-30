package com.cibertec.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.auto_entity;
import com.cibertec.edu.pe.repository.auto_repository;
@Service
public class auto_serviceImpl implements auto_service{

	private final auto_repository repositorioauto;
	
	public auto_serviceImpl(auto_repository repositorioauto) {
		this.repositorioauto = repositorioauto;
	}
	@Override
	public auto_entity crear(auto_entity auto) {
		// TODO Auto-generated method stub
		return repositorioauto.save(auto);
	}

	@Override
	public auto_entity buscar(Long id) {
		// TODO Auto-generated method stub
		return repositorioauto.findById(id).orElse(null);
	}

	@Override
	public auto_entity actualizar(Long id, auto_entity auto) {
		// TODO Auto-generated method stub
	 return repositorioauto.save(auto);
	}

	@Override
	public List<auto_entity> consultar() {
		// TODO Auto-generated method stub
		return repositorioauto.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		 repositorioauto.deleteById(id);
	}
	@Override
	public auto_entity guardar(auto_entity auto) {
		// TODO Auto-generated method stub
		return repositorioauto.save(auto);
	}

}
