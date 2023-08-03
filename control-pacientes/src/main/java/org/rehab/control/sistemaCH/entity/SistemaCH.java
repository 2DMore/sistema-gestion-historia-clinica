package org.rehab.control.sistemaCH.entity;

import java.util.List;

import org.rehab.control.diagnostico.entity.DiagnosticoEntitity;
import org.rehab.control.subsistemaCH.entity.SubSistemaCH;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sistemasCuerpoHumano")
@Data
@NoArgsConstructor
public class SistemaCH {
    @Id
    @Column(name = "id_sistema")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idSistema;

    @Column(name = "sistema_nombre")
    private String sistemaNombre;

  
    @OneToMany(mappedBy = "sistemaCH", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SubSistemaCH> subsistemas;

    // Nueva relación bidireccional con OtraEntidad
    @OneToOne(mappedBy = "sistema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DiagnosticoEntitity diagnosticoEntitity;

    // Constructor, getters y setters si es necesario
}