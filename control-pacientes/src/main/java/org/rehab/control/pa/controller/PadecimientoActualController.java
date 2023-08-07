package org.rehab.control.pa.controller;

import org.rehab.control.pa.entity.PadecimientoActual;
import org.rehab.control.pa.service.PadecimientoActualService;
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
@RequestMapping(value="/PA")
public class PadecimientoActualController {

	@Autowired
	private PadecimientoActualService PadecimientoActualService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getAllAHF(){
		try {
			return ResponseEntity.ok().body(PadecimientoActualService.getAllPA());
		}catch(Exception e) {
			return new ResponseEntity<>("datos no encontrados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	@ResponseBody
	public PadecimientoActual createPA(@RequestBody PadecimientoActual PA) {
		return PadecimientoActualService.updatePA(PA);
	}
	
	@PutMapping("/")
	@ResponseBody
	public PadecimientoActual updatePA(@RequestBody PadecimientoActual PA) {
		return PadecimientoActualService.updatePA(PA);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void deletePA(@PathVariable (value = "id") Long id) {
		PadecimientoActualService.deletePA(id);
	}
}
