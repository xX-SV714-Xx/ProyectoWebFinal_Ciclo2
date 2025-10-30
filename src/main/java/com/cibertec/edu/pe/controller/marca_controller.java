package com.cibertec.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.pe.entity.marca_entity;
import com.cibertec.edu.pe.service.marca_service; // Necesario para la lógica de negocio

@Controller
@RequestMapping("/marcas") // Prefijo: /marcas/
public class marca_controller {

    // Inyección del servicio de marca
    @Autowired
    private marca_service marcaService;

    /**
     * RUTA: GET /marcas/listado
     * Muestra la página con la tabla de todas las marcas registradas.
     */
    @GetMapping("/listado")
    public String listarMarcas(Model model) {
        // Cargar todas las marcas usando el servicio
        List<marca_entity> listaMarcas = marcaService.consultar();

        model.addAttribute("listaMarcas", listaMarcas);
        model.addAttribute("titulo", "Listado de Marcas de Vehículos");

        return "marca_listado"; // Nombre del archivo HTML para el listado
    }

    /**
     * RUTA: GET /marcas/nuevo
     * Muestra el formulario para registrar una nueva marca.
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        // Objeto vacío para que Thymeleaf pueda enlazar los campos
        model.addAttribute("marca", new marca_entity()); 
        model.addAttribute("titulo", "Registrar Nueva Marca");
        
        return "marca_form"; // Nombre del archivo HTML del formulario
    }

    /**
     * RUTA: POST /marcas/guardar
     * Procesa el envío del formulario y guarda la marca.
     */
    @PostMapping("/guardar")
    public String guardarMarca(@ModelAttribute marca_entity marca) {
        // Lógica de guardado (el método 'crear' o 'guardar' debe existir en marca_service)
        marcaService.crear(marca); 
        
        // Redirige al listado después de guardar
        return "redirect:/marcas/listado";
    }
}