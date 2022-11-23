package com.proyecto.microservicios.app.usuariocliente.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Rol;
import com.proyecto.microservicios.app.usuariocliente.services.RolService;

@EnableEurekaClient
@RestController	
public class RolController {
	@Autowired
	private RolService service;
	
	@PostMapping("/rol")
	public ResponseEntity<?> crear(@RequestBody Rol rol) {
		Rol rolDb = service.save(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(rolDb);
	}
	
	@GetMapping("/rol/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Rol> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PutMapping("/rol/{id}")
	public ResponseEntity<?> editar(@RequestBody Rol rol, @PathVariable Long id) {
		Optional<Rol> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Rol rolDb = o.get(); 
		rolDb.setRol_name(rol.getRol_name());
		rolDb.setBusiness_id(rol.getBusiness_id());		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rolDb));
	}
}
