package org.rehab.control.exploracionFisica.service;

import java.util.List;

import org.rehab.control.exploracionFisica.dto.ExploracionFisicaDto;
import org.rehab.control.exploracionFisica.entity.ExploracionFisicaEntity;
import org.rehab.control.exploracionFisica.repository.ExploracionFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ExploracionFisicaService {
    @Autowired
    private ExploracionFisicaRepository exploracionFisicaRepository;

    public ExploracionFisicaEntity create(ExploracionFisicaDto exploracionFisicaDto){
        ExploracionFisicaEntity exploracionFisicaEntity = new ExploracionFisicaEntity();
        exploracionFisicaEntity.setFecha(exploracionFisicaDto.getFechaExploracion());
        return exploracionFisicaRepository.save(exploracionFisicaEntity);
        
    }

      
    public List<ExploracionFisicaEntity> getAll(){
        
        return exploracionFisicaRepository.findAll();
        
    }


    
}
