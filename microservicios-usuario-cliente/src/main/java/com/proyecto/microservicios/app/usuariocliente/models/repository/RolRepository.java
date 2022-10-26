package com.proyecto.microservicios.app.usuariocliente.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Rol;

public interface RolRepository extends CrudRepository<Rol, Long> {
	
}
