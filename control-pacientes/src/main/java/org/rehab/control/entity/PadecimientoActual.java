package org.rehab.control.entity;

import java.time.LocalDate;

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
@Table(name="padecimiento_actual")
@Data
@NoArgsConstructor
public class PadecimientoActual {

	@Id
	@Column(name ="id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="num_expediente")
	private Paciente paciente;
	
	@Column(name="fecha")
	private LocalDate fecha;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="evolucion")
	private String evolucion;
	
	@Column(name="estado_actual")
	private String estadoActual;
}
