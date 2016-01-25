package com.cael.vraptor.infra;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.cfg.Configuration;

import com.cael.vraptor.products.Product;

import br.com.caelum.vraptor.environment.Environment;

public class HibernateConfigurationCreator {

	@Inject
	private Environment environment;
	
	@Produces
	public Configuration create() {
		Configuration configuration = new Configuration();
		configuration.configure(environment.getResource("/hibernate.cfg.xml"));
		configuration.addAnnotatedClass(Product.class);
		
		return configuration;
	}
	
}
