package com.distribuida.server.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationScoped
@ApplicationPath(value="/")
public class RestApplication extends Application {
//	@Inject
//	@ConfigProperty(name="server.port",defaultValue="8080")
//	private Integer puerto;
//	
//	@Inject
//	@ConfigProperty(name="consul.server",defaultValue="127.0.0.1")
//	private String consulHost;
//	
//	@Inject
//	@ConfigProperty(name="consul.port",defaultValue="8500")
//	private Integer consulPort;
//	
//	private String Id= UUID.randomUUID().toString(); 
//	
//	
//	//JDK11
////	@Override
////    public Set<Class<?>> getClasses() {
////        return Set.of(
////                HolaMundo.class
////        );
////    }
//	
//	//jdk8
//	@Override
//    public Set<Class<?>> getClasses() {
//		Set<Class<?>> ret = new HashSet<Class<?>>();
//		//ret.add(Singer.class);
//		//ret.add(DbProducer.class);
//		ret.add(SingerRest.class);	
//		
//        return ret;
//    }
//	
//	//observes listener para eventos
//	//para agregar al servidor
//	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
//		System.out.println("Iniciando");
//		
//		ConsulClient client = new ConsulClient(consulHost,consulPort);
//		//ConsulClient client = new ConsulClient();
//		
//		NewService s = new NewService();
//		
//		s.setName("rest-singer-tho");
//		s.setId(Id);
//		s.setAddress("127.0.0.1");
//		s.setPort( puerto );
//		
//		//check
//		NewService.Check check = new NewService.Check();
//		check.setMethod("GET");
//		check.setHttp("http://127.0.0.1:"+puerto+"/singers");
//		check.setInterval("10s");
//		check.setDeregisterCriticalServiceAfter("20s");
//				
//		s.setCheck(check);
//		
//		client.agentServiceRegister(s);
//	}
//	//para quitar del servidor
//	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
//		System.out.println("Finalizando");
//		
//		ConsulClient client = new ConsulClient();
//		client.agentServiceDeregister( Id );
//		
//	}
}
