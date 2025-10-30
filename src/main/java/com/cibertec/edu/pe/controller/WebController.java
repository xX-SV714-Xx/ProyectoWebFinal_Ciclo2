package com.cibertec.edu.pe.controller; // Asegúrate de que el paquete sea el correcto

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    /**
     * Mapea la URL "http://localhost:9090/Inicio"
     * para mostrar la página de inicio.
     */
    @GetMapping("/Inicio")
    public String mostrarPaginaInicio() {
        // Retorna el nombre del archivo HTML sin la extensión (.html)
        // Spring buscará: src/main/resources/templates/Inicio.html
        return "Inicio"; 
    }
    
    /**
     * (Opcional pero Recomendado) Mapea la URL raíz "http://localhost:9090/"
     * para que también muestre la página de inicio.
     */
    @GetMapping("/")
    public String mostrarRaiz() {
        return "Inicio";
    }
}
