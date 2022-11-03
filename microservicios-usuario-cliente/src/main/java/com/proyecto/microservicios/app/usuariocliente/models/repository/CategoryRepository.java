package com.proyecto.microservicios.app.usuariocliente.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.microservicios.app.usuariocliente.models.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
