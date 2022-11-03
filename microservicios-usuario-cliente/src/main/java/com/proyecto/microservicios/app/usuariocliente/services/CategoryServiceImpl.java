package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Category;
import com.proyecto.microservicios.app.usuariocliente.models.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Category> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return repository.save(category);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
