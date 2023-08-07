package org.rehab.control.exploracionFisica.controller;


import java.util.List;

import org.rehab.control.exploracionFisica.dto.ExploracionFisicaDto;
import org.rehab.control.exploracionFisica.entity.ExploracionFisicaEntity;
import org.rehab.control.exploracionFisica.service.ExploracionFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/exploracionFisica")
public class ExploracionFisicaController {
    @Autowired
    ExploracionFisicaService  exploracionFisicaService;
    @PostMapping
    public ExploracionFisicaEntity  create(@RequestBody ExploracionFisicaDto exploracionFisicaDto){

        return exploracionFisicaService.create(exploracionFisicaDto);
        
    }

    @GetMapping
    public List<ExploracionFisicaEntity>  getAll(){
        
        return exploracionFisicaService.getAll();
        
    }
    
}
