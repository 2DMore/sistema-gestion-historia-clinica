package org.rehab.control.agenda.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.rehab.control.fi.entity.Paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agenda")
@Data
@NoArgsConstructor
public class Agenda {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="num_expediente")
	private Paciente paciente;
	
	@Column(name = "fecha_cita")
	private LocalDate fecha;
	
	@Column(name = "hora_cita")
	private LocalTime hora;
	
	@Column(name = "tipo_paciente")
	private String tipoPaciente;
	
	@Column(name = "estatus_cita")
	private String estatusCita;
	
	@Column(name = "numero_sesion")
	private Integer numeroSesion;
	
	@Column(name = "costo_terapia")
	private Double costoTerapia;
    
}
