package org.rehab.control.pronostico.service;
import java.util.List;
import org.rehab.control.exploracionFisica.dto.ExploracionFisicaDto;
import org.rehab.control.exploracionFisica.entity.ExploracionFisicaEntity;
import org.rehab.control.exploracionFisica.repository.ExploracionFisicaRepository;
import org.rehab.control.fi.entity.Paciente;
import org.rehab.control.fi.repository.PacienteRepository;
import org.rehab.control.pronostico.dto.PronosticoDto;
import org.rehab.control.pronostico.entity.PronosticoEntity;
import org.rehab.control.pronostico.repository.PronosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PronosticoService {
    @Autowired
    private PronosticoRepository exploracionFisicaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public PronosticoEntity create(PronosticoDto exploracionFisicaDto){
        PronosticoEntity exploracionFisicaEntity = new PronosticoEntity();
        Paciente paciente = new Paciente();
        paciente = pacienteRepository.findById(exploracionFisicaDto.getId()).orElse(null);
        exploracionFisicaEntity.setDescripcion(exploracionFisicaDto.getPronostico());
        exploracionFisicaEntity.setFecha(exploracionFisicaDto.getFechaPronostico());
        exploracionFisicaEntity.setPaciente(paciente);
        return exploracionFisicaRepository.save(exploracionFisicaEntity);
        
    }

      
    public List<PronosticoEntity> getAll(){
        
        return exploracionFisicaRepository.findAll();
        
    }


    
}
