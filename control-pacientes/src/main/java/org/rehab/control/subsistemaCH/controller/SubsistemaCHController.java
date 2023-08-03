package org.rehab.control.subsistemaCH.controller;

import java.util.List;

import org.rehab.control.subsistemaCH.entity.SubSistemaCH;
import org.rehab.control.subsistemaCH.service.SubSistemaCHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/subsistema")
public class SubsistemaCHController {
    


    @Autowired
    private SubSistemaCHService subSistemaCHService;
    
    
    @PostMapping
    public SubSistemaCH create(@RequestBody SubSistemaCH subSistemaCH) {
     
        return this.subSistemaCHService.create(subSistemaCH);

    }

    @GetMapping 
    public List<SubSistemaCH> getAll(){
        return this.subSistemaCHService.getAll();

    }
}
