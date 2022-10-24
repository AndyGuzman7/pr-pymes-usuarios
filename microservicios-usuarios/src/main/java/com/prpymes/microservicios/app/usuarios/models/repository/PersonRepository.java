package com.PyMes.usuarios_cliente.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.PyMes.usuarios_cliente.models.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
		public Person login();
}
