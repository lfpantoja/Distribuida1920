package com.distribuida.server.conf;

import java.net.URL;

import org.wildfly.swarm.Swarm;

public class Main {
	public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        //1
        ClassLoader cl = Main.class.getClassLoader();
        //URL xmlConfig = cl.getResource("datasources.xml");
        URL yamlConfig = cl.getResource("project-defaults.yml");

        //2
        //swarm.withXmlConfig(xmlConfig);
        swarm.withConfig(yamlConfig);

        swarm.start().deploy();
    }
}
