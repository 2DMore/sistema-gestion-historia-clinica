package org.rehab.control.apnp.entity;

import org.rehab.control.fi.entity.Paciente;

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
@Table(name="antecedentes_personales_no_patologicos")
@Data
@NoArgsConstructor
public class AntecedentesPersonalesNoPatologicos {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="apnp_num_expediente", referencedColumnName="num_expediente"),
		@JoinColumn(name="apnp_estado_civil", referencedColumnName="estado_civil")
	})
	private Paciente paciente;
	
	@Column(name="habitos_personales")
	private String habitosPersonales;
	
	@Column(name="bano")
	private String bano;
	
	@Column(name="habitacion")
	private String habitacion;
	
	@Column(name="tabaquismo")
	private String tabaquismo;
	
	@Column(name="alcoholismo")
	private String alcoholismo;
	
	@Column(name="vacunas")
	private String vacunas;
	
	@Column(name="actividad_fisica")
	private String actividadFisica;
	
	@Column(name="alimentacion")
	private String alimentacion;
	
	@Column(name="zoonosis")
	private String zoonosis;
	
}
