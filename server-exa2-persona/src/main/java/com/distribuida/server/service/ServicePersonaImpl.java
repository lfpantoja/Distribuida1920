package com.distribuida.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

//import com.distribuida.server.conf.DbProducer;
import com.distribuida.server.model.Persona;

@ApplicationScoped
//@PersistenceContext(unitName = "distri")
public class ServicePersonaImpl implements ServicePersona{
	
	public static final String SELECT_PERSONA = "SELECT * FROM persona ORDER BY id;";
	public static final String SELECT_PERSONA_ID = "SELECT * FROM persona WHERE id = ?";
	//public static final String INSERT_ALBUM = "INSERT INTO album (id, singer_id, title, release_date) VALUES(?,?,?,?);";
	//public static final String DELETE_ALBUM = "DELETE FROM album WHERE id=?;";
	//public static final String UPDATE_ALBUM = "UPDATE album SET id = ?, singer_id = ?, title = ?, release_date = ? WHERE id = ?;";
	
	@PersistenceContext(unitName = "distri")
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Persona> listPersonas() {
		TypedQuery<Persona> query = entityManager.createQuery(SELECT_PERSONA, Persona.class);
		return query.getResultList();
	}

	@Override
	public Persona getPersona(Integer id) {
		Persona album = new Persona();
		try {
			TypedQuery<Persona> query = entityManager.createQuery(SELECT_PERSONA_ID, Persona.class);		
			query.setParameter(1, id);
			
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
