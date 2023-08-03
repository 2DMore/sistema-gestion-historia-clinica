package org.rehab.control.app.controller;

import org.rehab.control.app.entity.AntecedentesPersonalesPatologicos;
import org.rehab.control.app.service.AntecedentesPersonalesPatologicosService;
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
@RequestMapping(value="/APP")
public class AntecedentesPersonalesPatologicoController {

	@Autowired
	private AntecedentesPersonalesPatologicosService AntecedentesPersonalesPatologicosService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllAPP(){
		try {
			return ResponseEntity.ok().body(AntecedentesPersonalesPatologicosService.getAllAPP());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public AntecedentesPersonalesPatologicos createAPP(@RequestBody AntecedentesPersonalesPatologicos APP) {
		return AntecedentesPersonalesPatologicosService.createAPP(APP);
	}
	
	@PutMapping("/")
	@ResponseBody
	public AntecedentesPersonalesPatologicos updateAPP(@RequestBody AntecedentesPersonalesPatologicos APP) {
		return AntecedentesPersonalesPatologicosService.updateAPP(APP);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteAPP(@PathVariable (value = "id") Long id) {
		AntecedentesPersonalesPatologicosService.deleteAPP(id);
	}
}
