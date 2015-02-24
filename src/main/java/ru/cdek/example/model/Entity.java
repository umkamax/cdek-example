package ru.cdek.example.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Entity {
	private Long id;
	@NotEmpty
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
