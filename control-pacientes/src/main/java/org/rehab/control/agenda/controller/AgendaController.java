package org.rehab.control.agenda.controller;

import org.rehab.control.agenda.service.AgendaService;
import org.rehab.control.agenda.entity.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value="/agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllagenda(){
		try {
			return ResponseEntity.ok().body(agendaService.getAllAgendas());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public Agenda createagenda(@RequestBody Agenda agenda) {
		return agendaService.createAgenda(agenda);
	}
	
	@PutMapping("/")
	@ResponseBody
	public Agenda updateagenda(@RequestBody Agenda agenda) {
		return agendaService.updateAgenda(agenda);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteagenda(@PathVariable (value = "id") Long id) {
		agendaService.deleteAgenda(id);
	}
	
	@GetMapping("/{numExpediente}/{idAgenda}/{status}")
	public ResponseEntity<?> updateEstatusByNumExpediente(
	        @PathVariable(value = "numExpediente") Long numExpediente,
	        @PathVariable(value = "idAgenda") Long idAgenda,
	        @PathVariable(value = "status") int status) {
	    try {
	        Agenda updatedAgenda = agendaService.updateEstatusByNumExpediente(numExpediente, status, idAgenda);
	        return ResponseEntity.ok().body("Estatus de la cita: "+updatedAgenda.getEstatusCita());
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.notFound().build();
	    } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error al actualizar el estatus de la cita: " + e.getMessage());
        }
	}
}
