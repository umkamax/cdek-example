package ru.cdek.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.cdek.example.model.Entity;
import ru.cdek.example.repository.EntityRepository;

@Service("entityService")
public class EntityServiceImpl implements EntityService {

	@Autowired
	private EntityRepository entityRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Entity> findEntities() throws DataAccessException {
		return entityRepository.findAll();
	}

	@Override
	@Transactional
	public void saveEntity(Entity entity) throws DataAccessException {
		entityRepository.save(entity);
	}

}
