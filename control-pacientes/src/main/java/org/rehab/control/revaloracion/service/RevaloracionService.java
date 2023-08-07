package org.rehab.control.revaloracion.service;
import java.util.List;
import java.util.Optional; // Add this import statement

import org.rehab.control.diagnostico.dto.DiagnosticoDto;
import org.rehab.control.fi.entity.Paciente;
import org.rehab.control.fi.repository.PacienteRepository;
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
    private RevaloracionRepository revaloracionRepository;
    @Autowired
    private SistemaCHRepository sistemaCHRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    public void create(RevaloracionDto revaloracionDto) {
        RevaloracionEntitity revaloracionEntitity = new RevaloracionEntitity();
        Paciente paciente = new Paciente();
        if (revaloracionDto.getId() == null) {
           
            revaloracionDto.setId(1L); 
        }
        
    
        Optional<SistemaCH> sistemaCHOptional = sistemaCHRepository.findById(revaloracionDto.getId());
        if (sistemaCHOptional.isPresent()) {
            SistemaCH sistemaCH = sistemaCHOptional.get();
            revaloracionEntitity.setSistema(sistemaCH);
            revaloracionEntitity.setFechaRevaloracion(revaloracionDto.getFechaRevaloracion());
            revaloracionEntitity.setRevaloracion(revaloracionDto.getRevaloracion());

            //paciente
            paciente = pacienteRepository.findById(revaloracionDto.getIdExpediente()).orElse(null);
            revaloracionEntitity.setPaciente(paciente);
        } else {
       
            throw new RuntimeException("SistemaCH with ID " + revaloracionDto.getId() + " not found!");
        }
        
      
        revaloracionRepository.save(revaloracionEntitity);
    }

      public List<RevaloracionEntitity> getAll(){
        return revaloracionRepository.findAll();
    }
}
