package com.PyMes.usuarios_cliente.services;

import java.util.Optional;

import com.PyMes.usuarios_cliente.models.entity.Business;

public interface BusinessService {
	public Iterable<Business> findAll();
	
	public Optional<Business> findById(Long id);
	
	public Business save(Business business);
	
	public void deleteById(Long id);
}
