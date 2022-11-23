package com.proyecto.microservicios.app.usuariocliente.controllers;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Person;
import com.proyecto.microservicios.app.usuariocliente.services.EmailService;
import com.proyecto.microservicios.app.usuariocliente.services.PersonService;

@EnableEurekaClient
@RestController	
public class PersonController {
	
	

	@Autowired
	private PersonService service;

	
	@GetMapping("/person")	
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Person> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> ver(@RequestParam String email, String pass) {
		Optional<Person> o = service.login(email, pass);
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping("/person")
	public ResponseEntity<?> crear(@RequestBody Person person) {
		Person personDb = service.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(personDb);
	}
	
	@PutMapping("/person/{id}")
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
	
	@PutMapping("/recoverPassword/{email}")
	public ResponseEntity<?> recuperarContrasenia(@RequestBody Person person, @PathVariable String email) {
		Optional<Person> o = service.findByEmail(email);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Person personDb = o.get(); 
		personDb.setPassword(person.getPassword());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personDb));
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
