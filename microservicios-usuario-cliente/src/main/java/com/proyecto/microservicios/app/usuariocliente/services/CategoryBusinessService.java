package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.CategoryBusiness;

public interface CategoryBusinessService {
	public Iterable<CategoryBusiness> findAll();
	
	public Optional<CategoryBusiness> findById(Long id);
	
	public CategoryBusiness save(CategoryBusiness categoryBusiness);
	
	public void deleteById(Long id);
	
	public List<CategoryBusiness> saveAll(List<CategoryBusiness> categoryBusiness);
}
