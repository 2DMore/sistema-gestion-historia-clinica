package org.rehab.control.service;

import java.util.List;

import org.rehab.control.entity.AntecedentesPersonalesPatologicos;
import org.rehab.control.repository.AntecedentesPersonalesPatologicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AntecedentesPersonalesPatologicosService {
	@Autowired
	private AntecedentesPersonalesPatologicosRepository AntecedentesPersonalesPatologicosRepository;
	
	public AntecedentesPersonalesPatologicos createAPP(AntecedentesPersonalesPatologicos APP) {
		log.info("Creando APP: "+ APP.toString());
		return AntecedentesPersonalesPatologicosRepository.save(APP);
	}
	
	public List<AntecedentesPersonalesPatologicos> getAllAPP(){
		return AntecedentesPersonalesPatologicosRepository.findAll();
	}
	
	public AntecedentesPersonalesPatologicos updateAPP(AntecedentesPersonalesPatologicos APP) {
		log.info("Actualizando APP: "+ APP.toString());
		return AntecedentesPersonalesPatologicosRepository.save(APP);
	}
	
	public void deleteAPP(Long id) {
		AntecedentesPersonalesPatologicosRepository.deleteById(id);
	}
}
