package com.cibertec.edu.pe.service;

import java.util.List;


import com.cibertec.edu.pe.entity.venta_entity;

public interface venta_service {
	venta_entity crear(venta_entity venta);
    
	venta_entity buscar(Long id_venta);
    
	venta_entity actualizar(Long id_venta, venta_entity venta);
    
    List<venta_entity> consultar();
    
    void eliminar (Long id_venta);
}
