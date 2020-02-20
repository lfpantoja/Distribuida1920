package com.distribuida.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.distribuida.server.model.Direccion;

@ApplicationScoped
//@PersistenceContext(unitName = "distri")
public class ServiceDireccionImpl implements ServiceDireccion{
	
	public static final String SELECT_DIRECCION = "SELECT * FROM tipo_direccion ORDER BY id;";
	public static final String SELECT_DIRECCION_ID = "SELECT * FROM tipo_direccion WHERE id = ?";
	//public static final String INSERT_ALBUM = "INSERT INTO album (id, singer_id, title, release_date) VALUES(?,?,?,?);";
	//public static final String DELETE_ALBUM = "DELETE FROM album WHERE id=?;";
	//public static final String UPDATE_ALBUM = "UPDATE album SET id = ?, singer_id = ?, title = ?, release_date = ? WHERE id = ?;";
	
	@PersistenceContext(unitName = "distri")
	private EntityManager entityManager;
	
	@Override
	public List<Direccion> listDirecciones() {
		TypedQuery<Direccion> query = entityManager.createQuery(SELECT_DIRECCION, Direccion.class);
		return query.getResultList();
	}

	@Override
	public Direccion getDireccion(Integer id) {
		Direccion direccion = new Direccion();
		try {
			TypedQuery<Direccion> query = entityManager.createQuery(SELECT_DIRECCION_ID, Direccion.class);		
			query.setParameter(1, id);
			
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
