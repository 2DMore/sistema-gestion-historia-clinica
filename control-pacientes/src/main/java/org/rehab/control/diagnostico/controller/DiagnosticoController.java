package org.rehab.control.diagnostico.controller;

import java.util.List;

import org.rehab.control.diagnostico.dto.DiagnosticoDto;
import org.rehab.control.diagnostico.entity.DiagnosticoEntitity;

import org.rehab.control.diagnostico.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/diagnostico")
public class DiagnosticoController {
    @Autowired
    DiagnosticoService diagnosticoService;

    @PostMapping
    public void create(@RequestBody DiagnosticoDto diagnosticoDto){
        diagnosticoService.create(diagnosticoDto);
    }

    @GetMapping
    public List<DiagnosticoEntitity> getAll(){
        return diagnosticoService.getAll();
    }
}
