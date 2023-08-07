package org.rehab.control.revaloracion.repository;

import java.util.List;

import org.rehab.control.revaloracion.entity.RevaloracionEntitity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RevaloracionRepository extends JpaRepository<RevaloracionEntitity,Long>{
     @Query("SELECT d FROM DiagnosticoEntitity d JOIN FETCH d.sistema")
    List<RevaloracionEntitity> findAllWithSistema();
}
