package com.distribuida.server.conf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.commons.dbcp.BasicDataSource;

@ApplicationScoped
public class DbProducer{
	
    private static BasicDataSource basicDataSource=null;
    private String user = "postgres";
    private String pass = "root";

    public DbProducer(){
         if (null==basicDataSource){
             basicDataSource = new BasicDataSource();
             basicDataSource.setDriverClassName("org.postgresql.Driver");
             basicDataSource.setUsername(user);
             basicDataSource.setPassword(pass);
             basicDataSource.setUrl("jdbc:postgresql://localhost:5432/deber04");
             basicDataSource.setMaxActive(200);
             basicDataSource.setMinIdle(50);
             basicDataSource.setMaxIdle(100);
         }
     }

    @ApplicationScoped
    @Produces
     public BasicDataSource getDataSource(){
         return basicDataSource;
     }
}