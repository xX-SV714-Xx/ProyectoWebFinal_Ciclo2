package com.cibertec.edu.pe.service;

import java.util.List;

import com.cibertec.edu.pe.entity.concesionario_entity;

public interface concesionario_service {
	
	    concesionario_entity crear(concesionario_entity concesionario);
	    
	    concesionario_entity buscar(Long id_concesionario);
	    
	   
	    
	    concesionario_entity actualizar(Long id_concesionario, concesionario_entity concesionario);
	    
	    List<concesionario_entity> consultar();
	    
	    void eliminar (Long id_concesionario);
	    
	    

}
