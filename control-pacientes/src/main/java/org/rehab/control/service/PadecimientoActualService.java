package org.rehab.control.service;

import java.util.List;

import org.rehab.control.entity.PadecimientoActual;
import org.rehab.control.repository.PadecimientoActualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PadecimientoActualService {

	@Autowired
	private PadecimientoActualRepository PadecimientoActualRepository;
	
	public PadecimientoActual createPA(PadecimientoActual PA) {
		log.info("Creando PA: "+ PA.toString());
		return PadecimientoActualRepository.save(PA);
	}
	
	public List<PadecimientoActual> getAllPA(){
		return PadecimientoActualRepository.findAll();
	}
	
	public PadecimientoActual updatePA(PadecimientoActual PA) {
		log.info("Actualizando PA: "+ PA.toString());
		return PadecimientoActualRepository.save(PA);
	}
	
	public void deletePA(Long id) {
		PadecimientoActualRepository.deleteById(id);
	}
}
