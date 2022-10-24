package com.PyMes.usuarios_cliente.services;

import java.util.Optional;

import com.PyMes.usuarios_cliente.models.entity.Rol;

public interface RolService {
	public Iterable<Rol> findAll();
	
	public Optional<Rol> findById(Long id);
	
	public Rol save(Rol rol);
	
	public void deleteById(Long id);
}
