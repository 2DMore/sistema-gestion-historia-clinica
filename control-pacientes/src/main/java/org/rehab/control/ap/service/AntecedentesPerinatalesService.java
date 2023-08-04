package org.rehab.control.ap.service;

import java.util.List;

import org.rehab.control.ap.entity.AntecedentesPerinatales;
import org.rehab.control.ap.repository.AntecedentesPerinatalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AntecedentesPerinatalesService {
	
	@Autowired
	private AntecedentesPerinatalesRepository AntecedentesPerinatalesRepository;
	
	public AntecedentesPerinatales createAP(AntecedentesPerinatales AP) {
		log.info("Creando APNP: "+ AP.toString());
		return AntecedentesPerinatalesRepository.save(AP);
	}
	
	public List<AntecedentesPerinatales> getAllAP(){
		return AntecedentesPerinatalesRepository.findAll();
	}
	
	public AntecedentesPerinatales updateAP(AntecedentesPerinatales AP) {
		log.info("Actualizando AP: "+ AP.toString());
		return AntecedentesPerinatalesRepository.save(AP);
	}
	
	public void deleteAP(Long id) {
		AntecedentesPerinatalesRepository.deleteById(id);
	}
}
