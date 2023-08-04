package org.rehab.control.revaloracion.service;
import java.util.List;
import java.util.Optional; // Add this import statement

import org.rehab.control.diagnostico.dto.DiagnosticoDto;
import org.rehab.control.revaloracion.dto.RevaloracionDto;
import org.rehab.control.revaloracion.entity.RevaloracionEntitity;
import org.rehab.control.revaloracion.repository.RevaloracionRepository;
import org.rehab.control.sistemaCH.entity.SistemaCH;
import org.rehab.control.sistemaCH.repository.SistemaCHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevaloracionService {
    @Autowired
    private RevaloracionRepository diagnosticoRepository;
    @Autowired
    private SistemaCHRepository sistemaCHRepository;
    
    public void create(RevaloracionDto revaloracionDto) {
        RevaloracionEntitity diagnosticoEntity = new RevaloracionEntitity();
        
        if (revaloracionDto.getId() == null) {
           
            revaloracionDto.setId(1L); 
        }
        
    
        Optional<SistemaCH> sistemaCHOptional = sistemaCHRepository.findById(revaloracionDto.getId());
        if (sistemaCHOptional.isPresent()) {
            SistemaCH sistemaCH = sistemaCHOptional.get();
            diagnosticoEntity.setSistema(sistemaCH);
            diagnosticoEntity.setFechaDiagnostico(revaloracionDto.getFechaRevaloracion());
            diagnosticoEntity.setDiagnostico(revaloracionDto.getRevaloracion());
         
        } else {
       
            throw new RuntimeException("SistemaCH with ID " + revaloracionDto.getId() + " not found!");
        }
        
      
        diagnosticoRepository.save(diagnosticoEntity);
    }

      public List<RevaloracionEntitity> getAll(){
        return diagnosticoRepository.findAll();
    }
}
