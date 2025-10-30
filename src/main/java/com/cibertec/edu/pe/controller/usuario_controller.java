package com.cibertec.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.pe.entity.usuario_entity;
import com.cibertec.edu.pe.service.usuario_service;

@Controller
@RequestMapping("/clientes")
public class usuario_controller {

    // 🛑 CAMBIO CRÍTICO: Usamos @Qualifier con el nombre exacto del Bean
    @Autowired
    @Qualifier("usuario_serviceImpl") // Usamos el nombre de la clase, minúscula la primera letra
    private usuario_service usuarioService;
    /**
     * RUTA: GET /clientes/listado
     * Muestra la tabla de todos los clientes (usuarios).
     */
 // En tu UsuarioController.java o ClienteController.java
    @GetMapping("/listado") // Debe coincidir con la redirección del paso 1
    public String listarUsuarios(Model model) {
        
        // Obtener la lista completa de la BD
        List<usuario_entity> lista = usuarioService.consultar();
        
        // 🎯 CLAVE: El atributo debe llamarse "listaUsuarios"
        model.addAttribute("listaUsuarios", lista); 
        model.addAttribute("titulo", "Listado de Clientes (Usuarios)");
        
        return "usuario_listado"; // O el nombre de tu archivo HTML
    }

    /**
     * RUTA: GET /clientes/nuevo
     * Muestra el formulario para registrar un nuevo cliente.
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        
        // 🛑 CRÍTICO: Debes crear y añadir el objeto 'usuario' (una instancia vacía)
        model.addAttribute("usuario", new usuario_entity()); 
        model.addAttribute("titulo", "Registrar Nuevo Cliente (Usuario)");
        
        return "usuario_form"; // Retorna el formulario
    }

    /**
     * RUTA: POST /clientes/guardar
     * Procesa el formulario y guarda el nuevo cliente en la BD.
     */
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute usuario_entity usuario) {
        // Llama al servicio para guardar
        usuarioService.crear(usuario); // o .guardar(usuario)
        
        // 🎯 CLAVE: Redirigir al método GET del listado
        return "redirect:/clientes/listado"; 
    }
}
