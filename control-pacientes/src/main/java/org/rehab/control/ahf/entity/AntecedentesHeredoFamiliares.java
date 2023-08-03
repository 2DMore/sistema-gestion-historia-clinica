package org.rehab.control.ahf.entity;

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
@Table(name="antecedentes_heredo_familiares")
@Data
@NoArgsConstructor
public class AntecedentesHeredoFamiliares {

	@Id
	@Column(name ="id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="num_expediente")
	private Paciente paciente;
	
	@Column(name="cardiopatias")
	private String cardiopatias;
	
	@Column(name="alergias")
	private String alergias;
	
	@Column(name="diabetes")
	private String diabetes;
	
	@Column(name="nefropatias")
	private String nefropatias;
	
	@Column(name="psiquiatricos")
	private String psiquiatricos;
	
	@Column(name="neurologicas")
	private String neurologicas;
	
	@Column(name="otros")
	private String otros;
}
