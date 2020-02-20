package com.distribuida.server.rest;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
@ApplicationPath(value = "/")
public class RestApplication extends Application{

	@Inject
	@ConfigProperty(name="server.port")
	private Integer puerto;
	
	@Inject
	@ConfigProperty(name="consul.server",defaultValue="127.0.0.1")
	private String consulHost;
	
	@Inject
	@ConfigProperty(name="consul.port",defaultValue="8500")
	private Integer consulPort;
	
	private String Id;
	
	@PostConstruct
	public void inicializar( ) {
		UUID uuid = UUID.randomUUID();
		Id = uuid.toString();
	}
	
	//JDK11
//	@Override
//    public Set<Class<?>> getClasses() {
//        return Set.of(
//                HolaMundo.class
//        );
//    }
	
	//jdk8
	@Override
    public Set<Class<?>> getClasses() {
		Set<Class<?>> ret = new HashSet<Class<?>>();
		//ret.add(DbProducer.class);
		ret.add(SingerRest.class);	
		
        return ret;
    }
	
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		System.out.println("****************************Iniciando****************************");
		
		ConsulClient client = new ConsulClient(consulHost,consulPort);
		//ConsulClient client = new ConsulClient();
		
		NewService s = new NewService();
		
		s.setName("rest-singer");
		s.setId(Id);
		s.setAddress("127.0.0.1");
		s.setPort( puerto );
		
		//check
		NewService.Check check = new NewService.Check();
		check.setMethod("GET");
		check.setHttp("http://127.0.0.1:"+puerto+"/ping");
		check.setInterval("10s");
		check.setDeregisterCriticalServiceAfter("20s");
		
		s.setCheck(check);
		
		client.agentServiceRegister(s);
	}
	
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		System.out.println("****************************Finalizando****************************");
		
		ConsulClient client = new ConsulClient();
		client.agentServiceDeregister( Id );
		
	}
}