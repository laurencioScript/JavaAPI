package br.pro.api.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("rest")
public class ApiRosourceConfig extends ResourceConfig {
	public ApiRosourceConfig() {
		packages("br.pro.api.service");
	}
}
