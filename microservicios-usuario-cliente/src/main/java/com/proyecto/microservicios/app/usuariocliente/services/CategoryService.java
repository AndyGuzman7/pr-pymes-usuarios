package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.Optional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Category;

public interface CategoryService {
	public Iterable<Category> findAll();
	
	public Optional<Category> findById(Long id);
	
	public Category save(Category category);
	
	public void deleteById(Long id);
}
