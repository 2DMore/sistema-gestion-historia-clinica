package org.rehab.control.pronostico.repository;

import org.rehab.control.exploracionFisica.entity.ExploracionFisicaEntity;
import org.rehab.control.pronostico.entity.PronosticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PronosticoRepository extends JpaRepository<PronosticoEntity,Long> {
    
}
