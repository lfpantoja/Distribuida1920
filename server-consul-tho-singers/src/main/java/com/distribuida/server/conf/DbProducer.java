package com.distribuida.server.conf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;

//@Path(value="/")
@ApplicationScoped
public class DbProducer{
	
    private static BasicDataSource basicDataSource=null;
    
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
    
    @PostConstruct
    private void postConstruct() {
    	if (null==basicDataSource){
    		basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(driver);//org.postgresql.Driver
            basicDataSource.setUsername(user);
            basicDataSource.setPassword(pass);
            basicDataSource.setUrl(url);//jdbc:postgresql://localhost:5432/deber04
            basicDataSource.setMaxActive(20);
            basicDataSource.setMinIdle(5);
            basicDataSource.setMaxIdle(10);
    	}
    }
    
    public DbProducer(){
         if (null==basicDataSource){
        	 //config.getValue("user",String.class)
//             basicDataSource = new BasicDataSource();
//             basicDataSource.setDriverClassName(driver);//org.postgresql.Driver
//             basicDataSource.setUsername(user);
//             basicDataSource.setPassword(pass);
//             basicDataSource.setUrl(url);//jdbc:postgresql://localhost:5432/deber04
//             basicDataSource.setMaxActive(200);
//             basicDataSource.setMinIdle(50);
//             basicDataSource.setMaxIdle(100);
         }
     }

    @ApplicationScoped
    @Produces
     public BasicDataSource getDataSource(){
         return basicDataSource;
     }
}