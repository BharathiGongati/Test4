package org.jsp.dto;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "org.jsp")
public class configuration2 {
	@Bean
	public EntityManager getentitymanager() {
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		

	}

}
