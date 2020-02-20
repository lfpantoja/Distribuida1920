package com.distribuida.server.conf;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Path(value="/")
//@ApplicationScoped
public class DbProducer {
	
	@Produces
	@Default
	@PersistenceContext(unitName = "SingerPU")
    private EntityManager em;
	
}