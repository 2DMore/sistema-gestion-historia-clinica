package org.rehab.control.diagnostico.entity;

import java.util.Date;
import java.util.Optional;

import org.rehab.control.fi.entity.Paciente;
import org.rehab.control.sistemaCH.entity.SistemaCH;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

   @JsonManagedReference
    @ManyToOne
    private SistemaCH sistema;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="num_expediente")
    private Paciente paciente;
    
}
