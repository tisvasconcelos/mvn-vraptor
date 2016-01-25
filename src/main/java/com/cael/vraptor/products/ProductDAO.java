package com.cael.vraptor.products;

import javax.inject.Inject;

import org.hibernate.Session;

public class ProductDAO {
	
	@Inject
	private Session session;
	
	public void save(Product product) {
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
	}
	
}
