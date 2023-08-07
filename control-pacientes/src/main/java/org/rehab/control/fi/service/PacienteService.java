package org.rehab.control.fi.service;

import java.util.List;

import org.rehab.control.dto.EmailDto;
import org.rehab.control.fi.entity.Paciente;
import org.rehab.control.fi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;

//	private final KafkaTemplate<String, EmailDto> kafkaTemplate;
//	
//	public PacienteService(KafkaTemplate<String, EmailDto> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
	
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
//	
//	public void sendMessage(EmailDto emailDto) {
//        kafkaTemplate.send("uady-mail-topic", emailDto);
//    }

}
