package com.proyecto.microservicios.app.usuariocliente.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoryBusiness")
public class CategoryBusiness {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)	
	private Long category_id;
	private Long business_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public Long getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(Long business_id) {
		this.business_id = business_id;
	}
	
	
}
