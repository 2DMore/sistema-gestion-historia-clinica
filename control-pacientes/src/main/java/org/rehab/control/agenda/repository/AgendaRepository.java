package org.rehab.control.agenda.repository;

import org.rehab.control.agenda.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
	@Query("SELECT a FROM Agenda a WHERE a.paciente.numExpediente = :numExpediente AND a.id = :idAgenda")
    Agenda findByPacienteNumExpediente(@Param("numExpediente") Long numExpediente, @Param("idAgenda") Long idAgenda);
}
