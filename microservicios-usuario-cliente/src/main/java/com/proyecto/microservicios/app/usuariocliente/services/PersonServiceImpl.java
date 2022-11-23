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

	@Override
	public Optional<Person> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

	@Override
	public Optional<Person> getByTokenPassword(String tokenPassword) {
		// TODO Auto-generated method stub
		return repository.findByTokenPassword(tokenPassword);
	}	

	@Override
	@Transactional
	public Optional<Person> login(String email, String pass) {
		return repository.login(email, pass);
	}
}
