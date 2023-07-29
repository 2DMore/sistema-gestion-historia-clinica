package org.rehab.control.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
public class Paciente {
	@Id
	@Column(name = "num_expediente")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long numExpediente;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private Long telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "estado_civil")
	private String estadoCivil;
	
	@Column(name = "escolaridad")
	private String escolaridad;
	
	@Column(name = "ocupacion")
	private String ocupacion;
}
