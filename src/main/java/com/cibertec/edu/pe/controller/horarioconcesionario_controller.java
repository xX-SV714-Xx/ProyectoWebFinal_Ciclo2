package com.cibertec.edu.pe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.pe.entity.concesionario_entity;
import com.cibertec.edu.pe.entity.horarioconcesionario_entity;
import com.cibertec.edu.pe.service.concesionario_service;
import com.cibertec.edu.pe.service.horarioconcesionario_service;

@Controller
@RequestMapping("/horarios")
public class horarioconcesionario_controller {

	@Autowired
	private horarioconcesionario_service horarioService;

	@Autowired
	private concesionario_service concesionarioService;

	/**
	 * RUTA: GET /horarios/listado/{id_concesionario}
	 * Muestra la lista de horarios para un concesionario específico. */
	 private horarioconcesionario_entity obtenerHorarioPorTipo(List<horarioconcesionario_entity> lista, String tipo) {
    // ASUMIENDO que getTipoHorario() existe en tu entidad (como te sugerí)
    return lista.stream()
                .filter(h -> tipo.equals(h.getTipoHorario())) 
                .findFirst()
                .orElse(null);
}
		@GetMapping("/nuevo/{id_concesionario}")
		public String mostrarFormularioNuevo(@PathVariable("id_concesionario") Long id_concesionario, Model model) {

			concesionario_entity concesionario = concesionarioService.buscar(id_concesionario);

			if (concesionario == null) {
				return "redirect:/concesionarios/listado";
			}

			horarioconcesionario_entity nuevoHorario = new horarioconcesionario_entity();
			nuevoHorario.setConcesionario(concesionario);

			model.addAttribute("horario", nuevoHorario);
			model.addAttribute("concesionario", concesionario);
			model.addAttribute("titulo", "Agregar Horario para " + concesionario.getDistrito());

			return "horario_form";
		}
		
	 @GetMapping("/listado/{id_concesionario}")
	 public String listarHorariosPorConcesionario(@PathVariable("id_concesionario") Long id_concesionario, Model model) {
	     
	     // ... (código existente para buscar concesionario) ...

	     List<horarioconcesionario_entity> listaHorarios = horarioService.buscarPorConcesionario(id_concesionario); 
	     concesionario_entity concesionario = concesionarioService.buscar(id_concesionario);
	     // LÓGICA CLAVE: Creamos un mapa de los dos tipos de horarios posibles
	     horarioconcesionario_entity horarioRegular = obtenerHorarioPorTipo(listaHorarios, "Regular");
	     horarioconcesionario_entity horarioFeriado = obtenerHorarioPorTipo(listaHorarios, "Feriado");

	     model.addAttribute("concesionario", concesionario);
	     model.addAttribute("horarioRegular", horarioRegular); // Envia el objeto Regular (o null)
	     model.addAttribute("horarioFeriado", horarioFeriado); // Envia el objeto Feriado (o null)
	     model.addAttribute("listaHorarios", listaHorarios); 
	     model.addAttribute("titulo", "Horarios de: " + concesionario.getDistrito()); 

	     return "horario_listado";
	 }
	/**
	 * RUTA: GET /horarios/nuevo/{id_concesionario}
	 * Muestra el formulario para registrar un nuevo horario.
	 */


	/**
	 * RUTA: POST /horarios/guardar
	 * Procesa el envío del formulario y guarda/actualiza el horario.
	 */
	@PostMapping("/guardar")
	public String guardarHorario(@ModelAttribute horarioconcesionario_entity horario) {

		horarioService.crear(horario);

		// Redirige al listado de horarios de ESE concesionario
		return "redirect:/horarios/listado/" + horario.getConcesionario().getId_concesionario();
	}

	// --- MÉTODOS DE EDICIÓN Y ELIMINACIÓN CORREGIDOS ---

	/**
	 * RUTA: GET /horarios/editar/{id_horario}
	 * Muestra el formulario prellenado para editar un horario existente.
	 */
	@GetMapping("/editar/{id_horario}")
	// CORRECCIÓN: Se añade el nombre explícito para resolver el error de ambigüedad.
	public String editarHorario(@PathVariable("id_horario") Long id_horario, Model model) {

		horarioconcesionario_entity horario = horarioService.buscar(id_horario);

		if (horario == null) {
			return "redirect:/concesionarios/listado";
		}

		model.addAttribute("horario", horario);
		model.addAttribute("concesionario", horario.getConcesionario());
		model.addAttribute("titulo", "Editar Horario para " + horario.getConcesionario().getDistrito());

		return "horario_form";
	}

	/**
	 * RUTA: GET /horarios/eliminar/{id_horario}
	 */
	@GetMapping("/eliminar/{id_horario}")
	// ESTE YA ESTABA CORRECTO: ("id_horario")
	public String eliminarHorario(@PathVariable("id_horario") Long idHorario) {
		horarioconcesionario_entity horarioAEliminar = horarioService.buscar(idHorario);

		if (horarioAEliminar != null) {

			Long id_concesionario = horarioAEliminar.getConcesionario().getId_concesionario();

			horarioService.eliminar(idHorario);

			// Redirige al listado de horarios de ese concesionario

			return "redirect:/horarios/listado/" + id_concesionario;

		}

		// Si el horario no existe, redirige al listado principal

		return "redirect:/concesionarios/listado";

	}
}