package org.rehab.control.sistemaCH.controller;

import java.util.List;

//import org.rehab.control.service.SistemaCHService;
import org.rehab.control.entity.Paciente;
import org.rehab.control.service.PacienteService;
import org.rehab.control.sistemaCH.dto.SistemaCHWithSubsistemasDTO;
import org.rehab.control.sistemaCH.entity.SistemaCH;
import org.rehab.control.sistemaCH.service.SistemaCHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sistema")
public class SistemasCHController {
    @Autowired
    private SistemaCHService sistemaCHService;
    
    
    @PostMapping
    public SistemaCH create(@RequestBody SistemaCHWithSubsistemasDTO sistemaCH) {
 
        return this.sistemaCHService.create(sistemaCH);

    }

    @GetMapping 
    public List<SistemaCH> getAll(){
        return this.sistemaCHService.getAll();

    }

     
}
