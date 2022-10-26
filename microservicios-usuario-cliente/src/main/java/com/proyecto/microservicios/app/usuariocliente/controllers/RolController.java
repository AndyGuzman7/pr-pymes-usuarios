package com.proyecto.microservicios.app.usuariocliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Rol;
import com.proyecto.microservicios.app.usuariocliente.services.RolService;
@RestController	
public class RolController {
	@Autowired
	private RolService service;
	
	@PostMapping("/rol")
	public ResponseEntity<?> crear(@RequestBody Rol rol) {
		Rol rolDb = service.save(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(rolDb);
	}
}
