package org.rehab.control.sistemaCH.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.rehab.control.sistemaCH.dto.SistemaCHWithSubsistemasDTO;
import org.rehab.control.sistemaCH.entity.SistemaCH;
import org.rehab.control.sistemaCH.repository.SistemaCHRepository;
import org.rehab.control.subsistemaCH.entity.SubSistemaCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class SistemaCHService {
    @Autowired
    private SistemaCHRepository sistemaCHRepository;
    //@Autowired
   // private SubSistemaCH subSistemaCHRepository;
    /* 
    @Autowired
    private ModelMapper modelMapper;
*/
    public SistemaCH create(SistemaCHWithSubsistemasDTO dto) {
        try {
        SistemaCH sistemaCH = new SistemaCH();
        sistemaCH.setSistemaNombre(dto.getSistemaNombre());

        List<SubSistemaCH> subsistemas = new ArrayList<>();
        for (String subSistemaNombre : dto.getSubSistemas()) {
            SubSistemaCH subSistemaCH = new SubSistemaCH();
            subSistemaCH.setSubSistemaNombre(subSistemaNombre);

            // Establecer la relación con el objeto SistemaCH
            subSistemaCH.setSistemaCH(sistemaCH);
            subsistemas.add(subSistemaCH);
        }
           // Establecer la relación inversa en el objeto SistemaCH
           sistemaCH.setSubsistemas(subsistemas);

           // Guardar los objetos en la base de datos
            return sistemaCHRepository.save(sistemaCH);
        
        } catch (Exception e) {
            log.info(e);
        }
        return null;
    }

    public List<SistemaCH> getAll(){
        return sistemaCHRepository.findAll();
    }
    
}
