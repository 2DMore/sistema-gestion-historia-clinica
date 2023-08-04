package org.rehab.control.ago.entity;

import java.time.LocalDate;

import org.rehab.control.fi.entity.Paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "antecedentes_gineco_obstetricos")
@Data
@NoArgsConstructor
public class AntecedentesGinecoObstetricos {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="num_expediente")
	private Paciente paciente;
	
	@Column(name = "menarca")
	private LocalDate menarca;
	
	@Column(name = "ritmo_menstrual")
	private String ritmoMenstrual;
	
	@Column(name = "ipsa")
	private int ipsa;
	
	@Column(name = "num_partos")
	private int numPartos;
	
	@Column(name = "fup")
	private LocalDate fup;
	
	@Column(name = "abortos")
	private int abortos;
	
	@Column(name = "cesareas")
	private int cesareas;
}
