package org.rehab.control.revaloracion.entity;

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
@Table(name = "revaloracion")
@Data
@NoArgsConstructor
public class RevaloracionEntitity {
    @Id
    @Column(name = "id_revaloracion")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idRevolacion;

    @Column(name = "revaloracion")
    private String revaloracion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_diagnostico")
    private Date fechaRevaloracion;

   @JsonManagedReference
    @ManyToOne
    private SistemaCH sistema;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="num_expediente")
    private Paciente paciente;
    
}
