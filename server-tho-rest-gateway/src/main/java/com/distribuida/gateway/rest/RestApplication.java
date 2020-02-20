package com.distribuida.gateway.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(value = "/")
@ApplicationScoped
public class RestApplication extends Application {

}
