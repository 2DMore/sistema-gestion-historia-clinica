package org.rehab.control.ago.service;

import java.util.List;

import org.rehab.control.ago.entity.AntecedentesGinecoObstetricos;
import org.rehab.control.ago.repository.AntecedentesGinecoObstetricosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AntecedentesGinecoObstetricosService {

	@Autowired
	private AntecedentesGinecoObstetricosRepository AntecedentesGinecoObstetricosRepository;
	
	public AntecedentesGinecoObstetricos createAGO(AntecedentesGinecoObstetricos AGO) {
		log.info("Creando AGO: "+ AGO.toString());
		return AntecedentesGinecoObstetricosRepository.save(AGO);
	}
	
	public List<AntecedentesGinecoObstetricos> getAllAGO(){
		return AntecedentesGinecoObstetricosRepository.findAll();
	}
	
	public AntecedentesGinecoObstetricos updateAGO(AntecedentesGinecoObstetricos AGO) {
		log.info("Actualizando APNP: "+ AGO.toString());
		return AntecedentesGinecoObstetricosRepository.save(AGO);
	}
	
	public void deleteAGO(Long id) {
		AntecedentesGinecoObstetricosRepository.deleteById(id);
	}
}
