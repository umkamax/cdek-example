package ru.cdek.example.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import ru.cdek.example.model.Entity;

public interface EntityRepository {
	
	Collection<Entity> findAll() throws DataAccessException;
	
	void save(Entity entity) throws DataAccessException;
}
