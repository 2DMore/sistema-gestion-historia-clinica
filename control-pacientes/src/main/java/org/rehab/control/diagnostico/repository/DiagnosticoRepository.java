package org.rehab.control.diagnostico.repository;

import java.util.List;

import org.rehab.control.diagnostico.entity.DiagnosticoEntitity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiagnosticoRepository extends JpaRepository<DiagnosticoEntitity,Long>{
     @Query("SELECT d FROM DiagnosticoEntitity d JOIN FETCH d.sistema")
    List<DiagnosticoEntitity> findAllWithSistema();
}
