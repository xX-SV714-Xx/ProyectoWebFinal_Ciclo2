package com.cibertec.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.usuario_entity;
import com.cibertec.edu.pe.repository.usuario_repository;
@Service
public class usuario_serviceImpl implements usuario_service {
private final usuario_repository repositorioUsuario;
   public usuario_serviceImpl(usuario_repository repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}
	@Override
	public usuario_entity crear(usuario_entity cliente) {
		// TODO Auto-generated method stub
		return repositorioUsuario.save(cliente);
	}

	@Override
	public usuario_entity buscar(Long id_cliente) {
		// TODO Auto-generated method stub
		return repositorioUsuario.findById(id_cliente).orElse(null);
	}
	@Override
	public usuario_entity actualizar(Long id_cliente, usuario_entity cliente) {
		// TODO Auto-generated method stub
		return repositorioUsuario.save(cliente);
	}

	@Override
	public List<usuario_entity> consultar() {
		// TODO Auto-generated method stub
		return repositorioUsuario.findAll();
	}

	@Override
	public void eliminar(Long id_cliente) {
		// TODO Auto-generated method stub
		repositorioUsuario.deleteById(id_cliente);
	}
	@Override
    public usuario_entity guardar(usuario_entity cliente) {
        // 🛑 Lógica CORREGIDA: Llama al repositorio para guardar el objeto en la BD
        return repositorioUsuario.save(cliente); 	
    }
}
