package org.rehab.control.controller;

import org.rehab.control.entity.AntecedentesHeredoFamiliares;
import org.rehab.control.service.AntecedentesHeredoFamiliaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/AHF")
public class AntecedentesHeredoFamiliaresController {

	@Autowired
	private AntecedentesHeredoFamiliaresService AntecedentesHeredoFamiliaresService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllAHF(){
		try {
			return ResponseEntity.ok().body(AntecedentesHeredoFamiliaresService.getAllAHF());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public AntecedentesHeredoFamiliares createAHF(@RequestBody AntecedentesHeredoFamiliares AHF) {
		return AntecedentesHeredoFamiliaresService.updateAHF(AHF);
	}
	
	@PutMapping("/")
	@ResponseBody
	public AntecedentesHeredoFamiliares updateAHF(@RequestBody AntecedentesHeredoFamiliares AHF) {
		return AntecedentesHeredoFamiliaresService.updateAHF(AHF);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deletePaciente(@PathVariable (value = "id") Long id) {
		AntecedentesHeredoFamiliaresService.deleteAHF(id);
	}
}
