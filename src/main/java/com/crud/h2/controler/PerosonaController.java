package com.crud.h2.controler;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.h2.modelo.Persona;
import com.crud.h2.service.IPersonaService;

@Controller
public class PerosonaController {
	
	
	@Autowired
	private IPersonaService service;
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("personas", service.listar());
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String nuevo() {
		return "agregar";
		
	}
	@PostMapping("/agregar")
	public String agregar( Persona p) {
		service.agregar(p);
		return ("redirect:/listar");
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Persona persona = service.listPersona(id);
		model.addAttribute("persona", persona);
		return "editar";
		
	}
	@PostMapping("/actualizar")
	public String actualizar(Persona p) {
		service.editar(p);
		return "redirect:/listar";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		service.eliminar(id);
		
		return "redirect:/listar";
		}


}
