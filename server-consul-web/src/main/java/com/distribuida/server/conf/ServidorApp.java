package com.distribuida.server.conf;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
@ApplicationPath(value="/")
public class ServidorApp extends Application{
	
	private Integer puerto = 8080;
	
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
		//ret.add(Singer.class);
		//ret.add(DbProducer.class);
		ret.add(Producer.class);
		
        return ret;
    }
	
	//observes listener para eventos
	//para agregar al servidor
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		System.out.println("Iniciando");
		
		//ConsulClient client = new ConsulClient(consulHost,consulPort);
		ConsulClient client = new ConsulClient();
		
		NewService s = new NewService();
		
		s.setName("web");
		s.setId(Id);
		s.setAddress("127.0.0.1");
		s.setPort( puerto );
		
		//check
		NewService.Check check = new NewService.Check();
		check.setMethod("GET");
		check.setHttp("http://127.0.0.1:"+puerto+"/server-consul-web/");
		check.setInterval("10s");
		check.setDeregisterCriticalServiceAfter("20s");
		
		
		s.setCheck(check);
		
		client.agentServiceRegister(s);
	}
	//para quitar del servidor
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		System.out.println("Finalizando");
		
		ConsulClient client = new ConsulClient();
		client.agentServiceDeregister( Id );

		
	}

}
