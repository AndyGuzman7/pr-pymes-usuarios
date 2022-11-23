package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.Optional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Business;

public interface BusinessService {
	
	public Iterable<Business> findAll();
	
	public Optional<Business> findById(Long id);
	
	public Business save(Business business);
	
	public void deleteById(Long id);
	
	long getTheNextId();
}
