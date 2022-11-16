package com.proyecto.microservicios.app.usuariocliente.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Business;
import com.proyecto.microservicios.app.usuariocliente.services.BusinessService;
@RestController	
public class BusinessController {
	@Autowired
	private BusinessService service;
	
	@PostMapping("/business")
	public ResponseEntity<?> crear(@RequestBody Business business) {
		Business businessDb = service.save(business);
		return ResponseEntity.status(HttpStatus.CREATED).body(businessDb);
	}
	
	@PutMapping("/business/{id}")
	public ResponseEntity<?> editar(@RequestBody Business business, @PathVariable Long id) {
		Optional<Business> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Business businessDb = o.get(); 
		businessDb.setBusiness_name(business.getBusiness_name());
		businessDb.setDirection(business.getDirection());
		businessDb.setNit(business.getNit());
		businessDb.setPhone_number(business.getPhone_number());
		businessDb.setType(business.getType());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(businessDb));
	}
}
