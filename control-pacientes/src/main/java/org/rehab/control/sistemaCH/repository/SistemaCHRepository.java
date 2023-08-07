package org.rehab.control.sistemaCH.repository;

import java.util.List;

import org.rehab.control.sistemaCH.entity.SistemaCH;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SistemaCHRepository extends JpaRepository<SistemaCH,Long>{
    @Override
    @EntityGraph(attributePaths = "subsistemas")
    List<SistemaCH> findAll();
   
}
