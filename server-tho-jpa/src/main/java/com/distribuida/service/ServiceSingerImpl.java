package com.distribuida.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.model.Singer;

@ApplicationScoped
public class ServiceSingerImpl implements ServiceSinger{
	
	@Inject
    private EntityManager entityManager;
	
	@Override
	public List<Singer> listSingers() {
		System.out.println("*********************+ImplS");
		List<Singer> singers = new ArrayList<>();
		String sql = "SELECT a FROM Singer a order by a.id";
		singers = entityManager.createQuery(sql, Singer.class).getResultList();
		
		return singers;
	}

	@Override
	public Singer addSinger(Singer e) {
		entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
		return e;
	}

	@Override
	public void deleteSinger(Integer id) {
		entityManager.getTransaction().begin();
		Singer reference = entityManager.getReference(Singer.class, id);
		entityManager.remove(reference);
        entityManager.getTransaction().commit();
	}

	@Override
	public Singer getSinger(Integer id) {
		Singer reference = new Singer();
		reference = entityManager.getReference(Singer.class, id);
		
		return reference;
	}

	@Override
	public Singer updateSinger(Singer e) {
		entityManager.getTransaction().begin();
		
		e.setId(e.getId());
		e.setFirstName(e.getFirstName());
		e.setLastName(e.getLastName());
		e.setBirthDate(e.getBirthDate());
		 
		entityManager.merge(e);
		entityManager.getTransaction().commit();
		return null;
	}

	@PreDestroy
    void destroy() {
        entityManager.close();
    }
	
}
