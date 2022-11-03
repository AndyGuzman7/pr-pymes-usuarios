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

import com.proyecto.microservicios.app.usuariocliente.models.entity.CategoryBusiness;
import com.proyecto.microservicios.app.usuariocliente.services.CategoryBusinessService;

@RestController
public class CategoryBusinessController {
	@Autowired
	private CategoryBusinessService service;
	
	@GetMapping	
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<CategoryBusiness> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody CategoryBusiness categoryBusiness) {
		CategoryBusiness categoryBusinessDb = service.save(categoryBusiness);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryBusinessDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody CategoryBusiness categoryBusiness, @PathVariable Long id) {
		Optional<CategoryBusiness> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		CategoryBusiness categoryBusinessDb = o.get(); 
		categoryBusinessDb.setCategory_id(categoryBusiness.getCategory_id());
		categoryBusinessDb.setBusiness_id(categoryBusiness.getBusiness_id());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoryBusinessDb));
	}
}
