package org.rehab.control.pronostico.controller;


import java.util.List;

import org.rehab.control.exploracionFisica.dto.ExploracionFisicaDto;
import org.rehab.control.exploracionFisica.entity.ExploracionFisicaEntity;
import org.rehab.control.exploracionFisica.service.ExploracionFisicaService;
import org.rehab.control.pronostico.dto.PronosticoDto;
import org.rehab.control.pronostico.entity.PronosticoEntity;
import org.rehab.control.pronostico.service.PronosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pronostico")
public class PronosticoController {

    @Autowired
    PronosticoService exploracionFisicaService;
    @PostMapping
    public PronosticoEntity create(@RequestBody PronosticoDto exploracionFisicaDto){

        return exploracionFisicaService.create(exploracionFisicaDto);
        
    }

    @GetMapping
    public List<PronosticoEntity>  getAll(){
        
        return exploracionFisicaService.getAll();
        
    }
    
}
