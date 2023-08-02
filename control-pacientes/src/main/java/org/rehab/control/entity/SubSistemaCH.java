package org.rehab.control.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sub_sistema_cuerpo_humano")
@Data
@NoArgsConstructor
public class SubSistemaCH {
    @Id
    @Column(name = "id_subsistema")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idSubsistema;

    @Column(name = "subsistema_nombre")
    private String subSistemaNombre;
    
    @JsonIgnore 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sistema_ch")
    private SistemaCH sistemaCH;
}
