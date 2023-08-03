package org.rehab.control.diagnostico.repository;

import org.rehab.control.diagnostico.entity.DiagnosticoEntitity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoRepository extends JpaRepository<DiagnosticoEntitity,Long>{
    
}
