package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.CategoryBusiness;
import com.proyecto.microservicios.app.usuariocliente.models.repository.CategoryBusinessRepository;

@Service
public class CategoryBusinessServiceImpl implements CategoryBusinessService {

	@Autowired
	private CategoryBusinessRepository repository;	
	@Override
	@Transactional(readOnly = true)
	public Iterable<CategoryBusiness> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<CategoryBusiness> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public CategoryBusiness save(CategoryBusiness categoryBusiness) {
		// TODO Auto-generated method stub
		return repository.save(categoryBusiness);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public List<CategoryBusiness> saveAll(List<CategoryBusiness> entities) {
		repository.saveAll(entities);
		return entities;
	}
}
