package com.distribuida.service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.model.Album;

@ApplicationScoped
public class ServiceAlbumImpl implements ServiceAlbum{
	
	@Inject
    private EntityManager entityManager;
	
	@Override
	public List<Album> listAlbums() {
		System.out.println("*********************+ImplA");
		List<Album> albums = new ArrayList<>();
		String sql = "SELECT e FROM Album e order by e.id";
		albums = entityManager.createQuery(sql, Album.class).getResultList();
		
		return albums;
	}

	@Override
	public Album addAlbum(Album e) {
		entityManager.getTransaction().begin();
		e.setReleaseDate(new Date(10,10,10));
        entityManager.persist(e);
        entityManager.getTransaction().commit();
		return e;
	}

	@Override
	public void deleteAlbum(Integer id) {
		entityManager.getTransaction().begin();
		
		Album reference = entityManager.getReference(Album.class, id);
		entityManager.remove(reference);
		
        entityManager.getTransaction().commit();
	}

	@Override
	public Album getAlbum(Integer id) {
		Album reference = new Album();
		reference = entityManager.getReference(Album.class, id);
		
		return reference;
	}

	@Override
	public Album updateAlbum(Album e) {
		entityManager.getTransaction().begin();
		
		e.setId(e.getId());
		e.setSingerId(e.getSingerId());
		e.setTitle(e.getTitle());
		e.setReleaseDate(new Date(10,10,10));
		
		entityManager.merge(e);
		entityManager.getTransaction().commit();
		return null;
	}

	@PreDestroy
    void destroy() {
        entityManager.close();
    }
	
}
