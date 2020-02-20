package com.distribuida.server.conf;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.distribuida.server.model.Album;

@ApplicationScoped
public class DbProducer {
	
	@Inject
	@ConfigProperty(name = "driver",defaultValue="org.postgresql.Driver")
	private String driver;
    
    @Inject
	@ConfigProperty(name = "url",defaultValue="jdbc:postgresql://localhost:5432/deber04")
	private String url;
    
    @Inject
	@ConfigProperty(name = "user",defaultValue="postgres")
	private String user;
    
    @Inject
	@ConfigProperty(name = "pass",defaultValue="root")
	private String pass;
    
    @Inject
	@ConfigProperty(name = "dialect", defaultValue = "org.hibernate.dialect.PostgreSQLDialect")
	private String postgresDialect;
    
	private static SessionFactory sessionJpa;
    
	@ApplicationScoped
    @Produces
	public SessionFactory getSessionFactory() {
		if (sessionJpa == null) {
			Configuration configPersistence = new Configuration();
			
			Properties propPersistence = new Properties();
			propPersistence.put(Environment.DRIVER, driver);
			propPersistence.put(Environment.URL, url);
			propPersistence.put(Environment.USER, user);
			propPersistence.put(Environment.PASS, pass);
			propPersistence.put(Environment.DIALECT, postgresDialect);
			propPersistence.put(Environment.HBM2DDL_AUTO, "update");
			propPersistence.put(Environment.SHOW_SQL, "true");
			propPersistence.put(Environment.FORMAT_SQL, "true");
			propPersistence.put(Environment.USE_SQL_COMMENTS, "true");
			
			configPersistence.setProperties(propPersistence);
			configPersistence.addAnnotatedClass(Album.class);

			ServiceRegistry serviceR = new StandardServiceRegistryBuilder().applySettings(configPersistence.getProperties()).build();

			sessionJpa = configPersistence.buildSessionFactory(serviceR);
		}
		return sessionJpa;
	}
    
}
