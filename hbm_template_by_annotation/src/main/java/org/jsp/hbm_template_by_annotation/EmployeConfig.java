package org.jsp.hbm_template_by_annotation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="org.jsp.hbm_template_by_annotation" )
public class EmployeConfig {
	
	@Bean
	public EntityManager getManager() {
		return Persistence.createEntityManagerFactory("dev").createEntityManager();	
	}
}
