package com.distribuida.server.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.distribuida.server.model.Singer;

@ApplicationScoped
public class ServiceSingerImpl implements ServiceSinger{
	
	public static final String SELECT_SINGER = "Select e from Singer e";
	
	@Inject
	private SessionFactory entityManager;
	//private Transaction transaccion;
	
	@Override
	public List<Singer> listSingers() {
		Session sessionSQL = entityManager.openSession();
		TypedQuery<Singer> query = sessionSQL.createQuery(SELECT_SINGER, Singer.class);
		return query.getResultList();
	}
	
	@Override
	public Singer getSinger(Integer id) {
		Session sessionSQL = entityManager.openSession();
		Singer singer = sessionSQL.find(Singer.class, id);
		return singer;
	}
//
//	@Override
//	public Singer addSinger(Singer e) {
//		return null;
//	}
//
//	@Override
//	public void deleteSinger(Integer id) {
//		
//	}
//
//	@Override
//	public Singer updateSinger(Integer id, Singer e) {
//		return null;
//	}

}
