package com.proyecto.microservicios.app.usuariocliente.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Business;

public interface BusinessRepository extends CrudRepository<Business, Long> {
	@Query(value = "SELECT COUNT(*) + 1 FROM business", nativeQuery = true)
	public long getTheNextId();
}
