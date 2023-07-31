package org.rehab.control.service;

import java.util.List;

import org.rehab.control.entity.AntecedentesPersonalesNoPatologicos;
import org.rehab.control.repository.AntecedentesPersonalesNoPatologicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AntecedentesPersonalesNoPatologicosService {
	@Autowired
	private AntecedentesPersonalesNoPatologicosRepository AntecedentesPersonalesNoPatologicosRepository;
	
	public AntecedentesPersonalesNoPatologicos createAHF(AntecedentesPersonalesNoPatologicos APNP) {
		log.info("Creando APNP: "+ APNP.toString());
		return AntecedentesPersonalesNoPatologicosRepository.save(APNP);
	}
	
	public List<AntecedentesPersonalesNoPatologicos> getAllAPNP(){
		return AntecedentesPersonalesNoPatologicosRepository.findAll();
	}
	
	public AntecedentesPersonalesNoPatologicos updateAHF(AntecedentesPersonalesNoPatologicos APNP) {
		log.info("Actualizando APNP: "+ APNP.toString());
		return AntecedentesPersonalesNoPatologicosRepository.save(APNP);
	}
	
	public void deleteAPNP(Long id) {
		AntecedentesPersonalesNoPatologicosRepository.deleteById(id);
	}
}
