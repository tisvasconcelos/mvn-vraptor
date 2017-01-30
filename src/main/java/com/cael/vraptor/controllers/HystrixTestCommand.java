package com.cael.vraptor.controllers;

import com.cael.vraptor.products.Product;
import com.cael.vraptor.products.ProductDAO;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import br.com.caelum.vraptor.others.LoggerFactory;
import sun.util.logging.resources.logging;

public class HystrixTestCommand extends HystrixCommand<Product> {

	private Product product;
	private ProductDAO productDAO;

	protected HystrixTestCommand(Product product, ProductDAO productDAO) {
		super(HystrixCommandGroupKey.Factory.asKey("HystrixTest"));
		this.product = product;
		this.productDAO = productDAO;
	}

	@Override
	protected Product run() throws Exception {
		System.out.println(product);
		
		productDAO.save(product);
		
		return product;
	}
	
	@Override
	protected Product getFallback() {
		System.out.println("Ocorreu um erro ao tentar salvar o produto");
		System.out.println(this.getFailedExecutionException().getMessage());
		return null;
	}

}
