package com.cibertec.edu.pe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.pe.entity.concesionario_entity;
import com.cibertec.edu.pe.entity.marca_entity; // Importar la entidad de Marca
import com.cibertec.edu.pe.service.concesionario_service;
import com.cibertec.edu.pe.service.marca_service; // Importar el servicio de Marca
import org.springframework.web.bind.annotation.PathVariable; // ¡NECESARIO!

@Controller
@RequestMapping("/concesionarios") // Prefijo: /concesionarios/
public class concesionario_controller {

    // 1. INYECCIÓN DE DEPENDENCIAS: Concesionario
    @Autowired
    private concesionario_service concesionarioService;
    
    // 2. INYECCIÓN DE DEPENDENCIAS: Marca (¡Necesario para cargar el listado!)
    @Autowired
    private marca_service marcaService; // ⬅️ Nuevo: Inyectar servicio de marcas

    /**
     * RUTA: GET /concesionarios/listado
     * Muestra la página con la tabla de todos los concesionarios registrados.
     */
    @GetMapping("/listado")
    public String listarConcesionarios(Model model) {
        // Cargar todos los concesionarios
        List<concesionario_entity> listaConcesionarios = concesionarioService.consultar();

        model.addAttribute("listaConcesionarios", listaConcesionarios);
        model.addAttribute("titulo", "Listado de Concesionarios");

        return "concesionario_listado"; // Nombre del archivo HTML para el listado
    }

    /**
     * RUTA: GET /concesionarios/nueva
     * Muestra el formulario para registrar un nuevo concesionario.
     */
    @GetMapping("/nueva")
    public String mostrarFormularioNuevo(Model model) {
        // Objeto vacío para que Thymeleaf pueda enlazar los campos
        model.addAttribute("concesionario", new concesionario_entity()); 
        
        // 🛑 SOLUCIÓN AL PROBLEMA: Cargar la lista de marcas
        List<marca_entity> listaMarcas = marcaService.consultar(); // Asumiendo que tu método se llama 'consultar()'
        model.addAttribute("listaMarcas", listaMarcas); // ⬅️ Esto carga el dropdown en el HTML
        
        model.addAttribute("titulo", "Registrar Nuevo Concesionario");
        
        return "concesionario_form"; // Nombre del archivo HTML del formulario
    }

    /**
     * RUTA: POST /concesionarios/guardar
     * Procesa el envío del formulario y guarda el concesionario.
     */
    @PostMapping("/guardar")
    public String guardarConcesionario(@ModelAttribute concesionario_entity concesionario) {
        // Asumo que tu servicio tiene un método 'crear' o 'guardar'
        concesionarioService.crear(concesionario); 
        
        // Redirige al listado después de guardar
        return "redirect:/concesionarios/listado";
    }
    @GetMapping("/editar/{id}")
    // Usamos @PathVariable para que Spring sepa que el 'id' del método viene de la URL.
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        
        // 1. Buscar el concesionario por ID
        concesionario_entity concesionario = concesionarioService.buscar(id);
        
        // 2. Cargar lista de marcas (necesario para el dropdown en el formulario)
        List<marca_entity> listaMarcas = marcaService.consultar();
        
        if (concesionario != null) {
            model.addAttribute("concesionario", concesionario); // El objeto prellenado
            model.addAttribute("listaMarcas", listaMarcas);
            model.addAttribute("titulo", "Editar Concesionario: " + concesionario.getDistrito());
            return "concesionario_form"; // Reutiliza el formulario de registro
        }
        
        // Si no existe, redirige al listado
        return "redirect:/concesionarios/listado";
    }

    /**
     * RUTA: GET /concesionarios/eliminar/{id}
     * Elimina un concesionario por ID y redirige al listado.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarConcesionario(@PathVariable("id") Long id) {
        
        concesionarioService.eliminar(id);
        
        // Redirige al listado después de eliminar
        return "redirect:/concesionarios/listado";
    }
    
}