package com.PyMes.usuarios_cliente.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PyMes.usuarios_cliente.models.entity.Business;
import com.PyMes.usuarios_cliente.models.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessRepository repository;	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Business> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Business> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public Business save(Business business) {
		// TODO Auto-generated method stub
		return repository.save(business);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
