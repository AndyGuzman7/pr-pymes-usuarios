package com.proyecto.microservicios.app.usuariocliente.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Business;

public interface BusinessRepository extends CrudRepository<Business, Long> {

}
