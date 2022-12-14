package com.PyMes.usuarios_cliente.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PyMes.usuarios_cliente.models.entity.Person;
import com.PyMes.usuarios_cliente.services.PersonService;

@RestController	
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping	
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Person> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Person person) {
		Person personDb = service.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(personDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Person person, @PathVariable Long id) {
		Optional<Person> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Person personDb = o.get(); 
		personDb.setName(person.getName());
		personDb.setLast_name(person.getLast_name());
		personDb.setEmail(person.getEmail());
		personDb.setPassword(person.getPassword());
		personDb.setRol_id(person.getRol_id());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
