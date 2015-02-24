package ru.cdek.example.repository.jdbc;

import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ru.cdek.example.model.Entity;
import ru.cdek.example.repository.EntityRepository;

@Repository
public class JdbcEntityRepositoryImpl implements EntityRepository {

	private static final Logger logger = LoggerFactory.getLogger(JdbcEntityRepositoryImpl.class);
	
	private static final String SQL_ENTITIES = "SELECT id, name FROM entity ORDER BY id";

	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert insertEntity;

	@Autowired
	public JdbcEntityRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertEntity = new SimpleJdbcInsert(dataSource)
			.withTableName("entity")
			.usingGeneratedKeyColumns("id");
	}

	public Collection<Entity> findAll() throws DataAccessException {
		List<Entity> entities = this.jdbcTemplate.query(SQL_ENTITIES,
				BeanPropertyRowMapper.newInstance(Entity.class));
		return entities;
	}

	public void save(Entity entity) throws DataAccessException {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
		Number id = this.insertEntity.executeAndReturnKey(paramSource);
		logger.info(String.format("Added entity with id - %d (name: %s)", id, entity.getName()));
	}

}
