package com.cibertec.edu.pe.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // NECESARIO
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// --- Imports de las Entidades y Servicios ---
import com.cibertec.edu.pe.entity.auto_entity;
import com.cibertec.edu.pe.entity.especificaciones_entity; // NECESARIO para inicializar
import com.cibertec.edu.pe.entity.marca_entity; // NECESARIO para cargar las marcas

import com.cibertec.edu.pe.service.auto_service;
import com.cibertec.edu.pe.service.marca_service; // NECESARIO
// ------------------------------------------

@Controller
@RequestMapping("/autos") // Prefijo: todas las rutas empiezan con /autos
public class auto_controller {

    // 1. INYECCIÓN DE DEPENDENCIAS
    // Spring inyectará automáticamente las implementaciones de los servicios
    @Autowired
    private auto_service autoService;
    
    @Autowired
    private marca_service marcaService; // Servicio para cargar las marcas
    
    // NOTA: Tu constructor original no estaba usando Autowired, pero lo necesitas.
    // Si no usas @Autowired en el campo, debes usarlo en un constructor (método más limpio):
    /*
    public auto_controller(auto_service autoService, marca_service marcaService) {
        this.autoService = autoService;
        this.marcaService = marcaService;
    }
    */
    
    // --------------------------------------------------------------------------
    
    /**
     * RUTA: http://localhost:9090/autos/listado
     * Muestra la lista de todos los autos en el inventario.
     */
    @GetMapping("/listado")
    public String listarAutos(Model model) {
        // ❌ ELIMINA: List<String> listaAutos = new ArrayList<>();
        // ✅ AGREGA:
        List<auto_entity> listaAutos = autoService.consultar(); 
        
        model.addAttribute("listaAutos", listaAutos);
        return "auto_listado"; 
    }

    // --------------------------------------------------------------------------
    
    /**
     * RUTA: http://localhost:9090/autos/nuevo
     * Muestra el formulario para crear un nuevo auto.
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        // 1. Crear el objeto Auto
        auto_entity auto = new auto_entity();
        
        // 2. Inicializar la entidad anidada ESPECIFICACIONES (CRÍTICO para evitar el error 500)
        auto.setEspecificacion(new especificaciones_entity());
        
        // 3. Cargar la lista de Marcas desde el servicio (Para el desplegable)
        List<marca_entity> listaMarcas = marcaService.consultar();
        
        // 4. Agregar objetos al modelo
        model.addAttribute("auto", auto); // Objeto principal del formulario
        model.addAttribute("listaMarcas", listaMarcas); // Lista para el <select>
        model.addAttribute("titulo", "Registrar Nuevo Vehículo");
        
        return "auto_form"; 
    }

    // --------------------------------------------------------------------------
    
    /**
     * RUTA: Maneja el envío del formulario para guardar un auto.
     */
    @PostMapping("/guardar")
    public String guardarAuto(@ModelAttribute auto_entity auto) {
        // La lógica de guardado real usando el servicio
        autoService.guardar(auto); 
        
        // Redirige al listado después de guardar
        return "redirect:/autos/listado"; 
    }
 // En auto_controller.java

 // 🎯 La URL debe coincidir con la URL en el navegador: /autos/detalles/{id_auto}
    @GetMapping("/detalles/{id_auto}") // <--- ¡Esta es la corrección!
    public String verDetallesAuto(@PathVariable("id_auto") Long id_auto, Model model) {
        
        // NOTA: Verifica que tu autoService.buscar() es el método correcto para buscar por ID.

        auto_entity autoEncontrado = autoService.buscar(id_auto);

        if (autoEncontrado == null) {
            return "redirect:/autos/listado";
        }

        model.addAttribute("auto", autoEncontrado);

        return "auto_detalles"; 
    }
}