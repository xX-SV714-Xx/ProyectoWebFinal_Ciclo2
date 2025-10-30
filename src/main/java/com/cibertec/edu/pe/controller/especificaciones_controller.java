package com.cibertec.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.pe.entity.auto_entity;
import com.cibertec.edu.pe.service.auto_service; // Necesario para buscar el auto

@Controller
@RequestMapping("/especificaciones")
public class especificaciones_controller {

    // Inyectamos el servicio de auto, ya que la especificación está anidada en él.
    @Autowired
    private auto_service autoService;

    /**
     * RUTA: GET /especificaciones/detalle/{idAuto}
     * Muestra la página de detalle de las especificaciones para un auto específico.
     * * @param idAuto El ID del auto cuyas especificaciones se desean ver.
     * @param model El modelo para pasar datos a la vista.
     */
    @GetMapping("/detalle/{idAuto}")
    public String mostrarDetalleEspecificaciones(@PathVariable("id_auto") Long idAuto, Model model) {
        
        // 1. Buscar el Auto por su ID
        // Usamos autoService.buscar(id) que ya definiste en tu servicio.
        auto_entity auto = autoService.buscar(idAuto);

        // 2. Verificar que el auto y su especificación existan
        if (auto == null) {
            // Manejar error si el auto no existe
            model.addAttribute("error", "Auto no encontrado con ID: " + idAuto);
            return "error_page"; // Redirige a una página de error o a la lista de autos.
        }
        
        // 3. Pasar los objetos a la vista
        model.addAttribute("auto", auto);
        model.addAttribute("especificacion", auto.getEspecificacion()); // El nombre del campo es 'especificacion'
        model.addAttribute("titulo", "Especificaciones Técnicas del " + auto.getModelo());

        // Devuelve el nombre de la plantilla HTML para el detalle
        return "especificaciones_detalle"; 
    }
    
}
    
    // Si deseas mantener tu ruta original de listado de especificaciones,
    // puedes dejar este método (o adaptarlo a cómo quieres listar):
    /*
    @GetMapping("/listado")
    public String listarEspecificaciones(Model model) {
        // Lógica para obtener TODAS las especificaciones o la información relevante
        // ...
        return "especificaciones_listado";
    }
    */