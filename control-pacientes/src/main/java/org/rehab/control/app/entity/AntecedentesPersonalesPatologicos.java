package org.rehab.control.app.entity;

import org.rehab.control.ahf.entity.AntecedentesHeredoFamiliares;

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
@Table(name="antecedentes_personales_patologicos")
@Data
@NoArgsConstructor
public class AntecedentesPersonalesPatologicos {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="app_num_expediente", referencedColumnName="num_expediente"),
		@JoinColumn(name="app_alergias", referencedColumnName="alergias")
	})
	private AntecedentesHeredoFamiliares ahf;
	
	@Column(name="cirugias")
	private String cirugias;
	
	@Column(name="adicciones")
	private String adicciones;
	
	@Column(name="traumatismos")
	private String traumatismos;
	
	@Column(name="enferedades_transmicion_sexual")
	private String enfermedadesTransmicionSexual;
	
	@Column(name="padecimientos_articulares")
	private String padecimientosArticulares;
}
