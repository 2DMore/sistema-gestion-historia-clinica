package org.rehab.control.exploracionFisica.controller;


import java.util.List;

import org.rehab.control.exploracionFisica.dto.ExploracionFisicaDto;
import org.rehab.control.exploracionFisica.entity.ExploracionFisicaEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/exploracionFisica")
public class ExploracionFisicaController {
    @PostMapping
    public ExploracionFisicaEntity  create(@RequestBody ExploracionFisicaDto exploracionFisicaDto){

        return null;
        
    }

    @GetMapping
    public List<ExploracionFisicaEntity>  getAll(){
        
        return null;
        
    }
    
}
