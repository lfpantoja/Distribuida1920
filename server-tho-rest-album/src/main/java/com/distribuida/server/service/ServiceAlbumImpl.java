package com.distribuida.server.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.distribuida.server.model.Album;

@ApplicationScoped
public class ServiceAlbumImpl implements ServiceAlbum{
	
	public static final String SELECT_ALBUM = "Select e from Album e";
	
	@Inject
	private SessionFactory entityManager;
	//private Transaction transaccion;
	
	@Override
	public List<Album> listAlbums() {
		Session sessionSQL = entityManager.openSession();
		TypedQuery<Album> query = sessionSQL.createQuery(SELECT_ALBUM, Album.class);
		return query.getResultList();
	}
	
	@Override
	public Album getAlbum(Integer id) {
		Session sessionSQL = entityManager.openSession();
		Album singer = sessionSQL.find(Album.class, id);
		return singer;
	}
//
//	@Override
//	public Album addAlbum(Album e) {
//		return null;
//	}
//
//	@Override
//	public void deleteAlbum(Integer id) {
//		
//	}
//
//	@Override
//	public Singer updateAlbum(Integer id, Album e) {
//		return null;
//	}

}
