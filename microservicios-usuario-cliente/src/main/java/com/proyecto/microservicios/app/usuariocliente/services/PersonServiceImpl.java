package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Person;
import com.proyecto.microservicios.app.usuariocliente.models.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;
	@Override
	@Transactional(readOnly = true)
	public Iterable<Person> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Person> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return repository.save(person);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}	

}
