package org.rehab.control.service;

import java.util.List;

import org.rehab.control.entity.AntecedentesHeredoFamiliares;
import org.rehab.control.repository.AntecedentesHeredoFamiliaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AntecedentesHeredoFamiliaresService {
	@Autowired
	private AntecedentesHeredoFamiliaresRepository AntecedentesHeredoFamiliaresRepository;
	
	public AntecedentesHeredoFamiliares createAHF(AntecedentesHeredoFamiliares AHF) {
		log.info("Creando AHF: "+ AHF.toString());
		return AntecedentesHeredoFamiliaresRepository.save(AHF);
	}
	
	public List<AntecedentesHeredoFamiliares> getAllAHF(){
		return AntecedentesHeredoFamiliaresRepository.findAll();
	}
	
	public AntecedentesHeredoFamiliares updateAHF(AntecedentesHeredoFamiliares AHF) {
		log.info("Actualizando AHF: "+ AHF.toString());
		return AntecedentesHeredoFamiliaresRepository.save(AHF);
	}
	
	public void deleteAHF(Long id) {
		AntecedentesHeredoFamiliaresRepository.deleteById(id);
	}
}
