package com.PyMes.usuarios_cliente.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.PyMes.usuarios_cliente.models.entity.Rol;

public interface RolRepository extends CrudRepository<Rol, Long> {
	
}
