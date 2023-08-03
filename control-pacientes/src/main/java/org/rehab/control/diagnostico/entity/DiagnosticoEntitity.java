package org.rehab.control.diagnostico.entity;

import java.util.Date;

import org.rehab.control.sistemaCH.entity.SistemaCH;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diagnostico")
@Data
@NoArgsConstructor
public class DiagnosticoEntitity {
    @Id
    @Column(name = "id_diagnostico")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idDiagnostico;

    @Column(name = "diagnostico")
    private String diagnostico;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_diagnostico")
    private Date fechaDiagnostico;

    @ManyToOne
    private SistemaCH sistema;
    
}
