package com.ibk.app_server.config;

import org.springframework.beans.factory.annotation.Value;

public class ASdbConfig {

	@Value("${local.db.driver.class}")
	private String driver;
	
	@Value("${local.db.jdbc.url}")
	private String url;
	
	@Value("${local.db.uername}")
	private String username;
	
	@Value("${local.db.password}")
	private String password;

	public String getProperties() {
		System.out.println("driver : "+driver);
		return username;
	}
}
