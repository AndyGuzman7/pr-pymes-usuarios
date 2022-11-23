package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.Optional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Person;

public interface PersonService {

	public Iterable<Person> findAll();
	
	public Optional<Person> findById(Long id);
	
	public Person save(Person person);
	
	public void deleteById(Long id);

	public Optional<Person> findByEmail(String email);

	public Optional<Person> getByTokenPassword(String tokenPassword);
	
	public Optional<Person> login(String email, String pass);
}
