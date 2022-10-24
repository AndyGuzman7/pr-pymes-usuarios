package com.PyMes.usuarios_cliente.services;

import java.util.Optional;

import com.PyMes.usuarios_cliente.models.entity.Person;

public interface PersonService {

	public Iterable<Person> findAll();
	
	public Optional<Person> findById(Long id);
	
	public Person save(Person person);
	
	public void deleteById(Long id);
}
