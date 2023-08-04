package org.rehab.control.ap.controller;

import org.rehab.control.ap.entity.AntecedentesPerinatales;
import org.rehab.control.ap.service.AntecedentesPerinatalesService;
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
@RequestMapping(value="/AP")
public class AntecedentesPerinatalesController {

	@Autowired
	private AntecedentesPerinatalesService AntecedentesPerinatalesService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllAP(){
		try {
			return ResponseEntity.ok().body(AntecedentesPerinatalesService.getAllAP());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public AntecedentesPerinatales createAP(@RequestBody AntecedentesPerinatales AP) {
		return AntecedentesPerinatalesService.updateAP(AP);
	}
	
	@PutMapping("/")
	@ResponseBody
	public AntecedentesPerinatales updateAP(@RequestBody AntecedentesPerinatales AP) {
		return AntecedentesPerinatalesService.updateAP(AP);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteAP(@PathVariable (value = "id") Long id) {
		AntecedentesPerinatalesService.deleteAP(id);
	}
}
