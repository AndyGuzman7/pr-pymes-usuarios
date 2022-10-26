package com.proyecto.microservicios.app.usuariocliente.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=20, nullable = false)
	private String rol_name;
	
	@Column(nullable = true)
	private Long business_id;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol_name() {
		return rol_name;
	}

	public void setRol_name(String rol_name) {
		this.rol_name = rol_name;
	}

	public Long getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(Long business_id) {
		this.business_id = business_id;
	}
	
	
	
}
