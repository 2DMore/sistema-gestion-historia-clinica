package org.rehab.control.exploracionFisica.service;
import java.util.List;
import org.rehab.control.exploracionFisica.dto.ExploracionFisicaDto;
import org.rehab.control.exploracionFisica.entity.ExploracionFisicaEntity;
import org.rehab.control.exploracionFisica.repository.ExploracionFisicaRepository;
import org.rehab.control.fi.entity.Paciente;
import org.rehab.control.fi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExploracionFisicaService {
    @Autowired
    private ExploracionFisicaRepository exploracionFisicaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public ExploracionFisicaEntity create(ExploracionFisicaDto exploracionFisicaDto){
        ExploracionFisicaEntity exploracionFisicaEntity = new ExploracionFisicaEntity();
        Paciente paciente = new Paciente();
        paciente = pacienteRepository.findById(exploracionFisicaDto.getId()).orElse(null);
        exploracionFisicaEntity.setDescripcion(exploracionFisicaDto.getExploracionFisica());
        exploracionFisicaEntity.setFecha(exploracionFisicaDto.getFechaExploracion());
        exploracionFisicaEntity.setPaciente(paciente);
        return exploracionFisicaRepository.save(exploracionFisicaEntity);
        
    }

      
    public List<ExploracionFisicaEntity> getAll(){
        
        return exploracionFisicaRepository.findAll();
        
    }


    
}
