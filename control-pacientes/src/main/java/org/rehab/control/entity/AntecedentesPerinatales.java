package org.rehab.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="antecedentes_perinatales")
@Data
@NoArgsConstructor
public class AntecedentesPerinatales {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="ap_num_expediente", referencedColumnName="num_expediente"),
		@JoinColumn(name="ap_nacimiento", referencedColumnName="fecha_nacimiento")
	})
	private Paciente paciente;
	
	@Column(name="sdg")
	private int sdg;
	
	@Column(name="apgar")
	private int apgar;
	
	@Column(name="peso")
	private float peso;
	
	@Column(name="talla")
	private int talla;
	
	@Column(name="num_embarazo")
	private int numEmbarazo;
	
	@Column(name="problema_parto")
	private String problemaParto;
}
