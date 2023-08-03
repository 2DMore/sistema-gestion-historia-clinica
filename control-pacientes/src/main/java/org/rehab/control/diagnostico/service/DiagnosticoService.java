package org.rehab.control.diagnostico.service;
import java.util.List;
import java.util.Optional; // Add this import statement

import org.rehab.control.diagnostico.dto.DiagnosticoDto;
import org.rehab.control.diagnostico.entity.DiagnosticoEntitity;
import org.rehab.control.diagnostico.repository.DiagnosticoRepository;
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
            // You might want to handle this differently based on your requirements.
            // For now, let's assume if the ID is not provided, we set it to 1.
            diagnosticoDto.setId(1L); 
        }
        
        // Assuming the repository method returns an Optional<SistemaCH> object.
        Optional<SistemaCH> sistemaCHOptional = sistemaCHRepository.findById(diagnosticoDto.getId());
        if (sistemaCHOptional.isPresent()) {
            SistemaCH sistemaCH = sistemaCHOptional.get();
            diagnosticoEntity.setSistema(sistemaCH);
            diagnosticoEntity.setFechaDiagnostico(diagnosticoDto.getFechaDiagnostico());
            diagnosticoEntity.setDiagnostico(diagnosticoDto.getDiagnostico());
         
        } else {
            // Handle the case when the SistemaCH with the provided ID is not found.
            // For now, we can throw an exception.
            throw new RuntimeException("SistemaCH with ID " + diagnosticoDto.getId() + " not found!");
        }
        
        // You can perform additional operations with the diagnosticoEntity if needed.
        
        // Save the DiagnosticoEntity to the database.
        diagnosticoRepository.save(diagnosticoEntity);
    }

      public List<DiagnosticoEntitity> getAll(){
        return diagnosticoRepository.findAll();
    }
}
