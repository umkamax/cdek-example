package ru.cdek.example.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import ru.cdek.example.model.Entity;

public interface EntityService {

	Collection<Entity> findEntities() throws DataAccessException;
	
	void saveEntity(Entity entity) throws DataAccessException;
	
}
