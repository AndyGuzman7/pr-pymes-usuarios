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

import com.proyecto.microservicios.app.usuariocliente.models.entity.Category;
import com.proyecto.microservicios.app.usuariocliente.services.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping	
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Category> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Category category) {
		Category categoryDb = service.save(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Category category, @PathVariable Long id) {
		Optional<Category> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Category categoryDb = o.get(); 
		categoryDb.setCategory_name(category.getCategory_name());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoryDb));
	}

}
