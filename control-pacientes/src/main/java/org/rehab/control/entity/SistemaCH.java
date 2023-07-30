package org.rehab.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sistemasCuerpoHumano")
@Data
@NoArgsConstructor
public class SistemaCH {
    @Id
	@Column(name = "idSistema")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idSistema;

    @Column(name = "sistemaNombre")
    private String sistemaNombre;

}
