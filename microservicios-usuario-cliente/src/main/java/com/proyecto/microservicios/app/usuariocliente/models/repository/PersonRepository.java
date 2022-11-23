package com.proyecto.microservicios.app.usuariocliente.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	Optional<Person> findByEmail(String email);
	Optional<Person> findByTokenPassword(String tokenPassword);

	@Query("SELECT p FROM Person p WHERE p.email = :email AND p.password = :pass")
	public Optional<Person> login(@Param("email") String email, @Param("pass") String pass);
}
