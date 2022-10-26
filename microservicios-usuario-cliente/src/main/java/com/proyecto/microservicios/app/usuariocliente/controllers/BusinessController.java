package com.proyecto.microservicios.app.usuariocliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
