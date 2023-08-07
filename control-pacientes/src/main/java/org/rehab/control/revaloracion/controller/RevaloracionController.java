
package org.rehab.control.revaloracion.controller;

import java.util.List;

import org.rehab.control.diagnostico.dto.DiagnosticoDto;
import org.rehab.control.diagnostico.entity.DiagnosticoEntitity;
import org.rehab.control.diagnostico.service.DiagnosticoService;
import org.rehab.control.revaloracion.dto.RevaloracionDto;
import org.rehab.control.revaloracion.entity.RevaloracionEntitity;
import org.rehab.control.revaloracion.service.RevaloracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/revaloracion")
public class RevaloracionController {
    @Autowired
    RevaloracionService revaloracionService;

    @PostMapping
    public void create(@RequestBody RevaloracionDto revaloracionDto){
        revaloracionService.create(revaloracionDto);
    }

    @GetMapping
    public List<RevaloracionEntitity> getAll(){
        return revaloracionService.getAll();
    }
}
