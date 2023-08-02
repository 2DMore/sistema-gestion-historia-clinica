package org.rehab.control.controller;

import org.rehab.control.entity.AntecedentesGinecoObstetricos;
import org.rehab.control.service.AntecedentesGinecoObstetricosService;
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
@RequestMapping(value="/AGO")
public class AntecedentesGinecoObstetricosController {

	@Autowired
	private AntecedentesGinecoObstetricosService AntecedentesGinecoObstetricosService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllAGO(){
		try {
			return ResponseEntity.ok().body(AntecedentesGinecoObstetricosService.getAllAGO());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public AntecedentesGinecoObstetricos createAGO(@RequestBody AntecedentesGinecoObstetricos AGO) {
		return AntecedentesGinecoObstetricosService.updateAGO(AGO);
	}
	
	@PutMapping("/")
	@ResponseBody
	public AntecedentesGinecoObstetricos updateAGO(@RequestBody AntecedentesGinecoObstetricos AGO) {
		return AntecedentesGinecoObstetricosService.updateAGO(AGO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteAGO(@PathVariable (value = "id") Long id) {
		AntecedentesGinecoObstetricosService.deleteAGO(id);
	}
}
