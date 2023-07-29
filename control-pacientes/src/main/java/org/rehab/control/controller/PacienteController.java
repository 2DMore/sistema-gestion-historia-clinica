package org.rehab.control.controller;

import java.util.ArrayList;
import java.util.List;

import org.rehab.control.entity.Paciente;
import org.rehab.control.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value= "/paciente")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService; 
	
	/*
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("titulo", "Bienvenido al administrador de pacientes en rehabilitacion");
		return "index";
	}
	
	@ModelAttribute("pacientes")
	public List<Paciente> poblarPacientes(){
		List<Paciente> pacientes=pacienteService.getAllPacientes();
		return pacientes;
	}*/
	
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllPacientes(){
		try {
			return ResponseEntity.ok().body(pacienteService.getAllPacientes());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public Paciente createPaciente(@RequestBody Paciente paciente){
		return pacienteService.createPaciente(paciente);
	}
	
	@PutMapping("/")
	@ResponseBody
	public Paciente updatePaciente(@RequestBody Paciente paciente){
		return pacienteService.updatePaciente(paciente);
	}
	
	@DeleteMapping("/{numExp}")
	@ResponseBody
	public void deletePaciente(@PathVariable (value = "numExp") Long numExp){
		pacienteService.deletePaciente(numExp);
	}
}
