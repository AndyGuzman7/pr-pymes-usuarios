package com.proyecto.microservicios.app.usuariocliente.services;

import java.util.Optional;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Rol;

public interface RolService {
	public Iterable<Rol> findAll();
	
	public Optional<Rol> findById(Long id);
	
	public Rol save(Rol rol);
	
	public void deleteById(Long id);
}
