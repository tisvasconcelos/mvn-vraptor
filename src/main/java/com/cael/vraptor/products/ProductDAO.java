package com.cael.vraptor.products;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ProductDAO {
	
	@Inject
	private Session session;
	
	public void save(Product product) {
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getByStatus(ProductStatus status) {
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("status", status));
		return criteria.list();
	}

}
