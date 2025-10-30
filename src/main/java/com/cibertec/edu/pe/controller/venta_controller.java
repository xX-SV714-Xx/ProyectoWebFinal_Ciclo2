package com.cibertec.edu.pe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.pe.entity.auto_entity;
import com.cibertec.edu.pe.entity.usuario_entity;
import com.cibertec.edu.pe.entity.venta_entity;
import com.cibertec.edu.pe.service.auto_service;
import com.cibertec.edu.pe.service.usuario_service; // Asumo que el cliente es un usuario
import com.cibertec.edu.pe.service.venta_service;

@Controller
@RequestMapping("/ventas") // Prefijo: /ventas/
public class venta_controller {

    @Autowired
    private venta_service ventaService;
    
    @Autowired
    private auto_service autoService;
    
    @Autowired
    private usuario_service usuarioService;

    /**
     * RUTA: GET /ventas/listado
     * Muestra la página con el historial de todas las ventas registradas.
     */
    @GetMapping("/listado")
    public String listarVentas(Model model) {
        // Cargar todas las ventas
        List<venta_entity> listaVentas = ventaService.consultar();
        model.addAttribute("listaVentas", listaVentas);
        model.addAttribute("titulo", "Historial de Ventas Registradas");
        return "venta_listado";
    }

    /**
     * RUTA: GET /ventas/nueva
     * Muestra el formulario para registrar una nueva venta.
     */
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaVenta(Model model) {
        
        // 1. Necesario para el formulario: Objeto Venta vacío
        model.addAttribute("venta", new venta_entity());
        
        // 2. Necesario para el selector: Lista de Autos
        model.addAttribute("listaAutos", autoService.consultar()); 
        
        // 3. Necesario para el selector: Lista de Clientes (Usuarios)
        model.addAttribute("listaClientes", usuarioService.consultar()); 

        model.addAttribute("titulo", "Registrar Nueva Venta de Vehículo");
        
        return "venta_form";
    }

    /**
     * RUTA: POST /ventas/guardar
     * Procesa el envío del formulario y guarda la venta.
     */
    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute venta_entity venta, Model model) {
        try {
            // 1. OBTENER ID's del objeto 'venta' (que vienen del formulario)
            Long idAutoSeleccionado = venta.getAuto().getId(); // Asumiendo que el ID del Auto se llama 'id'
            Long idClienteSeleccionado = venta.getCliente().getId_cliente(); // Ya confirmamos que es 'id_cliente'

            // 2. CARGAR las entidades completas desde la BD
            auto_entity auto = autoService.buscar(idAutoSeleccionado);
            usuario_entity cliente = usuarioService.buscar(idClienteSeleccionado);
            
            // 3. ASIGNAR las entidades cargadas al objeto venta
            venta.setAuto(auto);
            venta.setCliente(cliente);

            // 4. GUARDAR la venta completa (con sus relaciones cargadas)
            ventaService.crear(venta); 
            
            return "redirect:/ventas/listado";
            
        } catch (Exception e) {
            // 🚨 SIEMPRE imprime el error para verlo en consola
            e.printStackTrace(); 
            
            // Si falla (ej. si el ID no existe), recargamos el formulario con un mensaje
            model.addAttribute("error", "Error al guardar la venta: " + e.getMessage());
            
            // Recargar listas para que el formulario no falle
            model.addAttribute("venta", venta); 
            model.addAttribute("listaAutos", autoService.consultar()); 
            model.addAttribute("listaClientes", usuarioService.consultar());
            model.addAttribute("titulo", "Registrar Nueva Venta de Vehículo");
            
            return "venta_form";
        }
    }
}