package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.Optional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Person;

public interface PersonService {

	public Iterable<Person> findAll();
	
	public Optional<Person> findById(Long id);
	
	public Person save(Person person);
	
	public void deleteById(Long id);
}