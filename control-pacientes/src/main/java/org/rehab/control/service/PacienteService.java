package org.rehab.control.service;

import java.util.List;

import org.rehab.control.entity.Paciente;
import org.rehab.control.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente createPaciente(Paciente paciente) {
		log.info("Creando paciente: " +paciente.toString());
		return pacienteRepository.save(paciente);
	}
	
	public Paciente updatePaciente(Paciente paciente) {
		log.info("Actualizando paciente: " +paciente.toString());
		return pacienteRepository.save(paciente);
	}
	
	public List<Paciente> getAllPacientes() {
		return pacienteRepository.findAll();
	}
	
	public void deletePaciente(Long numExpediente) {
		pacienteRepository.deleteById(numExpediente);
	}
}
