package org.rehab.control.fi.repository;

import org.rehab.control.dto.EmailDto;
import org.rehab.control.fi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	Paciente findByNumExpediente(Long numExpediente);
}
