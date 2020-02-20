package com.distribuida.conf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	//private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("SingerDB");

	@Produces
	public EntityManagerFactory createEntityManagerFactory() {
        return Persistence
                .createEntityManagerFactory("SingerDB")
                ;
    }
	
	@Produces
	public EntityManager createEntityManager( EntityManagerFactory emf ) {
        return emf.createEntityManager();
    }
	
	public void close( @Disposes EntityManager entityManager) {
        entityManager.close();
    }
}
