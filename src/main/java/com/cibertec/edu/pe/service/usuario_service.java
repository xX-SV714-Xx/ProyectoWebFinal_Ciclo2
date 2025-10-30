package com.cibertec.edu.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.usuario_entity;

@Service
public interface usuario_service {
	usuario_entity crear(usuario_entity cliente);
    
	usuario_entity buscar(Long id_cliente);
    
	usuario_entity actualizar(Long id_cliente, usuario_entity cliente);
    
    List<usuario_entity> consultar();
    
    void eliminar (Long id_cliente);
    
    public usuario_entity guardar(usuario_entity usuario);


}
