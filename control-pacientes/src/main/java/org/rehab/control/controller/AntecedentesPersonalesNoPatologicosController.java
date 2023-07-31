package org.rehab.control.controller;


import org.rehab.control.entity.AntecedentesPersonalesNoPatologicos;
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
@RequestMapping(value="/APNP")
public class AntecedentesPersonalesNoPatologicosController {

	@Autowired
	private org.rehab.control.service.AntecedentesPersonalesNoPatologicosService AntecedentesPersonalesNoPatologicosService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllAPNP(){
		try {
			return ResponseEntity.ok().body(AntecedentesPersonalesNoPatologicosService.getAllAPNP());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public AntecedentesPersonalesNoPatologicos createAPNP(@RequestBody AntecedentesPersonalesNoPatologicos APNP) {
		return AntecedentesPersonalesNoPatologicosService.updateAHF(APNP);
	}
	
	@PutMapping("/")
	@ResponseBody
	public AntecedentesPersonalesNoPatologicos updateAPNP(@RequestBody AntecedentesPersonalesNoPatologicos APNP) {
		return AntecedentesPersonalesNoPatologicosService.updateAHF(APNP);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteAPNP(@PathVariable (value = "id") Long id) {
		AntecedentesPersonalesNoPatologicosService.deleteAPNP(id);
	}
}
