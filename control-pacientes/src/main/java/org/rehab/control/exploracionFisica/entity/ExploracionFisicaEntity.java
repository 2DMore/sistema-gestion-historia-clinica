package org.rehab.control.exploracionFisica.entity;

import java.util.Date;

import org.rehab.control.fi.entity.Paciente;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exploracionFisica")
@Data
@NoArgsConstructor
public class ExploracionFisicaEntity {
    @Id
    @Column(name = "id_exploracion_fisica")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idExploracionFisica;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha")
    private Date fecha;

     @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="num_expediente")
    private Paciente paciente;

    
    
}
