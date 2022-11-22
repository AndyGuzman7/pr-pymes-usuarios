package com.proyecto.microservicios.app.usuariocliente.models.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	Optional<Person> findByEmail(String email);
	Optional<Person> findByTokenPassword(String tokenPassword);
}
