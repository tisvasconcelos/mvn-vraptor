package com.cael.vraptor.controllers;

import javax.inject.Inject;

import com.cael.vraptor.products.Product;
import com.cael.vraptor.products.ProductDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class ProductController {

	@Inject
	private Result result;
	
	@Inject
	private ProductDAO productDAO;
	
	@Get("/product/create")
	public void form(){
	}
	
	@Post("/product/save")
	public void save(Product product){
		productDAO.save(product);
		
		result.redirectTo(this).form();
	}
	
}
