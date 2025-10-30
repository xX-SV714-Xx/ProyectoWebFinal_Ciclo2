package com.cibertec.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.venta_entity;
import com.cibertec.edu.pe.repository.venta_repository;
@Service
public class venta_serviceImpl implements venta_service {
    private final venta_repository repositorioDeVentas;
    public venta_serviceImpl(venta_repository  repositorioDeVentas) {
    	this.repositorioDeVentas=repositorioDeVentas;
    }
    
	@Override
	public venta_entity crear(venta_entity venta) {
		// TODO Auto-generated method stub
		return repositorioDeVentas.save(venta);
	}

	@Override
	public venta_entity buscar(Long id_venta) {
		// TODO Auto-generated method stub
		return repositorioDeVentas.findById(id_venta).orElse(null);
	}

	@Override
	public venta_entity actualizar(Long id_venta, venta_entity venta) {
		// TODO Auto-generated method stub
		return repositorioDeVentas.save(venta);
	}

	@Override
	public List<venta_entity> consultar() {
		// TODO Auto-generated method stub
		return repositorioDeVentas.findAll();
	}

	@Override
	public void eliminar(Long id_venta) {
		// TODO Auto-generated method stub
		repositorioDeVentas.deleteById(id_venta);
	}
	

}
