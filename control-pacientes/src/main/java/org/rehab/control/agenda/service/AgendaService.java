package org.rehab.control.agenda.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.rehab.control.agenda.entity.Agenda;
import org.rehab.control.agenda.repository.AgendaRepository;
import org.rehab.control.dto.EmailDto;
import org.rehab.control.fi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;
	
	private final KafkaTemplate<String, EmailDto> kafkaTemplate;
	
	public AgendaService(KafkaTemplate<String, EmailDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
	
	String[] status = {"agendada","confirmada","cancelada","asistencia"};
	
	public Agenda createAgenda(Agenda agenda) {
		log.info("Creando Agenda: "+ agenda.toString());
		agendaRepository.save(agenda);
		String email = agenda.getPaciente().getEmail();
		// Obtener fecha y hora de la cita
	    LocalDate fechaCita = agenda.getFecha();
	    LocalTime horaCita = agenda.getHora();

	    // Formatear fecha y hora en un String
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	    String fechaCitaStr = fechaCita.format(dateFormatter);
	    String horaCitaStr = horaCita.format(timeFormatter);
	    
	    String asunto = "Confirmación de cita";
	    
		String mensaje = "Estimado paciente, su cita está programada para el "
	            + fechaCitaStr + " a las " + horaCitaStr + ". Para confirmar su cita, por favor, haga clic en el siguiente enlace: "
	            + "http://localhost:8081/crp/agenda/" + agenda.getPaciente().getNumExpediente()+"/"+ agenda.getId()+"/1";
		EmailDto emailDto = new EmailDto();
		emailDto.setMessage(mensaje);
		emailDto.setSubject(asunto);
		emailDto.setToUser(email);
		sendMessage(emailDto);
		
		return agenda;
	}
	
	public List<Agenda> getAllAgendas(){
		return agendaRepository.findAll();
	}
	
	public Agenda updateAgenda(Agenda agenda) {
		log.info("Actualizando agenda: "+ agenda.toString());
		return agendaRepository.save(agenda);
	}
	
	public void deleteAgenda(Long id) {
		agendaRepository.deleteById(id);
	}
	
	public Agenda updateEstatusByNumExpediente(Long numExpediente, int nuevoEstatus, Long idAgenda) {
        log.info("Actualizando estatus de cita para el número de expediente: " + numExpediente);
        Agenda agenda = agendaRepository.findByPacienteNumExpediente(numExpediente, idAgenda);
        if (agenda != null) {
        	if(nuevoEstatus >= 0 && nuevoEstatus < status.length) {
        		agenda.setEstatusCita(status[nuevoEstatus]);
        		return agendaRepository.save(agenda);
        	} else {
        		throw new IllegalArgumentException("El nuevo estatus proporcionado no es un índice válido en el arreglo 'status'.");
            }
            
        } else {
            throw new EntityNotFoundException("Cita no encontrada para el número de expediente: " + numExpediente);
        }
    }
	
	public void sendMessage(EmailDto emailDto) {
        kafkaTemplate.send("uady-mail-topic", emailDto);
    }
	
}
