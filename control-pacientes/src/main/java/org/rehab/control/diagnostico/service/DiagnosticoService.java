package org.rehab.control.diagnostico.service;
import java.util.List;
import java.util.Optional; // Add this import statement

import org.rehab.control.diagnostico.dto.DiagnosticoDto;
import org.rehab.control.diagnostico.entity.DiagnosticoEntitity;

import org.rehab.control.diagnostico.repository.DiagnosticoRepository;

import org.rehab.control.revaloracion.dto.RevaloracionDto;
import org.rehab.control.sistemaCH.entity.SistemaCH;
import org.rehab.control.sistemaCH.repository.SistemaCHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticoService {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;
    @Autowired
    private SistemaCHRepository sistemaCHRepository;
    
    public void create(DiagnosticoDto diagnosticoDto) {
        DiagnosticoEntitity diagnosticoEntity = new DiagnosticoEntitity();
        
        if (diagnosticoDto.getId() == null) {
           
            diagnosticoDto.setId(1L); 
        }
        
    
        Optional<SistemaCH> sistemaCHOptional = sistemaCHRepository.findById(diagnosticoDto.getId());
        if (sistemaCHOptional.isPresent()) {
            SistemaCH sistemaCH = sistemaCHOptional.get();
            diagnosticoEntity.setSistema(sistemaCH);
            diagnosticoEntity.setFechaDiagnostico(diagnosticoDto.getFechaDiagnostico());
            diagnosticoEntity.setDiagnostico(diagnosticoDto.getDiagnostico());
         
        } else {
       
            throw new RuntimeException("SistemaCH with ID " + diagnosticoDto.getId() + " not found!");
        }
        
      
        diagnosticoRepository.save(diagnosticoEntity);
    }

      public List<DiagnosticoEntitity> getAll(){
        return diagnosticoRepository.findAll();
    }
}
